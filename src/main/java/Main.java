import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatalogoBibliotecario catalogo = new CatalogoBibliotecario();

        // Aggiungi 20 libri statici al catalogo
        String[] libriStatici = {
                "LIBRO;978-0-13-468599-1;Clean Code;2008;464;Robert C. Martin;Programming",
                "LIBRO;978-0-07-160630-1;Effective Java;2008;416;Joshua Bloch;Programming",
                "LIBRO;978-0-201-63361-0;Design Patterns;1994;395;Erich Gamma;Programming",
                "LIBRO;978-0-07-352332-3;Database Systems;2011;1304;Thomas Connolly;Database",
                "LIBRO;978-0-12-394424-4;Introduction to Algorithms;2009;1312;Thomas H. Cormen;Algorithms",
                "LIBRO;978-0-13-485248-6;Operating System Concepts;2018;976;Abraham Silberschatz;Operating Systems",
                "LIBRO;978-0-321-54705-5;Computer Networking;2012;960;James F. Kurose;Networking",
                "LIBRO;978-1-119-05655-9;Data Science for Business;2013;414;Foster Provost;Data Science",
                "LIBRO;978-0-596-52068-7;The Mythical Man-Month;1995;322;Frederick P. Brooks Jr.;Software Engineering",
                "LIBRO;978-0-321-74284-0;Clean Architecture;2017;432;Robert C. Martin;Programming",
                "LIBRO;978-0-13-297129-4;Introduction to the Theory of Computation;2012;478;Michael Sipser;Theory of Computation",
                "LIBRO;978-0-321-81127-7;Code Complete;1993;960;Steve McConnell;Programming",
                "LIBRO;978-0-13-409266-9;Computer Systems;2016;1119;Randal E. Bryant;Computer Architecture",
                "LIBRO;978-0-321-54835-9;Distributed Systems;2011;670;Andrew S. Tanenbaum;Distributed Computing",
                "LIBRO;978-0-13-468603-5;Clean Architecture in PHP;2020;407;Kristopher Wilson;Programming",
                "LIBRO;978-0-262-03384-8;The Art of Computer Programming;1997;316;Donald Knuth;Algorithms",
                "LIBRO;978-0-262-13316-0;Concrete Mathematics;1989;657;Ronald L. Graham;Mathematics",
                "LIBRO;978-0-262-68000-9;The C Programming Language;1978;288;Brian Kernighan;Programming",
                "LIBRO;978-0-321-48681-3;Introduction to Automata Theory, Languages, and Computation;2006;550;John E. Hopcroft;Theory of Computation"
        };

        for (String libroString : libriStatici) {
            String[] libroAttrs = libroString.split(";");
            Libro libro = new Libro(
                    libroAttrs[1], // ISBN
                    libroAttrs[2], // Titolo
                    Integer.parseInt(libroAttrs[3]), // Anno di pubblicazione
                    Integer.parseInt(libroAttrs[4]), // Numero di pagine
                    libroAttrs[5], // Autore
                    libroAttrs[6]  // Genere
            );
            catalogo.aggiungiLibro(libro);
        }


        String[] rivisteStatiche = {
             1
        };

        for (String rivistaString : rivisteStatiche) {
            String[] rivistaAttrs = rivistaString.split(";");
            if (rivistaAttrs.length == 6) {
                try {
                    Rivista.Periodicita periodicita = Rivista.Periodicita.valueOf(rivistaAttrs[5].toUpperCase());
                    Rivista rivista = new Rivista(
                                                rivistaAttrs[1], // ISBN
                                                rivistaAttrs[2], // Titolo
                                                Integer.parseInt(rivistaAttrs[3]), // Anno di pubblicazione
                                                Integer.parseInt(rivistaAttrs[4]), // Numero di pagine
                            periodicita, // Autore
                            "" // Periodicità
                                        );
                    catalogo.aggiungiRivista(rivista);
                } catch (IllegalArgumentException e) {
                    System.out.println("Periodicità non valida per la rivista: " + rivistaAttrs[2]);
                }
            } else {
                System.out.println("Dati non validi per la rivista: " + Arrays.toString(rivistaAttrs));
            }
        }

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
            System.out.println("8. Visualizza tutti i libri e le riviste");
            System.out.println("9. Salvataggio su disco dell'archivio");
            System.out.println("10. Caricamento dal disco dell'archivio");
            System.out.println("11. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere newline

            switch (scelta) {
                case 1:
                    aggiungiElemento(scanner, catalogo);
                    break;
                case 2:
                    rimuoviElemento(scanner, catalogo);
                    break;
                case 3:
                    ricercaPerISBN(scanner, catalogo);
                    break;
                case 4:
                    ricercaPerAnnoPubblicazione(scanner, catalogo);
                    break;
                case 5:
                    ricercaPerAutore(scanner, catalogo);
                    break;
                case 6:
                    visualizzaLibri(catalogo);
                    break;
                case 7:
                    visualizzaRiviste(catalogo);
                    break;
                case 8:
                    visualizzaTutti(catalogo);
                    break;
                case 9:
                    salvaSuDisco(scanner, catalogo);
                    break;
                case 10:
                    caricaDaDisco(scanner, catalogo);
                    break;
                case 11:
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
            aggiungiLibro(scanner, catalogo);
        } else if (scelta.equals("R")) {
            aggiungiRivista(scanner, catalogo);
        } else {
            System.out.println("Scelta non valida. Riprova.");
        }
    }

    private static void aggiungiLibro(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci i dettagli del libro separati da punto e virgola (ISBN;Titolo;Anno;Pagine;Autore;Genere):");
        String[] input = scanner.nextLine().split(";");
        if (input.length == 6) {
            Libro libro = new Libro(input[0], input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), input[4], input[5]);
            catalogo.aggiungiLibro(libro);
            System.out.println("Libro aggiunto: " + libro.getTitolo());
        } else {
            System.out.println("Input non valido. Assicurati di inserire tutti i dettagli separati da punto e virgola.");
        }
    }

    private static void aggiungiRivista(Scanner scanner, CatalogoBibliotecario catalogo) {
        System.out.println("Inserisci i dettagli della rivista separati da punto e virgola (ISBN;Titolo;Anno;Pagine;Periodicità):");
        String[] input = scanner.nextLine().split(";");
        if (input.length == 5) {
            try {
                Rivista.Periodicita periodicita = Rivista.Periodicita.valueOf(input[4].toUpperCase());
                Rivista rivista = new Rivista(input[0], input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), periodicita, "");
                catalogo.aggiungiRivista(rivista);
                System.out.println("Rivista aggiunta: " + rivista.getTitolo());
            } catch (IllegalArgumentException e) {
                System.out.println("Periodicità non valida. Assicurati di inserire un valore valido tra i seguenti: SETTIMANALE, MENSILE, TRIMESTRALE, ANNUALE.");
            }
        } else {
            System.out.println("Input non valido. Assicurati di inserire tutti i dettagli separati da punto e virgola.");
        }
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
                System.out.println("Titolo: " + libro.getTitolo());
                System.out.println("Autore: " + libro.getAutore());
                System.out.println("Anno di pubblicazione: " + libro.getAnnoPubblicazione());
                System.out.println("ISBN: " + libro.getIsbn());
                System.out.println("Numero di pagine: " + libro.getNumeroPagine());
                System.out.println("Genere: " + libro.getGenere());
                System.out.println("------------------------------------");
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
                System.out.println("Titolo: " + rivista.getTitolo());
                System.out.println("Anno di pubblicazione: " + rivista.getAnnoPubblicazione());
                System.out.println("ISBN: " + rivista.getIsbn());
                System.out.println("Numero di pagine: " + rivista.getNumeroPagine());
                System.out.println("Periodicità: " + rivista.getPeriodicita());
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println("Nessuna rivista nel catalogo.");
        }
    }

    private static void visualizzaTutti(CatalogoBibliotecario catalogo) {
        visualizzaLibri(catalogo);
        visualizzaRiviste(catalogo);
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
