package co.edu.uniquindio.poo;

public class Autor {

    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        assert nacionalidad != null;
        assert nombre != null;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;

    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

}
