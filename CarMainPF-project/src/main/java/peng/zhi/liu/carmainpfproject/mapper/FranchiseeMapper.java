package peng.zhi.liu.carmainpfproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.carmainpfpojo.entity.Franchisee;

@Mapper
public interface FranchiseeMapper {
    //根据电话查询加盟店
    public Franchisee selectFranByPhoneMapper(String phone);
    //注册加盟店
    public void addFranMapper(Franchisee franchisee);
}
