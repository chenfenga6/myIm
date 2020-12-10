package cf.owm.myim.paraenum;

/**
 * @Author chenf
 * @Date 2020/12/10 14:13
 */
public enum  BaseEnum {
    IS_EXIST(0,"存在"),
    IS_NOT_EXIST(1,"不存在");


    private Integer code;
    private String value;

    BaseEnum(Integer code, String value) {
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
