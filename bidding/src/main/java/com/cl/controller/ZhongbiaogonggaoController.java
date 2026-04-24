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

import com.cl.entity.ZhongbiaogonggaoEntity;
import com.cl.entity.view.ZhongbiaogonggaoView;

import com.cl.service.ZhongbiaogonggaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 中标公告
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@RestController
@RequestMapping("/zhongbiaogonggao")
public class ZhongbiaogonggaoController {
    @Autowired
    private ZhongbiaogonggaoService zhongbiaogonggaoService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhongbiaogonggaoEntity zhongbiaogonggao,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("zhaobiaodaili")) {
            zhongbiaogonggao.setDailigongsizhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("yezhudanwei")) {
            zhongbiaogonggao.setQiyezhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("toubiaodanwei")) {
            zhongbiaogonggao.setToubiaorenzhanghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhongbiaogonggaoEntity> ew = new EntityWrapper<ZhongbiaogonggaoEntity>();


        PageUtils page = zhongbiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongbiaogonggao), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ZhongbiaogonggaoEntity zhongbiaogonggao,
                  HttpServletRequest request) {
        EntityWrapper<ZhongbiaogonggaoEntity> ew = new EntityWrapper<ZhongbiaogonggaoEntity>();

        PageUtils page = zhongbiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongbiaogonggao), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ZhongbiaogonggaoEntity zhongbiaogonggao) {
        EntityWrapper<ZhongbiaogonggaoEntity> ew = new EntityWrapper<ZhongbiaogonggaoEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhongbiaogonggao, "zhongbiaogonggao"));
        return R.ok().put("data", zhongbiaogonggaoService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhongbiaogonggaoEntity zhongbiaogonggao) {
        EntityWrapper<ZhongbiaogonggaoEntity> ew = new EntityWrapper<ZhongbiaogonggaoEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhongbiaogonggao, "zhongbiaogonggao"));
        ZhongbiaogonggaoView zhongbiaogonggaoView = zhongbiaogonggaoService.selectView(ew);
        return R.ok("查询中标公告成功").put("data", zhongbiaogonggaoView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ZhongbiaogonggaoEntity zhongbiaogonggao = zhongbiaogonggaoService.selectById(id);
        zhongbiaogonggao = zhongbiaogonggaoService.selectView(new EntityWrapper<ZhongbiaogonggaoEntity>().eq("id", id));
        return R.ok().put("data", zhongbiaogonggao);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ZhongbiaogonggaoEntity zhongbiaogonggao = zhongbiaogonggaoService.selectById(id);
        zhongbiaogonggao = zhongbiaogonggaoService.selectView(new EntityWrapper<ZhongbiaogonggaoEntity>().eq("id", id));
        return R.ok().put("data", zhongbiaogonggao);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhongbiaogonggaoEntity zhongbiaogonggao, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhongbiaogonggao);
        zhongbiaogonggaoService.insert(zhongbiaogonggao);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhongbiaogonggaoEntity zhongbiaogonggao, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhongbiaogonggao);
        zhongbiaogonggaoService.insert(zhongbiaogonggao);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhongbiaogonggaoEntity zhongbiaogonggao, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhongbiaogonggao);
        zhongbiaogonggaoService.updateById(zhongbiaogonggao);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        zhongbiaogonggaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
