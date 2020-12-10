package cf.owm.myim.paraenum;

/**
 * @author chenf
 */
public enum OutExchangeEnum {
    SUCCESS(1, "请求成功"),
    FAIL(2,"请求失败"),
    ERROR(3, "未知异常");

    private Integer code;
    private String message;

    OutExchangeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
