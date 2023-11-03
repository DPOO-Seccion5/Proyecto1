package procesamiento;

import java.util.ArrayList;
import procesamiento.Loader;

import modelo.*;
import java.util.List;
import java.util.Map;


public class Compañia {
	
	
	private Inventario inventario;
	
	private List<Sede> sedes;
	
	private List<Cliente> clientes;
	
	private List<Empleado> empleados;
	

	
	
	public Compañia(Inventario elInventario, List<Sede> lasSedes, List<Cliente> losClientes, List<Empleado> losEmpleados)
	{
		this.inventario = elInventario;
		this.sedes = lasSedes;
		this.clientes = losClientes;
		this.empleados = losEmpleados;
	}
	
	
	public Inventario getInventario()
	{
		return inventario;
	}
	
	public List<Sede> getSedes()
	{
		return sedes;
	}
	
	public List<Cliente> getClientes()
	{
		return clientes;
	}
	
	
	
	public boolean logIn(String username, String password)
	{
		
		boolean respuesta = false;
		
		if (username.contains("empleado"))
		{
			for(Empleado y : empleados)
			{
				String user = y.getUsername();
				String pass = y.getPassword();
			
				if ((username.equals(user)) && (password.equals(pass)))
				{
					respuesta = true;
				}
				else 
				{
					respuesta = false;
				}	
			}	
		}
		else
		{
			for(Cliente x : clientes)
			{
				String user = x.getUsername();
				String pass = x.getPassword();
			
				if ((username.equals(user)) && (password.equals(pass)))
				{
					respuesta = true;
				}
				else 
				{
					respuesta = false;
				}
			}
		}
		
		return respuesta;
		
	}
	
	
	
	
	
	public Cliente crearCliente(String nombre,String numID, String fechaNacimiento, String nacionalidad, String username, String password, String numeroLicencia, String paisExpedicion,String numeroTarjeta, String fechaVencimiento, String nombreTitular, String cvc)
	{
		DatosLicencia licencia = new DatosLicencia(numeroLicencia, paisExpedicion, fechaNacimiento);
		DatosPago tarjeta = new DatosPago(numeroTarjeta, fechaVencimiento,nombreTitular,cvc);
		ArrayList<ConductorExtra> conductoresExtra = new ArrayList();
		Cliente cliente = new Cliente(nombre,numID, fechaNacimiento, nacionalidad, username, password, licencia,conductoresExtra,tarjeta);
		clientes.add(cliente);
		return cliente;
		
	}
	
	public void addCliente(Cliente elCliente) {

		clientes.add(elCliente);

	}
	

	
	public Empleado crearEmpleado(String nombre, String username, String password, String numID, String nacionalidad, String fechaNacimiento)
	{
		Empleado empleado = new Empleado(nombre,username,password,numID,nacionalidad,fechaNacimiento);
		empleados.add(empleado);
		
		return empleado;
		
	}
	
}
