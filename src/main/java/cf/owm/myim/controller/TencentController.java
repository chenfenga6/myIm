package cf.owm.myim.controller;

import cf.owm.myim.service.TencentService;
import cf.owm.myim.vo.AppReturnBack;
import cf.owm.myim.vo.tencent.TencentUserSigVo;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author chenf
 * @Date 2020/12/10 9:22
 */
@RestController
@CrossOrigin
@RequestMapping("/tx")
@Api(value = "tencent",tags = {"【腾讯云】相关"})
public class TencentController {
    @Resource
    private TencentService tencentService;

    /**
     * 获取UserSig
    *@Author chenf
    *@Date 9:51 2020/12/10
    **/
    @ApiOperation(value = "获取UserSig")
    @PostMapping(value = "/getUserSig")
    @ApiResponses({@ApiResponse(code = 200,message = "success",response = TencentUserSigVo.class)})
    public AppReturnBack getUserSig(@ApiParam(value = "用户id",required = true) @RequestParam String userId){
        return AppReturnBack.success().addData(tencentService.getUserSig(userId));
    }
}
