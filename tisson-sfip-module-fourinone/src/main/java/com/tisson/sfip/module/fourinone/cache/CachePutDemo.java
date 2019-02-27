package com.tisson.sfip.module.fourinone.cache;

import com.fourinone.BeanContext;
import com.fourinone.ParkLocal;
import com.fourinone.CacheLocal;

public class CachePutDemo
{
	public static void putSmallCache(String[] keyArray)
	{
		ParkLocal pl = BeanContext.getPark();
		pl.delete("cache", "keyArray1");
		pl.delete("cache", "keyArray2");
		pl.delete("cache", "keyArray3");
		pl.create("cache", "keyArray2", keyArray);
	}
	
	public static String[] putBigCache()
	{
		CacheLocal cc = BeanContext.getCache();
		String[] keyArray = new String[50];
		for(int i=0;i<50;i++){
			keyArray[i] = cc.add("id","NO."+i);
			cc.put(keyArray[i], "value",""+(100+i));
		}
		return keyArray;
	}
	
	public static void main(String[] args){
		BeanContext.setConfigFile("..\\..\\sfip-config\\fourinone-config-Put.xml");
		String[] keyArray = putBigCache();
		putSmallCache(keyArray);
	}
}