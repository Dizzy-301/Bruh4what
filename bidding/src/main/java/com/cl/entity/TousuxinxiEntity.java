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
 * 投诉信息
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@TableName("tousuxinxi")
public class TousuxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public TousuxinxiEntity() {

    }

    public TousuxinxiEntity(T t) {
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
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 投诉编号
     */

    private String tousubianhao;

    /**
     * 投诉内容
     */

    private String tousuneirong;

    /**
     * 投诉时间
     */

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date tousushijian;

    /**
     * 投标账号
     */

    private String toubiaozhanghao;

    /**
     * 投标人姓名
     */

    private String toubiaorenxingming;

    /**
     * 手机号
     */

    private String shoujihao;

    /**
     * 是否审核
     */

    private String sfsh;

    /**
     * 回复内容
     */

    private String shhf;


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
     * 设置：投诉编号
     */
    public void setTousubianhao(String tousubianhao) {
        this.tousubianhao = tousubianhao;
    }

    /**
     * 获取：投诉编号
     */
    public String getTousubianhao() {
        return tousubianhao;
    }

    /**
     * 设置：投诉内容
     */
    public void setTousuneirong(String tousuneirong) {
        this.tousuneirong = tousuneirong;
    }

    /**
     * 获取：投诉内容
     */
    public String getTousuneirong() {
        return tousuneirong;
    }

    /**
     * 设置：投诉时间
     */
    public void setTousushijian(Date tousushijian) {
        this.tousushijian = tousushijian;
    }

    /**
     * 获取：投诉时间
     */
    public Date getTousushijian() {
        return tousushijian;
    }

    /**
     * 设置：投标账号
     */
    public void setToubiaozhanghao(String toubiaozhanghao) {
        this.toubiaozhanghao = toubiaozhanghao;
    }

    /**
     * 获取：投标账号
     */
    public String getToubiaozhanghao() {
        return toubiaozhanghao;
    }

    /**
     * 设置：投标人姓名
     */
    public void setToubiaorenxingming(String toubiaorenxingming) {
        this.toubiaorenxingming = toubiaorenxingming;
    }

    /**
     * 获取：投标人姓名
     */
    public String getToubiaorenxingming() {
        return toubiaorenxingming;
    }

    /**
     * 设置：手机号
     */
    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao;
    }

    /**
     * 获取：手机号
     */
    public String getShoujihao() {
        return shoujihao;
    }

    /**
     * 设置：是否审核
     */
    public void setSfsh(String sfsh) {
        this.sfsh = sfsh;
    }

    /**
     * 获取：是否审核
     */
    public String getSfsh() {
        return sfsh;
    }

    /**
     * 设置：回复内容
     */
    public void setShhf(String shhf) {
        this.shhf = shhf;
    }

    /**
     * 获取：回复内容
     */
    public String getShhf() {
        return shhf;
    }

}
