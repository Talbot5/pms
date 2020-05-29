package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.NoticeEntity;
import com.talbot.pms.service.NoticeService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:43
 */
@RestController
@RequestMapping("pms/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getNotices(@RequestParam Map<String, Object> params) {
        PageUtils page = noticeService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getNoticeById(@PathVariable("id") Integer id) {
        NoticeEntity notice = noticeService.getById(id);

        return R.ok().put("notice", notice);
    }

    /**
     * 保存
     *
     * @param notice
     * @return
     */
    @PutMapping("/")
    public R saveNotice(@RequestBody NoticeEntity notice) {
        noticeService.save(notice);

        return R.ok();
    }

    /**
     * 修改
     *
     * @param notice
     * @return
     */
    @PostMapping("/")
    public R updateNotice(@RequestBody NoticeEntity notice) {
        noticeService.updateById(notice);

        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteNotice(@RequestBody Integer[] ids) {
        noticeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
