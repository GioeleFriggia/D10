import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogoBibliotecario implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Libro> libri;
    private List<Rivista> riviste;

    public CatalogoBibliotecario() {
        this.libri = new ArrayList<>();
        this.riviste = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    public void aggiungiRivista(Rivista rivista) {
        riviste.add(rivista);
    }

    public void rimuoviElemento(String isbn) {
        libri.removeIf(libro -> libro.getIsbn().equals(isbn));
        riviste.removeIf(rivista -> rivista.getIsbn().equals(isbn));
    }

    public Libro ricercaLibroPerISBN(String isbn) {
        return libri.stream()
                .filter(libro -> libro.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Libro> ricercaLibriPerAnnoPubblicazione(int anno) {
        return libri.stream()
                .filter(libro -> libro.getAnnoPubblicazione() == anno)
                .toList();
    }

    public List<Libro> ricercaLibriPerAutore(String autore) {
        return libri.stream()
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .toList();
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public List<Rivista> getRiviste() {
        return riviste;
    }

    public void saveCatalogo(String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(this);
            System.out.println("Catalogo salvato con successo su " + filePath);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del catalogo: " + e.getMessage());
        }
    }

    public void caricaCatalogo(String filePath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            CatalogoBibliotecario catalogo = (CatalogoBibliotecario) inputStream.readObject();
            this.libri = catalogo.getLibri();
            this.riviste = catalogo.getRiviste();
            System.out.println("Catalogo caricato con successo da " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante il caricamento del catalogo: " + e.getMessage());
        }
    }
}
