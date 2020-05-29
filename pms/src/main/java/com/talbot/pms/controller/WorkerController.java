package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.WorkerEntity;
import com.talbot.pms.service.WorkerService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getWorkers(@RequestParam Map<String, Object> params) {
        PageUtils page = workerService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getWorkerById(@PathVariable("id") Integer id) {
        WorkerEntity worker = workerService.getById(id);

        return R.ok().put("worker", worker);
    }

    /**
     * 保存
     *
     * @param worker
     * @return
     */
    @PutMapping("/")
    public R saveWorker(@RequestBody WorkerEntity worker) {
        workerService.save(worker);

        return R.ok();
    }

    /**
     * 修改
     *
     * @param worker
     * @return
     */
    @PostMapping("/")
    public R updateWorker(@RequestBody WorkerEntity worker) {
        workerService.updateById(worker);

        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteWorker(@RequestBody Integer[] ids) {
        workerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
