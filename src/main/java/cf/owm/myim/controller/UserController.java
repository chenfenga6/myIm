package cf.owm.myim.controller;

import cf.owm.myim.entity.User;
import cf.owm.myim.service.UserService;
import cf.owm.myim.vo.AppReturnBack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author chenf
 * @Date 2020/12/9 17:07
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(value = "User",tags = {"【用户】相关"})
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public AppReturnBack login(@ApiParam(value = "账号",required = true) @RequestParam String loginId,
                               @ApiParam(value = "密码",required = true) @RequestParam String pwd){
        return userService.login(loginId,pwd);
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public AppReturnBack register(@RequestBody User user){
        return userService.register(user);
    }

}
