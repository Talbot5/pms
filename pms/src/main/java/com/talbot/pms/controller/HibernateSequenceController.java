package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talbot.pms.entity.HibernateSequenceEntity;
import com.talbot.pms.service.HibernateSequenceService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;



/**
 * 
 *
 * @author Talobt
 * @email 2806972787@qq.com
 * @date 2020-05-28 21:40:24
 */
@RestController
@RequestMapping("pms/hibernatesequence")
public class HibernateSequenceController {
    @Autowired
    private HibernateSequenceService hibernateSequenceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hibernateSequenceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{nextVal}")
    public R info(@PathVariable("nextVal") Long nextVal){
		HibernateSequenceEntity hibernateSequence = hibernateSequenceService.getById(nextVal);

        return R.ok().put("hibernateSequence", hibernateSequence);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HibernateSequenceEntity hibernateSequence){
		hibernateSequenceService.save(hibernateSequence);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HibernateSequenceEntity hibernateSequence){
		hibernateSequenceService.updateById(hibernateSequence);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] nextVals){
		hibernateSequenceService.removeByIds(Arrays.asList(nextVals));

        return R.ok();
    }

}
