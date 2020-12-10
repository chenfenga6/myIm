package cf.owm.myim.vo;

import cf.owm.myim.paraenum.OutExchangeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author chenf
 * @Date 2020/12/10 9:25
 */
@ApiModel(value = "返回说明")
public class AppReturnBack<T> implements Serializable {
    private static final long serialVersionUID = 3268107486064464144L;
    /**
     * 返回码
     * 200-请求成功
     * 400-处理异常
     * 500-未知异常
     */
    @ApiModelProperty(value = "请求状态;200:请求成功;400:请求失败;300：请求成功，无描述；500:未知异常")
    private int code;
    /**
     * 描述
     * 请求成功
     * 请求异常
     */
    @ApiModelProperty(value = "请求状态描述")
    private String msg;
    /**
     * 返回数据详情
     */
    @ApiModelProperty(value = "返回参数内容")
    private T data;


    public AppReturnBack<T> addData(T data) {
        this.data = data;
        return this;
    }

    public static AppReturnBack success() {
        AppReturnBack result = new AppReturnBack();
        result.setCode(200);
        result.setMsg(OutExchangeEnum.SUCCESS.getMessage());
        return result;
    }

    public static AppReturnBack fail() {
        AppReturnBack result = new AppReturnBack();
        result.setCode(400);
        result.setMsg(OutExchangeEnum.FAIL.getMessage());
        return result;
    }

    public static AppReturnBack warn(String message) {
        AppReturnBack result = new AppReturnBack();
        result.setCode(401);
        result.setMsg(message);
        return result;
    }

    public static AppReturnBack layuiSuccess() {
        AppReturnBack result = new AppReturnBack();
        result.setCode(0);
        result.setMsg(OutExchangeEnum.SUCCESS.getMessage());
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
