import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CatalogoBibliotecario catalogo = new CatalogoBibliotecario();

        // Aggiunta di un elemento
        Libro libro1 = new Libro("978-0-13-468599-1", "Clean Code", 2008, 464, "Robert C. Martin", "Programming");
        catalogo.aggiungiLibro(libro1);
        System.out.println("Libro aggiunto: " + libro1.getTitolo());

        // Rimozione di un elemento dato un codice ISBN
        catalogo.rimuoviElemento("978-0-13-468599-1");

        // Ricerca per ISBN
        Libro libroTrovato = catalogo.ricercaLibroPerISBN("978-0-13-468599-1");
        if (libroTrovato != null) {
            System.out.println("Libro trovato: " + libroTrovato.getTitolo());
        } else {
            System.out.println("Nessun libro trovato con l'ISBN specificato.");
        }

        // Ricerca per anno di pubblicazione
        List<Libro> libriAnno2008 = catalogo.ricercaLibriPerAnnoPubblicazione(2008);
        System.out.println("Libri pubblicati nel 2008:");
        for (Libro libro : libriAnno2008) {
            System.out.println(libro.getTitolo());
        }

        // Ricerca per autore
        List<Libro> libriDiRobertMartin = catalogo.ricercaLibriPerAutore("Robert C. Martin");
        System.out.println("Libri scritti da Robert C. Martin:");
        for (Libro libro : libriDiRobertMartin) {
            System.out.println(libro.getTitolo());
        }

        // Salvataggio su disco
        catalogo.saveCatalogo("catalogo.txt");
        System.out.println("Catalogo salvato su disco.");

        // Caricamento dal disco
        CatalogoBibliotecario nuovoCatalogo = new CatalogoBibliotecario();
        nuovoCatalogo.caricaCatalogo("catalogo.txt");
        System.out.println("Catalogo caricato da disco.");

        // Verifica del caricamento
        System.out.println("Numero di libri nel nuovo catalogo: " + nuovoCatalogo.getLibri().size());
    }
}
