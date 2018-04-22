package com.fiberlink.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fiberlink.ehcache.EhCacheService;

@Controller
public class EhcacheController {

	@Autowired
	@Qualifier("cacheService")
	EhCacheService cacheService;
	
	@RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
	public String ehCacheGet(@PathVariable("key") String key) {
		System.out.println("ehCacheGet excuted with key:"+key);
		
		if(cacheService.getQuiet(key, String.class)==null){
			System.out.println("key is in cache");
		}else{
			System.out.println("key is not in cache");
		}
		
		if(cacheService.get(key, String.class)==null){
			System.out.println("get in cache is null");
		}
			
		System.out.println("value is :"+cacheService.get(key, String.class));
		return "index";
	}
	
	@RequestMapping(value = "/{key}/{value}", method = RequestMethod.GET)
	public String ehCache(@PathVariable("key") String key,@PathVariable("value") String value) {
		System.out.println("ehCache excuted with key:"+key+" and value :"+value);
		
		if(cacheService.isKeyInCache(key)){
			System.out.println("key is in cache");
		}else{
			System.out.println("key is not in cache......");
			
		}
		
		if(cacheService.get(key, String.class)==null){
			System.out.println("get in cache is null...putting it...");
			cacheService.put(key, value);
		}
			
		System.out.println("value is :"+cacheService.get(key, String.class));
		return "index";
	}
	
	@RequestMapping(value = "/post/{key}/{value}", method = RequestMethod.GET)
	public String ehCachePost(@PathVariable("key") String key,@PathVariable("value") String value) {
		System.out.println("ehCachePost excuted with key:"+key+" and value:"+value);
		cacheService.put(key, value);
		return "index";
	}
}
