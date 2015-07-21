package dao.interfaces;

import java.util.Vector;

import beans.ProductoBean;

public interface ProductoDao {
	
	// declarar metodos o funcionalidades de cada clase
	public boolean crear (ProductoBean producto) throws Exception;
	public boolean eliminar(int id)throws Exception;
    public boolean actualizar(ProductoBean producto) throws Exception;
	
	public Vector<ProductoBean> seleccionarTodos() throws Exception;
	
	public ProductoBean seleccionarPorId(int id) throws Exception;
}
