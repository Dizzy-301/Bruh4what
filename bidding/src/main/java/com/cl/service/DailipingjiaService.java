package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DailipingjiaEntity;
import com.cl.entity.view.DailipingjiaView;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 代理评价
 */
public interface DailipingjiaService extends IService<DailipingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<DailipingjiaView> selectListView(Wrapper<DailipingjiaEntity> wrapper);
    
    DailipingjiaView selectView(@Param("ew") Wrapper<DailipingjiaEntity> wrapper);
    
    PageUtils queryPage(Map<String, Object> params, Wrapper<DailipingjiaEntity> wrapper);
}
