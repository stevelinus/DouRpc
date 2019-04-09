package com.xilidou.api;

public interface Serialization {

	/**
	 * 序列化
	 * @param obj
	 * @param <T>
	 * @return
	 */
	<T> byte[] serialize(T obj);

	/**
	 * 反序列化
	 * @param data
	 * @param clz
	 * @param <T>
	 * @return
	 */
	<T> T deSerialize(byte[] data, Class<T> clz);

}
