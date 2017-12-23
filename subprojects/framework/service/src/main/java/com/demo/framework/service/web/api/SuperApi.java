package com.demo.framework.service.web.api;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demo.framework.core.exception.BusinessException;
import com.demo.framework.core.model.Page;
import com.demo.framework.core.model.ParamsMap;
import com.demo.framework.core.model.Result;
import com.demo.framework.core.utils.HelpUtil;
import com.demo.framework.service.model.ResponseResult;

public abstract class SuperApi {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new TimestampEditor());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 直接获取参数
     */
    public static String $(String paramName) {
        return getRequest().getParameter(paramName);
    }

    public static String $(String paramName, String defaultValue) {
        String value = $(paramName);
        return HelpUtil.isEmpty(value) ? defaultValue : value;
    }

    public static Boolean $bool(String paramName) {
        return $bool(paramName, null);
    }

    public static Boolean $bool(String paramName, Boolean defaultValue) {
        String value = $(paramName);
        return HelpUtil.isEmpty(value) ? defaultValue : Boolean.parseBoolean(value);
    }

    public static Integer $int(String paramName) {
        return $int(paramName, null);
    }

    public static Integer $int(String paramName, Integer defaultValue) {
        String value = $(paramName);
        if (HelpUtil.isEmpty(value)) {
            return defaultValue;
        } else {
            return Integer.parseInt(value);
        }
    }

    public static Long $long(String paramName) {
        return $long(paramName, null);
    }

    public static Long $long(String paramName, Long defaultValue) {
        String value = $(paramName);
        return HelpUtil.isEmpty(value) ? defaultValue : Long.parseLong(value);
    }

    public static Float $float(String paramName) {
        return $float(paramName, null);
    }

    public static Float $float(String paramName, Float defaultValue) {
        String value = $(paramName);
        return HelpUtil.isEmpty(value) ? defaultValue : Float.parseFloat(value);
    }

    public static Double $double(String paramName) {
        return $double(paramName, null);
    }

    public static Double $double(String paramName, Double defaultValue) {
        String value = $(paramName);
        return HelpUtil.isEmpty(value) ? defaultValue : Double.parseDouble(value);
    }

    public static ParamsMap $params() {
        return $params(null);
    }

    public static <T> Page<T> $page() {
        return $params(null).page();
    }

    public static ParamsMap $params(String prefix) {
        ParamsMap paramsMap = new ParamsMap();

        int prefixLength = prefix == null ? 0 : prefix.length();
        HttpServletRequest request = getRequest();
        Enumeration<?> paramNames = request.getParameterNames();
        while (paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            if (prefixLength == 0 || paramName.startsWith(prefix)) {
                String[] values = request.getParameterValues(paramName);
                if (values == null || values.length == 0) {
                    // Do nothing, no values found at all.
                } else if (values.length > 1) {
                    paramsMap.put(paramName.substring(prefixLength), values);
                } else {
                    paramsMap.put(paramName.substring(prefixLength), values[0]);
                }
            }
        }

        return paramsMap;
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    public static Object $attr(String attrKey) {
        return getRequest().getAttribute(attrKey);
    }

    public static void $attr(String attrKey, Object attrValue) {
        getRequest().setAttribute(attrKey, attrValue);
    }

    public static void $attrs(Object... args) {
        HttpServletRequest request = getRequest();
        for (int i = 1; i < args.length; i += 2) {
            request.setAttribute(String.valueOf(args[i - 1]), args[i]);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected static String getFullContextPath() {
        HttpServletRequest request = getRequest();
        return new StringBuffer().append(request.getScheme()).append("://").append(request.getServerName()).append(':')
                .append(request.getServerPort()).append(request.getContextPath()).toString();
    }

    protected static ServletContext getServletContext() {
        return getRequest().getSession().getServletContext();
    }

    protected String getIpAddress() {
        HttpServletRequest request = getRequest();

        // 获取请求主机IP地址，如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");
        if (HelpUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            if (HelpUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (HelpUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (HelpUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (HelpUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (HelpUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else {
            if (ip.length() > 15) {
                String[] ips = ip.split(",");
                for (int index = 0; index < ips.length; index++) {
                    String strIp = ips[index];
                    if (!("unknown".equalsIgnoreCase(strIp))) {
                        ip = strIp;
                        break;
                    }
                }
            }
        }

        return ip;
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    /**
     * 基于@ExceptionHandler异常处理
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public ResponseResult<Object> exceptionHandler(HttpServletRequest request, Exception e) {
        String errorMsg = "";
        if (e instanceof BusinessException) {
            errorMsg = ((BusinessException) e).getMessage();
            // } else if (e instanceof DataAccessException) {
            // Throwable root = ((DataAccessException) e).getRootCause();
            // errorMsg = root != null ? root.getMessage() : ((DataAccessException) e).getMessage();
        } else if (e instanceof NoSuchMethodException) {
            errorMsg = "请求的方法不存在!";
        } else if (e instanceof BindException) {
            errorMsg = "类型转换错误!";
        } else {
            errorMsg = e.getMessage();
            if (HelpUtil.isEmpty(errorMsg)) {
                errorMsg = e.toString();
            }
        }
        logger.error(e.getMessage(), e);

        return new ResponseResult<Object>(new Result<Object>(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
