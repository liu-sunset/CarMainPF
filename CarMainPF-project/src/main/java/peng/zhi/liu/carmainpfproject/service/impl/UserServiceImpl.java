package peng.zhi.liu.carmainpfproject.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.carmainpfcommon.constant.UserConstant;
import peng.zhi.liu.carmainpfcommon.exception.UserException;
import peng.zhi.liu.carmainpfpojo.dto.UserRegisterDTO;
import peng.zhi.liu.carmainpfpojo.entity.User;
import peng.zhi.liu.carmainpfproject.controller.user.UserController;
import peng.zhi.liu.carmainpfproject.mapper.UserMapper;
import peng.zhi.liu.carmainpfproject.service.UserService;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void userRegisterService(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        User userTemp = userMapper.selectUserByPhoneMapper(userRegisterDTO.getPhone());
        if (userTemp==null){
            BeanUtils.copyProperties(userRegisterDTO,user);
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            userMapper.insertUserMapper(user);
        }else {
            throw new UserException(UserConstant.USER_EXIST);
        }
    }
}
