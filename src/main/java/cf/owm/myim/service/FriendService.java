package cf.owm.myim.service;

import cf.owm.myim.entity.Friend;
import cf.owm.myim.entity.FriendGroup;
import cf.owm.myim.entity.FriendType;
import cf.owm.myim.mapper.FriendGroupMapper;
import cf.owm.myim.mapper.FriendMapper;
import cf.owm.myim.mapper.FriendTypeMapper;
import cf.owm.myim.mapper.UserMapper;
import cf.owm.myim.paraenum.BaseEnum;
import cf.owm.myim.paraenum.FriendEnum;
import cf.owm.myim.tools.UUIDTool;
import cf.owm.myim.vo.AppReturnBack;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author chenf
 * @Date 2020/12/10 14:41
 */
@Service
public class FriendService {
    @Resource
    private FriendMapper friendMapper;
    @Resource
    private FriendTypeMapper friendTypeMapper;
    @Resource
    private FriendGroupMapper friendGroupMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 发送-好友申请
     */
    public AppReturnBack addFriendSend(Friend friend){
        if (StringUtils.isBlank(friend.getUserId()) || userMapper.selectByPrimaryKey(friend.getUserId()) == null){
            return AppReturnBack.warn("user用户已不存在！");
        }
        if (StringUtils.isBlank(friend.getFriendId()) || userMapper.selectByPrimaryKey(friend.getFriendId()) == null){
            return AppReturnBack.warn("friend用户已不存在！");
        }
//        if (StringUtils.isBlank(friend.getFriendGroupId()) || friendGroupMapper.selectByPrimaryKey(friend.getFriendGroupId()) == null){
//            return AppReturnBack.warn("friendGroup已不存在！");
//        }
        friend.setId(UUIDTool.getUUIDRandom());
        friend.setCreateTime(new Date());
        int flag = friendMapper.insert(friend);
        if (flag == 0){
            return AppReturnBack.fail();
        }
        return AppReturnBack.success();
    }


    /**
     * 确认-好友申请（type=1-成为好友 2-已拒绝好友申请）
    *@Author chenf
    *@Date 14:43 2020/12/10
    **/
    @Transactional(rollbackFor = Exception.class)
    public AppReturnBack friendOpts(String friendSendId,String friendName,String friendType,String friendGroupId,Integer type){
        Friend friendInfo = friendMapper.selectByPrimaryKey(friendSendId);
        if(StringUtils.isNotBlank(friendSendId) && friendInfo != null ){
            if (FriendEnum.STATUS_FRIEND.getCode().equals(type) && FriendEnum.STATUS_SEND.getCode().equals(friendInfo.getFriendStatus())){
                friendInfo.setFriendStatus(FriendEnum.STATUS_FRIEND.getCode());
                if( friendMapper.updateByPrimaryKey(friendInfo) == 0){
                    return AppReturnBack.fail();
                }
                Friend friend = new Friend();
                friend.setId(UUIDTool.getUUIDRandom());
                friend.setUserId(friendInfo.getFriendId());
                friend.setFriendId(friendInfo.getUserId());
                friend.setFriendName(friendName);
                friend.setFriendType(friendType);
                friend.setFriendGroupId(friendGroupId);
                if (friendMapper.insert(friend) == 0){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return AppReturnBack.fail();
                }

            }else if (FriendEnum.STATUS_REFUSED.getCode().equals(type) && FriendEnum.STATUS_SEND.getCode().equals(friendInfo.getFriendStatus())){
                friendInfo.setFriendStatus(FriendEnum.STATUS_REFUSED.getCode());
                if( friendMapper.updateByPrimaryKey(friendInfo) == 0){
                    return AppReturnBack.fail();
                }
            }else{
                return AppReturnBack.warn("type不正确/流程错误");
            }
            return AppReturnBack.success();
        }
        return AppReturnBack.warn("friendSendId不存在");
    }

}
