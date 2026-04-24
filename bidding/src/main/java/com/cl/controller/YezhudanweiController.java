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

import com.cl.entity.YezhudanweiEntity;
import com.cl.entity.view.YezhudanweiView;

import com.cl.service.YezhudanweiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 业主单位
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@RestController
@RequestMapping("/yezhudanwei")
public class YezhudanweiController {
    @Autowired
    private YezhudanweiService yezhudanweiService;


    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YezhudanweiEntity u = yezhudanweiService.selectOne(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", username));
        if (u == null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        if (u.getSfsh() != null && u.getSfsh().equals("待审核")) {
            return R.error("账号待审核中，请联系管理员");
        }
        if (u.getSfsh() != null && u.getSfsh().equals("否")) {
            return R.error("账号审核未通过，请重新提交或联系管理员");
        }
        String token = tokenService.generateToken(u.getId(), username, "yezhudanwei", "业主单位");
        return R.ok().put("token", token);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YezhudanweiEntity yezhudanwei) {
        //ValidatorUtils.validateEntity(yezhudanwei);
        YezhudanweiEntity u = yezhudanweiService.selectOne(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", yezhudanwei.getQiyezhanghao()));
        if (u != null) {
            return R.error("注册用户已存在");
        }
        Long uId = new Date().getTime();
        yezhudanwei.setId(uId);
        yezhudanwei.setSfsh("待审核");
        yezhudanweiService.insert(yezhudanwei);
        return R.ok();
    }


    /**
     * 退出
     */
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request) {
        Long id = (Long) request.getSession().getAttribute("userId");
        return R.ok().put("data", yezhudanweiService.selectView(new EntityWrapper<YezhudanweiEntity>().eq("id", id)));
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YezhudanweiEntity u = yezhudanweiService.selectOne(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", username));
        if (u == null) {
            return R.error("账号不存在");
        }
        u.setMima("123456");
        yezhudanweiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取联系方式 (找回密码第一步)
     */
    @IgnoreAuth
    @RequestMapping("/getContact")
    public R getContact(String username) {
        YezhudanweiEntity u = yezhudanweiService.selectOne(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", username));
        if (u == null) {
            return R.error("账号不存在");
        }
        return R.ok();
    }

    /**
     * 校验联系方式 (找回密码第二步)
     */
    @IgnoreAuth
    @RequestMapping("/verifyContact")
    public R verifyContact(String username, String contact) {
        YezhudanweiEntity u = yezhudanweiService.selectOne(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", username));
        if (u == null || !u.getLianxidianhua().equals(contact)) {
            return R.error("账号或联系方式不匹配");
        }
        return R.ok();
    }

    /**
     * 重置密码 (找回密码第二步)
     */
    @IgnoreAuth
    @RequestMapping("/updatePassword")
    public R updatePassword(String username, String contact, String password) {
        YezhudanweiEntity u = yezhudanweiService.selectOne(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", username));
        if (u == null || !u.getLianxidianhua().equals(contact)) {
            return R.error("账号或联系方式不匹配");
        }
        u.setMima(password);
        yezhudanweiService.updateById(u);
        return R.ok("密码重置成功");
    }


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YezhudanweiEntity yezhudanwei,
                  HttpServletRequest request) {
        EntityWrapper<YezhudanweiEntity> ew = new EntityWrapper<YezhudanweiEntity>();


        PageUtils page = yezhudanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yezhudanwei), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, YezhudanweiEntity yezhudanwei,
                  HttpServletRequest request) {
        EntityWrapper<YezhudanweiEntity> ew = new EntityWrapper<YezhudanweiEntity>();

        PageUtils page = yezhudanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yezhudanwei), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(YezhudanweiEntity yezhudanwei) {
        EntityWrapper<YezhudanweiEntity> ew = new EntityWrapper<YezhudanweiEntity>();
        ew.allEq(MPUtil.allEQMapPre(yezhudanwei, "yezhudanwei"));
        return R.ok().put("data", yezhudanweiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YezhudanweiEntity yezhudanwei) {
        EntityWrapper<YezhudanweiEntity> ew = new EntityWrapper<YezhudanweiEntity>();
        ew.allEq(MPUtil.allEQMapPre(yezhudanwei, "yezhudanwei"));
        YezhudanweiView yezhudanweiView = yezhudanweiService.selectView(ew);
        return R.ok("查询业主单位成功").put("data", yezhudanweiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        YezhudanweiEntity yezhudanwei = yezhudanweiService.selectById(id);
        yezhudanwei = yezhudanweiService.selectView(new EntityWrapper<YezhudanweiEntity>().eq("id", id));
        return R.ok().put("data", yezhudanwei);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        YezhudanweiEntity yezhudanwei = yezhudanweiService.selectById(id);
        yezhudanwei = yezhudanweiService.selectView(new EntityWrapper<YezhudanweiEntity>().eq("id", id));
        return R.ok().put("data", yezhudanwei);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YezhudanweiEntity yezhudanwei, HttpServletRequest request) {
        if (yezhudanweiService.selectCount(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", yezhudanwei.getQiyezhanghao())) > 0) {
            return R.error("企业账号已存在");
        }
        yezhudanwei.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(yezhudanwei);
        YezhudanweiEntity u = yezhudanweiService.selectOne(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", yezhudanwei.getQiyezhanghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        yezhudanwei.setId(new Date().getTime());
        yezhudanwei.setSfsh("待审核");
        yezhudanweiService.insert(yezhudanwei);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YezhudanweiEntity yezhudanwei, HttpServletRequest request) {
        if (yezhudanweiService.selectCount(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", yezhudanwei.getQiyezhanghao())) > 0) {
            return R.error("企业账号已存在");
        }
        yezhudanwei.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(yezhudanwei);
        YezhudanweiEntity u = yezhudanweiService.selectOne(new EntityWrapper<YezhudanweiEntity>().eq("qiyezhanghao", yezhudanwei.getQiyezhanghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        yezhudanwei.setId(new Date().getTime());
        yezhudanwei.setSfsh("待审核");
        yezhudanweiService.insert(yezhudanwei);
        return R.ok();
    }



    /**
     * 审核
     */
    @RequestMapping("/sh/{tableName}")
    @Transactional
    public R sh(@RequestBody YezhudanweiEntity yezhudanwei) {
        yezhudanweiService.updateById(yezhudanwei);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YezhudanweiEntity yezhudanwei, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(yezhudanwei);
        yezhudanweiService.updateById(yezhudanwei);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        yezhudanweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
