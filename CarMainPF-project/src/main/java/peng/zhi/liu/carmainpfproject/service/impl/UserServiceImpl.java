package peng.zhi.liu.carmainpfproject.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.carmainpfcommon.constant.UserConstant;
import peng.zhi.liu.carmainpfcommon.exception.UserException;
import peng.zhi.liu.carmainpfcommon.utils.JWTUtils;
import peng.zhi.liu.carmainpfpojo.dto.UserLoginDTO;
import peng.zhi.liu.carmainpfpojo.dto.UserRegisterDTO;
import peng.zhi.liu.carmainpfpojo.entity.User;
import peng.zhi.liu.carmainpfpojo.property.JWTProperty;
import peng.zhi.liu.carmainpfpojo.vo.UserLoginVO;
import peng.zhi.liu.carmainpfpojo.vo.UserVO;
import peng.zhi.liu.carmainpfproject.mapper.UserMapper;
import peng.zhi.liu.carmainpfproject.service.UserService;
import java.time.LocalDateTime;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JWTProperty jwtProperty;
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

    @Override
    public UserLoginVO userLoginService(UserLoginDTO userLoginDTO) {
        //查询用户
        User user = userMapper.selectUserByPhoneMapper(userLoginDTO.getPhone());
        if(user==null){
            throw new UserException(UserConstant.USER_NO_EXIST);
        }
        String password = user.getPassword();
        if (password.equals(userLoginDTO.getPassword())){
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId",user.getId());
            String token = JWTUtils.createJWT(jwtProperty.getSecretKey(), jwtProperty.getTtlTime(), map);
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user,userVO);
            UserLoginVO build = UserLoginVO.builder().token(token).userVO(userVO).build();
            return build;
        }else {
            throw new UserException(UserConstant.PASSWORD_ERROR);
        }
    }
}
