package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.ProductoBean;
import dao.interfaces.ProductoDao;
import daoFactory.MySqlDaoFactory;

public class MySql_ProductoDao  extends MySqlDaoFactory implements ProductoDao{

	@Override
	public boolean crear(ProductoBean producto) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Connection con=MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "insert into libros " +
			" (nombre_cliente, hamburguesas_id,papas_id, precio,cremas_id) " +  
			" values " +
			" ('"+producto.getNombre_cliente()+"', '"+producto.getHamburguesas_id()+"', " +
			" '"+producto.getPapas_id()+"', '"+producto.getPrecio()+"', " +
			" '"+producto.getCremas_id()+"')";
			
			int filas = stmt.executeUpdate(query);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "delete from producto where id=" + id;
			
			int filas = stmt.executeUpdate(query);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return flag;
		
	}

	@Override
	public boolean actualizar(ProductoBean producto) throws Exception {
		// TODO Auto-generated method stub

		boolean flag = false;
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "update producto set " +
					"nombre_cliente='"+producto.getNombre_cliente()+"', " +
					"hamburguesas_id='"+producto.getHamburguesas_id()+"', " +
					"papas_id='"+producto.getPapas_id()+"', " +
					"precio='"+producto.getPrecio()+"'," +
					"cremas_id='"+producto.getCremas_id()+"', " +
					"where id=" + producto.getId();
			
			int filas = stmt.executeUpdate(query);
			if(filas == 1){
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}

	@Override
	public Vector<ProductoBean> seleccionarTodos() throws Exception {
		// TODO Auto-generated method stub
		Vector<ProductoBean> producto = new Vector<ProductoBean>();	
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select id, nombre_cliente, precio from producto";
			
			ResultSet rs = stmt.executeQuery(query);

			ProductoBean productos = null;
			while(rs.next()){
				productos = new ProductoBean();
				productos.setId(rs.getInt("id"));
				productos.setNombre_cliente(rs.getString("nombre_cliente"));
				productos.setPrecio(rs.getDouble("precio"));
				
				producto.add(productos);
			}	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return producto;
	}

	@Override
	public ProductoBean seleccionarPorId(int id) throws Exception {
		ProductoBean producto = null;
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select id,nombre_cliente, hamburguesas_id, papas_id,precio,cremas_id " +
			
			"from producto " +
			"where id=" + id;
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){
				producto = new ProductoBean();
				producto.setId( rs.getInt("id") );
				producto.setNombre_cliente( rs.getString("nombre") );
				producto.setHamburguesas_id( rs.getInt("hamburguesas") );
				producto.setPapas_id( rs.getInt("papas") );
				producto.setPrecio( rs.getDouble("precio") );
				
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return producto;
	}
	

}
