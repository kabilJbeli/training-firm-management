package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entities.Don;
import entities.Type;
import services.serviceDon;
import services.serviceDonImpl;

@Path("/dons")
public class donEntityManagement{
	public serviceDonImpl servicedon = new serviceDonImpl();
	
	
	
	
	
	@POST
	@Path("/addType")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Type addType(Type type) {
		try {
			return servicedon.addType(type);
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
	
	
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Don addDon(Don don) {
		try {
			if (don.getQuantity()<(don.getType().getQuantite() - servicedon.quantiteAjouté(don.getType().getId())))
			{
			return servicedon.add(don);
			}
			{
				return null;
				}
		}catch(NullPointerException e) {
			throw e;
			
		}
	}

	@DELETE
	@Path("/removeDon")
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
	public List<Don> getAll() {
		List<Don> donsList;
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
	@Path("/getSpecificDon")
	@Produces({MediaType.APPLICATION_JSON})
	public Don getSpecificDon(@QueryParam("id") int id) {
		Don don;
		try {			
			don = servicedon.find(id);
			return don;
		}catch(NullPointerException e) {
			throw e;
			
		}
	}
}
