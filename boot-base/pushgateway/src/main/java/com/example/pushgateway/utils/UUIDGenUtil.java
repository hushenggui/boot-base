package com.example.pushgateway.utils;

import java.util.UUID;

/**
 * Created by wangjun on 2016/7/6.
 */
public class UUIDGenUtil {
	/**
	 * 获取UUID值
	 *
	 * @return
	 */
	public static String createUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "").toUpperCase();
		return uuid;
	}

	public static String randomUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}


}