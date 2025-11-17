package peng.zhi.liu.carmainpfproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import peng.zhi.liu.carmainpfpojo.entity.User;

@Mapper
public interface UserMapper {
    //根据号码查询用户
    public User selectUserByPhoneMapper(String phone);
    //用户成功注册
    public void insertUserMapper(User user);
}
