package peng.zhi.liu.carmainpfpojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseeRegisterDTO {
    private String storeName;
    private String contactPerson;
    private String phone;
    private String address;
}
