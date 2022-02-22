import java.util.ArrayList;
import java.util.Random;

public class Arvonta {

    // public Arvonta(String sanalista) {
    // this.sanalista = sanalista;
    // }

    public String arvoSana(ArrayList<String> sanalista) {
        Random arpa = new Random();
        int indeksi = arpa.nextInt(sanalista.size());
        return sanalista.get(indeksi);
    }

}
