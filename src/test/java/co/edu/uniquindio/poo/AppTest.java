package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    // EN ESTA PRUEBA PROBAMOS EL NOMBRE DE LIBRO 1
    public void ProbarDatosLibroNombre() {
        LOG.info("PROBANDO NOMBRE DE LIBRO");
        Autor autor = new Autor("Brayan CORDOBA ", "COLOMBIANO");
        Editorial editorial = new Editorial("LIBROS PIPE ", "212212");
        LibroImpreso libro1 = new LibroImpreso("LA VUELTA AL MUNDO EN 80 DIAS", "29/06/2010", autor, editorial, 25);
        assertEquals("LA VUELTA AL MUNDO EN 80 DIAS", libro1.getNombreLibro());
        LOG.info("Fin de prueba de nombre del libro...");

    }

    @Test
    // EN ESTA PRUEBA PROBAMOS EL NOMBRE DEL AUTOR DE LIBRO 1
    public void ProbarDatosLibroNacionalidad() {
        LOG.info("probando nombre  del autor");
        Autor autor = new Autor("Brayan CORDOBA ", "COLOMBIANO");
        Editorial editorial = new Editorial("LIBROS PIPE ", "212212");
        LibroImpreso libro1 = new LibroImpreso("LA VUELTA AL MUNDO EN 80 DIAS", "29/06/2010", autor, editorial, 25);
        assertEquals("COLOMBIANO", libro1.getAutor().getNacionalidad());
        LOG.info("Fin de prueba de nombre del libro...");

    }

    
    @Test
    public void testBuscarLibroAutorExistente() {
        LOG.info("Probando busqueda de libro por autor");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Autor autor = new Autor("Stephen king","Estadounidense");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        LibroCd libro1 = new LibroCd("El Resplandor","1977", autor,editorial,"32 MB");
        LibroCd libro2 = new LibroCd("Cementerio De Animales", "1983",autor,editorial,"42 MB");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        assertTrue(biblioteca.BuscarLibroAutor(libro1));
        LOG.info("Fin de prueba de busqueda del libro...");
    }


   

    @Test
    public void testBuscarLibrosPorFormato() {
        LOG.info("Probando busqueda de libro por formato");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Autor autor = new Autor("Stephen king","Estadounidense");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        LOibroDigital libroDigital = new LOibroDigital("It", "1984", autor,editorial,"https:/it.com");
        biblioteca.agregarLibro(libroDigital);

        Optional<Libro> resultado = biblioteca.BuscarLibrosPorFormato(libroDigital);

        assertTrue(resultado.isPresent());
        assertEquals(libroDigital, resultado.get());
        LOG.info("Fin de prueba de busqueda...");
    }

   /**@Test
    public void testLibrosDigitalesconVersionImpresa() {
        LOG.info("Probando libros digitales con version impresa");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Autor autor = new Autor("Stephen king","Estadounidense");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        LOibroDigital libroDigital = new LOibroDigital("It", "1984", autor,editorial,"https:/it.com");
        LibroImpreso libroImpreso = new LibroImpreso("It", "1984", autor,editorial,34);
        biblioteca.agregarLibro(libroDigital);
        biblioteca.agregarLibro(libroImpreso);

        Optional<LibroImpreso> resultado = biblioteca.LibrosDigitalesconVersionImpresa(libroDigital);

        assertTrue(resultado.isPresent());
        assertEquals(libroImpreso, resultado.get());
        LOG.info("Fin de prueba...");
    }**/

    

    @Test
    public void testLibrosDigitalesconVersionImpresa() {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Autor autor = new Autor("Stephen king","Estadounidense");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        LOibroDigital libroDigital = new LOibroDigital("El Libro Digital", "2023", autor,editorial, "https:digital.com");
        LibroImpreso libroImpreso = new LibroImpreso("El Libro Digital", "2023",autor, editorial, 200);

        biblioteca.agregarLibro(libroDigital);
        biblioteca.agregarLibro(libroImpreso);

        Optional<LibroImpreso> resultado = biblioteca.librosDigitalesconVersionImpresa(libroDigital);

        //assertTrue(resultado.isPresent());
        assertEquals(libroImpreso, resultado.get());
    }



    @Test
    public void testBuscarLibroPorNombre() {
        LOG.info("Probando busqueda de libro por autor");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Autor autor = new Autor("Stephen king","Estadounidense");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        LibroCd libro1 = new LibroCd("El Resplandor","1977", autor,editorial,"32 MB");
        LibroCd libro2 = new LibroCd("Cementerio De Animales", "1983",autor,editorial,"42 MB");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        Optional<Libro> resultado = biblioteca.BuscarLibroPorNombre("El Resplandor");

        assertTrue(resultado.isPresent());
        assertEquals(libro1, resultado.get());
        LOG.info("Fin de la prueba...");
    }

    

    @Test
    public void testListaLibrosImpresos() {
        LOG.info("Probando listar libros impresos");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Collection<LibroImpreso> librosImpresos = biblioteca.ListaLibrosImpresos();

        for (Libro libro : librosImpresos) {
            assertTrue(libro instanceof LibroImpreso);
        }
        LOG.info("Fin de la prueba...");
    }

    @Test
    public void testListaLibrosCd() {
        LOG.info("Probando listar libros en cds");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Collection<LibroCd> librosCd = biblioteca.ListaLibrosCd();

        for (Libro libro : librosCd) {
            assertTrue(libro instanceof LibroCd);
        }
        LOG.info("Fin de la prueba...");
    }

    @Test
    public void testListaLibrosDigital() {
        LOG.info("Probando listar libros digitales");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Collection<LOibroDigital> librosDigitales = biblioteca.ListaLibrosDigital();

        for (Libro libro : librosDigitales) {
            assertTrue(libro instanceof LOibroDigital);
        }
        LOG.info("Fin de la prueba...");
    }

    
    @Test
    public void testCantidadLibrosPorDigitales() {
        LOG.info("Probando lista de cantidad libros digitales");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        Autor autor = new Autor("Stephen King", "Estadounidense");
        LOibroDigital libro1 = new LOibroDigital("El Resplandor","1977", autor,editorial,"wwww.libros.com");
        biblioteca.agregarLibro(libro1);
        int cantidad = biblioteca.CantidadLibrosPorDigitales(autor);
        assertEquals(1, cantidad); // Ajusta este valor si esperas una cantidad diferente
        LOG.info("Fin de la prueba...");
    }

    @Test
    public void testCantidadLibrosPorCd() {
        LOG.info("Probando lista de cantidad libros en cds");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        Autor autor = new Autor("Stephen King", "Estadounidense");
        LibroCd libro1 = new LibroCd("El Resplandor","1977", autor,editorial,"32 MB");
        biblioteca.agregarLibro(libro1);
        int cantidad = biblioteca.CantidadLibrosPorCd(autor);
        assertEquals(1, cantidad); // Ajusta este valor si esperas una cantidad diferente
        LOG.info("Fin de la prueba...");
    }

    @Test
    public void testCantidadLibrosImpresos() {
        LOG.info("Probando lista de cantidad libros impresos");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        Autor autor = new Autor("Stephen King", "Estadounidense");
        LibroImpreso libro1 = new LibroImpreso("El Resplandor","1977", autor,editorial,32);
        biblioteca.agregarLibro(libro1);
        int cantidad = biblioteca.CantidadLibrosImpresos(autor);
        assertEquals(1, cantidad); // Ajusta este valor si esperas una cantidad diferente
        LOG.info("Fin de la prueba...");
    }

    @Test
    public void testCantidadLibrosAutor() {
        LOG.info("Probando lista de cantidad libros por autor");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Autor autor = new Autor("Stephen King", "Estadounidense");
        ArrayList<Integer> cantidades = biblioteca.cantidadLibrosAutor(autor);
        // Ajusta estos valores si esperas cantidades diferentes
        assertEquals(0, cantidades.get(0).intValue()); // Cantidad de libros impresos
        assertEquals(0, cantidades.get(1).intValue()); // Cantidad de libros en CD
        assertEquals(0, cantidades.get(2).intValue()); // Cantidad de libros digitales
        LOG.info("Fin de la prueba...");
    }

    @Test
    public void testAgregarLibroExitoso() {
        LOG.info("Probando agregar libros sin repetir");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunitaria", "Calle 3 Carrera 7", "2007");
        Editorial editorial = new Editorial("MUNDOLIBRO","323341");
        Autor autor = new Autor("Stephen King", "Estadounidense");
        LibroImpreso libro1 = new LibroImpreso("El Resplandor","1977", autor,editorial,32);
        boolean resultado = biblioteca.agregarLibro(libro1);
        assertTrue(resultado);
        LOG.info("Fin de la prueba...");
    }

  
}