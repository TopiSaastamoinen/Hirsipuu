import java.util.Scanner;

public class UusiSana {
    private Scanner lukija;

    public UusiSana() {
        this.lukija = new Scanner(System.in);
    }

    public void lisaa() {
        System.out.println("Syötä lisättävä sana: ");
        String syote = lukija.nextLine().toUpperCase();

        // tarkista kaikki sanan kirjaimet, jos ääkkösiä => virhe
        if (!(! syote.matches(".*[^A-Z].*"))) {
            System.out.println("Sanassa ei voi olla ääkkösiä!");
        } else {
            // lisää syöte sanat.txt tiedostoon
            // käytä lisättyä sanaa heti?
        }
    }
}
