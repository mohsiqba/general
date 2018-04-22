package com.spring.web.service;

import java.util.List;

public interface Service<T,U> {
	public T add(T obj);
	public T get(U id);
	public List<T> getAll();
	public T update(T obj);
	public T delete(U id);
}
