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
import com.managament.entities.Matiere;
import com.managament.entities.Personnel;
import com.managament.entities.Poste;
import com.managament.entities.Type;
import com.management.dao.formationDaoImpl;
import com.management.dao.matiiereDao;
import com.management.dao.PersonnelDao;

@Path("/dons")
public class centerManagement{
	public PersonnelDao servicedon = new PersonnelDao();
	public formationDaoImpl serviceformation = new formationDaoImpl();
	public matiiereDao serviceMatiere = new matiiereDao();
	
	

	@DELETE
	@Path("/removeMatiere")
	public void removeMatiere(@QueryParam("code") int code) {
		try {			
			serviceMatiere.remove(code);		
			
		}catch(NullPointerException e) {
			throw e;
		}
	}
	
	@POST
	@Path("/add/matiere/{employee}/{name}/{theme}/{salle}")
	@Produces({MediaType.APPLICATION_JSON})
	public Matiere addMatiere(@PathParam("employee") int employee,@PathParam("name") String name,@PathParam("theme") String theme,@PathParam("salle") String salle) {
		Matiere f = new Matiere();
		 f.setName(name);
		 f.setEmployee(employee);
		 f.setTheme(theme);
		 f.setSalle(salle);
		try {
			
			return serviceMatiere.add(f);
			
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	

	@GET
	@Path("/getAllMatiere")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Matiere> getMatiereList() {
		List<Matiere> forms;
		try {			
			forms = serviceMatiere.findAll();
			return forms;
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	
	
	
	
	@GET
	@Path("/getSpecificMatiere")
	@Produces({MediaType.APPLICATION_JSON})
	public Matiere getSpecificMatiere(@QueryParam("id") int id) {
		Matiere f;
		try {			
			f = serviceMatiere.find(id);
			return f;
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	
	@PUT
	@Path("/modifyMatiere")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Boolean updateMatiere(@QueryParam("id") int id,  @QueryParam("name") String name,@QueryParam("theme") String theme, @QueryParam("employee") int employee,@QueryParam("salle") String salle) {
		try {
			Matiere f = serviceMatiere.find(id);
			 f.setName(name);
			 f.setEmployee(employee);
			 f.setSalle(salle);
			 f.setTheme(theme);
			return serviceMatiere.update(f);
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	
	
	
	
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
	@Path("/add/formation/{name}/{theme}/{matiere}")
	@Produces({MediaType.APPLICATION_JSON})
	public Formation addFormation(@PathParam("name") String name,@PathParam("theme") String theme,@PathParam("matiere") int matiere) {
		Formation f = new Formation();
		 f.setName(name);
		 f.setMatiere(matiere);
		 f.setTheme(theme);
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
	public Boolean updateFormation(@QueryParam("id") int id,  @QueryParam("name") String name,@QueryParam("theme") String theme, @QueryParam("matiere") int matiere) {
		try {
			Formation f = serviceformation.find(id);
			 f.setName(name);
			 f.setMatiere(matiere);
			 f.setTheme(theme);
			return serviceformation.update(f);
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	@PUT
	@Path("/modifyEmployee")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Boolean addType(Personnel perso, @QueryParam("typeid") int idType) {
		try {
			return servicedon.update(perso);
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	
	
	
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
	
	
	@GET
	@Path("/getAllPostes")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Poste> getAllPostes() {
	try {
					
		return servicedon.getAllPosts();
		
		}
	catch(NullPointerException e) {
		throw e;		
	}
	}
			
	@POST
	@Path("/add/{nom}/{prenom}/{honoraire}/{post}")
	@Produces({MediaType.APPLICATION_JSON})
	public Personnel addPersonnel(@PathParam("nom") String nom,@PathParam("prenom") String prenom,@PathParam("honoraire") double honoraire,@PathParam("post") String post) {
	
		Personnel perso = new Personnel();
		perso.setHonoraireparheure(honoraire);
		perso.setPoste(Poste.valueOf(post));
		perso.setNom(nom);
		perso.setPrenom(prenom);
		try {	
			
			return servicedon.add(perso);
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
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
	@Path("/removeEmployee")
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
	@Path("/getSpecificEmployee")
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
