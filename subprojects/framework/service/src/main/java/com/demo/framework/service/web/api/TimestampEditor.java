package com.demo.framework.service.web.api;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 袁进勇
 *
 */
public class TimestampEditor extends PropertyEditorSupport {
    @Override
    @SuppressWarnings("deprecation")
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.trim().length() == 0) {
            setValue(null);
        } else {
            setValue(new Timestamp(new Date(text).getTime()));
        }
    }
}
