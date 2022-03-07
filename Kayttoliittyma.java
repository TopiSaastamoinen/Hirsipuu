import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private ArrayList<String> sanalista;
    private Arvonta arvonta;
    private UusiSana UusiSana;
    private Tarkista tarkista;
    private String arvottuSana;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.sanalista = new ArrayList<>();
        this.arvonta = new Arvonta();
        this.UusiSana = new UusiSana();
        this.tarkista = new Tarkista();

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

            System.out.print("Aloita peli kirjoittamalla 'Aloita'\n" // aloita peli, lisää sanoja yms
                    + "Lisää uusi sana listalle kirjoittamalla 'lisaa'\n"
                    + "Lopeta painamalla L\n"
                    + ">");
            String syote = lukija.nextLine();

            if (syote.equalsIgnoreCase("l")) {
                break;
            } else if (syote.equalsIgnoreCase("lisaa")) {
                this.UusiSana.lisaa();
            } else if (syote.equalsIgnoreCase("aloita")) {
                arvottuSana = arvonta.arvoSana(sanalista); // sana on valittu arvalla
                testi();
            }

        }
    }

    public void testi() {

        while (true) {
            System.out.print("Anna kirjain: ");
            String kirjain = lukija.nextLine().toUpperCase();

            if (this.tarkista.tarkistaSana(arvottuSana, kirjain) == true) {
                System.out.println(arvottuSana);
            } else {
                if (tarkista.getVirheet() == 1) {
                    System.out.println("       ");
                    System.out.println("       ");
                    System.out.println("       ");
                    System.out.println("       ");
                    System.out.println("       ");
                    System.out.println("_______");
                } else if (tarkista.getVirheet() == 2) {
                    System.out.println("      |");
                    System.out.println("      |");
                    System.out.println("      |");
                    System.out.println("      |");
                    System.out.println("______|");
                } else if (tarkista.getVirheet() == 3) {
                    System.out.println("______ ");
                    System.out.println("      |");
                    System.out.println("      |");
                    System.out.println("      |");
                    System.out.println("      |");
                    System.out.println("______|");
                } else if (tarkista.getVirheet() == 4) {
                    System.out.println("______ ");
                    System.out.println("     L|");
                    System.out.println("      |");
                    System.out.println("      |");
                    System.out.println("      |");
                    System.out.println("______|");
                } else if (tarkista.getVirheet() == 5) {
                    System.out.println("______ ");
                    System.out.println(" |   L|");
                    System.out.println(" |    |");
                    System.out.println(" O    |");
                    System.out.println("      |");
                    System.out.println("__A___|");
                } else if (tarkista.getVirheet() >= 6) {
                    System.out.println("______ ");
                    System.out.println(" |   L|");
                    System.out.println("_O_   |");
                    System.out.println("|||   |");
                    System.out.println(" H    |");
                    System.out.println("__A___|");

                    tarkista.nollaa();

                    break;
                }
            }

        }

    }
}
