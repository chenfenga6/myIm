package cf.owm.myim.entity;

import java.util.Date;

public class Friend {
    private String id;

    private String friendId;

    private String userId;

    private String friendName;

    private String friendType;

    private String friendGroupId;

    private Date createTime;

    private Integer friendStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName == null ? null : friendName.trim();
    }

    public String getFriendType() {
        return friendType;
    }

    public void setFriendType(String friendType) {
        this.friendType = friendType == null ? null : friendType.trim();
    }

    public String getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(String friendGroupId) {
        this.friendGroupId = friendGroupId == null ? null : friendGroupId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", friendId=").append(friendId);
        sb.append(", userId=").append(userId);
        sb.append(", friendName=").append(friendName);
        sb.append(", friendType=").append(friendType);
        sb.append(", friendGroupId=").append(friendGroupId);
        sb.append(", createTime=").append(createTime);
        sb.append(", friendStatus=").append(friendStatus);
        sb.append("]");
        return sb.toString();
    }
}