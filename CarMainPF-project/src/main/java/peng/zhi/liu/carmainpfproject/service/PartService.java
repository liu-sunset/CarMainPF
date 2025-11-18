package peng.zhi.liu.carmainpfproject.service;

import peng.zhi.liu.carmainpfpojo.dto.AddPartDTO;
import peng.zhi.liu.carmainpfpojo.dto.PartQueryPageDTO;
import peng.zhi.liu.carmainpfpojo.entity.Part;
import peng.zhi.liu.carmainpfpojo.vo.PartPageVO;

public interface PartService {
    //添加商品
    void addPart(AddPartDTO addPartDTO);
    //根据id查询商品
    Part getPartById(Integer id);
    //分页查询
    PartPageVO getAllParts(PartQueryPageDTO partQueryPageDTO);
    //更新商品
    void updatePart(Integer id, AddPartDTO addPartDTO);
    //根据id删除商品
    void deletePart(Integer id);
}