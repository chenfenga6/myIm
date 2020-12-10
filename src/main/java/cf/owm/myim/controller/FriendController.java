package cf.owm.myim.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenf
 * @Date 2020/12/10 14:41
 */
@RestController
@CrossOrigin
@RequestMapping("/friend")
@Api(value = "friend",tags = {"【好友】相关"})
public class FriendController {

}
