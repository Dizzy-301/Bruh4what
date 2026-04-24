package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 招标代理
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@TableName("zhaobiaodaili")
public class ZhaobiaodailiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ZhaobiaodailiEntity() {

    }

    public ZhaobiaodailiEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 代理公司账号
     */

    private String dailigongsizhanghao;

    /**
     * 密码
     */

    private String mima;

    /**
     * 代理公司名称
     */

    private String dailigongsimingcheng;

    /**
     * 联系电话
     */
    private String lianxidianhua;
    /**
     * 是否审核
     */
    private String sfsh;
    /**
     * 回复内容
     */
    private String shhf;
    /**
     * 资质
     */
    private String zizhi;
    /**
     * 满意度
     */
    private Double manyidu;
    /**
     * 等级
     */
    private String dengji;


    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置：代理公司账号
     */
    public void setDailigongsizhanghao(String dailigongsizhanghao) {
        this.dailigongsizhanghao = dailigongsizhanghao;
    }

    /**
     * 获取：代理公司账号
     */
    public String getDailigongsizhanghao() {
        return dailigongsizhanghao;
    }

    /**
     * 设置：密码
     */
    public void setMima(String mima) {
        this.mima = mima;
    }

    /**
     * 获取：密码
     */
    public String getMima() {
        return mima;
    }

    /**
     * 设置：代理公司名称
     */
    public void setDailigongsimingcheng(String dailigongsimingcheng) {
        this.dailigongsimingcheng = dailigongsimingcheng;
    }

    /**
     * 获取：代理公司名称
     */
    public String getDailigongsimingcheng() {
        return dailigongsimingcheng;
    }

    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua;
    }

    public String getLianxidianhua() {
        return lianxidianhua;
    }

    public void setSfsh(String sfsh) {
        this.sfsh = sfsh;
    }

    public String getSfsh() {
        return sfsh;
    }

    public void setShhf(String shhf) {
        this.shhf = shhf;
    }

    public String getShhf() {
        return shhf;
    }

    public void setZizhi(String zizhi) {
        this.zizhi = zizhi;
    }

    public String getZizhi() {
        return zizhi;
    }

    public void setManyidu(Double manyidu) {
        this.manyidu = manyidu;
    }

    public Double getManyidu() {
        return manyidu;
    }

    public void setDengji(String dengji) {
        this.dengji = dengji;
    }

    public String getDengji() {
        return dengji;
    }

}
