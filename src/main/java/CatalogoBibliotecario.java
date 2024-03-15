import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogoBibliotecario {
    private List<Libro> libri;
    private List<Rivista> riviste;

    public CatalogoBibliotecario() {
        libri = new ArrayList<>();
        riviste = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    public void aggiungiRivista(Rivista rivista) {
        riviste.add(rivista);
    }

    public void rimuoviElemento(String isbn) {
        List<Libro> copiaLibri = new ArrayList<>(libri);
        List<Rivista> copiaRiviste = new ArrayList<>(riviste);

        copiaLibri.removeIf(libro -> libro.getIsbn().equals(isbn));
        copiaRiviste.removeIf(rivista -> rivista.getIsbn().equals(isbn));

        libri = copiaLibri;
        riviste = copiaRiviste;

        System.out.println("Elemento con ISBN " + isbn + " rimosso dal catalogo.");
    }

    public Libro ricercaLibroPerISBN(String isbn) {
        return libri.stream()
                .filter(libro -> libro.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public Rivista ricercaRivistaPerISBN(String isbn) {
        return riviste.stream()
                .filter(rivista -> rivista.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Libro> ricercaLibriPerAnnoPubblicazione(int anno) {
        return libri.stream()
                .filter(libro -> libro.getAnnoPubblicazione() == anno)
                .toList();
    }

    public List<Rivista> ricercaRivistePerAnnoPubblicazione(int anno) {
        return riviste.stream()
                .filter(rivista -> rivista.getAnnoPubblicazione() == anno)
                .toList();
    }

    public List<Libro> ricercaLibriPerAutore(String autore) {
        return libri.stream()
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .toList();
    }

    public List<Rivista> ricercaRivistePerAutore(String autore) {
        return riviste.stream()
                .filter(rivista -> rivista.getAutore().equalsIgnoreCase(autore))
                .toList();
    }

    public void saveCatalogo(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Libro libro : libri) {
                writer.write("LIBRO;" + libro.getIsbn() + ";" + libro.getTitolo() + ";" + libro.getAnnoPubblicazione() + ";" + libro.getNumeroPagine() + ";" + libro.getAutore() + ";" + libro.getGenere());
                writer.newLine();
            }
            for (Rivista rivista : riviste) {
                writer.write("RIVISTA;" + rivista.getIsbn() + ";" + rivista.getTitolo() + ";" + rivista.getAnnoPubblicazione() + ";" + rivista.getNumeroPagine() + ";" + rivista.getPeriodicita());
                writer.newLine();
            }
            System.out.println("Catalogo salvato correttamente.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del catalogo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void caricaCatalogo(String filePath) {
        libri.clear();
        riviste.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 6) {
                    if (parts[0].equalsIgnoreCase("libro")) {
                        Libro libro = new Libro();
                        libro.setIsbn(parts[1]);
                        libro.setTitolo(parts[2]);
                        libro.setAnnoPubblicazione(Integer.parseInt(parts[3]));
                        libro.setNumeroPagine(Integer.parseInt(parts[4]));
                        libro.setAutore(parts[5]);
                        libro.setGenere(parts.length > 6 ? parts[6] : "");
                        libri.add(libro);
                    } else if (parts[0].equalsIgnoreCase("rivista")) {
                        Rivista rivista = new Rivista();
                        rivista.setIsbn(parts[1]);
                        rivista.setTitolo(parts[2]);
                        rivista.setAnnoPubblicazione(Integer.parseInt(parts[3]));
                        rivista.setNumeroPagine(Integer.parseInt(parts[4]));
                        try {
                            rivista.setPeriodicita(Rivista.Periodicita.valueOf(parts[5].toUpperCase()));
                        } catch (IllegalArgumentException e) {
                            System.err.println("Errore durante il caricamento del catalogo: valore della periodicità non valido ('SETTIMANALE', 'MENSILE', 'SEMESTRALE'): " + parts[5]);
                        }
                        riviste.add(rivista);
                    }
                }
            }
            System.out.println("Catalogo caricato correttamente.");
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento del catalogo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public List<Rivista> getRiviste() {
        return riviste;
    }
}
