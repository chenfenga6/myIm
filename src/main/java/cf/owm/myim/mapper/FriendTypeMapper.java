package cf.owm.myim.mapper;

import cf.owm.myim.entity.FriendType;
import cf.owm.myim.entity.FriendTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendTypeMapper {
    long countByExample(FriendTypeExample example);

    int deleteByExample(FriendTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(FriendType record);

    int insertSelective(FriendType record);

    List<FriendType> selectByExample(FriendTypeExample example);

    int updateByExampleSelective(@Param("record") FriendType record, @Param("example") FriendTypeExample example);

    int updateByExample(@Param("record") FriendType record, @Param("example") FriendTypeExample example);
}