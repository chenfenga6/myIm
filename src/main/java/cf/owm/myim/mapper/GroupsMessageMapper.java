package cf.owm.myim.mapper;

import cf.owm.myim.entity.GroupsMessage;
import cf.owm.myim.entity.GroupsMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupsMessageMapper {
    long countByExample(GroupsMessageExample example);

    int deleteByExample(GroupsMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(GroupsMessage record);

    int insertSelective(GroupsMessage record);

    List<GroupsMessage> selectByExampleWithBLOBs(GroupsMessageExample example);

    List<GroupsMessage> selectByExample(GroupsMessageExample example);

    GroupsMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GroupsMessage record, @Param("example") GroupsMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") GroupsMessage record, @Param("example") GroupsMessageExample example);

    int updateByExample(@Param("record") GroupsMessage record, @Param("example") GroupsMessageExample example);

    int updateByPrimaryKeySelective(GroupsMessage record);

    int updateByPrimaryKeyWithBLOBs(GroupsMessage record);

    int updateByPrimaryKey(GroupsMessage record);
}