package peng.zhi.liu.carmainpfproject.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peng.zhi.liu.carmainpfcommon.result.Result;
import peng.zhi.liu.carmainpfpojo.dto.UserLoginDTO;
import peng.zhi.liu.carmainpfpojo.dto.UserRegisterDTO;
import peng.zhi.liu.carmainpfpojo.vo.UserLoginVO;
import peng.zhi.liu.carmainpfproject.service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result userRegisterController(@RequestBody UserRegisterDTO userRegisterDTO){
        log.info("用户注册：{}",userRegisterDTO);
        userService.userRegisterService(userRegisterDTO);
        return Result.success();
    }
    @PostMapping("/login")
    public Result userLoginController(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录:{}",userLoginDTO);
        UserLoginVO userLoginVO = userService.userLoginService(userLoginDTO);
        return Result.success(userLoginVO);
    }
}
