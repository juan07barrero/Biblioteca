package co.edu.uniquindio.poo;

public class LibroCd extends Libro {
    private String tamanio;

    public LibroCd(String nombreLibro, String fechaCreacion, Autor autor, Editorial editorial, String tamanio) {
        super(nombreLibro, fechaCreacion, autor, editorial);
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }

}
