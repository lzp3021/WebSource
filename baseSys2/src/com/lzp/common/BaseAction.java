package com.lzp.common;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseAction {
	protected static final String SUCCESS = "success";
	protected static final String FAIL = "fail";
	
	public final static ObjectMapper mapper = new ObjectMapper(); 
	
	public static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... parameterClasses) {
		return mapper.getTypeFactory().constructParametrizedType(collectionClass,
				collectionClass, parameterClasses);

	}
	/**
	 * 获取泛型的Collection Type
	 * @param jsonStr json字符串
	 * @param collectionClass 泛型的Collection
	 * @param parameterClasses 元素类型
	 */
	public static <T> T readJson(String jsonStr, Class<?> collectionClass, Class<?>... parameterClasses) throws Exception {
	       ObjectMapper mapper = new ObjectMapper();
	       JavaType javaType = mapper.getTypeFactory().constructParametrizedType(collectionClass,collectionClass, parameterClasses);
	       return mapper.readValue(jsonStr, javaType);

	}
}
