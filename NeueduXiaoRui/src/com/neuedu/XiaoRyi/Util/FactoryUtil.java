package com.neuedu.XiaoRyi.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ģʽ - �����������ӹ������,ʹ������ʵ�ַ���. ���new�ؼ���
 * 
 * @author Chiva 874460517@qq.com 2018��9��20��
 */
public class FactoryUtil {

	private static final Map<String, Object> map = new HashMap<>();

	/**
	 * ʹ��������ȡʵ������
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public synchronized static Object getObject(String className) {		
		try {
			// ����class�ļ�
			Class<?> clazz = Class.forName("className");
			// �൱�ڵ���class�ļ��Ĺ��췽����������
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
	}
	
	/**
	 * ʹ�ü���ȡ����
	 * @param key
	 * @return
	 */
	public synchronized static Object getObjectByName(String key) {
		try {
			return getObject(PropertiesUtil.get(key));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * ʹ��������ȡ������ʵ������
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public synchronized static Object getInstanceObject(String className){
		Object instance = map.get(className);
		
		if (null == instance) {
			try {
				Class<?> clazz = Class.forName(className);
				instance = clazz.newInstance();
				map.put(className, instance);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return instance;
	}

	/**
	 * ʹ�ü���ȡ������ʵ������
	 * @param key
	 * @return
	 */
	public synchronized static Object getInstanceObjectByName(String key) {
		try {
			return getInstanceObject(PropertiesUtil.get(key));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
