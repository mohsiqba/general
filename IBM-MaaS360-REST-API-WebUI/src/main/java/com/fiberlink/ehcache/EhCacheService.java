package com.fiberlink.ehcache;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheService implements CacheService {	
	private CacheManager manager = null;
	private Cache cache = null;

	public void removeAll()
	{
		cache.removeAll();
	}

	/***
	 * Constructor which takes a cache manager and the name
	 * of the cache which is to be used in this service.
	 *
	 * @param manager The cache manager
	 * @param cacheName The name of the cache to use
	 */
	public EhCacheService(CacheManager manager, String cacheName) {
		super();
		this.manager = manager;
		this.cache = this.manager.getCache(cacheName);
	}

	/***
	 * Constructor which takes a cache
	 * which is to be used in this service
	 * @param cache The cache
	 */
	public EhCacheService(Cache cache)
	{
		super();
		this.cache = cache;
		this.manager = this.cache.getCacheManager();
	}


	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> clazz) {
		Object o = cache.get(key);
		Element el = (Element) o;
		if (el == null || el.getValue() == null) {
			return null;
		}
		else if (clazz.isAssignableFrom(el.getValue().getClass())) {
			return (T)el.getValue();
		}
		else {
			return (T)null;
		}
	}

	public <T> void put(String key, T data) {
		cache.put(new Element(key, data));
	}

	public void remove(String key) {
		if (cache.isKeyInCache(key)) {
			cache.remove(key);
		}
	}

	@SuppressWarnings("unchecked")
	public Set<String> getKeysMatchingPattern(String pattern) {
		Pattern p = Pattern.compile(pattern);
		List<String> l = cache.getKeys();
		Set<String> keys = new HashSet<String>();
		for (String key : l) {
			if (p.matcher(key).matches()) {
				keys.add(key);
			}
		}
		return keys;
	}

	@Override
	public <T> T getQuiet(Object key, Class<T> clazz) {
		Object o = cache.getQuiet((Serializable)key);
		Element el = (Element) o;
		if (el == null || el.getValue() == null) {
			return null;
		}
		else if (clazz.isAssignableFrom(el.getValue().getClass())) {
			return (T)el.getValue();
		}
		else {
			return (T)null;
		}
	}
	
	@Override
	public boolean isKeyInCache(Object key) {
		return cache.isKeyInCache(key);
	}
}
