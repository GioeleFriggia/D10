public class Main {
    public static void main(String[] args) {
        CatalogoBibliotecario catalogo = new CatalogoBibliotecario();

        // Esempio di utilizzo
        Libro libro1 = new Libro("978-0-13-468599-1", "Clean Code", 2008, 464, "Robert C. Martin", "Programming");
        catalogo.aggiungiLibro(libro1);

        // Salvataggio su disco
        catalogo.salvaCatalogo("catalogo.txt");

        // Caricamento dal disco
        catalogo.caricaCatalogo("catalogo.txt");
    }
}
