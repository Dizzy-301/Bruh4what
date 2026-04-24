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

import com.cl.entity.ZhaobiaojihuaEntity;
import com.cl.entity.view.ZhaobiaojihuaView;

import com.cl.service.ZhaobiaojihuaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 招标计划
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@RestController
@RequestMapping("/zhaobiaojihua")
public class ZhaobiaojihuaController {
    @Autowired
    private ZhaobiaojihuaService zhaobiaojihuaService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhaobiaojihuaEntity zhaobiaojihua,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yezhudanwei")) {
            zhaobiaojihua.setQiyezhanghao((String) request.getSession().getAttribute("username"));
        }

        EntityWrapper<ZhaobiaojihuaEntity> ew = new EntityWrapper<ZhaobiaojihuaEntity>();


        PageUtils page = zhaobiaojihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaojihua), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ZhaobiaojihuaEntity zhaobiaojihua,
                  HttpServletRequest request) {
        EntityWrapper<ZhaobiaojihuaEntity> ew = new EntityWrapper<ZhaobiaojihuaEntity>();

        PageUtils page = zhaobiaojihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaojihua), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ZhaobiaojihuaEntity zhaobiaojihua) {
        EntityWrapper<ZhaobiaojihuaEntity> ew = new EntityWrapper<ZhaobiaojihuaEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhaobiaojihua, "zhaobiaojihua"));
        return R.ok().put("data", zhaobiaojihuaService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaobiaojihuaEntity zhaobiaojihua) {
        EntityWrapper<ZhaobiaojihuaEntity> ew = new EntityWrapper<ZhaobiaojihuaEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhaobiaojihua, "zhaobiaojihua"));
        ZhaobiaojihuaView zhaobiaojihuaView = zhaobiaojihuaService.selectView(ew);
        return R.ok("查询招标计划成功").put("data", zhaobiaojihuaView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ZhaobiaojihuaEntity zhaobiaojihua = zhaobiaojihuaService.selectById(id);
        zhaobiaojihua = zhaobiaojihuaService.selectView(new EntityWrapper<ZhaobiaojihuaEntity>().eq("id", id));
        return R.ok().put("data", zhaobiaojihua);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ZhaobiaojihuaEntity zhaobiaojihua = zhaobiaojihuaService.selectById(id);
        zhaobiaojihua = zhaobiaojihuaService.selectView(new EntityWrapper<ZhaobiaojihuaEntity>().eq("id", id));
        return R.ok().put("data", zhaobiaojihua);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaobiaojihuaEntity zhaobiaojihua, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaojihua);
        zhaobiaojihuaService.insert(zhaobiaojihua);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaobiaojihuaEntity zhaobiaojihua, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaojihua);
        zhaobiaojihuaService.insert(zhaobiaojihua);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaobiaojihuaEntity zhaobiaojihua, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaojihua);
        zhaobiaojihuaService.updateById(zhaobiaojihua);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        zhaobiaojihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
