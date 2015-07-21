package dao.interfaces;

import beans.AdministradorBean;

public interface AdministradorDao {

	public AdministradorBean validar(String usuario, String clave) throws Exception;
	
}