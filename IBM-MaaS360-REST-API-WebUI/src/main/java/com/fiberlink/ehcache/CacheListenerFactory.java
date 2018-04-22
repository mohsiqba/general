/**
 * 
 */
package com.fiberlink.ehcache;

import java.util.Properties;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

/**
 * @author mohsiqba
 *
 */
public class CacheListenerFactory extends CacheEventListenerFactory{

	@Override
	public CacheEventListener createCacheEventListener(Properties arg0) {
		return CacheListener.INSTANCE;
	}
	
}
