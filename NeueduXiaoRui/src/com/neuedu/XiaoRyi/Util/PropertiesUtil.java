package com.neuedu.XiaoRyi.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * ��ȡ�����ļ�
 * 
 * @author Administrator
 *
 */
public class PropertiesUtil {

	private static Properties p = new Properties();
	private static File file = null;

	static {
		InputStream in = null;

		// ����ʹ�ò��Է�������
		try {
			file = new File("config.properties");
			in = new FileInputStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ����ʹ�ò���ʽ����
		if (null == in) {
			try {
				String path = PropertiesUtil.class.getResource("").getPath();
				path = path.substring(1).split("!")[0];

				file = new File(path, "config.properties");
				in = new FileInputStream(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// ����JUNIT��ȡ
		if (null == in) {
			in = PropertiesUtil.class.getResourceAsStream("src/config.properties");
		}
		
		// ����classpath��ȡ
		if (null == in) {
			in = PropertiesUtil.class.getResourceAsStream("/config.properties");
		}

		try {
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return p.getProperty(key);
	}

	public static void set(String key, String value) {
		p.setProperty(key, value);
	}

	/**
	 * �洢�����ļ�
	 * 
	 * @param out
	 * @param mark��ע��Ϣ
	 * @return
	 */
	public static boolean save(OutputStream out, String mark) {
		try {
			p.store(out, mark);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * �洢ʹ��Ĭ�ϱ�ע
	 * 
	 * @return
	 */
	public static boolean save() {
		try {
			OutputStream out = new FileOutputStream(file);
			save(out, "default mark");

			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
}
