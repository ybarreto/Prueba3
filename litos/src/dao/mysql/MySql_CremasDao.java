package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.CremasBean;
import dao.interfaces.CremasDao;
import daoFactory.MySqlDaoFactory;

public class MySql_CremasDao extends MySqlDaoFactory implements CremasDao{

	@Override
	public Vector<CremasBean> seleccionarTodos() throws Exception {
		// TODO Auto-generated method stub
		Vector<CremasBean> cremas = new Vector<CremasBean>();	
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select id, nombre from generos";
			
			ResultSet rs = stmt.executeQuery(query);

			CremasBean crema = null;
			while(rs.next()){
				crema= new CremasBean();
				crema.setId(rs.getInt("id"));
				crema.setNombre(rs.getString("nombre"));
				
				cremas.add(crema);
			}	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return cremas;	
	}
	

}
