package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhongbiaogonggaoEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongbiaogonggaoView;


/**
 * 中标公告
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ZhongbiaogonggaoService extends IService<ZhongbiaogonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ZhongbiaogonggaoView> selectListView(Wrapper<ZhongbiaogonggaoEntity> wrapper);

    ZhongbiaogonggaoView selectView(@Param("ew") Wrapper<ZhongbiaogonggaoEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ZhongbiaogonggaoEntity> wrapper);


}

