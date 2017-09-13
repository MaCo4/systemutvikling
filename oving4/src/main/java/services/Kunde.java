package services;

/**
 * Created by Magnus on 12.09.2017.
 *
 * @author Magnus Conrad Hyll (magnus@hyll.no)
 */
public class Kunde {
    private String id;
    private String navn;

    public Kunde() {

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
