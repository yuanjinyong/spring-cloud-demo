package com.demo.framework.core.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author 袁进勇
 *
 */
public class RowMap extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public RowMap() {
        super();
    }

    public RowMap(final String key, Object value) {
        super();
        put(key, value);
    }

    public RowMap(Map<String, Object> map) {
        super();
        this.putAll(map);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public RowMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public RowMap safePut(String key, Object value) {
        if (value != null) {
            put(key, value);
        }
        return this;
    }

    public RowMap safePut(String key, Object value, Object defaultValue) {
        if (value == null) {
            put(key, defaultValue);
        } else {
            put(key, value);
        }
        return this;
    }

    public RowMap putAll(final ResourceBundle resourceBundle) {
        Enumeration<String> enumeration = resourceBundle.getKeys();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            put(key, resourceBundle.getObject(key));
        }
        return this;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Properties toProperties() {
        Properties answer = new Properties();
        for (Iterator<Map.Entry<String, Object>> iter = entrySet().iterator(); iter.hasNext();) {
            Map.Entry<String, Object> entry = iter.next();
            answer.put(entry.getKey(), entry.getValue());
        }
        return answer;
    }

    public String toXML() {
        StringBuffer xml = new StringBuffer();
        xml.append("<xml>");
        for (Map.Entry<String, Object> entry : this.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            xml.append('<').append(key).append('>');
            if (value instanceof Number) {
                xml.append(value.toString());
            } else {
                xml.append("<![CDATA[").append(value).append("]]>");
            }
            xml.append("</").append(key).append('>');
        }
        xml.append("</xml>");

        return xml.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String $(final String key) {
        Object answer = get(key);
        if (answer != null) {
            return answer.toString();
        }
        return null;
    }

    public String $(final String key, String defaultValue) {
        String answer = $(key);
        if (answer != null) {
            return answer;
        }
        return defaultValue;
    }

    public Boolean $bool(final String key) {
        Object answer = get(key);
        if (answer != null) {
            if (answer instanceof Boolean) {
                return (Boolean) answer;
            } else if (answer instanceof String) {
                return new Boolean((String) answer);
            } else if (answer instanceof Number) {
                return (((Number) answer).intValue() != 0) ? Boolean.TRUE : Boolean.FALSE;
            }
        }
        return null;
    }

    public Boolean $bool(final String key, Boolean defaultValue) {
        Boolean answer = $bool(key);
        if (answer != null) {
            return answer;
        }
        return defaultValue;
    }

    public Number $number(final String key) throws ParseException {
        Object answer = get(key);
        if (answer != null) {
            if (answer instanceof Number) {
                return (Number) answer;
            } else if (answer instanceof String) {
                return NumberFormat.getInstance().parse((String) answer);
            }
            throw new ParseException("对象" + answer + "不能解析成为数字！", 0);
        }
        return null;
    }

    public Number $number(final String key, Number defaultValue) {
        try {
            Number answer = $number(key);
            if (answer != null) {
                return answer;
            }
        } catch (ParseException e) {
        }
        return defaultValue;
    }

    public Byte $byte(final String key) throws ParseException {
        Number answer = $number(key);
        if (answer != null) {
            if (answer instanceof Byte) {
                return (Byte) answer;
            }
            return new Byte(answer.byteValue());
        }
        return null;
    }

    public Byte $byte(final String key, Byte defaultValue) {
        try {
            Byte answer = $byte(key);
            if (answer != null) {
                return answer;
            }
        } catch (ParseException e) {
        }
        return defaultValue;
    }

    public Short $short(final String key) throws ParseException {
        Number answer = $number(key);
        if (answer != null) {
            if (answer instanceof Short) {
                return (Short) answer;
            }
            return new Short(answer.shortValue());
        }
        return null;
    }

    public Short $short(final String key, Short defaultValue) {
        try {
            Short answer = $short(key);
            if (answer != null) {
                return answer;
            }
        } catch (ParseException e) {
        }
        return defaultValue;
    }

    public Integer $int(final String key) throws ParseException {
        Number answer = $number(key);
        if (answer != null) {
            if (answer instanceof Integer) {
                return (Integer) answer;
            }
            return new Integer(answer.intValue());
        }
        return null;
    }

    public Integer $int(final String key, Integer defaultValue) {
        try {
            Integer answer = $int(key);
            if (answer != null) {
                return answer;
            }
        } catch (ParseException e) {
        }
        return defaultValue;
    }

    public Long $long(final String key) throws ParseException {
        Number answer = $number(key);
        if (answer != null) {
            if (answer instanceof Long) {
                return (Long) answer;
            }
            return new Long(answer.longValue());
        }
        return null;
    }

    public Long $long(final String key, Long defaultValue) {
        try {
            Long answer = $long(key);
            if (answer != null) {
                return answer;
            }
        } catch (ParseException e) {
        }
        return defaultValue;
    }

    public Float $float(final String key) throws ParseException {
        Number answer = $number(key);
        if (answer != null) {
            if (answer instanceof Float) {
                return (Float) answer;
            }
            return new Float(answer.floatValue());
        }
        return null;
    }

    public Float $float(final String key, Float defaultValue) {
        try {
            Float answer = $float(key);
            if (answer != null) {
                return answer;
            }
        } catch (ParseException e) {
        }
        return defaultValue;
    }

    public Double $double(final String key) throws ParseException {
        Number answer = $number(key);
        if (answer != null) {
            if (answer instanceof Double) {
                return (Double) answer;
            }
            return new Double(answer.doubleValue());
        }
        return null;
    }

    public Double $double(final String key, Double defaultValue) {
        try {
            Double answer = $double(key);
            if (answer != null) {
                return answer;
            }
        } catch (ParseException e) {
        }
        return defaultValue;
    }

    public BigDecimal $bigDecimal(final String key) throws ParseException {
        Number answer = $number(key);
        if (answer != null) {
            if (answer instanceof BigDecimal) {
                return (BigDecimal) answer;
            }
            return new BigDecimal(answer.toString());
        }

        return null;
    }

    public BigDecimal $bigDecimal(final String key, BigDecimal defaultValue) {
        try {
            BigDecimal answer = $bigDecimal(key);
            if (answer != null) {
                return answer;
            }
        } catch (ParseException e) {
        }
        return defaultValue;
    }

    @SuppressWarnings("unchecked")
    public <V, K> Map<K, V> $map(final String key) {
        Object answer = get(key);
        if (answer != null && answer instanceof Map) {
            return (Map<K, V>) answer;
        }
        return null;
    }

    public <V, K> Map<K, V> $map(String key, Map<K, V> defaultValue) {
        Map<K, V> answer = $map(key);
        if (answer == null) {
            answer = defaultValue;
        }
        return answer;
    }
}
