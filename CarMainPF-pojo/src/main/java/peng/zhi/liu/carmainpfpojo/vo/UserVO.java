package peng.zhi.liu.carmainpfpojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class UserVO implements Serializable {
    private Integer id;
    private String userName;
    private String phone;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
