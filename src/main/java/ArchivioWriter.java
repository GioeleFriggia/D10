import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivioWriter {

    public static void salvaSuFile(String percorsoFile, List<String> contenuto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(percorsoFile))) {
            for (String riga : contenuto) {
                writer.write(riga);
                writer.newLine();
            }
            System.out.println("Dati salvati correttamente nel file: " + percorsoFile);
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante il salvataggio dei dati: " + e.getMessage());
        }
    }
}

