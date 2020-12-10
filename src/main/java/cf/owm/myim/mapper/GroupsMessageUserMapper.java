package cf.owm.myim.mapper;

import cf.owm.myim.entity.GroupsMessageUser;
import cf.owm.myim.entity.GroupsMessageUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupsMessageUserMapper {
    long countByExample(GroupsMessageUserExample example);

    int deleteByExample(GroupsMessageUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(GroupsMessageUser record);

    int insertSelective(GroupsMessageUser record);

    List<GroupsMessageUser> selectByExample(GroupsMessageUserExample example);

    GroupsMessageUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GroupsMessageUser record, @Param("example") GroupsMessageUserExample example);

    int updateByExample(@Param("record") GroupsMessageUser record, @Param("example") GroupsMessageUserExample example);

    int updateByPrimaryKeySelective(GroupsMessageUser record);

    int updateByPrimaryKey(GroupsMessageUser record);
}