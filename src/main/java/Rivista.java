import java.io.Serializable;

public class Rivista implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }

    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private Periodicita periodicita;
    private String autore; // Aggiungo l'attributo autore

    public Rivista() {
    }

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita, String autore) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.periodicita = periodicita;
        this.autore = autore; // Inizializzo l'attributo autore
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    // Aggiungo il metodo getAutore()
    public String getAutore() {
        return autore;
    }

    // Aggiungo il metodo setAutore()
    public void setAutore(String autore) {
        this.autore = autore;
    }
}
