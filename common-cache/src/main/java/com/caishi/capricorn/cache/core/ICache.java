package com.caishi.capricorn.cache.core;

import java.util.List;

public interface ICache<K, V> {

	public void put(K k, V v);
	
	public V get(K k);
	
	public void remove(K k);
	
	public void removeAll();
	
	public List<K> getKeys();
	
}
