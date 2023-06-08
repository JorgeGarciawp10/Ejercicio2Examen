package Ejercicio2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro();
        libro1.setTitulo("La Isla del Tesoro");
        libro1.setAutores(new String[]{"Robert Louis Stevenson"});
        libro1.setIdentificador("LIT001");
        libro1.setCategoria("Aventuras");
        libro1.setEdadRecomendada(10);

        Libro libro2 = new Libro();
        libro2.setTitulo("1984");
        libro2.setAutores(new String[]{"George Orwell"});
        libro2.setIdentificador("LIT002");
        libro2.setCategoria("Ciencia Ficción");
        libro2.setEdadRecomendada(14);

        biblioteca.darDeAltaLibro(libro1);
        biblioteca.darDeAltaLibro(libro2);

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Juan");
        usuario1.setApellidos("Pérez");
        usuario1.setFechaNacimiento("2005-05-15");
        usuario1.setDni("12345678A");
        usuario1.setEdad(18);

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("María");
        usuario2.setApellidos("Gómez");
        usuario2.setFechaNacimiento("2009-02-28");
        usuario2.setDni("87654321B");
        usuario2.setEdad(14);

        biblioteca.darDeAltaUsuario(usuario1);
        biblioteca.darDeAltaUsuario(usuario2);
        
        //biblioteca.darDeBajaUsuario(usuario2);

        biblioteca.prestarLibro(libro1, usuario1);

        //biblioteca.devolverLibro(libro1);

        List<Libro> librosDisponibles = biblioteca.listarLibrosDisponibles();
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo());
        }

        biblioteca.almacenarEstado("estado_biblioteca.txt");
    }
}
