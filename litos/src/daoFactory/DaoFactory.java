package daoFactory;
//conexiones de base de datos
import dao.interfaces.AdministradorDao;
import dao.interfaces.CremasDao;
import dao.interfaces.HamburguesasDao;
import dao.interfaces.PapasDao;
import dao.interfaces.ProductoDao;

public abstract class DaoFactory {
	public static final int MYSQL 		= 1;
	public static final int SQLSERVER 	= 2;
	public static final int ORACLE 		= 3;
// van de acuerdo a las interfaces
	public abstract AdministradorDao getAdministradorDao();
	public abstract ProductoDao getProductoDao();
	public abstract CremasDao getCremasDao();
	public abstract HamburguesasDao getHamburguesasDao();
	public abstract PapasDao getPapasDao();
	
	
	public static DaoFactory getDAOFactory(int factory){
		
		switch (factory) {
			case MYSQL:
				return new MySqlDaoFactory();
			case SQLSERVER:
				//return new SqlServerDaoFactory();
			case ORACLE:
				//return new OracleDaoFactory();
			default:
				return null;
		}
	}
}
