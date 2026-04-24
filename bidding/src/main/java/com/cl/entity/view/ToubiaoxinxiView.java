package com.cl.entity.view;

import com.cl.entity.ToubiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;

import com.cl.utils.EncryptUtil;


/**
 * 投标信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@TableName("toubiaoxinxi")
public class ToubiaoxinxiView extends ToubiaoxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ToubiaoxinxiView() {
    }

    public ToubiaoxinxiView(ToubiaoxinxiEntity toubiaoxinxiEntity) {
        try {
            BeanUtils.copyProperties(this, toubiaoxinxiEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
