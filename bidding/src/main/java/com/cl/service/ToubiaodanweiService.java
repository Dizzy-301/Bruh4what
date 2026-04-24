package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ToubiaodanweiEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ToubiaodanweiView;


/**
 * 投标单位
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ToubiaodanweiService extends IService<ToubiaodanweiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ToubiaodanweiView> selectListView(Wrapper<ToubiaodanweiEntity> wrapper);

    ToubiaodanweiView selectView(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ToubiaodanweiEntity> wrapper);


}

