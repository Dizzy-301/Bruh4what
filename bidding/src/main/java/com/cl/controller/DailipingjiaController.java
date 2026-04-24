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
import com.cl.entity.DailipingjiaEntity;
import com.cl.entity.ZhaobiaodailiEntity;
import com.cl.service.DailipingjiaService;
import com.cl.service.ZhaobiaodailiService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.annotation.IgnoreAuth;

/**
 * 代理评价
 * 后端接口
 */
@RestController
@RequestMapping("/dailipingjia")
public class DailipingjiaController {
    @Autowired
    private DailipingjiaService dailipingjiaService;
    
    @Autowired
    private ZhaobiaodailiService zhaobiaodailiService;

    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DailipingjiaEntity dailipingjia, HttpServletRequest request){
        EntityWrapper<DailipingjiaEntity> ew = new EntityWrapper<DailipingjiaEntity>();
        
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yezhudanwei")) {
            dailipingjia.setYezhuzhanghao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("zhaobiaodaili")) {
            dailipingjia.setDailigongsizhanghao((String) request.getSession().getAttribute("username"));
        }

        PageUtils page = dailipingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dailipingjia), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DailipingjiaEntity dailipingjia, HttpServletRequest request){
        EntityWrapper<DailipingjiaEntity> ew = new EntityWrapper<DailipingjiaEntity>();
        PageUtils page = dailipingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dailipingjia), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DailipingjiaEntity dailipingjia = dailipingjiaService.selectById(id);
        return R.ok().put("data", dailipingjia);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DailipingjiaEntity dailipingjia, HttpServletRequest request){
        dailipingjiaService.insert(dailipingjia);
        updateAgencyMetrics(dailipingjia.getDailigongsizhanghao());
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DailipingjiaEntity dailipingjia, HttpServletRequest request){
        dailipingjiaService.insert(dailipingjia);
        updateAgencyMetrics(dailipingjia.getDailigongsizhanghao());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DailipingjiaEntity dailipingjia, HttpServletRequest request){
        dailipingjiaService.updateById(dailipingjia);
        updateAgencyMetrics(dailipingjia.getDailigongsizhanghao());
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        for(Long id : ids) {
            DailipingjiaEntity pj = dailipingjiaService.selectById(id);
            if(pj != null) {
                String account = pj.getDailigongsizhanghao();
                dailipingjiaService.deleteById(id);
                updateAgencyMetrics(account);
            }
        }
        return R.ok();
    }

    private void updateAgencyMetrics(String dailigongsizhanghao) {
        if (dailigongsizhanghao == null) return;
        List<DailipingjiaEntity> ratings = dailipingjiaService.selectList(
            new EntityWrapper<DailipingjiaEntity>().eq("dailigongsizhanghao", dailigongsizhanghao)
        );
        
        double average = 0;
        if (!ratings.isEmpty()) {
            double sum = 0;
            for (DailipingjiaEntity r : ratings) {
                sum += r.getManyidu();
            }
            average = sum / ratings.size();
        }
        
        String grade = "暂无等级";
        if (average >= 9) grade = "金牌代理公司";
        else if (average >= 8) grade = "银牌代理公司";
        else if (average >= 7) grade = "铜牌代理公司";

        ZhaobiaodailiEntity agency = zhaobiaodailiService.selectOne(
            new EntityWrapper<ZhaobiaodailiEntity>().eq("dailigongsizhanghao", dailigongsizhanghao)
        );
        if (agency != null) {
            agency.setManyidu(average);
            agency.setDengji(grade);
            zhaobiaodailiService.updateById(agency);
        }
    }
}
