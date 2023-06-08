package Ejercicio2;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String dni;
    private int edad;
    
    
 // Constructor, getters y setters
    
    
    
    public Usuario(String nombre, String apellidos, String fechaNacimiento, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
		this.edad = edad;
	}
    
    
	public Usuario() {
		super();
	}


	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", dni=" + dni + ", edad=" + edad + "]";
	}
	
	

    
    
    
    
}
