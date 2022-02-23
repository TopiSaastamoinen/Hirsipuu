import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private ArrayList<String> sanalista;
    private Arvonta arvonta;
    private UusiSana UusiSana;


    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.sanalista = new ArrayList<>();
        this.arvonta = new Arvonta();
        this.UusiSana = new UusiSana();
    }

    public void kaynnista() {
        try (Scanner tiedostonlukija = new Scanner(Paths.get("sanat.txt"))) {
            while (tiedostonlukija.hasNextLine()) {
                String rivi = tiedostonlukija.nextLine();
                if (rivi.isEmpty()) {
                    break;
                }
                sanalista.add(rivi);
            }
        } catch (Exception e) {
            System.out.println("Virhe!" + e.getMessage()); 
        }

        while (true) {
            System.out.println("Syötä lisättävä sana ");
            String syote = lukija.nextLine();
            arvonta.arvoSana(sanalista);
            UusiSana.lisaa(syote);
        
        }
    }



}
