package com.aio;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Path("/student")
public class RestServer {
	private DaoService daoService;

	public RestServer() {
		daoService = new DaoServiceImp();
	}

	@GET
	@Path("/getallstudent")
	@Produces("application/json"+";charset=utf-8")
	public Response getAllStudent() throws Exception {
		List<Student> students = daoService.getAllStudent();
		Gson gson = new Gson();
//		JsonElement element = gson.toJsonTree(students, new TypeToken<List<Student>>() {
//		}.getType());
		
		String json = gson.toJson(students);

//		JsonArray jsonArray = element.getAsJsonArray();
//		System.out.println(Response.status(201).entity(jsonArray).build());
		return Response.status(201).entity(json).build();
	}

	@POST
	@Path("/getstudent")
	@Consumes("application/json")
	public Response getStudent(int id) throws Exception {
		return Response.status(201).entity(daoService.getStudent(id)).build();
		//return Response.status(201).entity().build();
	}

	@POST
	@Path("/addstudent")
	public Response addStudent(@FormParam("name") String name, 
							   @FormParam("sname")String sname, 
							   @FormParam("email")String email) throws Exception {
		daoService.addStudent(name, sname, email);
		return Response.status(200).entity("database e eklendi").build();
	}

	@POST
	@Path("/deleteStudent")
	public Response deleteStudent(int id) throws Exception {
		daoService.deleteStudent(id);
		return Response.status(201).entity("databaseden silindi").build();
	}

	@POST
	@Path("/updatestudent")
	public Response updateStudent(int id, String name, String lname, String email) throws Exception {
		daoService.updateStudent(id, name, lname, email);
		return Response.status(201).entity("database update oldu").build();
	}
}
