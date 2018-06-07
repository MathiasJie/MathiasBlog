package com.mathias.usermanage.util;

import lombok.Data;

import java.util.Map;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@Data
public class ResponseHelper {
    private Integer code;
    private String msg;
    private Map<String,Object> data;

    public ResponseHelper(Integer code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
