import java.util.ArrayList;

public class Postać {
    private String nazwa;
    private int hp;
    private int pancerz;
    private int atak;
    public ArrayList<Przedmiot> getEkwipunek() {
        return ekwipunek;
    }

    public void setEkwipunek(ArrayList<Przedmiot> ekwipunek) {
        this.ekwipunek = ekwipunek;
    }

    private ArrayList<Przedmiot>ekwipunek=new ArrayList<>();

    public Postać(String nazwa, int hp, int pancerz, int atak,ArrayList<Przedmiot>ekwipunek) {
        this.nazwa = nazwa;
        this.hp = hp;
        this.pancerz = pancerz;
        this.atak = atak;
        this.ekwipunek=ekwipunek;
    }
    public void odnieś_obrażenia(int zadane_obrażenia){
        if(pancerz>0){
            pancerz-=zadane_obrażenia;
        }
        else {
            hp-=zadane_obrażenia;
        }
    }
    public void zadaj_obrażenia(Postać cel){
        cel.odnieś_obrażenia(atak);
    }

    public void dodajhp(Przedmiot eliskir ){
        if(ekwipunek.contains(eliskir)){
            System.out.println("Odnowiono zdrowie");
            this.hp+=eliskir.getDodane_zdrowie();
            if(this.hp>100){
                this.hp=100;
            }
            ekwipunek.remove(eliskir);
        }
        else{
            System.out.println("Brak eliksirów");
        }
    }
    public void dodajpancerz(Przedmiot pancerz ){
        if(ekwipunek.contains(pancerz)){
            System.out.println("Odnowiono pancerz");
            this.pancerz+=pancerz.getDodany_pancerz();
            if(this.pancerz>100){
                this.pancerz=100;
            }
            ekwipunek.remove(pancerz);
        }
        else{
            System.out.println("Brak kawałków pancerza");
        }
    }
    public void dodajatak(Przedmiot miecz ){
        if(ekwipunek.contains(miecz)){
            System.out.println("Zwiększono atak");
            this.atak+=miecz.getDodany_atak();
            if(this.atak>100){
                this.atak=100;
            }
            ekwipunek.remove(miecz);
        }
        else{
            System.out.println("Brak mieczy");
        }
    }
    public  void dodajprzedmiot(Przedmiot przedmiot){
        ekwipunek.add(przedmiot);
    }
    public void wypisz(){
        System.out.println("Zdrowie "+this.hp);
        System.out.println("Pancerz "+this.pancerz);
        System.out.println("Atak "+this.atak);
        for(Przedmiot i:ekwipunek){
            System.out.print(i.getNazwa());
        }
        System.out.println("");
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPancerz() {
        return pancerz;
    }

    public void setPancerz(int pancerz) {
        this.pancerz = pancerz;
    }

    public int getAtak() {
        return atak;
    }

    public void setAtak(int atak) {
        this.atak = atak;
    }


}
