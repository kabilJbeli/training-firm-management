package com.management.dao;

import java.util.List;

import com.managament.entities.Don;

public interface serviceDon {

	public Don add(Don don);
	public void remove(int code);
	public List<Don> findAll();
	public Don find(int code);
	public boolean update(Don don);

	
}
