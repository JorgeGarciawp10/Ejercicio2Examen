package Ejercicio2;

import java.util.Arrays;

public class Libro {
    private String titulo;
    private String[] autores;
    private String identificador;
    private String categoria;
    private int edadRecomendada;
    private boolean prestado;
    private Usuario usuarioPrestamo;
 // Constructor, getters y setters
    
    
	public Libro(String titulo, String[] autores, String identificador, String categoria, int edadRecomendada,
			boolean prestado, Usuario usuarioPrestamo) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.identificador = identificador;
		this.categoria = categoria;
		this.edadRecomendada = edadRecomendada;
		this.prestado = prestado;
		this.usuarioPrestamo = usuarioPrestamo;
	}
	public Libro() {
		super();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String[] getAutores() {
		return autores;
	}
	public void setAutores(String[] autores) {
		this.autores = autores;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getEdadRecomendada() {
		return edadRecomendada;
	}
	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	public boolean isPrestado() {
		return prestado;
	}
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	public Usuario getUsuarioPrestamo() {
		return usuarioPrestamo;
	}
	public void setUsuarioPrestamo(Usuario usuarioPrestamo) {
		this.usuarioPrestamo = usuarioPrestamo;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autores=" + Arrays.toString(autores) + ", identificador=" + identificador
				+ ", categoria=" + categoria + ", edadRecomendada=" + edadRecomendada + ", prestado=" + prestado
				+ ", usuarioPrestamo=" + usuarioPrestamo + "]";
	}
    
    
    
    
    
}
