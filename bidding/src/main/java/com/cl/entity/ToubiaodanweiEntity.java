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
 * 投标单位
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@TableName("toubiaodanwei")
public class ToubiaodanweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ToubiaodanweiEntity() {

    }

    public ToubiaodanweiEntity(T t) {
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
     * 投标账号
     */

    private String toubiaozhanghao;

    /**
     * 密码
     */

    private String mima;

    /**
     * 投标人姓名
     */

    private String toubiaorenxingming;

    /**
     * 性别
     */

    private String xingbie;

    /**
     * 年龄
     */

    private String nianling;

    /**
     * 身份证号
     */

    private String shenfenzhenghao;

    /**
     * 手机号
     */

    private String shoujihao;

    /**
     * 头像
     */

    private String touxiang;


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
     * 设置：性别
     */
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    /**
     * 获取：性别
     */
    public String getXingbie() {
        return xingbie;
    }

    /**
     * 设置：年龄
     */
    public void setNianling(String nianling) {
        this.nianling = nianling;
    }

    /**
     * 获取：年龄
     */
    public String getNianling() {
        return nianling;
    }

    /**
     * 设置：身份证号
     */
    public void setShenfenzhenghao(String shenfenzhenghao) {
        this.shenfenzhenghao = shenfenzhenghao;
    }

    /**
     * 获取：身份证号
     */
    public String getShenfenzhenghao() {
        return shenfenzhenghao;
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
     * 设置：头像
     */
    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang;
    }

    /**
     * 获取：头像
     */
    public String getTouxiang() {
        return touxiang;
    }

}
