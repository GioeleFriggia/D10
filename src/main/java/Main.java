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
                "LIBRO;978-0-321-48681-3;Introduction to Automata Theory, Languages, and Computation;2006;550;John E. Hopcroft;Theory of Computation",
                "LIBRO;978-0-13-705040-8;Clean Agile: Back to Basics;2019;256;Robert C. Martin;Programming",
                "LIBRO;978-0-13-409266-6;Refactoring: Improving the Design of Existing Code;2018;448;Martin Fowler;Programming",
                "LIBRO;978-1-4919-2640-9;Java Concurrency in Practice;2006;432;Brian Goetz;Programming",
                "LIBRO;978-1-4919-2106-0;Test Driven Development: By Example;2002;240;Kent Beck;Programming",
                "LIBRO;978-0-321-95868-6;Effective Modern C++: 42 Specific Ways to Improve Your Use of C++11 and C++14;2014;352;Scott Meyers;Programming",
                "LIBRO;978-0-596-00733-4;The Pragmatic Programmer: Your Journey to Mastery;1999;352;Andrew Hunt, David Thomas;Programming",
                "LIBRO;978-0-13-485248-5;Operating Systems: Three Easy Pieces;2014;675;Remzi H. Arpaci-Dusseau, Andrea C. Arpaci-Dusseau;Operating Systems",
                "LIBRO;978-0-07-351720-9;Database Management Systems;2019;784;Raghu Ramakrishnan, Johannes Gehrke;Database",
                "LIBRO;978-0-13-276253-4;Algorithms;2011;976;Robert Sedgewick, Kevin Wayne;Algorithms",
                "LIBRO;978-0-12-805055-9;Foundations of Machine Learning;2019;444;Mehryar Mohri, Afshin Rostamizadeh, Ameet Talwalkar;Machine Learning"


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
                "RIVISTA;0360-0300;Communications of the ACM;2022;100;MENSILE",
                "RIVISTA;0734-3227;IEEE Spectrum;2022;100;MENSILE",
                "RIVISTA;0888-8507;Scientific American;2022;100;MENSILE",
                "RIVISTA;0036-8075;Science;2022;100;SETTIMANALE",
                "RIVISTA;1095-9203;Trends in Cognitive Sciences;2022;100;MENSILE",
                "RIVISTA;1063-4266;Psychology and Aging;2022;100;MENSILE",
                "RIVISTA;1467-9280;Human Brain Mapping;2022;100;MENSILE",
                "RIVISTA;0270-7306;IEEE Transactions on Pattern Analysis and Machine Intelligence;2022;100;MENSILE",
                "RIVISTA;0003-066X;American Psychologist;2022;100;MENSILE",
                "RIVISTA;0735-7036;Psychology of Addictive Behaviors;2022;100;MENSILE",
                "RIVISTA;0036-8075;Science;2019;100;SETTIMANALE",
                "RIVISTA;0002-9602;American Journal of Sociology;2018;100;MENSILE",
                "RIVISTA;0022-3514;Journal of Personality and Social Psychology;2017;100;MENSILE",
                "RIVISTA;0003-066X;American Psychologist;2016;100;MENSILE",
                "RIVISTA;0046-8177;Journal of Educational Psychology;2015;100;MENSILE",
                "RIVISTA;0018-716X;Human Communication Research;2014;100;MENSILE",
                "RIVISTA;1059-1028;Psychology of Women Quarterly;2013;100;MENSILE",
                "RIVISTA;0003-0064;Behavior Therapy;2012;100;MENSILE",
                "RIVISTA;1040-7308;Professional Psychology: Research and Practice;2011;100;MENSILE",
                "RIVISTA;0009-3920;Cultural Diversity and Ethnic Minority Psychology;2010;100;MENSILE",
                "RIVISTA;0360-0025;American Psychologist;2009;100;MENSILE",
                "RIVISTA;1063-4266;Psychology and Aging;2008;100;MENSILE",
                "RIVISTA;1094-3412;Journal of the Society for Social Work and Research;2007;100;MENSILE",
                "RIVISTA;0022-2437;Journal of Comparative Psychology;2006;100;MENSILE",
                "RIVISTA;0735-7036;Psychology of Addictive Behaviors;2005;100;MENSILE",
                "RIVISTA;0893-164X;Psychology of Men & Masculinities;2004;100;MENSILE",
                "RIVISTA;1063-5157;Psychology of Women Quarterly;2003;100;MENSILE",
                "RIVISTA;1050-3293;Health Psychology;2002;100;MENSILE",
                "RIVISTA;1064-1297;Psychological Assessment;2001;100;MENSILE"
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
                            periodicita, // Periodicità
                            "" // Autore
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
            scanner.nextLine(); 

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
