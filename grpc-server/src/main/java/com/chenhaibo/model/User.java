package com.chenhaibo.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenhaibo
 * @since 2018-11-27
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户中心主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 链家网用户自增Id
     */
    @TableField("client_id")
    private Integer clientId;
    /**
     * 信息来源
     */
    @TableField("app_id")
    private Integer appId;
    /**
     * 密码MD5
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 显示名
     */
    @TableField("display_name")
    private String displayName;
    /**
     * 用户头像
     */
    private String favicon;
    /**
     * 手机
     */
    private String mobile;
    private String mwmobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * qq平台openId
     */
    @TableField("qq_id")
    private String qqId;
    /**
     * 微信平台openId
     */
    @TableField("wx_id")
    private String wxId;
    /**
     * 支付宝平台openId
     */
    @TableField("zfb_id")
    private String zfbId;
    /**
     * 微博平台openId
     */
    @TableField("wb_id")
    private String wbId;
    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;
    /**
     * 生日（1989-04-04）
     */
    private String birthday;
    /**
     * 性别（1 男 0 女）
     */
    private Integer sex;
    /**
     * 身份证号
     */
    @TableField("id_card")
    private String idCard;
    /**
     * 实名认证标志（1 已认证 0 未认证）
     */
    private Integer certification;
    /**
     * 最后一次登录IP
     */
    @TableField("last_login_ip")
    private String lastLoginIp;
    /**
     * 最后一次登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 注册时间
     */
    private Date ctime;
    /**
     * 更新时间
     */
    private Date mtime;
    /**
     * 注册时的设备id
     */
    @TableField("device_id")
    private String deviceId;
    private Integer status;
    /**
     * 贝壳QQID
     */
    @TableField("ke_qq_id")
    private String keQqId;
    /**
     * 贝壳微信OPENID
     */
    @TableField("ke_wx_id")
    private String keWxId;
    /**
     * 贝壳支付宝ID
     */
    @TableField("ke_zfb_id")
    private String keZfbId;
    /**
     * 贝壳微博ID
     */
    @TableField("ke_wb_id")
    private String keWbId;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMwmobile() {
        return mwmobile;
    }

    public void setMwmobile(String mwmobile) {
        this.mwmobile = mwmobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getZfbId() {
        return zfbId;
    }

    public void setZfbId(String zfbId) {
        this.zfbId = zfbId;
    }

    public String getWbId() {
        return wbId;
    }

    public void setWbId(String wbId) {
        this.wbId = wbId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getCertification() {
        return certification;
    }

    public void setCertification(Integer certification) {
        this.certification = certification;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKeQqId() {
        return keQqId;
    }

    public void setKeQqId(String keQqId) {
        this.keQqId = keQqId;
    }

    public String getKeWxId() {
        return keWxId;
    }

    public void setKeWxId(String keWxId) {
        this.keWxId = keWxId;
    }

    public String getKeZfbId() {
        return keZfbId;
    }

    public void setKeZfbId(String keZfbId) {
        this.keZfbId = keZfbId;
    }

    public String getKeWbId() {
        return keWbId;
    }

    public void setKeWbId(String keWbId) {
        this.keWbId = keWbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", clientId=" + clientId +
        ", appId=" + appId +
        ", password=" + password +
        ", salt=" + salt +
        ", displayName=" + displayName +
        ", favicon=" + favicon +
        ", mobile=" + mobile +
        ", mwmobile=" + mwmobile +
        ", email=" + email +
        ", qqId=" + qqId +
        ", wxId=" + wxId +
        ", zfbId=" + zfbId +
        ", wbId=" + wbId +
        ", realName=" + realName +
        ", birthday=" + birthday +
        ", sex=" + sex +
        ", idCard=" + idCard +
        ", certification=" + certification +
        ", lastLoginIp=" + lastLoginIp +
        ", lastLoginTime=" + lastLoginTime +
        ", ctime=" + ctime +
        ", mtime=" + mtime +
        ", deviceId=" + deviceId +
        ", status=" + status +
        ", keQqId=" + keQqId +
        ", keWxId=" + keWxId +
        ", keZfbId=" + keZfbId +
        ", keWbId=" + keWbId +
        ", name=" + name +
        "}";
    }
}
