package peng.zhi.liu.carmainpfpojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartQueryPageDTO implements Serializable {
    private String partName;
    private Integer franchiseeId;
    private Integer page;
    private Integer pageSize;
}