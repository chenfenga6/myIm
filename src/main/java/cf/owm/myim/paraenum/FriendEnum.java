package cf.owm.myim.paraenum;

/**
 * @Author chenf
 * @Date 2020/12/10 15:06
 */
public enum  FriendEnum {
    STATUS_SEND(0,"已发送好友申请"),
    STATUS_FRIEND(1,"已成为好友"),
    STATUS_REFUSED(2,"拒绝好友申请"),
    STATUS_BLOCK(3,"已拉黑");


    private Integer code;
    private String value;

    FriendEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
