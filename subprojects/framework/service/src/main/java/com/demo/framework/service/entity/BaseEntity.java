/**
 * 
 */
package com.demo.framework.service.entity;

import java.io.Serializable;

import com.demo.framework.core.utils.JsonUtil;

/**
 * @author 袁进勇
 *
 */
public abstract class BaseEntity<P> implements Serializable {
    private static final long serialVersionUID = 7276382872468580595L;

    private P f_id; // 主键，如果某个实体类不以f_id字段作为主键，则忽略该属性即可。

    public P getF_id() {
        return f_id;
    }

    public void setF_id(P f_id) {
        this.f_id = f_id;
    }

    @Override
    public String toString() {
        return JsonUtil.toString(this);
    }
}
