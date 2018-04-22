package com.fiberlink.ehcache;

import java.util.Set;

public interface CacheService {
	/***
	 * Get an item out of the cache which is of a particular expected type.
	 * @param <T>
	 * @param key The key of the cache item
	 * @param clazz The expected class of the entry.
	 * @return
	 */
	<T> T get(String key, Class<T> clazz);

	/***
	 * Put an item in the cachce
	 * @param <T>
	 * @param key The key of the cache item
	 * @param data The data to put in the cache
	 */
	<T> void put(String key, T data);

	/***
	 * Remove the item with the given key from the cache.
	 *
	 * @param key The key of the item to remove
	 */
	void remove(String key);

	/***
	 * Gets all the keys which match a given pattern that are
	 * currently in the cache.
	 *
	 * @param pattern
	 * @return
	 */
	Set<String> getKeysMatchingPattern(String pattern);

	/**
	 * Removes all elements in the cache
	 */
	void removeAll();
	
	/**
	 * Gets an element from the cache, without updating Element statistics. Cache statistics are not updated.
	 * Listeners are not called.
	 * @param key
	 * @return
	 */
	<T> T getQuiet(Object key, Class<T> clazz);
	
	/**
	 * An inexpensive check to see if the key exists in the cache.
	 * @param key
	 * @return
	 */
	boolean isKeyInCache(Object key);
	
}
