package cf.owm.myim.controller;

import cf.owm.myim.entity.Groups;
import cf.owm.myim.service.GroupService;
import cf.owm.myim.vo.AppReturnBack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author chenf
 * @Date 2020/12/10 15:31
 */
@RestController
@CrossOrigin
@RequestMapping("/group")
@Api(value = "group",tags = {"【群】相关"})
public class GroupController {
    @Resource
    private GroupService groupService;

    @PostMapping("/createGroup")
    @ApiOperation(value = "创建群")
    public AppReturnBack createGroup(@RequestBody Groups group){
        return groupService.createGroup(group);
    }

}
