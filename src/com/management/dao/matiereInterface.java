package com.management.dao;

import java.util.List;

import com.managament.entities.Matiere;

public interface matiereInterface {
	public Matiere add(Matiere form);
	public void remove(int code);
	public List<Matiere> findAll();
	public Matiere find(int code);
	public boolean update(Matiere form);
	
}
