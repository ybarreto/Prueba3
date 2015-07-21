package daoFactory;

import java.sql.DriverManager;

import java.sql.Connection;

import dao.interfaces.AdministradorDao;
import dao.interfaces.CremasDao;
import dao.interfaces.HamburguesasDao;
import dao.interfaces.PapasDao;
import dao.interfaces.ProductoDao;
import dao.mysql.MySql_AdministradorDao;
import dao.mysql.MySql_CremasDao;
import dao.mysql.MySql_HamburguesasDao;
import dao.mysql.MySql_PapasDao;
import dao.mysql.MySql_ProductoDao;

public class MySqlDaoFactory extends DaoFactory{
	public static Connection obtenerConexion(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/litos";
			String user = "";
			String password ="";
			con = (Connection) DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return con;
	}

	@Override
	public ProductoDao getProductoDao() {
		// TODO Auto-generated method stub
		return new MySql_ProductoDao();
	}

	@Override
	public CremasDao getCremasDao() {
		// TODO Auto-generated method stub
		return new MySql_CremasDao();
	}

	@Override
	public HamburguesasDao getHamburguesasDao() {
		// TODO Auto-generated method stub
		return new MySql_HamburguesasDao();
	}

	@Override
	public PapasDao getPapasDao() {
		// TODO Auto-generated method stub
		return new MySql_PapasDao();
		
	}
	public AdministradorDao getAdministradorsDao() {
		// TODO Auto-generated method stub
		return new MySql_AdministradorDao();
	}

	@Override
	public AdministradorDao getAdministradorDao() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
