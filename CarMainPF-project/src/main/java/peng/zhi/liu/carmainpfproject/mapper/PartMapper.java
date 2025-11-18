package peng.zhi.liu.carmainpfproject.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.carmainpfpojo.dto.PartQueryPageDTO;
import peng.zhi.liu.carmainpfpojo.entity.Part;

@Mapper
public interface PartMapper {
    //添加商品
    void addPartMapper(Part part);
    //根据id查询商品
    Part selectPartByIdMapper(Integer id);
    //分页查询
    Page<Part> selectAllByPageMapper(PartQueryPageDTO query);
    //更新商品
    void updatePartMapper(Part part);
    //根据id删除商品
    void deletePartByIdMapper(Integer id);
}