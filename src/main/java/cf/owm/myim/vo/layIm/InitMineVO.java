package cf.owm.myim.vo.layIm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.net.SocketFlow;

/**
 * @Author chenf
 * @Date 2020/12/10 15:49
 */
@ApiModel("我的信息")
public class InitMineVO {
    @ApiModelProperty(value = "我的昵称")
    private String username;

    @ApiModelProperty(value = "我的ID")
    private String id;

    @ApiModelProperty(value = "在线状态")
    private String status;

    @ApiModelProperty(value = "我的签名")
    private String sign;

    @ApiModelProperty(value = "我的头像")
    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
