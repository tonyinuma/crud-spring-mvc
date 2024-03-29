/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.Conexion;
import Entidad.Persona;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lenovo
 */
@Controller
public class Controlador {
	
	Conexion con = new Conexion();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
	ModelAndView mav = new ModelAndView();
	
	//to get id, Methos GET
	int id;
	//To get List
	List datos;
	
	@RequestMapping("index.htm")
	public ModelAndView Listar(){
		String sql = "select * from persona";
		datos = this.jdbcTemplate.queryForList(sql);
		mav.addObject("lista", datos);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
	public ModelAndView Agregar(){
		mav.addObject(new Persona());
		mav.setViewName("agregar");
		
		return mav;
	}
	
	@RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
	public ModelAndView Agregar(Persona p){
		String sql = "insert into persona(Nombres, Correo, Nacionalidad) values(?,?,?);";
		this.jdbcTemplate.update(sql, p.getNombre(), p.getCorreo(), p.getNacionalidad());
				
		return new ModelAndView("redirect: /index.htm");
	}
	
	//Edit Persona
	@RequestMapping(value = "editar.htm", method = RequestMethod.GET)
	public ModelAndView Editar(HttpServletRequest  request){
		id = Integer.parseInt(request.getParameter("id"));
		
		String sql = "select * from persona where Id= "+id;
		datos = this.jdbcTemplate.queryForList(sql);
		mav.addObject("lista", datos);
		mav.setViewName("editar");
		return mav;
	}
	
	@RequestMapping(value = "editar.htm", method = RequestMethod.POST)
	public ModelAndView Editar(Persona p){
		String sql = "update persona set Nombres = ?, Correo = ?, Nacionalidad = ? where Id = ?";
		this.jdbcTemplate.update(sql, p.getNombre(), p.getCorreo(), p.getNacionalidad(), id);
				
		return new ModelAndView("redirect: /index.htm");
	}
	
	//Delete Persona
	@RequestMapping("delete.htm")
	public ModelAndView Delete(HttpServletRequest  request){
		id = Integer.parseInt(request.getParameter("id"));
		
		String sql = "delete from persona where Id= "+id;
		this.jdbcTemplate.update(sql);
		return new ModelAndView("redirect: /index.htm");
	}
}
