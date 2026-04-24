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

import com.cl.entity.ZhaobiaoxiangmuEntity;
import com.cl.entity.view.ZhaobiaoxiangmuView;

import com.cl.service.ZhaobiaoxiangmuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 招标项目
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@RestController
@RequestMapping("/zhaobiaoxiangmu")
public class ZhaobiaoxiangmuController {
    @Autowired
    private ZhaobiaoxiangmuService zhaobiaoxiangmuService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhaobiaoxiangmuEntity zhaobiaoxiangmu,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yezhudanwei")) {
            zhaobiaoxiangmu.setQiyezhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("zhaobiaodaili")) {
            zhaobiaoxiangmu.setDailigongsizhanghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhaobiaoxiangmuEntity> ew = new EntityWrapper<ZhaobiaoxiangmuEntity>();


        PageUtils page = zhaobiaoxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaoxiangmu), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ZhaobiaoxiangmuEntity zhaobiaoxiangmu,
                  HttpServletRequest request) {
        EntityWrapper<ZhaobiaoxiangmuEntity> ew = new EntityWrapper<ZhaobiaoxiangmuEntity>();

        PageUtils page = zhaobiaoxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaoxiangmu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ZhaobiaoxiangmuEntity zhaobiaoxiangmu) {
        EntityWrapper<ZhaobiaoxiangmuEntity> ew = new EntityWrapper<ZhaobiaoxiangmuEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhaobiaoxiangmu, "zhaobiaoxiangmu"));
        return R.ok().put("data", zhaobiaoxiangmuService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaobiaoxiangmuEntity zhaobiaoxiangmu) {
        EntityWrapper<ZhaobiaoxiangmuEntity> ew = new EntityWrapper<ZhaobiaoxiangmuEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhaobiaoxiangmu, "zhaobiaoxiangmu"));
        ZhaobiaoxiangmuView zhaobiaoxiangmuView = zhaobiaoxiangmuService.selectView(ew);
        return R.ok("查询招标项目成功").put("data", zhaobiaoxiangmuView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ZhaobiaoxiangmuEntity zhaobiaoxiangmu = zhaobiaoxiangmuService.selectById(id);
        zhaobiaoxiangmu = zhaobiaoxiangmuService.selectView(new EntityWrapper<ZhaobiaoxiangmuEntity>().eq("id", id));
        return R.ok().put("data", zhaobiaoxiangmu);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ZhaobiaoxiangmuEntity zhaobiaoxiangmu = zhaobiaoxiangmuService.selectById(id);
        zhaobiaoxiangmu = zhaobiaoxiangmuService.selectView(new EntityWrapper<ZhaobiaoxiangmuEntity>().eq("id", id));
        return R.ok().put("data", zhaobiaoxiangmu);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaobiaoxiangmuEntity zhaobiaoxiangmu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaoxiangmu);
        if (zhaobiaoxiangmu.getToubiaojiezhishijian() != null && zhaobiaoxiangmu.getKaibiaoshijian() != null) {
            if (zhaobiaoxiangmu.getToubiaojiezhishijian().before(zhaobiaoxiangmu.getKaibiaoshijian())) {
                return R.error("截止时间不能早于开标时间");
            }
        }
        zhaobiaoxiangmuService.insert(zhaobiaoxiangmu);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaobiaoxiangmuEntity zhaobiaoxiangmu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaoxiangmu);
        if (zhaobiaoxiangmu.getToubiaojiezhishijian() != null && zhaobiaoxiangmu.getKaibiaoshijian() != null) {
            if (zhaobiaoxiangmu.getToubiaojiezhishijian().before(zhaobiaoxiangmu.getKaibiaoshijian())) {
                return R.error("截止时间不能早于开标时间");
            }
        }
        zhaobiaoxiangmuService.insert(zhaobiaoxiangmu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaobiaoxiangmuEntity zhaobiaoxiangmu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaoxiangmu);
        ZhaobiaoxiangmuEntity oldEntity = zhaobiaoxiangmuService.selectById(zhaobiaoxiangmu.getId());
        if (oldEntity != null && oldEntity.getXiangmuyusuan() != null &&
                !oldEntity.getXiangmuyusuan().equals(zhaobiaoxiangmu.getXiangmuyusuan())) {
            return R.error("项目预算在发布后不能更改");
        }
        if (zhaobiaoxiangmu.getToubiaojiezhishijian() != null && zhaobiaoxiangmu.getKaibiaoshijian() != null) {
            if (zhaobiaoxiangmu.getToubiaojiezhishijian().before(zhaobiaoxiangmu.getKaibiaoshijian())) {
                return R.error("截止时间不能早于开标时间");
            }
        }
        zhaobiaoxiangmuService.updateById(zhaobiaoxiangmu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf) {
        List<ZhaobiaoxiangmuEntity> list = new ArrayList<ZhaobiaoxiangmuEntity>();
        for (Long id : ids) {
            ZhaobiaoxiangmuEntity zhaobiaoxiangmu = zhaobiaoxiangmuService.selectById(id);
            zhaobiaoxiangmu.setSfsh(sfsh);
            zhaobiaoxiangmu.setShhf(shhf);
            list.add(zhaobiaoxiangmu);
        }
        zhaobiaoxiangmuService.updateBatchById(list);
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        zhaobiaoxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
