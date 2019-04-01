package com.wzc.jwt.model;


import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: joey
 * Date: 2019-03-29 16:07
 */
public class HttpResult extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public HttpResult() {
		put("code", 200);
		put("msg", "success");
	}
	
	public static HttpResult error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static HttpResult error(String msg) {
		return error(500, msg);
	}
	
	public static HttpResult error(int code, String msg) {
		HttpResult r = new HttpResult();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static HttpResult ok(String msg) {
		HttpResult r = new HttpResult();
		r.put("msg", msg);
		return r;
	}
	
	public static HttpResult ok(Map<String, Object> map) {
		HttpResult r = new HttpResult();
		r.putAll(map);
		return r;
	}
	
	public static HttpResult ok() {
		return new HttpResult();
	}

	public HttpResult put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
