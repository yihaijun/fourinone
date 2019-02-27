package com.tisson.sfip.module.fourinone.cache;

import com.fourinone.BeanContext;

public class ParkServerDemo
{
	public static void main(String[] args)
	{
		BeanContext.setConfigFile("..\\..\\sfip-config\\fourinone-config-Park.xml");
		BeanContext.startPark();
	}
}