import java.io.FileWriter;
import java.io.IOException;

public class Journal {
    private static final String JOURNAL_FILE = "journal.log";

    public void log(String message) {
        try (FileWriter writer = new FileWriter(JOURNAL_FILE, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao registrar no journal: " + e.getMessage());
        }
    }
}
