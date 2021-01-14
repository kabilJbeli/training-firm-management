package com.management.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.managament.entities.Formation;
import com.managament.entities.Personnel;
import com.managament.entities.Type;
import com.management.dao.formationDaoImpl;
import com.management.dao.PersonnelDao;

@Path("/dons")
public class centerManagement{
	public PersonnelDao servicedon = new PersonnelDao();
	public formationDaoImpl serviceformation = new formationDaoImpl();

	@DELETE
	@Path("/removeFormation")
	public void removeFormation(@QueryParam("code") int code) {
		try {			
			 serviceformation.remove(code);		
			
		}catch(NullPointerException e) {
throw e;
		}
	}
	
	
	@POST
	@Path("/add/formation/{name}")
	@Produces({MediaType.APPLICATION_JSON})
	public Formation addFormation(@PathParam("name") String name) {
		Formation f = new Formation();
		 f.setName(name);
		try {
			
			return serviceformation.add(f);
			
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	
	
	@GET
	@Path("/getAllformations")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Formation> getFormationList() {
		List<Formation> forms;
		try {			
			forms = serviceformation.findAll();
			return forms;
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	@GET
	@Path("/getSpecificFormation")
	@Produces({MediaType.APPLICATION_JSON})
	public Formation getSpecificFormation(@QueryParam("id") int id) {
		Formation f;
		try {			
			f = serviceformation.find(id);
			return f;
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	
	@PUT
	@Path("/modifyFormation")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Boolean updateFormation(@QueryParam("id") int id,  @QueryParam("name") String name) {
		try {
			Formation f = serviceformation.find(id);
			 f.setName(name);
			return serviceformation.update(f);
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
//	@PUT
//	@Path("/modifyDon")
//	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	public Boolean addType(Personnel perso, @QueryParam("typeid") int idType) {
//		try {
//			return servicedon.update(perso);
//		}catch(NullPointerException e) {
//			throw e;
//			
//		}
//	}
//	
	
	
	
	@POST
	@Path("/addType")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON})
	public Type addType(Type type) {
		try {
			return servicedon.addType(type);
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	@GET
	@Path("/findType")
	@Produces({MediaType.APPLICATION_JSON})
	public Type findTypeById(@QueryParam("code") int code) {
	try {
					
		return servicedon.findType(code);
		
		}
	catch(NullPointerException e) {
		throw e;		
	}
	}
			
//	@POST
//	@Path("/add/{type}/{affectation}/{quantity}/{description}")
//	@Produces({MediaType.APPLICATION_JSON})
//	public Don addDon(@PathParam("type") int idType,@PathParam("affectation") String affectation,@PathParam("quantity") int quantity,@PathParam("description") String description) {
//		Don don = new Don();
//		don.setAffectation(affectation);
//		don.setDescription(description);
//		don.setQuantity(quantity);
//		try {
//			
//			Type type = servicedon.findType(idType);
//			don.setType(type);
//			
//			if (don.getQuantity() < (type.getQuantite() - servicedon.quantiteAjouté(type.getId())))
//			{
//			return servicedon.add(don);
//			}
//			{
//				return null;
//				}
//		}catch(NullPointerException e) {
//			throw e;
//			
//		}
//	}
	
	@DELETE
	@Path("/removeType")
	@Produces({MediaType.TEXT_HTML})
	public String removeTypeEntity(@QueryParam("code") int code) {
		try {			
			 return "<h3>"+servicedon.removeType(code)+"</h3>";		
			
		}catch(NullPointerException e) {
throw e;
		}
	}
	
	
	@DELETE
	@Path("/removeDon")
	@Produces({MediaType.TEXT_PLAIN})
	public void removeDon(@QueryParam("code") int code) {
		try {			
			
			servicedon.remove(code);		
			
		}catch(NullPointerException e) {
throw e;
		}
	}
	
	@GET
	@Path("/getAll")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Personnel> getAll() {
		List<Personnel> donsList;
		try {			
			donsList = servicedon.findAll();
			return donsList;
		}catch(NullPointerException e) {
			throw e;
			
		}
	}

	
	@GET
	@Path("/getTypeList")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Type> getTypeList() {
		List<Type> typeList;
		try {			
			typeList = servicedon.findAllTypes();
			return typeList;
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	@GET
	@Path("/getSpecificPerso")
	@Produces({MediaType.APPLICATION_JSON})
	public Personnel getSpecificPersonnel(@QueryParam("id") int id) {
		Personnel perso;
		try {			
			perso = servicedon.find(id);
			return perso;
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
}
