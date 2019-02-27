package com.tisson.sfip.module.fourinone.cache;
import com.fourinone.BeanContext;

public class CacheFacadeDemo
{
	public static void main(String[] args)
	{
		BeanContext.setConfigFile("..\\..\\sfip-config\\fourinone-config-Facade.xml");
		BeanContext.startCacheFacade();
		System.out.println("CacheFacade is ok...");
	}
}