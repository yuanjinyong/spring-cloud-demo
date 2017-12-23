package com.demo.service.platform.tools.entity;

import org.springframework.util.DigestUtils;

import com.demo.framework.service.entity.BaseEntity;

public class UrlEntity extends BaseEntity<String> {
    private static final long serialVersionUID = -1131848227396986177L;

    private String f_url; // URL
    private String f_desc; // URL描述
    private String f_patterns; // URL表达式
    private String f_methods; // 提交方式
    private String f_params; // 匹配查询参数
    private String f_headers; // 匹配HTTP头参数
    private String f_consumes; // 匹配Content-type，如application/json、application/xml、text/xml
    private String f_produces; //
    private String f_custom; //
    private String f_handler_method; // 处理方法
    private Integer f_is_log; // 是否记录日志。如查询列表，进入增加界面等，都不记录，而删除、修改、增加就需要记录
    private Integer f_is_auto; // 是否自动扫描生成

    public String generateF_id() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getF_patterns());
        sb.append(this.getF_methods());
        sb.append(this.getF_params());
        sb.append(this.getF_headers());
        sb.append(this.getF_consumes());
        sb.append(this.getF_produces());
        sb.append(this.getF_custom());
        super.setF_id(DigestUtils.md5DigestAsHex(sb.toString().getBytes()));

        return super.getF_id();
    }

    public String getF_url() {
        return f_url;
    }

    public void setF_url(String f_url) {
        this.f_url = f_url;
    }

    public String getF_desc() {
        return f_desc;
    }

    public void setF_desc(String f_desc) {
        this.f_desc = f_desc;
    }

    public String getF_patterns() {
        return f_patterns;
    }

    public void setF_patterns(String f_patterns) {
        this.f_patterns = f_patterns;
    }

    public String getF_methods() {
        return f_methods;
    }

    public void setF_methods(String f_methods) {
        this.f_methods = f_methods;
    }

    public String getF_params() {
        return f_params;
    }

    public void setF_params(String f_params) {
        this.f_params = f_params;
    }

    public String getF_headers() {
        return f_headers;
    }

    public void setF_headers(String f_headers) {
        this.f_headers = f_headers;
    }

    public String getF_consumes() {
        return f_consumes;
    }

    public void setF_consumes(String f_consumes) {
        this.f_consumes = f_consumes;
    }

    public String getF_produces() {
        return f_produces;
    }

    public void setF_produces(String f_produces) {
        this.f_produces = f_produces;
    }

    public String getF_custom() {
        return f_custom;
    }

    public void setF_custom(String f_custom) {
        this.f_custom = f_custom;
    }

    public String getF_handler_method() {
        return f_handler_method;
    }

    public void setF_handler_method(String f_handler_method) {
        this.f_handler_method = f_handler_method;
    }

    public Integer getF_is_log() {
        return f_is_log;
    }

    public void setF_is_log(Integer f_log) {
        this.f_is_log = f_log;
    }

    public Integer getF_is_auto() {
        return f_is_auto;
    }

    public void setF_is_auto(Integer f_auto) {
        this.f_is_auto = f_auto;
    }
}
