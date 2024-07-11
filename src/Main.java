import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
       System.out.println("Wybierz poziom trudności. 1 to łatwy 2 to średni 3 to trudny");
        int poziom_trudnosci=scanner.nextInt();
        Przedmiot eliksir_zdrowia=new Przedmiot("eliksir zdrowia",50,0,0);
        Przedmiot pancerz=new Przedmiot("pancerz",0,50,0);
        Przedmiot miecz=new Przedmiot("miecz",0,0,20);
        ArrayList<Przedmiot>eq=new ArrayList<>();

        int piętra=0;
        boolean gra=true;
        if(poziom_trudnosci==1){
            Postać bohater=new Postać("Bohater",100,50,10,eq);
        }
        if(poziom_trudnosci==2){
            Postać bohater=new Postać("Bohater",100,0,10,eq);
        }
        if(poziom_trudnosci==3){
            Postać bohater=new Postać("Bohater",50,0,10,eq);
        }
        System.out.println(("Jesteś poszukiwaczem przygód okrywającym starożytne lochy. Lochy są podzielona na piętra.");
        System.out.println("Aby wybrać akcję trzeba podac jej numer");
        while (gra){
            System.out.println("Piętro"+piętra);
            int pokój=random.nextInt(1,4);
            if(pokój==1){
                boolean pokonany_pokój=false;
                while(!pokonany_pokój) {
                    System.out.println("Przed tobą widnieje dziura");
                    System.out.println("1 Przeskocz nad dziurą. 50% szany powodzenia. 2 wypisz statystyki");
                    int akcja=scanner.nextInt();
                    if(akcja==2){
                        bohater.wypisz();
                    }
                    if(akcja==1){

                    }
                }
            }
        }
    }
}