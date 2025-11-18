package peng.zhi.liu.carmainpfproject.controller;

import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peng.zhi.liu.carmainpfcommon.result.Result;
import peng.zhi.liu.carmainpfpojo.dto.AddPartDTO;
import peng.zhi.liu.carmainpfpojo.dto.PartQueryPageDTO;
import peng.zhi.liu.carmainpfpojo.entity.Part;
import peng.zhi.liu.carmainpfpojo.vo.PartPageVO;
import peng.zhi.liu.carmainpfproject.service.PartService;

@Slf4j
@RestController
@RequestMapping("/parts")
public class PartController {
    @Autowired
    private PartService partService;

    @PostMapping
    public Result addPartController(@RequestBody AddPartDTO addPartDTO) {
        log.info("添加商品：{}", addPartDTO);
        partService.addPart(addPartDTO);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getPartByIdController(@PathVariable Integer id) {
        log.info("查询商品：{}", id);
        Part part = partService.getPartById(id);
        return Result.success(part);
    }

    @GetMapping
    public Result getAllPartsController(PartQueryPageDTO partQueryPageDTO) {
        log.info("分页查询商品：{}",partQueryPageDTO);
        PartPageVO partPageVO = partService.getAllParts(partQueryPageDTO);
        return Result.success(partPageVO);
    }

    @PutMapping("/{id}")
    public Result updatePartController(@PathVariable Integer id, @RequestBody AddPartDTO addPartDTO) {
        log.info("更新商品：{}，{}", id, addPartDTO);
        partService.updatePart(id, addPartDTO);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deletePartController(@PathVariable Integer id) {
        log.info("删除商品：{}", id);
        partService.deletePart(id);
        return Result.success();
    }
}