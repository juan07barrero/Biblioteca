package co.edu.uniquindio.poo;

public class Editorial {

    private String nombreEditorial;
    private String numero;

    public Editorial(String nombreEditorial, String numero) {
        assert nombreEditorial != null && !nombreEditorial.isBlank();
        assert numero != null;
        this.nombreEditorial = nombreEditorial;
        this.numero = numero;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public String getNumero() {
        return numero;
    }

}
