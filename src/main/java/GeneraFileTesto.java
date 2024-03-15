import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import com.github.javafaker.Faker;

public class GeneraFileTesto {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));

        // Modifica il nome del file di output se necessario
        String nomeFile = "nuovo_catalogo.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
            for (int i = 0; i < 20; i++) {
                // Genera dati casuali per i libri
                String isbn = generaISBN();
                String titolo = faker.book().title();
                int annoPubblicazione = faker.number().numberBetween(1950, 2023);
                int numeroPagine = faker.number().numberBetween(50, 1000);
                String autore = faker.book().author();
                String genere = faker.book().genre();

                writer.write("LIBRO;" + isbn + ";" + titolo + ";" + annoPubblicazione + ";" + numeroPagine + ";" + autore + ";" + genere);
                writer.newLine();
            }

            for (int i = 0; i < 20; i++) {
                // Genera dati casuali per le riviste
                String isbn = generaISBN();
                String titolo = faker.book().title();
                int annoPubblicazione = faker.number().numberBetween(1950, 2023);
                int numeroPagine = faker.number().numberBetween(50, 100);
                String periodicita = faker.options().option("SETTIMANALE", "MENSILE", "SEMESTRALE");

                writer.write("RIVISTA;" + isbn + ";" + titolo + ";" + annoPubblicazione + ";" + numeroPagine + ";" + periodicita);
                writer.newLine();
            }

            System.out.println("File di testo generato correttamente.");
        } catch (IOException e) {
            System.err.println("Errore durante la generazione del file di testo: " + e.getMessage());
        }
    }

    private static String generaISBN() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }
}
