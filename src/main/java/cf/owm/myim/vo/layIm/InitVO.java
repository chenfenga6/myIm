package cf.owm.myim.vo.layIm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * @Author chenf
 * @Date 2020/12/10 15:49
 */
@ApiModel(value = "Layim初始化数据")
public class InitVO {

    @ApiModelProperty(value = "我的信息")
    private InitMineVO mine;

    @ApiModelProperty(value = "好友列表")
    private List<InitFriendsVO> friend;

    @ApiModelProperty(value = "群组列表")
    private List<InitGroupVO> group;

    public InitMineVO getMine() {
        return mine;
    }

    public void setMine(InitMineVO mine) {
        this.mine = mine;
    }

    public List<InitFriendsVO> getFriend() {
        return friend;
    }

    public void setFriend(List<InitFriendsVO> friend) {
        this.friend = friend;
    }

    public List<InitGroupVO> getGroup() {
        return group;
    }

    public void setGroup(List<InitGroupVO> group) {
        this.group = group;
    }
}
