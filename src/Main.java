import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Wybierz poziom trudności. 1 to łatwy 2 to średni 3 to trudny");
        int poziom_trudnosci = scanner.nextInt();
        Przedmiot eliksir_zdrowia = new Przedmiot("eliksir zdrowia", 50, 0, 0);
        Przedmiot  pancerz = new Przedmiot("kawałek_pancerza", 0, 50, 0);
        Przedmiot miecz = new Przedmiot("miecz", 0, 0, 20);
        ArrayList<Przedmiot> eq = new ArrayList<>();
        ArrayList<Przedmiot> eq0 = new ArrayList<>();
        Postać bohater = new Postać("Bohater", 6, 6, 6, eq);

        int piętra = 0;
        boolean gra = true;
        if (poziom_trudnosci == 1) {
            bohater.setHp(100);
            bohater.setPancerz(50);
            bohater.setAtak(10);
            bohater.setEkwipunek(eq);
        }
        if (poziom_trudnosci == 2) {
            bohater.setHp(100);
            bohater.setPancerz(0);
            bohater.setAtak(10);
            bohater.setEkwipunek(eq);
        }
        if (poziom_trudnosci == 3) {
            bohater.setHp(50);
            bohater.setPancerz(0);
            bohater.setAtak(10);
            bohater.setEkwipunek(eq);
        }
        System.out.println("Jesteś poszukiwaczem przygód okrywającym starożytne lochy. Lochy są podzielona na piętra.");
        System.out.println("Aby wybrać akcję trzeba podac jej numer");
        while (gra) {
            System.out.println("Piętro " + piętra);
            int pokój = random.nextInt(1, 5);
            if (pokój == 1) {
                boolean pokonany_pokój = false;
                while (!pokonany_pokój) {
                    System.out.println("Przed tobą widnieje dziura");
                    System.out.println("1 Przeskocz nad dziurą. 50% szany powodzenia. 2 wypisz statystyki. 3 użyj eliskiru. 4 dodaj pancerz. 5 użyj miecza");
                    int akcja = scanner.nextInt();
                    if (akcja == 2) {
                        bohater.wypisz();
                    }
                    if (akcja == 3) {
                        bohater.dodajhp(eliksir_zdrowia);
                    }
                    if (akcja == 4) {
                        bohater.dodajpancerz(pancerz);
                    }
                    if (akcja == 5) {
                        bohater.dodajatak(miecz);
                    }
                    if (akcja == 1) {
                        int chance = random.nextInt(1, 3);
                        if (chance == 1) {
                            System.out.println("Spadles do dziury 30dmg");
                             bohater.odnieś_obrażenia(30);
                        } else System.out.println("Przeskoczyłeś dziurę");
                        pokonany_pokój = true;

                    }
                }
            }
            if (pokój == 2) {
                boolean pokonany_pokój = false;
                while (!pokonany_pokój) {
                    Postać wróg = new Postać("Bandyta", 100, 0, 10, eq0);
                    System.out.println("Przed tobą widnieje wrogi bandyta");
                    System.out.println("1 Zaatakuj wroga. 2 wypisz statystyki. 3 użyj eliskiru. 4  dodaj pancerz. 5 użyj miecza");
                    int akcja = scanner.nextInt();
                    if (akcja == 2) {
                        bohater.wypisz();
                    }
                    if (akcja == 3) {
                        bohater.dodajhp(eliksir_zdrowia);
                    }
                    if (akcja == 4) {
                        bohater.dodajpancerz(pancerz);
                    }
                    if (akcja == 5) {
                        bohater.dodajatak(miecz);
                    }
                    if (akcja == 1) {
                        boolean walka = true;
                        while (walka) {
                            int pierwszeństwo = random.nextInt(1, 3);
                            if (wróg.getHp() <= 0) {
                                System.out.println("Pokonałeś wroga");
                                walka = false;
                            } else if (bohater.getHp() <= 0) {
                                walka = false;
                            } else if (pierwszeństwo == 1) {
                               bohater.zadaj_obrażenia(wróg);
                                System.out.println("Zaatakowałeś wroga "+bohater.getAtak()+"dmg");
                            } else if (pierwszeństwo == 2) {
                               wróg.zadaj_obrażenia(bohater);
                                System.out.println("Wróg zaatakował ciebie "+wróg.getAtak()+"dmg");
                            }
                        }
                        pokonany_pokój = true;
                    }
                }
            }
            if (pokój == 3) {
                boolean pokonany_pokój = false;
                while (!pokonany_pokój) {
                    System.out.println("Przed toba widnieje pułapka wymagająca krew.");
                    System.out.println("1 Oddaj krew -10HP. 2 Spróbuj ominąć pułapkę 25% szans na powodzienie. 3 wypisz statystyki. 4 użyj eliskiru. 5 dodaj pancerz. 6 użyj miecza");
                    int akcja = scanner.nextInt();
                    if (akcja == 3) {
                        bohater.wypisz();
                    }
                    if (akcja == 4) {
                        bohater.dodajhp(eliksir_zdrowia);
                    }
                    if (akcja == 5) {
                        bohater.dodajpancerz(pancerz);
                    }
                    if (akcja == 6) {
                        bohater.dodajatak(miecz);
                    }
                    if (akcja == 1) {
                        System.out.println("Oddaleś krew");
                        bohater.setHp(bohater.getHp() - 10);
                        pokonany_pokój = true;
                    }
                    if (akcja == 2) {
                        int chance = random.nextInt(1, 5);
                        if (chance == 1) {
                            System.out.println("Ominąłeś pułapkę");
                            pokonany_pokój = true;
                        } else {
                            System.out.println("Pułapka raniła cię 40dmg");
                            bohater.odnieś_obrażenia(40);
                            pokonany_pokój = true;
                        }
                    }
                }

            }
            if(pokój==4){
                boolean pokonany_pokój=false;
                while (!pokonany_pokój){
                    System.out.println("Przed tobą widnieje skrzynia");
                    System.out.println("1 Otwórz skrzynię. 2 wypisz statystyki. 3 użyj eliskiru. 4 dodaj pancerz. 5 użyj miecza");
                    int akcja = scanner.nextInt();
                    if (akcja == 2) {
                        bohater.wypisz();
                    }
                    if (akcja == 3) {
                        bohater.dodajhp(eliksir_zdrowia);
                    }
                    if (akcja == 4) {
                        bohater.dodajpancerz(pancerz);
                    }
                    if (akcja == 5) {
                        bohater.dodajatak(miecz);
                    }
                    if(akcja==1){
                        int item=random.nextInt(1,5);
                        if(item==1){
                            System.out.println("Znalazłeś eliksir zdrowia");
                            bohater.dodajprzedmiot(eliksir_zdrowia);
                        }
                        if(item==2){
                            System.out.println("Znalazłeś pancerz");
                            bohater.dodajprzedmiot(pancerz);
                        }
                        if(item==3){
                            System.out.println("Znalazłeś miecz");
                            bohater.dodajprzedmiot(miecz);
                        }
                        if (item == 4) {
                            System.out.println("Skrzynia jest pusta");
                        }
                        pokonany_pokój=true;
                    }
                }
            }
            if (bohater.getHp() <= 0) {
                gra = false;
            } else {
                piętra++;
            }
        }
            System.out.println("Poległeś");
            System.out.println("Dotarłes do " + piętra + " piętra");
        }
    }
