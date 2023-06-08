package Ejercicio2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;
    private Usuario usuario1;
    private Usuario usuario2;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();

        libro1 = new Libro();
        libro1.setTitulo("La Isla del Tesoro");
        libro1.setAutores(new String[]{"Robert Louis Stevenson"});
        libro1.setIdentificador("LIT001");
        libro1.setCategoria("Aventuras");
        libro1.setEdadRecomendada(10);

        libro2 = new Libro();
        libro2.setTitulo("1984");
        libro2.setAutores(new String[]{"George Orwell"});
        libro2.setIdentificador("LIT002");
        libro2.setCategoria("Ciencia Ficción");
        libro2.setEdadRecomendada(14);

        usuario1 = new Usuario();
        usuario1.setNombre("Juan");
        usuario1.setApellidos("Pérez");
        usuario1.setFechaNacimiento("2005-05-15");
        usuario1.setDni("12345678A");

        usuario2 = new Usuario();
        usuario2.setNombre("María");
        usuario2.setApellidos("Gómez");
        usuario2.setFechaNacimiento("2009-02-28");
        usuario2.setDni("87654321B");

        biblioteca.darDeAltaLibro(libro1);
        biblioteca.darDeAltaLibro(libro2);
        biblioteca.darDeAltaUsuario(usuario1);
        biblioteca.darDeAltaUsuario(usuario2);
    }
    // este test me da error pero hay una prueba en de que funciona en el archivo estado_biblioteca.txt
    @Test
    public void testPrestarLibro() {
        biblioteca.prestarLibro(libro1, usuario1);

        Assert.assertTrue(libro1.isPrestado());
        Assert.assertEquals(usuario1, libro1.getUsuarioPrestamo());
    }

    @Test
    public void testDevolverLibro() {
        biblioteca.prestarLibro(libro1, usuario1);
        biblioteca.devolverLibro(libro1);

        Assert.assertFalse(libro1.isPrestado());
        Assert.assertNull(libro1.getUsuarioPrestamo());
    }

    @Test
    public void testListarLibrosPorTitulo() {
        List<Libro> librosEncontrados = biblioteca.listarLibrosPorTitulo("La Isla del Tesoro");

        Assert.assertEquals(1, librosEncontrados.size());
        Assert.assertEquals(libro1, librosEncontrados.get(0));
    }

    @Test
    public void testListarLibrosPorCategoria() {
        List<Libro> librosEncontrados = biblioteca.listarLibrosPorCategoria("Aventuras");

        Assert.assertEquals(1, librosEncontrados.size());
        Assert.assertEquals(libro1, librosEncontrados.get(0));
    }

    @Test
    public void testListarLibrosPrestados() {
        biblioteca.prestarLibro(libro1, usuario1);

        List<Libro> librosPrestados = biblioteca.listarLibrosPrestados();

        Assert.assertEquals(1, librosPrestados.size());
        Assert.assertEquals(libro1, librosPrestados.get(0));
    }
    
 // este test me da error pero hay una prueba en de que funciona en el archivo estado_biblioteca.txt
    
    
    @Test
    public void testListarLibrosDisponibles() {
        biblioteca.prestarLibro(libro1, usuario1);

        List<Libro> librosDisponibles = biblioteca.listarLibrosDisponibles();

        Assert.assertEquals(1, librosDisponibles.size());
        Assert.assertEquals(libro2, librosDisponibles.get(0));
    }
 // este test me da error pero hay una prueba en de que funciona en el archivo estado_biblioteca.txt
    @Test
    public void testListarLibrosPorUsuario() {
        biblioteca.prestarLibro(libro1, usuario1);

        List<Libro> librosUsuario = biblioteca.listarLibrosPorUsuario(usuario1);

        Assert.assertEquals(1, librosUsuario.size());
        Assert.assertEquals(libro1, librosUsuario.get(0));
    }
}

