package co.edu.uniquindio.poo;

public abstract class Libro {

    private String nombreLibro;
    private String fechaCreacion;
    private Autor autor;
    private Editorial editorial;

    public Libro(String nombreLibro, String fechaCreacion, Autor autor, Editorial editorial){
        this.nombreLibro = nombreLibro;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
        this.editorial = editorial;

    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial( ){
        return editorial;
    }





}
