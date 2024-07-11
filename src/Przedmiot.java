public class Przedmiot {
    private String nazwa;
    private int dodane_zdrowie;
    private int dodany_pancerz;
    private int dodany_atak;


    public Przedmiot(String nazwa, int dodane_zdrowie, int dodany_pancerz, int dodany_atak) {
        this.nazwa = nazwa;
        this.dodane_zdrowie = dodane_zdrowie;
        this.dodany_pancerz = dodany_pancerz;
        this.dodany_atak = dodany_atak;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getDodane_zdrowie() {
        return dodane_zdrowie;
    }

    public void setDodane_zdrowie(int dodane_zdrowie) {
        this.dodane_zdrowie = dodane_zdrowie;
    }

    public int getDodany_pancerz() {
        return dodany_pancerz;
    }

    public void setDodany_pancerz(int dodany_pancerz) {
        this.dodany_pancerz = dodany_pancerz;
    }

    public int getDodany_atak() {
        return dodany_atak;
    }

    public void setDodany_atak(int dodany_atak) {
        this.dodany_atak = dodany_atak;
    }
}
