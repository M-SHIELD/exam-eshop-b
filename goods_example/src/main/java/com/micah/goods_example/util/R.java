/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.micah.goods_example.util;

import com.micah.goods_example.enums.AppHttpCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R() {
		put("code", 200);
		put("msg", "success");
	}
	/**
	 * 检测对应b,然后返回对应的R
	 * @param b bool
	 * @param code 错误码
	 * @param msg 错误信息
	 * @return 封装好的R
	 */
	public static R check(boolean b, Integer code,String msg){
		return b?R.ok():R.error(code,msg);
	}
	public static R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}

	public static R error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	public static R init(AppHttpCodeEnum appHttpCodeEnum){
		return error(appHttpCodeEnum.getCode(), appHttpCodeEnum.getMsg());
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public Integer getCode(){
		return (Integer) super.get("code");
	}



}
