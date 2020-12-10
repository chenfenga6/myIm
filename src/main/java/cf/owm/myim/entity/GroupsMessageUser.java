package cf.owm.myim.entity;

import java.util.Date;

public class GroupsMessageUser {
    private String id;

    private String userId;

    private String groupMsgId;

    private Integer msgStatus;

    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getGroupMsgId() {
        return groupMsgId;
    }

    public void setGroupMsgId(String groupMsgId) {
        this.groupMsgId = groupMsgId == null ? null : groupMsgId.trim();
    }

    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", groupMsgId=").append(groupMsgId);
        sb.append(", msgStatus=").append(msgStatus);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}