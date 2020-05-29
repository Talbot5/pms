package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.CarPositionEntity;
import com.talbot.pms.service.CarPositionService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/carposition")
public class CarPositionController {
    @Autowired
    private CarPositionService carPositionService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping
    public R getCarPositions(@RequestParam Map<String, Object> params) {
        PageUtils page = carPositionService.queryPage(params);

        return R.getR(page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public R getCarPositionById(@PathVariable("id") Integer id) {
        CarPositionEntity carPosition = carPositionService.getById(id);
        if (carPosition != null) {
            return R.ok().put("carPosition", carPosition);
        }
        return R.error("查询失败");
    }

    /**
     * 保存
     *
     * @param carPosition
     * @return
     */
    @PutMapping
    public R saveCarPosition(@RequestBody CarPositionEntity carPosition) {
        if(carPositionService.save(carPosition)){

        return R.ok("保存成功");}
        return R.error("保存失败");
    }

    /**
     * 修改
     *
     * @param carPosition
     * @return
     */
    @PostMapping
    public R updateCarPosition(@RequestBody CarPositionEntity carPosition) {
        if(carPositionService.updateById(carPosition)){

        return R.ok("修改成功");}
        return R.error("修改失败");
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    public R deleteCarPosition(@RequestBody Integer[] ids) {
        if(carPositionService.removeByIds(Arrays.asList(ids))){

        return R.ok("删除成功");}
        return R.error("删除失败");
    }

}
