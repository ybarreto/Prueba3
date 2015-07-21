package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CremasBean;
import beans.HamburguesasBean;
import beans.PapasBean;
import beans.ProductoBean;

import dao.interfaces.CremasDao;
import dao.interfaces.HamburguesasDao;
import dao.interfaces.PapasDao;
import dao.interfaces.ProductoDao;
import daoFactory.DaoFactory;

/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		
		if(accion.equals("agregar")){
			
			request.getRequestDispatcher("/admin/producto_agregar.jsp")
											.forward(request, response);
		}else if(accion.equals("listar")){
			try {
				
				DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
				ProductoDao productodao = dao.getProductoDao();
				Vector<ProductoBean> productos = productodao.seleccionarTodos();
				
				request.setAttribute("productos", productos);
				request.getRequestDispatcher("/admin/producto_listar.jsp")
												.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}else if(accion.equals("eliminar")){
			try {
				String id = request.getParameter("id");
				
				DaoFactory dao= DaoFactory.getDAOFactory(DaoFactory.MYSQL);
				ProductoDao productodao = dao.getProductoDao();
				boolean flag = productodao.eliminar(Integer.parseInt(id));
				if(flag){
					request.setAttribute("mensaje", "Producto eliminado");
				}else{
					request.setAttribute("mensaje", "Ocurrió un error");
				}
				
				request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);	
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}else if(accion.equals("editar")){
			try {
				String id = request.getParameter("id");
				
				DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
				
				ProductoDao productodao = dao.getProductoDao();
				ProductoBean producto = productodao.seleccionarPorId(Integer.parseInt(id));
				request.setAttribute("producto", producto);
				
				HamburguesasDao hamburguesadao = dao.getHamburguesasDao();
				Vector<HamburguesasBean> hamburguesas = hamburguesadao.seleccionarTodos();
				request.setAttribute("hamburguesas", hamburguesas);
				
				PapasDao papasdao = dao.getPapasDao();
				Vector<PapasBean> papas= papasdao.seleccionarTodos();
				request.setAttribute("papas", papas);
				
				CremasDao cremasdao = dao.getCremasDao();
				Vector<CremasBean> cremas = cremasdao.seleccionarTodos();
				request.setAttribute("cremas", cremas);
				
				request.getRequestDispatcher("/admin/producto_editar.jsp").forward(request, response);
				
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try {
			ProductoBean producto = new ProductoBean();
			producto.setNombre_cliente( request.getParameter("txt_nombre_cliente") );
			producto.setHamburguesas_id( Integer.parseInt(request.getParameter("sel_hamburguesa")) );
			producto.setPapas_id( Integer.parseInt(request.getParameter("sel_papas")) );
			producto.setPrecio( Double.parseDouble(request.getParameter("txt_precio")) );
			producto.setCremas_id( Integer.parseInt(request.getParameter("cbo_cremas")) );
			
			
			DaoFactory dao= DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			ProductoDao productodao = dao.getProductoDao();
			
			boolean flag;
			if(request.getParameter("accion") != null &&
					request.getParameter("accion").equals("actualizar")){
				producto.setId(Integer.parseInt(request.getParameter("txt_id")));
				flag = productodao.actualizar(producto);
			}else{
				flag =productodao.crear(producto);
			}
			
			if(flag){
				request.setAttribute("mensaje", "Producto guardado");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);	
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}