package cf.owm.myim.service;

import cf.owm.myim.entity.User;
import cf.owm.myim.entity.UserExample;
import cf.owm.myim.mapper.UserMapper;
import cf.owm.myim.paraenum.BaseEnum;
import cf.owm.myim.tools.UUIDTool;
import cf.owm.myim.vo.AppReturnBack;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * @Author chenf
 * @Date 2020/12/9 17:07
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
    *@Author chenf
    *@Date 17:11 2020/12/10
    **/
    public AppReturnBack login(String loginId,String pwd){
        UserExample userExample = new UserExample();
        userExample.or().andIsDelEqualTo(BaseEnum.IS_EXIST.getCode()).andLoginIdEqualTo(loginId);
        List<User> listUser = userMapper.selectByExample(userExample);
        if (listUser.size() == 1){
            User userInfo = listUser.get(0);
            if (userInfo.getPassword().equals(pwd)){
                JSONObject object = new JSONObject();
                object.put("userId",userInfo.getId());
                return AppReturnBack.success().addData(object);
            }else {
                return AppReturnBack.warn("账号或密码不正确！");
            }
        }
        return AppReturnBack.warn("账号或密码不正确！");
    }


    /**
     * 注册用户
    *@Author chenf
    *@Date 14:19 2020/12/10
    **/
    public AppReturnBack register(User user){
        if (StringUtils.isNotBlank(user.getLoginId())){
            UserExample userExample = new UserExample();
            userExample.or().andLoginIdEqualTo(user.getLoginId()).andIsDelEqualTo(BaseEnum.IS_EXIST.getCode());
            long nums = userMapper.countByExample(userExample);
            if (nums > 0L){
                return AppReturnBack.warn("登录id已存在");
            }
            user.setIsDel(BaseEnum.IS_EXIST.getCode());;
            user.setId(UUIDTool.getUUIDRandom());
            int flag = userMapper.insert(user);
            if (flag == 0){
                return AppReturnBack.warn("注册失败");
            }
            return AppReturnBack.success();
        }
        return AppReturnBack.warn("传参不全");
    }
}
