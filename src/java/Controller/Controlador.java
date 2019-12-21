/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.Conexion;
import Entidad.Persona;
import java.util.List;
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
	
	@RequestMapping("index.htm")
	public ModelAndView Listar(){
		String sql = "select * from persona";
		List datos = this.jdbcTemplate.queryForList(sql);
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
	
}
