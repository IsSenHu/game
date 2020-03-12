package com.qdhh.game;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

public class ProtocstuffUtils {

	public static <T extends Object> T byte2Bean(byte[] data, Class<T> clazz) {
		Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(clazz);
		T bean = null;
		try {
			bean = schema.newMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(data != null) {
			ProtobufIOUtil.mergeFrom(data, bean, schema);
		}

		return bean;
	}

	public static <T extends Object> byte[] bean2Byte(T bean, Class<?> clazz) {
		try {
			LinkedBuffer buffer = getApplicationBuffer();
			@SuppressWarnings("unchecked")
            Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(clazz);
			
			return ProtobufIOUtil.toByteArray(bean, schema, buffer);
		} catch(Exception e) {
			System.out.println("catch exception on bean2Byte. class " + clazz.getName());
			return null;
		}
	}

	static final int bufferSize = 2048;

	static final ThreadLocal<LinkedBuffer> localBuffer = new ThreadLocal<LinkedBuffer>() {
		public LinkedBuffer initialValue() {
			return LinkedBuffer.allocate(bufferSize);
		}
	};

	public static LinkedBuffer getApplicationBuffer() {
		return localBuffer.get().clear();
	}
}
