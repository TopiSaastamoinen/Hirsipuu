import java.util.ArrayList;
import java.util.Scanner;

public class Aloita {
    private Arvonta arvonta;
    private Tarkista tarkista;
    private Scanner lukija;
    private String arvottuSana;


    public Aloita(Scanner lukija) {
        this.arvonta = new Arvonta();
        this.tarkista = new Tarkista();
        this.lukija = lukija;


    }

    public void aloita(ArrayList<String> sanalista) {
        
        arvottuSana = arvonta.arvoSana(sanalista); //sana on valittu arvalla
        tarkista.tulostaSana(arvottuSana);
        testi();
    }

    public void testi() {

        while (true) {
            System.out.print("Anna kirjain: ");
            String kirjain = lukija.nextLine().toUpperCase();
            if (!(!kirjain.matches(".*[^A-Z].*")) || kirjain.equals("")) {
                continue;
            }

            if (this.tarkista.tarkistaSana(arvottuSana, kirjain) == true) {
                this.tarkista.tulostaSana(arvottuSana);

            } else {
                if (tarkista.getVirheet() == 1) {
                    System.out.println("       ");
                    System.out.println("  -    ");
                    System.out.println("    -  ");
                    System.out.println(" -     ");
                    System.out.println("   -   ");
                    System.out.println("______ ");
                } else if (tarkista.getVirheet() == 2) {
                    System.out.println("       ");
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
                    System.out.println("  |  L|");
                    System.out.println("  |   |");
                    System.out.println("  O   |");
                    System.out.println("      |");
                    System.out.println("_A____|");
                } else if (tarkista.getVirheet() >= 6) {
                    System.out.println("______ ");
                    System.out.println("  |  L|");
                    System.out.println(" _O_  |");
                    System.out.println(" |||  |");
                    System.out.println("  H   |");
                    System.out.println("_A____|");

                    tarkista.nollaa();

                    break;
                }

                System.out.println("");
                this.tarkista.tulostaSana(arvottuSana);

            }

            if (this.tarkista.onkoKaikki() == true) {
                taysiSana();
                break;
            }
            this.tarkista.tulostaVaarat();
            System.out.println("");
        }

    }

    public void taysiSana() {

        if (tarkista.getVirheet() == 0) {
            System.out.println("     ");
            System.out.println("    P");
            System.out.println("__O/ ");
            System.out.println(" _|_/");
            System.out.println("/    ");
            System.out.println("     ");
        } else if (tarkista.getVirheet() == 1) {
            System.out.println("                 ");
            System.out.println("    P            ");
            System.out.println("__O/             ");
            System.out.println(" _|_/            ");
            System.out.println("/         ______ ");
            System.out.println("                 ");

        } else if (tarkista.getVirheet() == 2) {
            System.out.println("                 ");
            System.out.println("                |");
            System.out.println("    P           |");
            System.out.println("__O/            |");
            System.out.println(" _|_/           |");
            System.out.println("/         ______|");
            System.out.println("                 ");

        } else if (tarkista.getVirheet() == 3) {
            System.out.println("          ______ ");
            System.out.println("                |");
            System.out.println("    P           |");
            System.out.println("__O/            |");
            System.out.println(" _|_/           |");
            System.out.println("/         ______|");
            System.out.println("                 ");

        } else if (tarkista.getVirheet() == 4) {
            System.out.println("          ______ ");
            System.out.println("               L|");
            System.out.println("    P           |");
            System.out.println("__O/            |");
            System.out.println(" _|_/           |");
            System.out.println("/         ______|");
            System.out.println("                 ");

        } else if (tarkista.getVirheet() == 5) {
            System.out.println("          ______ ");
            System.out.println("            |  L|");
            System.out.println("    P       |   |");
            System.out.println("__O/        O   |");
            System.out.println(" _|_/           |");
            System.out.println("/         _A____|");
            System.out.println("                 ");

        }
        tarkista.nollaa();

    }
}
