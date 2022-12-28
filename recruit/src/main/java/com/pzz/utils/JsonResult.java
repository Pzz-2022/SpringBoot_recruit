package com.pzz.utils;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {
    private Integer code; // 和前端自定义的状态码
    private Map<String, Object> data = new HashMap<>(); // 数据都放这里
    private String msg; // 错误提示信息

    public JsonResult() {
    }

    public JsonResult(Integer code, Map<String, Object> data) {
        this.code = code;
        this.data = data;
    }

    public JsonResult(Integer code, Map<String, Object> data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    // 成功静态方法
    public static JsonResult ok() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(Code.SUCCESS);
        jsonResult.setMsg("成功");
        return jsonResult;
    }
    public static JsonResult ok(Map<String, Object> data) {
        JsonResult result = JsonResult.ok();
        result.setData(data);
        return result;
    }
    public static JsonResult ok(String key, Object value) {
        JsonResult result = JsonResult.ok();
        result.getData().put(key, value);
        return result;
    }

    // 失败静态方法
    public static JsonResult error() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(Code.ERROR);
        jsonResult.setMsg("失败");
        return jsonResult;
    }
    public static JsonResult error(String msg) {
        JsonResult jsonResult = JsonResult.error();
        jsonResult.setMsg(msg);
        return jsonResult;
    }

    // 给添加数据
    public JsonResult addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    // 根据需要返回数据
    public static JsonResult judge(Boolean flag) {
        return flag ? ok() : error();
    }
}
