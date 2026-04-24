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

import com.cl.entity.ZhaobiaodailiEntity;
import com.cl.entity.view.ZhaobiaodailiView;

import com.cl.service.ZhaobiaodailiService;
import com.cl.service.ToubiaoxinxiService;
import com.cl.service.TokenService;
import com.cl.entity.ToubiaoxinxiEntity;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 招标代理
 * 后端接口
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@RestController
@RequestMapping("/zhaobiaodaili")
public class ZhaobiaodailiController {
    @Autowired
    private ZhaobiaodailiService zhaobiaodailiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ToubiaoxinxiService toubiaoxinxiService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhaobiaodailiEntity u = zhaobiaodailiService.selectOne(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", username));
        if (u == null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        if (u.getSfsh() != null && u.getSfsh().equals("待审核")) {
            return R.error("账号待审核中，请联系管理员");
        }
        if (u.getSfsh() != null && u.getSfsh().equals("否")) {
            return R.error("账号审核未通过，请重新提交或联系管理员");
        }
        String token = tokenService.generateToken(u.getId(), username, "zhaobiaodaili", "招标代理");
        return R.ok().put("token", token);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ZhaobiaodailiEntity zhaobiaodaili) {
        //ValidatorUtils.validateEntity(zhaobiaodaili);
        ZhaobiaodailiEntity u = zhaobiaodailiService.selectOne(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", zhaobiaodaili.getDailigongsizhanghao()));
        if (u != null) {
            return R.error("注册用户已存在");
        }
        Long uId = new Date().getTime();
        zhaobiaodaili.setId(uId);
        zhaobiaodaili.setSfsh("待审核");
        zhaobiaodailiService.insert(zhaobiaodaili);
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
        return R.ok().put("data", zhaobiaodailiService.selectView(new EntityWrapper<ZhaobiaodailiEntity>().eq("id", id)));
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZhaobiaodailiEntity u = zhaobiaodailiService.selectOne(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", username));
        if (u == null) {
            return R.error("账号不存在");
        }
        u.setMima("123456");
        zhaobiaodailiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取联系方式 (找回密码第一步)
     */
    @IgnoreAuth
    @RequestMapping("/getContact")
    public R getContact(String username) {
        ZhaobiaodailiEntity u = zhaobiaodailiService.selectOne(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", username));
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
        ZhaobiaodailiEntity u = zhaobiaodailiService.selectOne(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", username));
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
        ZhaobiaodailiEntity u = zhaobiaodailiService.selectOne(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", username));
        if (u == null || !u.getLianxidianhua().equals(contact)) {
            return R.error("账号或联系方式不匹配");
        }
        u.setMima(password);
        zhaobiaodailiService.updateById(u);
        return R.ok("密码重置成功");
    }


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhaobiaodailiEntity zhaobiaodaili,
                  HttpServletRequest request) {
        EntityWrapper<ZhaobiaodailiEntity> ew = new EntityWrapper<ZhaobiaodailiEntity>();


        PageUtils page = zhaobiaodailiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaodaili), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ZhaobiaodailiEntity zhaobiaodaili,
                  HttpServletRequest request) {
        EntityWrapper<ZhaobiaodailiEntity> ew = new EntityWrapper<ZhaobiaodailiEntity>();

        PageUtils page = zhaobiaodailiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaodaili), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ZhaobiaodailiEntity zhaobiaodaili) {
        EntityWrapper<ZhaobiaodailiEntity> ew = new EntityWrapper<ZhaobiaodailiEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhaobiaodaili, "zhaobiaodaili"));
        return R.ok().put("data", zhaobiaodailiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaobiaodailiEntity zhaobiaodaili) {
        EntityWrapper<ZhaobiaodailiEntity> ew = new EntityWrapper<ZhaobiaodailiEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhaobiaodaili, "zhaobiaodaili"));
        ZhaobiaodailiView zhaobiaodailiView = zhaobiaodailiService.selectView(ew);
        return R.ok("查询招标代理成功").put("data", zhaobiaodailiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ZhaobiaodailiEntity zhaobiaodaili = zhaobiaodailiService.selectById(id);
        zhaobiaodaili = zhaobiaodailiService.selectView(new EntityWrapper<ZhaobiaodailiEntity>().eq("id", id));
        return R.ok().put("data", zhaobiaodaili);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ZhaobiaodailiEntity zhaobiaodaili = zhaobiaodailiService.selectById(id);
        zhaobiaodaili = zhaobiaodailiService.selectView(new EntityWrapper<ZhaobiaodailiEntity>().eq("id", id));
        return R.ok().put("data", zhaobiaodaili);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaobiaodailiEntity zhaobiaodaili, HttpServletRequest request) {
        if (zhaobiaodailiService.selectCount(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", zhaobiaodaili.getDailigongsizhanghao())) > 0) {
            return R.error("代理公司账号已存在");
        }
        zhaobiaodaili.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(zhaobiaodaili);
        ZhaobiaodailiEntity u = zhaobiaodailiService.selectOne(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", zhaobiaodaili.getDailigongsizhanghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        zhaobiaodaili.setId(new Date().getTime());
        zhaobiaodaili.setSfsh("待审核");
        zhaobiaodailiService.insert(zhaobiaodaili);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaobiaodailiEntity zhaobiaodaili, HttpServletRequest request) {
        if (zhaobiaodailiService.selectCount(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", zhaobiaodaili.getDailigongsizhanghao())) > 0) {
            return R.error("代理公司账号已存在");
        }
        zhaobiaodaili.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(zhaobiaodaili);
        ZhaobiaodailiEntity u = zhaobiaodailiService.selectOne(new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", zhaobiaodaili.getDailigongsizhanghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        zhaobiaodaili.setId(new Date().getTime());
        zhaobiaodaili.setSfsh("待审核");
        zhaobiaodailiService.insert(zhaobiaodaili);
        return R.ok();
    }



    /**
     * 审核
     */
    @RequestMapping("/sh/{tableName}")
    @Transactional
    public R sh(@RequestBody ZhaobiaodailiEntity zhaobiaodaili) {
        zhaobiaodailiService.updateById(zhaobiaodaili);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaobiaodailiEntity zhaobiaodaili, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhaobiaodaili);
        zhaobiaodailiService.updateById(zhaobiaodaili);//全部更新
        return R.ok();
    }


    /**
     * 推荐列表 (协同过滤算法)
     */
    @IgnoreAuth
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        String role = (String) request.getSession().getAttribute("role");

        // 1. 获取所有投标信息
        List<ToubiaoxinxiEntity> allBids = toubiaoxinxiService.selectList(null);

        // 2. 统计每个代理公司的投标次数 (作为热门程度 fallback)
        Map<String, Integer> agencyCounts = new HashMap<>();
        // 3. 统计每个用户参与过的代理公司
        Map<String, Set<String>> userAgenciesMap = new HashMap<>();

        for (ToubiaoxinxiEntity bid : allBids) {
            String bidder = bid.getToubiaozhanghao();
            String agency = bid.getDailigongsizhanghao();

            if (bidder != null && agency != null) {
                agencyCounts.put(agency, agencyCounts.getOrDefault(agency, 0) + 1);
                userAgenciesMap.computeIfAbsent(bidder, k -> new HashSet<>()).add(agency);
            }
        }

        List<String> recommendedAgencies = new ArrayList<>();

        // 4. 执行协同过滤
        if ("投标单位".equals(role) && userAgenciesMap.containsKey(username)) {
            Set<String> currentUserBids = userAgenciesMap.get(username);
            Map<String, Double> userSimilarities = new HashMap<>();

            // 计算该用户与其他用户的 Jaccard 相似度
            for (Map.Entry<String, Set<String>> entry : userAgenciesMap.entrySet()) {
                String otherUser = entry.getKey();
                if (otherUser.equals(username)) continue;

                Set<String> otherUserBids = entry.getValue();
                Set<String> intersection = new HashSet<>(currentUserBids);
                intersection.retainAll(otherUserBids);

                Set<String> union = new HashSet<>(currentUserBids);
                union.addAll(otherUserBids);

                double similarity = (double) intersection.size() / union.size();
                if (similarity > 0) {
                    userSimilarities.put(otherUser, similarity);
                }
            }

            // 获取相似用户参与过但当前用户未参与过的代理公司
            Map<String, Double> agencyScores = new HashMap<>();
            for (Map.Entry<String, Double> entry : userSimilarities.entrySet()) {
                String similarUser = entry.getKey();
                double similarity = entry.getValue();
                for (String agency : userAgenciesMap.get(similarUser)) {
                    if (!currentUserBids.contains(agency)) {
                        agencyScores.put(agency, agencyScores.getOrDefault(agency, 0.0) + similarity);
                    }
                }
            }

            // 排序并提取前 N 个
            List<Map.Entry<String, Double>> sortedScores = new ArrayList<>(agencyScores.entrySet());
            sortedScores.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            for (Map.Entry<String, Double> entry : sortedScores) {
                recommendedAgencies.add(entry.getKey());
            }
        }

        // 5. 补充热门代理公司 (如果推荐不足或未登录)
        List<Map.Entry<String, Integer>> popularAgencies = new ArrayList<>(agencyCounts.entrySet());
        popularAgencies.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<String, Integer> entry : popularAgencies) {
            if (!recommendedAgencies.contains(entry.getKey())) {
                recommendedAgencies.add(entry.getKey());
            }
        }

        // 6. 根据推荐的账号查询实体
        EntityWrapper<ZhaobiaodailiEntity> ew = new EntityWrapper<ZhaobiaodailiEntity>();
        if (!recommendedAgencies.isEmpty()) {
            ew.in("dailigongsizhanghao", recommendedAgencies);
            // 保持推荐顺序 (MyBatis Plus in 不保证顺序，手动排序)
            List<ZhaobiaodailiEntity> list = zhaobiaodailiService.selectList(ew);
            Map<String, ZhaobiaodailiEntity> agencyMap = new HashMap<>();
            for (ZhaobiaodailiEntity entity : list) {
                agencyMap.put(entity.getDailigongsizhanghao(), entity);
            }
            List<ZhaobiaodailiEntity> sortedList = new ArrayList<>();
            for (String account : recommendedAgencies) {
                if (agencyMap.containsKey(account)) {
                    sortedList.add(agencyMap.get(account));
                }
            }
            
            // 分页逻辑
            int limit = params.get("limit") != null ? Integer.parseInt(params.get("limit").toString()) : 10;
            int pageNum = params.get("page") != null ? Integer.parseInt(params.get("page").toString()) : 1;
            int start = (pageNum - 1) * limit;
            int end = Math.min(start + limit, sortedList.size());
            
            List<ZhaobiaodailiEntity> resultList = new ArrayList<>();
            if (start < sortedList.size()) {
                resultList = sortedList.subList(start, end);
            }
            
            PageUtils page = new PageUtils(resultList, sortedList.size(), limit, pageNum);
            return R.ok().put("data", page);
        }

        // 7. 如果没有数据，返回默认的分页
        PageUtils page = zhaobiaodailiService.queryPage(params, new EntityWrapper<ZhaobiaodailiEntity>());
        return R.ok().put("data", page);
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        zhaobiaodailiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
