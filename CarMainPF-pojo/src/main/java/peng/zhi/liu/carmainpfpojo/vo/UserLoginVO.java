package peng.zhi.liu.carmainpfpojo.vo;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class UserLoginVO implements Serializable {
    private String token;
    private UserVO userVO;
}
