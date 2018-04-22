package com.fiberlink.ehcache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

final class CacheListener implements CacheEventListener {

	public static final CacheEventListener INSTANCE = new CacheListener();
	
	@Override
	public void dispose() {
		System.out.println("disposed listner");
	}

	@Override
	public void notifyElementEvicted(Ehcache arg0, Element arg1) {
		System.out.println("Evicted listner ("+arg1.getObjectValue()+" | "+arg1.getObjectKey()+" )");
	}

	@Override
	public void notifyElementExpired(Ehcache arg0, Element arg1) {
		System.out.println("expired listner ("+arg1.getObjectValue()+" | "+arg1.getObjectKey()+" )");
		
	}

	@Override
	public void notifyElementPut(Ehcache arg0, Element arg1)
			throws CacheException {
		System.out.println("put listner ("+arg1.getObjectValue()+" | "+arg1.getObjectKey()+" )");
	}

	@Override
	public void notifyElementRemoved(Ehcache arg0, Element arg1)
			throws CacheException {
		System.out.println("removed listner ("+arg1.getObjectValue()+" | "+arg1.getObjectKey()+" )");
	}

	@Override
	public void notifyElementUpdated(Ehcache arg0, Element arg1)
			throws CacheException {
		System.out.println("updated listner ("+arg1.getObjectValue()+" | "+arg1.getObjectKey()+" )");
	}

	@Override
	public void notifyRemoveAll(Ehcache arg0) {
		System.out.println("remove all listner");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton instance");
	}
}
