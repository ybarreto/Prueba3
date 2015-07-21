package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.HamburguesasBean;
import beans.PapasBean;
import dao.interfaces.PapasDao;
import daoFactory.MySqlDaoFactory;

public class MySql_PapasDao extends MySqlDaoFactory implements PapasDao{

	@Override
	public Vector<PapasBean> seleccionarTodos() throws Exception {
		// TODO Auto-generated method stub
		Vector<PapasBean> papas = new Vector<PapasBean>();	
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select id, nombre from papas";
			
			ResultSet rs = stmt.executeQuery(query);

			PapasBean papa = null;
			while(rs.next()){
				papa= new PapasBean();
				papa.setId(rs.getInt("id"));
				papa.setNombre(rs.getString("nombre"));
				
				papas.add(papa);
			}	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return papas;	
	}

}
