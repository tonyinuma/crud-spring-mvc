/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author lenovo
 */
public class Conexion {
	
	public DriverManagerDataSource Conectar(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/registro");//Url and Database Name
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	
}
