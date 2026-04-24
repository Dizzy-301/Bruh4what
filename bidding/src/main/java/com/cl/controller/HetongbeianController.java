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

import com.cl.entity.HetongbeianEntity;
import com.cl.entity.view.HetongbeianView;

import com.cl.service.HetongbeianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 合同备案
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@RestController
@RequestMapping("/hetongbeian")
public class HetongbeianController {
    @Autowired
    private HetongbeianService hetongbeianService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HetongbeianEntity hetongbeian,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yezhudanwei")) {
            hetongbeian.setQiyezhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("toubiaodanwei")) {
            hetongbeian.setToubiaorenzhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("zhaobiaodaili")) {
            hetongbeian.setDailigongsizhanghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<HetongbeianEntity> ew = new EntityWrapper<HetongbeianEntity>();


        PageUtils page = hetongbeianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hetongbeian), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HetongbeianEntity hetongbeian,
                  HttpServletRequest request) {
        EntityWrapper<HetongbeianEntity> ew = new EntityWrapper<HetongbeianEntity>();

        PageUtils page = hetongbeianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hetongbeian), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(HetongbeianEntity hetongbeian) {
        EntityWrapper<HetongbeianEntity> ew = new EntityWrapper<HetongbeianEntity>();
        ew.allEq(MPUtil.allEQMapPre(hetongbeian, "hetongbeian"));
        return R.ok().put("data", hetongbeianService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HetongbeianEntity hetongbeian) {
        EntityWrapper<HetongbeianEntity> ew = new EntityWrapper<HetongbeianEntity>();
        ew.allEq(MPUtil.allEQMapPre(hetongbeian, "hetongbeian"));
        HetongbeianView hetongbeianView = hetongbeianService.selectView(ew);
        return R.ok("查询合同备案成功").put("data", hetongbeianView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        HetongbeianEntity hetongbeian = hetongbeianService.selectById(id);
        hetongbeian = hetongbeianService.selectView(new EntityWrapper<HetongbeianEntity>().eq("id", id));
        return R.ok().put("data", hetongbeian);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        HetongbeianEntity hetongbeian = hetongbeianService.selectById(id);
        hetongbeian = hetongbeianService.selectView(new EntityWrapper<HetongbeianEntity>().eq("id", id));
        return R.ok().put("data", hetongbeian);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HetongbeianEntity hetongbeian, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(hetongbeian);
        hetongbeianService.insert(hetongbeian);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HetongbeianEntity hetongbeian, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(hetongbeian);
        hetongbeianService.insert(hetongbeian);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HetongbeianEntity hetongbeian, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(hetongbeian);
        hetongbeianService.updateById(hetongbeian);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        hetongbeianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
