import com.github.javafaker.Faker;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatalogoBibliotecario catalogo = new CatalogoBibliotecario();

        boolean continua = true;
        while (continua) {
            System.out.println("Seleziona un'operazione:");
            System.out.println("1. Aggiungi un elemento");
            System.out.println("2. Rimuovi un elemento per ISBN");
            System.out.println("3. Ricerca per ISBN");
            System.out.println("4. Ricerca per anno di pubblicazione");
            System.out.println("5. Ricerca per autore");
            System.out.println("6. Visualizza libri");
            System.out.println("7. Visualizza riviste");
            System.out.println("8. Salvataggio su disco dell'archivio");
            System.out.println("9. Caricamento dal disco dell'archivio");
            System.out.println("10. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere newline

            switch (scelta) {
                case 1:
                    // Aggiungi un elemento
                    aggiungiElemento(scanner, catalogo);
                    break;
                case 2:
                    // Rimuovi un elemento per ISBN
                    rimuoviElemento(scanner, catalogo);
                    break;
                case 3:
                    // Ricerca per ISBN
                    ricercaPerISBN(scanner, catalogo);
                    break;
                case 4:
                    // Ricerca per anno di pubblicazione
                    ricercaPerAnnoPubblicazione(scanner, catalogo);
                    break;
                case 5:
                    // Ricerca per autore
                    ricercaPerAutore(scanner, catalogo);
                    break;
                case 6:
                    // Visualizza libri
                    visualizzaLibri(catalogo);
                    break;
                case 7:
                    // Visualizza riviste
                    visualizzaRiviste(catalogo);
                    break;
                case 8:
                    // Salvataggio su disco dell'archivio
                    salvaSuDisco(scanner, catalogo);
                    break;
                case 9:
                    // Caricamento dal disco dell'archivio
                    caricaDaDisco(scanner, catalogo);
                    break;
                case 10:
                    // Esci dal programma
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }

    private static void aggiungiElemento(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Vuoi aggiungere un libro (L) o una rivista (R)?");
        String scelta = scanner.nextLine().toUpperCase();
        if (scelta.equals("L")) {
            // Aggiungi un libro generato casualmente
            Faker faker = new Faker();
            Libro libro = new Libro(
                    generaISBN(), // Genera un ISBN casuale
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2023),
                    faker.number().numberBetween(50, 1000),
                    faker.book().author(),
                    faker.book().genre()
            );
            catalogo.aggiungiLibro(libro);
            System.out.println("Libro aggiunto: " + libro.getTitolo());
        } else if (scelta.equals("R")) {
            // Aggiungi una rivista generata casualmente (aggiungi logica per la generazione di riviste se necessario)
            System.out.println("Funzionalità non ancora implementata per le riviste.");
        } else {
            System.out.println("Scelta non valida. Riprova.");
        }
    }

    private static String generaISBN() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    private static void rimuoviElemento(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci l'ISBN dell'elemento da rimuovere:");
        String isbn = scanner.nextLine();
        catalogo.rimuoviElemento(isbn);
    }

    private static void ricercaPerISBN(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci l'ISBN da cercare:");
        String isbn = scanner.nextLine();
        Libro libro = catalogo.ricercaLibroPerISBN(isbn);
        if (libro != null) {
            System.out.println("Libro trovato: " + libro.getTitolo());
        } else {
            System.out.println("Nessun libro trovato con l'ISBN specificato.");
        }
    }

    private static void ricercaPerAnnoPubblicazione(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci l'anno di pubblicazione da cercare:");
        int anno = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere newline
        List<Libro> libri = catalogo.ricercaLibriPerAnnoPubblicazione(anno);
        if (!libri.isEmpty()) {
            System.out.println("Libri pubblicati nel " + anno + ":");
            for (Libro libro : libri) {
                System.out.println(libro.getTitolo());
            }
        } else {
            System.out.println("Nessun libro trovato per l'anno specificato.");
        }
    }

    private static void ricercaPerAutore(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci il nome dell'autore da cercare:");
        String autore = scanner.nextLine();
        List<Libro> libri = catalogo.ricercaLibriPerAutore(autore);
        if (!libri.isEmpty()) {
            System.out.println("Libri scritti da " + autore + ":");
            for (Libro libro : libri) {
                System.out.println(libro.getTitolo());
            }
        } else {
            System.out.println("Nessun libro trovato per l'autore specificato.");
        }
    }

    private static void visualizzaLibri(CatalogoBibliotecario catalogo) {
        List<Libro> libri = catalogo.getLibri();
        if (!libri.isEmpty()) {
            System.out.println("Elenco dei libri nel catalogo:");
            for (Libro libro : libri) {
                System.out.println(libro.getTitolo());
            }
        } else {
            System.out.println("Nessun libro nel catalogo.");
        }
    }

    private static void visualizzaRiviste(CatalogoBibliotecario catalogo) {
        List<Rivista> riviste = catalogo.getRiviste();
        if (!riviste.isEmpty()) {
            System.out.println("Elenco delle riviste nel catalogo:");
            for (Rivista rivista : riviste) {
                System.out.println(rivista.getTitolo());
            }
        } else {
            System.out.println("Nessuna rivista nel catalogo.");
        }
    }

    private static void salvaSuDisco(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci il percorso del file di salvataggio:");
        String filePath = scanner.nextLine();
        catalogo.saveCatalogo(filePath);
    }

    private static void caricaDaDisco(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci il percorso del file da caricare:");
        String filePath = scanner.nextLine();
        catalogo.caricaCatalogo(filePath);
    }
}
