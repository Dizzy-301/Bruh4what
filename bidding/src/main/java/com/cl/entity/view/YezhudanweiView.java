package com.cl.entity.view;

import com.cl.entity.YezhudanweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;

import com.cl.utils.EncryptUtil;


/**
 * 业主单位
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@TableName("yezhudanwei")
public class YezhudanweiView extends YezhudanweiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public YezhudanweiView() {
    }

    public YezhudanweiView(YezhudanweiEntity yezhudanweiEntity) {
        try {
            BeanUtils.copyProperties(this, yezhudanweiEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
