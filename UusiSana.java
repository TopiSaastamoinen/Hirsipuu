import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UusiSana {
    private Scanner lukija;

    public UusiSana() {
        this.lukija = new Scanner(System.in);
    }

    public void lisaa() {
        System.out.println("Syötä lisättävä sana: ");
        String syote = lukija.nextLine().toUpperCase();

        // tarkista kaikki sanan kirjaimet, jos ääkkösiä tai numeroita yms. => virhe
        if (!(! syote.matches(".*[^A-Z].*"))) {
            System.out.println("Sanassa voi olla vain kirjaimia A-Z");

        } else {
            // lisää syöte sanat.txt tiedostoon
            // tästä puuttuu se tarkistus if-lauseke, joka tarkistaa sanan olemassaolon listalla.
            try(FileWriter fwriter = new FileWriter("sanat.txt", true);
                BufferedWriter bwriter = new BufferedWriter(fwriter);
                PrintWriter out = new PrintWriter(bwriter))
                {
                    out.print("\n" + syote);
                
            } catch (IOException e) {
                System.out.println("Virhe! " + e.getMessage());

            }

            // System.out.println("Käytä lisättyä sanaa heti?");
            // - lue sanat.txt tiedoston viimeinen rivi (tarpeeton koska sana on syote muuttujassa?) *
            // - käytä valittua sanaa seuraavassa pelissä
            //    * riippuen miten tämä suoritetaan. käyttöliittymässä vai tässä? aloitusta pitäisi muuttaa joustavammaksi

            // aloitus esim. 
            // jos käytä lisättyä sanaa == true => käytä syote muuttujaa/lue sanat.txt viimeinen rivi (mieluiten käyttäisin muuttujaa... mietittävää)
            // muuten => arvo random sana
        }
    }
}
