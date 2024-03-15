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
        // Implementa la logica per l'aggiunta di un elemento al catalogo
        // Puoi chiedere all'utente di inserire manualmente i dettagli del libro o generare dati casuali
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
        // Implementa la logica per la ricerca per anno di pubblicazione
    }

    private static void ricercaPerAutore(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci l'autore da cercare:");
        String autore = scanner.nextLine();
        // Implementa la logica per la ricerca per autore
    }

    private static void visualizzaLibri(CatalogoBibliotecario catalogo) {
        System.out.println("Elenco dei libri:");
        for (Libro libro : catalogo.getLibri()) {
            System.out.println(libro);
        }
    }

    private static void visualizzaRiviste(CatalogoBibliotecario catalogo) {
        System.out.println("Elenco delle riviste:");
        for (Rivista rivista : catalogo.getRiviste()) {
            System.out.println(rivista);
        }
    }

    private static void salvaSuDisco(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci il percorso del file su cui salvare l'archivio:");
        String filePath = scanner.nextLine();
        catalogo.saveCatalogo(filePath);
    }

    private static void caricaDaDisco(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci il percorso del file da cui caricare l'archivio:");
        String filePath = scanner.nextLine();
        catalogo.caricaCatalogo(filePath);
    }
}
