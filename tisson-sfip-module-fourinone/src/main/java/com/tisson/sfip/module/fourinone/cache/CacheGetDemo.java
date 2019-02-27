package com.tisson.sfip.module.fourinone.cache;

import com.fourinone.BeanContext;
import com.fourinone.ParkLocal;
import com.fourinone.CacheLocal;

public class CacheGetDemo
{
	public static String[] getSmallCache()
	{
		ParkLocal pl = BeanContext.getPark();
		return (String[])pl.get("cache", "keyArray2").toObject();
	}
	
	public static void getBigCache(String[] keyArray)
	{
		CacheLocal cc = BeanContext.getCache();
		for(String k:keyArray){
			System.out.println(k+"------"+cc.get(k, "id")+"----"+cc.get(k, "value"));
		}
	}
	
	public static void main(String[] args){
		String[] keyArray = getSmallCache();
		System.out.println("keyArray.length="+keyArray.length);
		getBigCache(keyArray);
	}
}