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

import com.cl.entity.ZhaobiaogonggaoEntity;
import com.cl.entity.view.ZhaobiaogonggaoView;

import com.cl.service.ZhaobiaogonggaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 招标公告
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:04
 */
@RestController
@RequestMapping("/zhaobiaogonggao")
public class ZhaobiaogonggaoController {
    @Autowired
    private ZhaobiaogonggaoService zhaobiaogonggaoService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhaobiaogonggaoEntity zhaobiaogonggao,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("zhaobiaodaili")) {
            zhaobiaogonggao.setDailigongsizhanghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhaobiaogonggaoEntity> ew = new EntityWrapper<ZhaobiaogonggaoEntity>();


        PageUtils page = zhaobiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaogonggao), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ZhaobiaogonggaoEntity zhaobiaogonggao,
                  HttpServletRequest request) {
        EntityWrapper<ZhaobiaogonggaoEntity> ew = new EntityWrapper<ZhaobiaogonggaoEntity>();

        PageUtils page = zhaobiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaogonggao), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ZhaobiaogonggaoEntity zhaobiaogonggao) {
        EntityWrapper<ZhaobiaogonggaoEntity> ew = new EntityWrapper<ZhaobiaogonggaoEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhaobiaogonggao, "zhaobiaogonggao"));
        return R.ok().put("data", zhaobiaogonggaoService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaobiaogonggaoEntity zhaobiaogonggao) {
        EntityWrapper<ZhaobiaogonggaoEntity> ew = new EntityWrapper<ZhaobiaogonggaoEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhaobiaogonggao, "zhaobiaogonggao"));
        ZhaobiaogonggaoView zhaobiaogonggaoView = zhaobiaogonggaoService.selectView(ew);
        return R.ok("查询招标公告成功").put("data", zhaobiaogonggaoView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ZhaobiaogonggaoEntity zhaobiaogonggao = zhaobiaogonggaoService.selectById(id);
        zhaobiaogonggao = zhaobiaogonggaoService.selectView(new EntityWrapper<ZhaobiaogonggaoEntity>().eq("id", id));
        return R.ok().put("data", zhaobiaogonggao);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ZhaobiaogonggaoEntity zhaobiaogonggao = zhaobiaogonggaoService.selectById(id);
        zhaobiaogonggao = zhaobiaogonggaoService.selectView(new EntityWrapper<ZhaobiaogonggaoEntity>().eq("id", id));
        return R.ok().put("data", zhaobiaogonggao);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaobiaogonggaoEntity zhaobiaogonggao, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaogonggao);
        zhaobiaogonggaoService.insert(zhaobiaogonggao);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaobiaogonggaoEntity zhaobiaogonggao, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaogonggao);
        zhaobiaogonggaoService.insert(zhaobiaogonggao);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaobiaogonggaoEntity zhaobiaogonggao, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaogonggao);
        zhaobiaogonggaoService.updateById(zhaobiaogonggao);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf) {
        List<ZhaobiaogonggaoEntity> list = new ArrayList<ZhaobiaogonggaoEntity>();
        for (Long id : ids) {
            ZhaobiaogonggaoEntity zhaobiaogonggao = zhaobiaogonggaoService.selectById(id);
            zhaobiaogonggao.setSfsh(sfsh);
            zhaobiaogonggao.setShhf(shhf);
            list.add(zhaobiaogonggao);
        }
        zhaobiaogonggaoService.updateBatchById(list);
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        zhaobiaogonggaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
