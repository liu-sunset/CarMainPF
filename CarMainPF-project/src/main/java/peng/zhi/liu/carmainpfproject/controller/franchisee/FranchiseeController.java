package peng.zhi.liu.carmainpfproject.controller.franchisee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peng.zhi.liu.carmainpfcommon.result.Result;
import peng.zhi.liu.carmainpfpojo.dto.FranchiseeRegisterDTO;
import peng.zhi.liu.carmainpfproject.service.FranchiseeService;

@Slf4j
@RestController
@RequestMapping("/franchisee")
public class FranchiseeController {
    @Autowired
    private FranchiseeService franchiseeService;
    @PostMapping("/register")
    public Result franchiseeRegisterController(@RequestBody FranchiseeRegisterDTO franchiseeRegisterDTO){
        log.info("加盟店注册信息：{}",franchiseeRegisterDTO);
        franchiseeService.franchiseeRegisterService(franchiseeRegisterDTO);
        return Result.success();
    }
}
