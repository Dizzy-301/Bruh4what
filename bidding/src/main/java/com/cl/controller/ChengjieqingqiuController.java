package com.cl.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cl.entity.ChengjieqingqiuEntity;
import com.cl.service.ChengjieqingqiuService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.annotation.IgnoreAuth;

/**
 * 承接申请
 * 后端接口
 */
@RestController
@RequestMapping("/chengjieqingqiu")
public class ChengjieqingqiuController {
    @Autowired
    private ChengjieqingqiuService chengjieqingqiuService;

    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ChengjieqingqiuEntity chengjieqingqiu, HttpServletRequest request){
        EntityWrapper<ChengjieqingqiuEntity> ew = new EntityWrapper<ChengjieqingqiuEntity>();
        
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yezhudanwei")) {
            chengjieqingqiu.setQiyezhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("zhaobiaodaili")) {
            chengjieqingqiu.setDailigongsizhanghao((String) request.getSession().getAttribute("username"));
        }

        PageUtils page = chengjieqingqiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengjieqingqiu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ChengjieqingqiuEntity chengjieqingqiu, HttpServletRequest request){
        EntityWrapper<ChengjieqingqiuEntity> ew = new EntityWrapper<ChengjieqingqiuEntity>();
        PageUtils page = chengjieqingqiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengjieqingqiu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChengjieqingqiuEntity chengjieqingqiu = chengjieqingqiuService.selectById(id);
        return R.ok().put("data", chengjieqingqiu);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChengjieqingqiuEntity chengjieqingqiu, HttpServletRequest request){
        chengjieqingqiuService.insert(chengjieqingqiu);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChengjieqingqiuEntity chengjieqingqiu, HttpServletRequest request){
        chengjieqingqiuService.insert(chengjieqingqiu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChengjieqingqiuEntity chengjieqingqiu, HttpServletRequest request){
        chengjieqingqiuService.updateById(chengjieqingqiu);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chengjieqingqiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
