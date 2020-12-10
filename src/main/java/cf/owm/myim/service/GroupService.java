package cf.owm.myim.service;

import cf.owm.myim.entity.Groups;
import cf.owm.myim.mapper.GroupsMapper;
import cf.owm.myim.mapper.UserMapper;
import cf.owm.myim.tools.UUIDTool;
import cf.owm.myim.vo.AppReturnBack;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author chenf
 * @Date 2020/12/10 15:31
 */
@Service
public class GroupService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private GroupsMapper groupsMapper;


    /**
     * 创建群
    *@Author chenf
    *@Date 15:33 2020/12/10
    **/
    public AppReturnBack createGroup(Groups group){
        if(StringUtils.isBlank(group.getAdminUserId()) || userMapper.selectByPrimaryKey(group.getAdminUserId()) == null){
            return AppReturnBack.warn("群主账号不存在！");
        }
        group.setId(UUIDTool.getUUIDRandom());
        group.setCreateTime(new Date());
        if(groupsMapper.insert(group) == 0){
            return AppReturnBack.fail();
        }
        return AppReturnBack.success();
    }


}
