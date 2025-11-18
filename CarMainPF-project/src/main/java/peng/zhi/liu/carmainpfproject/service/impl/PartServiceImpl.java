package peng.zhi.liu.carmainpfproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.carmainpfpojo.dto.AddPartDTO;
import peng.zhi.liu.carmainpfpojo.dto.PartQueryPageDTO;
import peng.zhi.liu.carmainpfpojo.entity.Part;
import peng.zhi.liu.carmainpfpojo.vo.PartPageVO;
import peng.zhi.liu.carmainpfproject.mapper.PartMapper;
import peng.zhi.liu.carmainpfproject.service.PartService;

import java.time.LocalDateTime;

@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartMapper partMapper;

    @Override
    public void addPart(AddPartDTO addPartDTO) {
        Part part = new Part();
        BeanUtils.copyProperties(addPartDTO, part);
        part.setCreateTime(LocalDateTime.now());
        part.setUpdateTime(LocalDateTime.now());
        partMapper.addPartMapper(part);
    }

    @Override
    public Part getPartById(Integer id) {
        return partMapper.selectPartByIdMapper(id);
    }

    @Override
    public PartPageVO getAllParts(PartQueryPageDTO partQueryPageDTO) {
        PageHelper.startPage(partQueryPageDTO.getPage(), partQueryPageDTO.getPageSize());
        Page<Part> parts = partMapper.selectAllByPageMapper(partQueryPageDTO);
        PartPageVO partPageVO = PartPageVO.builder().partList(parts.getResult()).total(parts.getTotal()).build();
        return partPageVO;
    }

    @Override
    public void updatePart(Integer id, AddPartDTO addPartDTO) {
        Part part = new Part();
        BeanUtils.copyProperties(addPartDTO, part);
        part.setId(id);
        part.setUpdateTime(LocalDateTime.now());
        partMapper.updatePartMapper(part);
    }

    @Override
    public void deletePart(Integer id) {
        partMapper.deletePartByIdMapper(id);
    }
}