package cf.owm.myim.mapper;

import cf.owm.myim.entity.GroupsUser;
import cf.owm.myim.entity.GroupsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupsUserMapper {
    long countByExample(GroupsUserExample example);

    int deleteByExample(GroupsUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(GroupsUser record);

    int insertSelective(GroupsUser record);

    List<GroupsUser> selectByExample(GroupsUserExample example);

    GroupsUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GroupsUser record, @Param("example") GroupsUserExample example);

    int updateByExample(@Param("record") GroupsUser record, @Param("example") GroupsUserExample example);

    int updateByPrimaryKeySelective(GroupsUser record);

    int updateByPrimaryKey(GroupsUser record);
}