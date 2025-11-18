package peng.zhi.liu.carmainpfpojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import peng.zhi.liu.carmainpfpojo.entity.Part;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartPageVO implements Serializable {
    private List<Part> partList;
    private Long total;
}
