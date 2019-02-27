package com.fourinone;

import java.util.logging.*;
import java.util.*;

public class LogUtil
{
	private static Logger logger;
	private static boolean fineFlag = false;
	private static boolean infoFlag = false;
	static
	{
		String levelName = ConfigContext.getLogLevel("FINE");
		fineFlag = Boolean.valueOf(ConfigContext.getConfig("LOG","FINE",null,"false"));
		infoFlag = Boolean.valueOf(ConfigContext.getConfig("LOG","INFO",null,"false"));
		//System.out.println(levelName+",fineFlag:"+fineFlag+",infoFlag:"+infoFlag);
//		logger =  Logger.getLogger("com.log");
		logger =  Logger.getLogger("com.fourinone");
		Level lv = Level.parse(levelName);
		logger.setLevel(lv);
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(lv);
		logger.addHandler(handler);
	}
	
	public static void info(Object obj)
	{
		info(obj.toString());
	}
	
	public static void info(String logStr)
	{
		if(infoFlag)
			logger.log(Level.INFO, getCaller()+ logStr);
	}
	
	public static void info(String logStr, Throwable e)
	{
		if(infoFlag)
			logger.log(Level.INFO, logStr, e);
		//StackTraceElement stack[] = e.getStackTrace();
		//logger.logp(Level.INFO, stack[0].getClassName(), stack[0].getMethodName(), logStr, e);
	}
	
	public static void info(String className, String methodName, Object logStr)
	{
		if(infoFlag)
//			logger.logp(Level.INFO, className, methodName, getLogStr(logStr));
			logger.log(Level.INFO, getCaller()+ logStr);
	}
	
	public static void info(String className, String methodName, Throwable e)
	{
		if(infoFlag)
			logger.logp(Level.INFO, className, methodName, "", e);
	}
	
	public static void info(String className, String methodName, Object logStr, Throwable e)
	{
		if(infoFlag)
			logger.logp(Level.INFO, className, methodName, getLogStr(logStr), e);
	}
	
	public static void fine(Object obj)
	{
		fine(obj.toString());
	}
	
	public static void fine(String logStr)
	{
		if(fineFlag)
//			logger.log(Level.FINE, logStr);
			logger.log(Level.FINE, getCaller()+ logStr);
	}
	
	public static void fine(String logStr, Throwable e)
	{
		if(fineFlag)
			logger.log(Level.FINE, logStr, e);
	}
	
	public static void fine(String className, String methodName, Object logStr)
	{
		if(fineFlag)
//			logger.logp(Level.FINE, className, methodName, getLogStr(logStr));
			logger.log(Level.FINE, getCaller()+ logStr);
	}
	
	public static void fine(String className, String methodName, Throwable e)
	{
		if(fineFlag)
			logger.logp(Level.FINE, className, methodName, "", e);
	}	
	
	public static void fine(String className, String methodName, Object logStr, Throwable e)
	{
		if(fineFlag)
			logger.logp(Level.FINE, className, methodName, getLogStr(logStr), e);
	}
	
	public static void warn(String className, String methodName, Object logStr)
	{
//		logger.logp(Level.WARNING, className, methodName, getLogStr(logStr));
		logger.log(Level.WARNING, getCaller()+ logStr);
	}

//2014.1.7	
	public static void fail(String className, String methodName, Object logStr)
	{
//		logger.logp(Level.SEVERE, className, methodName, getLogStr(logStr));
		logger.log(Level.SEVERE, getCaller()+ logStr);
	}
	
	public static String getLogStr(Object logStr)
	{
		return logStr!=null?logStr.toString():null;
	}
	
	public static String getCaller(){
		String logName="[::] ";
		StackTraceElement stack[] = (new Throwable()).getStackTrace(); // 获取线程运行栈信息
		for (int i = 0; i < stack.length; i++) {
			StackTraceElement s = stack[i];
			if(!(s.getClassName().equals("com.fourinone.LogUtil")) || s.getMethodName().equals("main")){
				logName="["+s.getClassName()+":"+s.getMethodName()+":"+s.getLineNumber()+"] ";
				break;
			}
		}
		return logName;
	}

	public static void main(String args[])
	{
		LogUtil.fine("hhhhhhhhhhh");
		LogUtil.info("select * from db");
	}
}