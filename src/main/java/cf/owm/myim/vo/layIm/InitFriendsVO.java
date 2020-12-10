package cf.owm.myim.vo.layIm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * @Author chenf
 * @Date 2020/12/10 15:49
 */
@ApiModel(value = "好友列表")
public class InitFriendsVO {
    @ApiModelProperty(value = "好友分组名")
    private String groupname;

    @ApiModelProperty(value = "分组ID")
    private String id;

    @ApiModelProperty(value = "分组下的好友列表")
    private List<InitMineVO> list;


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

    public List<InitMineVO> getList() {
        return list;
    }

    public void setList(List<InitMineVO> list) {
        this.list = list;
    }
}
