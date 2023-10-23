package co.edu.uniquindio.poo;

public class LibroImpreso extends Libro {
    private int cantidadHojas;

    public LibroImpreso(String nombreLibro, String fechaCreacion, Autor autor, Editorial editorial, int cantidadHojas) {
        super(nombreLibro, fechaCreacion, autor, editorial);
        assert cantidadHojas >= 1;
        this.cantidadHojas = cantidadHojas;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

}
