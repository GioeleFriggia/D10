import com.github.javafaker.Faker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatalogoBibliotecario {
    private List<Libro> libri;
    private List<Rivista> riviste;
    private final Faker faker;

    public CatalogoBibliotecario() {
        libri = new ArrayList<>();
        riviste = new ArrayList<>();
        faker = new Faker(new Locale("it"));
    }

    // Metodi per aggiungere, rimuovere e cercare libri e riviste
    // ...

    public void salvaCatalogo(String filePath) {
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
        }
    }

    public void caricaCatalogo(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 6) {
                    if (parts[0].equals("LIBRO")) {
                        Libro libro = new Libro();
                        libro.setIsbn(parts[1]);
                        libro.setTitolo(parts[2]);
                        libro.setAnnoPubblicazione(Integer.parseInt(parts[3]));
                        libro.setNumeroPagine(Integer.parseInt(parts[4]));
                        libro.setAutore(parts[5]);
                        libro.setGenere(parts[6]);
                        libri.add(libro);
                    } else if (parts[0].equals("RIVISTA")) {
                        Rivista rivista = new Rivista();
                        rivista.setIsbn(parts[1]);
                        rivista.setTitolo(parts[2]);
                        rivista.setAnnoPubblicazione(Integer.parseInt(parts[3]));
                        rivista.setNumeroPagine(Integer.parseInt(parts[4]));
                        rivista.setPeriodicita(Rivista.Periodicita.valueOf(parts[5]));
                        riviste.add(rivista);
                    }
                }
            }
            System.out.println("Catalogo caricato correttamente.");
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento del catalogo: " + e.getMessage());
        }
    }

    public void aggiungiLibro(Libro libro1) {
    }
}
