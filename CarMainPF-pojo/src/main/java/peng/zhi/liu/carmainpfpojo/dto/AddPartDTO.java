package peng.zhi.liu.carmainpfpojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddPartDTO implements Serializable {
    private String partName;
    private Double price;
    private Double laborCost;
    private Integer stock;
    private Integer isOnSale;
    private Integer franchiseeId;
}