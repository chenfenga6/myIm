package cf.owm.myim.service;

import cf.owm.myim.entity.Groups;
import cf.owm.myim.entity.GroupsUser;
import cf.owm.myim.entity.GroupsUserExample;
import cf.owm.myim.entity.User;
import cf.owm.myim.mapper.GroupsMapper;
import cf.owm.myim.mapper.GroupsUserMapper;
import cf.owm.myim.mapper.UserMapper;
import cf.owm.myim.vo.layIm.InitFriendsVO;
import cf.owm.myim.vo.layIm.InitGroupVO;
import cf.owm.myim.vo.layIm.InitMineVO;
import cf.owm.myim.vo.layIm.InitVO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenf
 * @Date 2020/12/10 15:47
 */
@Service
public class LayimService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private GroupsMapper groupsMapper;
    @Resource
    private GroupsUserMapper groupsUserMapper;


    /**
     * LayIm 初始化方法
    *@Author chenf
    *@Date 17:04 2020/12/10
    **/
    public InitVO init(String userId){
        InitVO resultVo = new InitVO();
        User userInfo = userMapper.selectByPrimaryKey(userId);
        if (userInfo != null){
            InitMineVO mineVo = new InitMineVO();
            mineVo.setId(userInfo.getId());
            mineVo.setUsername(userInfo.getNickName());
            mineVo.setStatus("online");
            mineVo.setSign("猜猜我是谁...");
            mineVo.setAvatar("");
            resultVo.setMine(mineVo);

            //friend先跳过
            List<InitFriendsVO> friendsVos = new ArrayList<>();
            resultVo.setFriend(friendsVos);

            //group
            List<InitGroupVO> groupVos = new ArrayList<>();
            GroupsUserExample groupsUserExample = new GroupsUserExample();
            groupsUserExample.or().andUserIdEqualTo(userInfo.getId());
            List<GroupsUser> listGroupsUser = groupsUserMapper.selectByExample(groupsUserExample);
            for (GroupsUser index : listGroupsUser){
                Groups groupInfo = groupsMapper.selectByPrimaryKey(index.getGroupId());
                if (groupInfo != null){
                    InitGroupVO groupVo = new InitGroupVO();
                    groupVo.setId(groupInfo.getId());
                    groupVo.setGroupname(groupInfo.getGroupName());
                    groupVo.setAvatar("http://221.226.128.138:9000/lshuiju/CAPACITY_BASE/1607235735011.jpg");
                    groupVos.add(groupVo);
                }
            }
            resultVo.setGroup(groupVos);
        }
        return resultVo;
    }

}
