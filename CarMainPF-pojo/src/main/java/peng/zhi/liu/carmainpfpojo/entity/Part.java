package peng.zhi.liu.carmainpfpojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Part implements Serializable {
    private Integer id;
    private String partName;
    private Double price;
    private Double laborCost;
    private Integer stock = 0;
    private Integer isOnSale = 1;
    private Integer franchiseeId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
