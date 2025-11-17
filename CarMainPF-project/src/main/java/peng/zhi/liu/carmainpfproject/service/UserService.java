package peng.zhi.liu.carmainpfproject.service;

import peng.zhi.liu.carmainpfpojo.dto.UserRegisterDTO;
import peng.zhi.liu.carmainpfpojo.entity.User;

public interface UserService {
    //用户注册
    public void userRegisterService(UserRegisterDTO userRegisterDTO);
}
