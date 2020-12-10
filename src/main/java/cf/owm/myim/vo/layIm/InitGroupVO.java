package cf.owm.myim.vo.layIm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author chenf
 * @Date 2020/12/10 15:50
 */
@ApiModel(value = "群组列表")
public class InitGroupVO {
    @ApiModelProperty(value = "群组名")
    private String groupname;

    @ApiModelProperty(value = "群组ID")
    private String id;

    @ApiModelProperty(value = "群组头像")
    private String avatar;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
