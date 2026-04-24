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
 * 业主单位
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@TableName("yezhudanwei")
public class YezhudanweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public YezhudanweiEntity() {

    }

    public YezhudanweiEntity(T t) {
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
     * 企业账号
     */

    private String qiyezhanghao;

    /**
     * 密码
     */

    private String mima;

    /**
     * 企业名称
     */

    private String qiyemingcheng;

    /**
     * 负责人
     */

    private String fuzeren;

    /**
     * 联系电话
     */

    private String lianxidianhua;

    /**
     * 地址
     */

    private String dizhi;

    /**
     * 资质
     */

    private String zizhi;

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
     * 设置：企业账号
     */
    public void setQiyezhanghao(String qiyezhanghao) {
        this.qiyezhanghao = qiyezhanghao;
    }

    /**
     * 获取：企业账号
     */
    public String getQiyezhanghao() {
        return qiyezhanghao;
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
     * 设置：企业名称
     */
    public void setQiyemingcheng(String qiyemingcheng) {
        this.qiyemingcheng = qiyemingcheng;
    }

    /**
     * 获取：企业名称
     */
    public String getQiyemingcheng() {
        return qiyemingcheng;
    }

    /**
     * 设置：负责人
     */
    public void setFuzeren(String fuzeren) {
        this.fuzeren = fuzeren;
    }

    /**
     * 获取：负责人
     */
    public String getFuzeren() {
        return fuzeren;
    }

    /**
     * 设置：联系电话
     */
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua;
    }

    /**
     * 获取：联系电话
     */
    public String getLianxidianhua() {
        return lianxidianhua;
    }

    /**
     * 设置：地址
     */
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    /**
     * 获取：地址
     */
    public String getDizhi() {
        return dizhi;
    }

    /**
     * 设置：资质
     */
    public void setZizhi(String zizhi) {
        this.zizhi = zizhi;
    }

    /**
     * 获取：资质
     */
    public String getZizhi() {
        return zizhi;
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

}
