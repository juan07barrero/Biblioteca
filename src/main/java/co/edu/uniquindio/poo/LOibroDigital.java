package co.edu.uniquindio.poo;

public class LOibroDigital extends Libro {
    private String url;

    public LOibroDigital(String nombreLibro, String fechaCreacion, Autor autor, Editorial editorial, String url) {
        super(nombreLibro, fechaCreacion, autor, editorial);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
