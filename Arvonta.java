import java.util.ArrayList;
import java.util.Random;

public class Arvonta {
    private ArrayList<String> sanalista;

    public Arvonta() {
        this.sanalista = new ArrayList<>();
    }

    public String arvoSana() {
        Random arpa = new Random();
        int indeksi = arpa.nextInt(sanalista.size());
        return sanalista.get(indeksi);
    }

}
