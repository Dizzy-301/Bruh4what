package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ChangdiyuyueEntity;
import com.cl.entity.view.ChangdiyuyueView;

import com.cl.service.ChangdiyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 场地预约
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:04
 */
@RestController
@RequestMapping("/changdiyuyue")
public class ChangdiyuyueController {
    @Autowired
    private ChangdiyuyueService changdiyuyueService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ChangdiyuyueEntity changdiyuyue,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("toubiaodanwei")) {
            changdiyuyue.setToubiaozhanghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<ChangdiyuyueEntity> ew = new EntityWrapper<ChangdiyuyueEntity>();


        PageUtils page = changdiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiyuyue), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ChangdiyuyueEntity changdiyuyue,
                  HttpServletRequest request) {
        EntityWrapper<ChangdiyuyueEntity> ew = new EntityWrapper<ChangdiyuyueEntity>();

        PageUtils page = changdiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiyuyue), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ChangdiyuyueEntity changdiyuyue) {
        EntityWrapper<ChangdiyuyueEntity> ew = new EntityWrapper<ChangdiyuyueEntity>();
        ew.allEq(MPUtil.allEQMapPre(changdiyuyue, "changdiyuyue"));
        return R.ok().put("data", changdiyuyueService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdiyuyueEntity changdiyuyue) {
        EntityWrapper<ChangdiyuyueEntity> ew = new EntityWrapper<ChangdiyuyueEntity>();
        ew.allEq(MPUtil.allEQMapPre(changdiyuyue, "changdiyuyue"));
        ChangdiyuyueView changdiyuyueView = changdiyuyueService.selectView(ew);
        return R.ok("查询场地预约成功").put("data", changdiyuyueView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ChangdiyuyueEntity changdiyuyue = changdiyuyueService.selectById(id);
        changdiyuyue = changdiyuyueService.selectView(new EntityWrapper<ChangdiyuyueEntity>().eq("id", id));
        return R.ok().put("data", changdiyuyue);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ChangdiyuyueEntity changdiyuyue = changdiyuyueService.selectById(id);
        changdiyuyue = changdiyuyueService.selectView(new EntityWrapper<ChangdiyuyueEntity>().eq("id", id));
        return R.ok().put("data", changdiyuyue);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdiyuyueEntity changdiyuyue, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(changdiyuyue);
        changdiyuyueService.insert(changdiyuyue);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdiyuyueEntity changdiyuyue, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(changdiyuyue);
        changdiyuyueService.insert(changdiyuyue);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdiyuyueEntity changdiyuyue, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(changdiyuyue);
        changdiyuyueService.updateById(changdiyuyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf) {
        List<ChangdiyuyueEntity> list = new ArrayList<ChangdiyuyueEntity>();
        for (Long id : ids) {
            ChangdiyuyueEntity changdiyuyue = changdiyuyueService.selectById(id);
            changdiyuyue.setSfsh(sfsh);
            changdiyuyue.setShhf(shhf);
            list.add(changdiyuyue);
        }
        changdiyuyueService.updateBatchById(list);
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        changdiyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
