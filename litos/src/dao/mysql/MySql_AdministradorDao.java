package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import beans.AdministradorBean;
import dao.interfaces.AdministradorDao;
import daoFactory.MySqlDaoFactory;

public class MySql_AdministradorDao extends MySqlDaoFactory implements AdministradorDao{

	@Override
	public AdministradorBean validar(String usuario, String clave)
			throws Exception {
		// TODO Auto-generated method stub
		AdministradorBean admin = null;
		
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id, nombre " +
					" from administradores " +
					" where usuario='" + usuario +"' " +
					" and clave='" + clave +"'");
			
			if(rs.next()){
				admin = new AdministradorBean();
				admin.setId(rs.getInt("id"));
				admin.setNombre(rs.getString("nombre"));
			}
			/*while(rs.next()){
				if (rs.getString("usuario").equals(usuario)){
					
				}
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return admin;
	}

}