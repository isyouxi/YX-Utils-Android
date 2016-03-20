package xyz.isyouxi.utils;

import android.util.Log;

/**
 * 关于打印日志的工具类
 * @author isyouxi
 */
public class YXLog {
	/**
	 * 是否显示Log
	 */
	public static boolean isShow = true; 
	/**
	 * 自定义的tag配置
	 * 如果這個是null的話，會使用自動生成的tag的方式
	 */
	public static String customTagPrefix = null;
	
	/**
	 * 输出D级别的Log
	 * @param content
	 */
	public static void d(String content) {
		if(!isShow)return;
		Log.d(generateTag(),content);
    }
	/**
	 * 输出E级别的Log
	 * @param content
	 */
	public static void e(String content) {
		if(!isShow)return;
		Log.e(generateTag(),content);
    }
	/**
	 * 输出I级别的Log
	 * @param content
	 */
	public static void i(String content) {
		if(!isShow)return;
		Log.i(generateTag(),content);
    }
	/**
	 *输出W级别的Log
	 * @param content
	 */
	public static void w(String content) {
		if(!isShow)return;
		Log.w(generateTag(),content);
	}
	/**
	 * 输出V级别的Log
	 * @param content
	 */
	public static void v(String content) {
		if(!isShow)return;
		Log.v(generateTag(),content);
	}
	/**
	 * 生成Tag
	 * @return
	 */
	public static String generateTag(){
		if (customTagPrefix != null) return customTagPrefix;
		StackTraceElement caller = Thread.currentThread().getStackTrace()[4];
		String tag = "%s.%s(L:%d)";
        	String callerClazzName = caller.getClassName();
        	callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        	tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
		return tag;
	}
}
