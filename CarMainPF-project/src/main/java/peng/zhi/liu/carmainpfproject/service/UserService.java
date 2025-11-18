package peng.zhi.liu.carmainpfproject.service;

import peng.zhi.liu.carmainpfpojo.dto.UserLoginDTO;
import peng.zhi.liu.carmainpfpojo.dto.UserRegisterDTO;
import peng.zhi.liu.carmainpfpojo.entity.User;
import peng.zhi.liu.carmainpfpojo.vo.UserLoginVO;

public interface UserService {
    //用户注册
    public void userRegisterService(UserRegisterDTO userRegisterDTO);
    //用户登录
    public UserLoginVO userLoginService(UserLoginDTO userLoginDTO);
}
