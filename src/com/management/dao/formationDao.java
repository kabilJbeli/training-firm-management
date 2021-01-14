package com.management.dao;

import java.util.List;

import com.managament.entities.Formation;

public interface formationDao {
	public Formation add(Formation form);
	public void remove(int code);
	public List<Formation> findAll();
	public Formation find(int code);
	public boolean update(Formation form);
}
