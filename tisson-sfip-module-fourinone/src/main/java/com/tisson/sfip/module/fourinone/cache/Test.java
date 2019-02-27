/**
 * 
 */
package com.tisson.sfip.module.fourinone.cache;

/**
 * @author yihaijun
 *
 */
public class Test {

	public static String getCaller(){
		String logName="[::]";
		StackTraceElement stack[] = (new Throwable()).getStackTrace(); // 获取线程运行栈信息
		for (int i = 0; i < stack.length; i++) {
			StackTraceElement s = stack[i];
			System.out.format(" ClassName:%d\t%s\n", i, s.getClassName());
			System.out.format("MethodName:%d\t%s\n", i, s.getMethodName());
			System.out.format("  FileName:%d\t%s\n", i, s.getFileName());
			System.out.format("LineNumber:%d\t%s\n\n", i, s.getLineNumber());
			if(!(s.getClassName().equals("com.tisson.sfip.module.fourinone.cache.Test")) || s.getMethodName().equals("main")){
				logName="["+s.getClassName()+":"+s.getMethodName()+":"+s.getLineNumber()+"]";
				break;
			}
		}
		return logName;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("test....");
		StackTraceElement stack[] = (new Throwable()).getStackTrace(); // 获取线程运行栈信息
		for (int i = 0; i < stack.length; i++) {
			StackTraceElement s = stack[i];
			System.out.format(" ClassName:%d\t%s\n", i, s.getClassName());
			System.out.format("MethodName:%d\t%s\n", i, s.getMethodName());
			System.out.format("  FileName:%d\t%s\n", i, s.getFileName());
			System.out.format("LineNumber:%d\t%s\n\n", i, s.getLineNumber());
		}
		System.out.println("test continue....");
		System.out.println("getCaller()="+getCaller());
	}

}
