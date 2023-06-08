package Ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Clase principal que representa la biblioteca
public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void darDeAltaLibro(Libro libro) {
        libros.add(libro);
    }

    public void darDeBajaLibro(Libro libro) {
        libros.remove(libro);
    }

    public void darDeAltaUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void darDeBajaUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (!libro.isPrestado() && usuario.getEdad() >= libro.getEdadRecomendada()) {
            libro.setPrestado(true);
            libro.setUsuarioPrestamo(usuario);
        }
    }

    public void devolverLibro(Libro libro) {
        if (libro.isPrestado()) {
            libro.setPrestado(false);
            libro.setUsuarioPrestamo(null);
        }
    }

    public List<Libro> listarLibrosPorTitulo(String titulo) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public List<Libro> listarLibrosPorCategoria(String categoria) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getCategoria().equalsIgnoreCase(categoria)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public List<Libro> listarLibrosPrestados() {
        List<Libro> librosPrestados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isPrestado()) {
                librosPrestados.add(libro);
            }
        }
        return librosPrestados;
    }

    public List<Libro> listarLibrosDisponibles() {
        List<Libro> librosDisponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (!libro.isPrestado()) {
                librosDisponibles.add(libro);
            }
        }
        return librosDisponibles;
    }

    public List<Libro> listarLibrosDeUsuario(Usuario usuario) {
        List<Libro> librosUsuario = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getUsuarioPrestamo() != null && libro.getUsuarioPrestamo().equals(usuario)) {
                librosUsuario.add(libro);
            }
        }
        return librosUsuario;
    }
    
    public List<Libro> listarLibrosPorUsuario(Usuario usuario) {
        List<Libro> librosUsuario = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.isPrestado() && libro.getUsuarioPrestamo().equals(usuario)) {
                librosUsuario.add(libro);
            }
        }

        return librosUsuario;
    }

    public void almacenarEstado(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            // Escribir información de los libros
            writer.write("LIBROS\n");
            for (Libro libro : libros) {
                writer.write("Título: " + libro.getTitulo() + "\n");
                writer.write("Autores: ");
                for (String autor : libro.getAutores()) {
                    writer.write(autor + ", ");
                }
                writer.write("\n");
                writer.write("Identificador: " + libro.getIdentificador() + "\n");
                writer.write("Categoría: " + libro.getCategoria() + "\n");
                writer.write("Edad recomendada: " + libro.getEdadRecomendada() + "\n");
                writer.write("Prestado: " + libro.isPrestado() + "\n");
                if (libro.isPrestado()) {
                    writer.write("Usuario de préstamo: " + libro.getUsuarioPrestamo().getNombre() + "\n");
                }
                writer.write("\n");
            }

            // Escribir información de los usuarios
            writer.write("USUARIOS\n");
            for (Usuario usuario : usuarios) {
                writer.write("Nombre: " + usuario.getNombre() + "\n");
                writer.write("Apellidos: " + usuario.getApellidos() + "\n");
                writer.write("Fecha de nacimiento: " + usuario.getFechaNacimiento() + "\n");
                writer.write("DNI: " + usuario.getDni() + "\n");
                writer.write("Edad: " + usuario.getEdad() + "\n");
                writer.write("\n");
            }

            System.out.println("Estado de la biblioteca almacenado en el archivo: " + archivo);
        } catch (IOException e) {
            System.out.println("Error al almacenar el estado de la biblioteca en el archivo: " + archivo);
            e.printStackTrace();
        }
    }
}
