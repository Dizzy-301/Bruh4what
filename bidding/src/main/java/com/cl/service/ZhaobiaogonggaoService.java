package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhaobiaogonggaoEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaobiaogonggaoView;


/**
 * 招标公告
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:04
 */
public interface ZhaobiaogonggaoService extends IService<ZhaobiaogonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ZhaobiaogonggaoView> selectListView(Wrapper<ZhaobiaogonggaoEntity> wrapper);

    ZhaobiaogonggaoView selectView(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaogonggaoEntity> wrapper);


}

