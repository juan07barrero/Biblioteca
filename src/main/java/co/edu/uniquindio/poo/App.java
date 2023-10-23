package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

class Biblioteca {
    private String nombre;
    private String direccion;
    private int cantidadLibros;
    private String fechaCreacion;
    private Set<Libro> nombresLibros;

    public Biblioteca(String nombre, String direccion, String fechaCreacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaCreacion = fechaCreacion;
        nombresLibros = new HashSet<>();
    }

    // Getters y setters para acceder a los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidadLibros() {

        return nombresLibros.size();
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean BuscarLibroAutor(Libro nn) {
        boolean centinela = false;
        for (Libro i : nombresLibros) {
            if (i.getAutor().equals(nn.getAutor())) {
                centinela = true;
            }

        }

        return centinela;
    }

    public Optional<Libro> BuscarLibrosPorFormato(LOibroDigital lOibroDigital) {
        Predicate<Libro> nombreIgual = j -> j.getAutor().equals(lOibroDigital.getAutor());
        return nombresLibros.stream().filter(nombreIgual).findAny();

    }

    

    public Optional<LibroImpreso> librosDigitalesconVersionImpresa(LOibroDigital lOibroDigital) {

        Predicate<Libro> nombreIgual = j -> j.getNombreLibro().equals(lOibroDigital.getNombreLibro());
        Collection<LibroImpreso> ll = ListaLibrosImpresos();

        return ll.stream().filter(nombreIgual).findAny();

    }

    public Optional<Libro> BuscarLibroPorNombre(String nombre) {
        Predicate<Libro> nombreIgual = j -> j.getNombreLibro().equals(nombre);
        return nombresLibros.stream().filter(nombreIgual).findAny();
    }

    public Collection<LibroImpreso> ListaLibrosImpresos() {
        Predicate<Libro> condicion = libro -> libro instanceof LibroImpreso;
        return nombresLibros.stream().filter(condicion).map(libro -> (LibroImpreso) libro).toList();

    }

    public Collection<LibroCd> ListaLibrosCd() {
        Predicate<Libro> condicion = libro -> libro instanceof LibroCd;
        return nombresLibros.stream().filter(condicion).map(libro -> (LibroCd) libro).toList();

    }

    public Collection<LOibroDigital> ListaLibrosDigital() {
        Predicate<Libro> condicion = libro -> libro instanceof LOibroDigital;
        return nombresLibros.stream().filter(condicion).map(libro -> (LOibroDigital) libro).toList();
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Cantidad de libros: " + cantidadLibros);
        System.out.println("Fecha de creación: " + fechaCreacion);
        // System.out.println(agregarLibro(libroA));
        // System.out.println(agregarLibro(libroB));
        System.out.println(nombresLibros);
    }

    public int CantidadLibrosPorDigitales(Autor autor) {
        assert autor != null;
        int contadorLibrosDigitales = 0;

        Collection<LOibroDigital> libroDigital = ListaLibrosDigital();

        for (LOibroDigital i : libroDigital) {
            if (i.getAutor().equals(autor)) {
                contadorLibrosDigitales++;
            }
        }

        return contadorLibrosDigitales;
    }

    public int CantidadLibrosPorCd(Autor autor) {
        assert autor != null;
        int contadorLibrosCd = 0;

        Collection<LibroCd> libroCds = ListaLibrosCd();
        for (LibroCd i : libroCds) {
            if (i.getAutor().equals(autor)) {
                contadorLibrosCd++;
            }
        }

        return contadorLibrosCd;
    }

    public int CantidadLibrosImpresos(Autor autor) {
        assert autor != null;
        int contadorLibrosImpresos = 0;

        Collection<LibroImpreso> libroImpresos = ListaLibrosImpresos();
        for (LibroImpreso i : libroImpresos) {
            if (i.getAutor().equals(autor)) {
                contadorLibrosImpresos++;
            }
        }

        return contadorLibrosImpresos;
    }

    public ArrayList<Integer> cantidadLibrosAutor(Autor autor) {
        assert autor != null;
        ArrayList<Integer> cant = new ArrayList<>();
        cant.add(CantidadLibrosImpresos(autor));
        cant.add(CantidadLibrosPorCd(autor));
        cant.add(CantidadLibrosPorDigitales(autor));

        return cant;
    }

    public boolean agregarLibro(Libro libro) {
        if (!nombresLibros.contains(libro.getNombreLibro())) {
            nombresLibros.add(libro);
            System.out.println("El libro ha sido agregado exitosamente.");
            return true;
        } else {
            System.out.println("Ya existe un libro con el mismo nombre en la biblioteca.");
            return false;
        }
    }

    

}
