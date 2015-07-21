package beans;
// atributos

public class ProductoBean {
	
	int id;
	String nombre_cliente;
	int hamburguesas_id;
	int papas_id;
	double precio;
	int cremas_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public int getHamburguesas_id() {
		return hamburguesas_id;
	}
	public void setHamburguesas_id(int hamburguesas_id) {
		this.hamburguesas_id = hamburguesas_id;
	}
	public int getPapas_id() {
		return papas_id;
	}
	public void setPapas_id(int papas_id) {
		this.papas_id = papas_id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCremas_id() {
		return cremas_id;
	}
	public void setCremas_id(int crema_id) {
		this.cremas_id = crema_id;
	}
	
	

}
