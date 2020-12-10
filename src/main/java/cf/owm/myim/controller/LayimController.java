package cf.owm.myim.controller;

import cf.owm.myim.service.LayimService;
import cf.owm.myim.vo.AppReturnBack;
import cf.owm.myim.vo.layIm.InitVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author chenf
 * @Date 2020/12/10 15:46
 */
@RestController
@CrossOrigin
@RequestMapping("/layim")
@Api(value = "layim",tags = {"【layim】相关"})
public class LayimController {
    @Resource
    private LayimService layimService;

    @PostMapping("/init")
    @ApiOperation(value = "layim初始化")
    @ApiResponses({@ApiResponse(code = 200,message = "success",response =InitVO.class )})
    public AppReturnBack init(@ApiParam(value = "用户id",required = true) @RequestParam  String userId){
        return AppReturnBack.layuiSuccess().addData(layimService.init(userId));
    }
}
