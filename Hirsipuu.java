import java.util.Scanner;

public class Hirsipuu {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.kaynnista();
    }
}