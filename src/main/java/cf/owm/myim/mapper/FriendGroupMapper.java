package cf.owm.myim.mapper;

import cf.owm.myim.entity.FriendGroup;
import cf.owm.myim.entity.FriendGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendGroupMapper {
    long countByExample(FriendGroupExample example);

    int deleteByExample(FriendGroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(FriendGroup record);

    int insertSelective(FriendGroup record);

    List<FriendGroup> selectByExample(FriendGroupExample example);

    FriendGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FriendGroup record, @Param("example") FriendGroupExample example);

    int updateByExample(@Param("record") FriendGroup record, @Param("example") FriendGroupExample example);

    int updateByPrimaryKeySelective(FriendGroup record);

    int updateByPrimaryKey(FriendGroup record);
}