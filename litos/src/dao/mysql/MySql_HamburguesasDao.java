package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.CremasBean;
import beans.HamburguesasBean;
import dao.interfaces.HamburguesasDao;
import daoFactory.MySqlDaoFactory;

public class MySql_HamburguesasDao extends MySqlDaoFactory implements HamburguesasDao{

	@Override
	public Vector<HamburguesasBean> seleccionarTodos() throws Exception {
		// TODO Auto-generated method stub
		Vector<HamburguesasBean> hamburguesas = new Vector<HamburguesasBean>();	
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select id, nombre from hamburguesa";
			
			ResultSet rs = stmt.executeQuery(query);

			HamburguesasBean hamburguesa = null;
			while(rs.next()){
				hamburguesa= new HamburguesasBean();
				hamburguesa.setId(rs.getInt("id"));
				hamburguesa.setNombre(rs.getString("nombre"));
				
				hamburguesas.add(hamburguesa);
			}	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return hamburguesas;	
	}
	
}
