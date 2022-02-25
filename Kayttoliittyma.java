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
                        
            System.out.print("Aloita peli kirjoittamalla 'Aloita'\n" //aloita peli, lisää sanoja yms
                            +   "Lisää uusi sana listalle kirjoittamalla 'lisaa'\n"
                            +   "Lopeta painamalla L\n"
                            +   ">");
            String syote = lukija.nextLine();

            if (syote.equalsIgnoreCase("l")) {
                break;
            } else if (syote.equalsIgnoreCase("lisaa")) {
                this.UusiSana.lisaa();
            } else if (syote.equalsIgnoreCase("aloita")) {
                String arvottuSana = arvonta.arvoSana(sanalista); //sana on valittu arvalla
            }
                   
        }
    }
}


