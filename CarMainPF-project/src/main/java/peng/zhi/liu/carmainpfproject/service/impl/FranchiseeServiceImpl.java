package peng.zhi.liu.carmainpfproject.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.carmainpfcommon.constant.FranchiseeConstant;
import peng.zhi.liu.carmainpfcommon.exception.FranchiseeException;
import peng.zhi.liu.carmainpfpojo.dto.FranchiseeRegisterDTO;
import peng.zhi.liu.carmainpfpojo.entity.Franchisee;
import peng.zhi.liu.carmainpfproject.mapper.FranchiseeMapper;
import peng.zhi.liu.carmainpfproject.service.FranchiseeService;

import java.time.LocalDateTime;

@Service
public class FranchiseeServiceImpl implements FranchiseeService {
    @Autowired
    private FranchiseeMapper franchiseeMapper;
    @Override
    public void franchiseeRegisterService(FranchiseeRegisterDTO franchiseeRegisterDTO) {
        Franchisee franchisee = new Franchisee();
        Franchisee franchiseeTemp = franchiseeMapper.selectFranByPhoneMapper(franchiseeRegisterDTO.getPhone());
        if(franchiseeTemp==null){
            BeanUtils.copyProperties(franchiseeRegisterDTO,franchisee);
            franchisee.setCreateTime(LocalDateTime.now());
            franchisee.setUpdateTime(LocalDateTime.now());
            franchisee.setAdmitStatus(0);
            franchiseeMapper.addFranMapper(franchisee);
        }else {
            throw new FranchiseeException(FranchiseeConstant.FRANCHISEE_EXIST);
        }
    }
}
