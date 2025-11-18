package peng.zhi.liu.carmainpfpojo.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserLoginDTO {
    private String phone;
    private String password;
}
