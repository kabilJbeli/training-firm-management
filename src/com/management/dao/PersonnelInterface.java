package com.management.dao;

import java.util.List;

import com.managament.entities.Personnel;

public interface PersonnelInterface {

	public Personnel add(Personnel don);
	public void remove(int code);
	public List<Personnel> findAll();
	public Personnel find(int code);
	public boolean update(Personnel don);

	
}
