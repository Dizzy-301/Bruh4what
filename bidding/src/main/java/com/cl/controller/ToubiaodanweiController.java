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

import com.cl.entity.ToubiaodanweiEntity;
import com.cl.entity.view.ToubiaodanweiView;

import com.cl.service.ToubiaodanweiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 投标单位
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@RestController
@RequestMapping("/toubiaodanwei")
public class ToubiaodanweiController {
    @Autowired
    private ToubiaodanweiService toubiaodanweiService;


    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", username));
        if (u == null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(u.getId(), username, "toubiaodanwei", "投标单位");
        return R.ok().put("token", token);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ToubiaodanweiEntity toubiaodanwei) {
        //ValidatorUtils.validateEntity(toubiaodanwei);
        ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", toubiaodanwei.getToubiaozhanghao()));
        if (u != null) {
            return R.error("注册用户已存在");
        }
        Long uId = new Date().getTime();
        toubiaodanwei.setId(uId);
        toubiaodanweiService.insert(toubiaodanwei);
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
        return R.ok().put("data", toubiaodanweiService.selectView(new EntityWrapper<ToubiaodanweiEntity>().eq("id", id)));
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", username));
        if (u == null) {
            return R.error("账号不存在");
        }
        u.setMima("123456");
        toubiaodanweiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取联系方式 (找回密码第一步)
     */
    @IgnoreAuth
    @RequestMapping("/getContact")
    public R getContact(String username) {
        ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", username));
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
        ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", username));
        if (u == null || !u.getShoujihao().equals(contact)) {
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
        ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", username));
        if (u == null || !u.getShoujihao().equals(contact)) {
            return R.error("账号或联系方式不匹配");
        }
        u.setMima(password);
        toubiaodanweiService.updateById(u);
        return R.ok("密码重置成功");
    }


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ToubiaodanweiEntity toubiaodanwei,
                  HttpServletRequest request) {
        EntityWrapper<ToubiaodanweiEntity> ew = new EntityWrapper<ToubiaodanweiEntity>();


        PageUtils page = toubiaodanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toubiaodanwei), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ToubiaodanweiEntity toubiaodanwei,
                  HttpServletRequest request) {
        EntityWrapper<ToubiaodanweiEntity> ew = new EntityWrapper<ToubiaodanweiEntity>();

        PageUtils page = toubiaodanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toubiaodanwei), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ToubiaodanweiEntity toubiaodanwei) {
        EntityWrapper<ToubiaodanweiEntity> ew = new EntityWrapper<ToubiaodanweiEntity>();
        ew.allEq(MPUtil.allEQMapPre(toubiaodanwei, "toubiaodanwei"));
        return R.ok().put("data", toubiaodanweiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ToubiaodanweiEntity toubiaodanwei) {
        EntityWrapper<ToubiaodanweiEntity> ew = new EntityWrapper<ToubiaodanweiEntity>();
        ew.allEq(MPUtil.allEQMapPre(toubiaodanwei, "toubiaodanwei"));
        ToubiaodanweiView toubiaodanweiView = toubiaodanweiService.selectView(ew);
        return R.ok("查询投标单位成功").put("data", toubiaodanweiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ToubiaodanweiEntity toubiaodanwei = toubiaodanweiService.selectById(id);
        toubiaodanwei = toubiaodanweiService.selectView(new EntityWrapper<ToubiaodanweiEntity>().eq("id", id));
        return R.ok().put("data", toubiaodanwei);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ToubiaodanweiEntity toubiaodanwei = toubiaodanweiService.selectById(id);
        toubiaodanwei = toubiaodanweiService.selectView(new EntityWrapper<ToubiaodanweiEntity>().eq("id", id));
        return R.ok().put("data", toubiaodanwei);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ToubiaodanweiEntity toubiaodanwei, HttpServletRequest request) {
        if (toubiaodanweiService.selectCount(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", toubiaodanwei.getToubiaozhanghao())) > 0) {
            return R.error("投标账号已存在");
        }
        toubiaodanwei.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(toubiaodanwei);
        ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", toubiaodanwei.getToubiaozhanghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        toubiaodanwei.setId(new Date().getTime());
        toubiaodanweiService.insert(toubiaodanwei);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ToubiaodanweiEntity toubiaodanwei, HttpServletRequest request) {
        if (toubiaodanweiService.selectCount(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", toubiaodanwei.getToubiaozhanghao())) > 0) {
            return R.error("投标账号已存在");
        }
        toubiaodanwei.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(toubiaodanwei);
        ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaozhanghao", toubiaodanwei.getToubiaozhanghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        toubiaodanwei.setId(new Date().getTime());
        toubiaodanweiService.insert(toubiaodanwei);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ToubiaodanweiEntity toubiaodanwei, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(toubiaodanwei);
        toubiaodanweiService.updateById(toubiaodanwei);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        toubiaodanweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
