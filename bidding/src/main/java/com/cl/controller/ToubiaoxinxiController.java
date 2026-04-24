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

import com.cl.entity.ToubiaoxinxiEntity;
import com.cl.entity.ZhaobiaoxiangmuEntity;
import com.cl.entity.ZhongbiaogonggaoEntity;
import com.cl.entity.view.ToubiaoxinxiView;

import com.cl.service.ToubiaoxinxiService;
import com.cl.service.ZhaobiaoxiangmuService;
import com.cl.service.ZhongbiaogonggaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 投标信息
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@RestController
@RequestMapping("/toubiaoxinxi")
public class ToubiaoxinxiController {
    @Autowired
    private ToubiaoxinxiService toubiaoxinxiService;

    @Autowired
    private ZhaobiaoxiangmuService zhaobiaoxiangmuService;

    @Autowired
    private ZhongbiaogonggaoService zhongbiaogonggaoService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ToubiaoxinxiEntity toubiaoxinxi,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yezhudanwei")) {
            toubiaoxinxi.setQiyezhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("toubiaodanwei")) {
            toubiaoxinxi.setToubiaozhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("zhaobiaodaili")) {
            toubiaoxinxi.setDailigongsizhanghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<ToubiaoxinxiEntity> ew = new EntityWrapper<ToubiaoxinxiEntity>();


        PageUtils page = toubiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toubiaoxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ToubiaoxinxiEntity toubiaoxinxi,
                  HttpServletRequest request) {
        EntityWrapper<ToubiaoxinxiEntity> ew = new EntityWrapper<ToubiaoxinxiEntity>();

        PageUtils page = toubiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toubiaoxinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ToubiaoxinxiEntity toubiaoxinxi) {
        EntityWrapper<ToubiaoxinxiEntity> ew = new EntityWrapper<ToubiaoxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre(toubiaoxinxi, "toubiaoxinxi"));
        return R.ok().put("data", toubiaoxinxiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ToubiaoxinxiEntity toubiaoxinxi) {
        EntityWrapper<ToubiaoxinxiEntity> ew = new EntityWrapper<ToubiaoxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre(toubiaoxinxi, "toubiaoxinxi"));
        ToubiaoxinxiView toubiaoxinxiView = toubiaoxinxiService.selectView(ew);
        return R.ok("查询投标信息成功").put("data", toubiaoxinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ToubiaoxinxiEntity toubiaoxinxi = toubiaoxinxiService.selectById(id);
        toubiaoxinxi = toubiaoxinxiService.selectView(new EntityWrapper<ToubiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", toubiaoxinxi);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ToubiaoxinxiEntity toubiaoxinxi = toubiaoxinxiService.selectById(id);
        toubiaoxinxi = toubiaoxinxiService.selectView(new EntityWrapper<ToubiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", toubiaoxinxi);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ToubiaoxinxiEntity toubiaoxinxi, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(toubiaoxinxi);
        if (zhongbiaogonggaoService.selectCount(new EntityWrapper<ZhongbiaogonggaoEntity>().eq("xiangmumingcheng", toubiaoxinxi.getXiangmumingcheng())) > 0) {
            return R.error("该项目已有投标单位中标");
        }
        ZhaobiaoxiangmuEntity zhaobiaoxiangmu = zhaobiaoxiangmuService.selectOne(new EntityWrapper<ZhaobiaoxiangmuEntity>().eq("xiangmumingcheng", toubiaoxinxi.getXiangmumingcheng()));
        if (zhaobiaoxiangmu != null) {
            // 校验预算
            if (toubiaoxinxi.getToubiaozongbaojia() != null && zhaobiaoxiangmu.getXiangmuyusuan() != null) {
                if (toubiaoxinxi.getToubiaozongbaojia() > zhaobiaoxiangmu.getXiangmuyusuan()) {
                    return R.error("总报价不能高于项目预算");
                }
            }
            Date now = new Date();
            if (zhaobiaoxiangmu.getKaibiaoshijian() != null && now.before(zhaobiaoxiangmu.getKaibiaoshijian())) {
                return R.error("未到开标时间，暂不能投标");
            }
            if (zhaobiaoxiangmu.getToubiaojiezhishijian() != null && now.after(zhaobiaoxiangmu.getToubiaojiezhishijian())) {
                return R.error("投标已截止");
            }
        }
        toubiaoxinxiService.insert(toubiaoxinxi);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ToubiaoxinxiEntity toubiaoxinxi, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(toubiaoxinxi);
        if (zhongbiaogonggaoService.selectCount(new EntityWrapper<ZhongbiaogonggaoEntity>().eq("xiangmumingcheng", toubiaoxinxi.getXiangmumingcheng())) > 0) {
            return R.error("该项目已有投标单位中标");
        }
        ZhaobiaoxiangmuEntity zhaobiaoxiangmu = zhaobiaoxiangmuService.selectOne(new EntityWrapper<ZhaobiaoxiangmuEntity>().eq("xiangmumingcheng", toubiaoxinxi.getXiangmumingcheng()));
        if (zhaobiaoxiangmu != null) {
            // 校验预算
            if (toubiaoxinxi.getToubiaozongbaojia() != null && zhaobiaoxiangmu.getXiangmuyusuan() != null) {
                if (toubiaoxinxi.getToubiaozongbaojia() > zhaobiaoxiangmu.getXiangmuyusuan()) {
                    return R.error("总报价不能高于项目预算");
                }
            }
            Date now = new Date();
            if (zhaobiaoxiangmu.getKaibiaoshijian() != null && now.before(zhaobiaoxiangmu.getKaibiaoshijian())) {
                return R.error("未到开标时间，暂不能投标");
            }
            if (zhaobiaoxiangmu.getToubiaojiezhishijian() != null && now.after(zhaobiaoxiangmu.getToubiaojiezhishijian())) {
                return R.error("投标已截止");
            }
        }
        toubiaoxinxiService.insert(toubiaoxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ToubiaoxinxiEntity toubiaoxinxi, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(toubiaoxinxi);
        toubiaoxinxiService.updateById(toubiaoxinxi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        toubiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
