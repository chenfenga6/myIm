package cf.owm.myim.vo.tencent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author chenf
 * @Date 2020/8/4 9:05
 */
@ApiModel(value = "腾讯云生成userSig返回Vo")
public class TencentUserSigVo {

    @ApiModelProperty(value = "SDKAppID")
    private String sdkAppID;

    @ApiModelProperty(value = "userSig")
    private String userSig;

    public String getSdkAppID() {
        return sdkAppID;
    }

    public void setSdkAppID(String sdkAppID) {
        this.sdkAppID = sdkAppID;
    }

    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }
}
