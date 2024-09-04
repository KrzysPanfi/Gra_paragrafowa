import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Przedmiot eliksir_zdrowia = new Przedmiot("eliksir zdrowia", 50, 0, 0);
    static Przedmiot pancerz = new Przedmiot("kawałek pancerza", 0, 50, 0);
    static Przedmiot miecz = new Przedmiot("miecz", 0, 0, 20);
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Wybierz poziom trudności. 1 to łatwy 2 to średni 3 to trudny");
        int poziom_trudnosci = scanner.nextInt();
        ArrayList<Przedmiot> eq = new ArrayList<>();
        ArrayList<Przedmiot> eq0 = new ArrayList<>();
        Postac bohater = new Postac("Bohater", 6, 6, 6, eq);

        int pietra = 0;
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
        System.out.println("Jesteś poszukiwaczem przygód okrywającym starożytne lochy. Lochy są podzielone na piętra.");
        System.out.println("Aby wybrać akcję trzeba podac jej numer");
        while (gra) {
            System.out.println("Piętro " + pietra);
            int pokoj = random.nextInt(1, 5);
            boolean pokonany_pokoj;
            if (pokoj == 1) {
                pokonany_pokoj = false;
                while (!pokonany_pokoj) {
                    System.out.println("Przed tobą widnieje dziura");
                    System.out.println("1 Przeskocz nad dziurą. 50% szany powodzenia. 2 Menu postaci");
                    int akcja = scanner.nextInt();
                    if (akcja == 2) {
                        Menu_ekwipunku(bohater);
                    }

                    if (akcja == 1) {
                        int chance = random.nextInt(1, 3);
                        if (chance == 1) {
                            System.out.println("Spadles do dziury 30dmg");
                            bohater.odnies_obrazenia(30);
                        } else System.out.println("Przeskoczyłeś dziurę");
                        pokonany_pokoj = true;

                    }
                }
            }
            if (pokoj == 2) {
                pokonany_pokoj = false;
                while (!pokonany_pokoj) {
                    Postac wrog = new Postac("Bandyta", 100, 0, 10, eq0);
                    System.out.println("Przed tobą widnieje wrogi bandyta");
                    System.out.println("1 Zaatakuj wroga. 2 Menu postaci");
                    int akcja = scanner.nextInt();
                    if (akcja == 2) {
                        Menu_ekwipunku(bohater);
                    }

                    if (akcja == 1) {
                        boolean walka = true;
                        while (walka) {
                            int atak = random.nextInt(1, 3);
                            if (wrog.getHp() <= 0) {
                                System.out.println("Pokonałeś wroga");
                                walka = false;
                            } else if (bohater.getHp() <= 0) {
                                walka = false;
                            } else if (atak == 1) {
                                bohater.zadaj_obrazenia(wrog);
                                System.out.println("Zaatakowałeś wroga " + bohater.getAtak() + "dmg");
                            } else if (atak == 2) {
                                wrog.zadaj_obrazenia(bohater);
                                System.out.println("Wróg zaatakował ciebie " + wrog.getAtak() + "dmg");
                            }
                            System.out.println("Napisz 1 aby kontynuować");
                            int cont=scanner.nextInt();
                        }
                        pokonany_pokoj = true;
                    }
                }
            }
            if (pokoj == 3) {
                pokonany_pokoj = false;
                while (!pokonany_pokoj) {
                    System.out.println("Przed toba widnieje pułapka wymagająca krew.");
                    System.out.println("1 Oddaj krew -10HP. 2 Spróbuj ominąć pułapkę 25% szansy powodzenia. 3 Menu postaci");
                    int akcja = scanner.nextInt();
                    if (akcja == 3) {
                        Menu_ekwipunku(bohater);
                    }

                    if (akcja == 1) {
                        System.out.println("Oddaleś krew");
                        bohater.setHp(bohater.getHp() - 10);
                    }
                    if (akcja == 2) {
                        int chance = random.nextInt(1, 5);
                        if (chance == 1) {
                            System.out.println("Ominąłeś pułapkę");
                        } else {
                            System.out.println("Pułapka raniła cię 40dmg");
                            bohater.odnies_obrazenia(40);
                        }
                    }
                    pokonany_pokoj = true;
                }

            }
            if (pokoj == 4) {
                pokonany_pokoj = false;
                while (!pokonany_pokoj) {
                    System.out.println("Przed tobą widnieje skrzynia");
                    System.out.println("1 Otwórz skrzynię. 2 Menu Postaci");
                    int akcja = scanner.nextInt();
                    if (akcja == 2) {
                        Menu_ekwipunku(bohater);
                    }
                    if (akcja == 1) {
                        int item = random.nextInt(1, 5);
                        if (item == 1) {
                            System.out.println("Znalazłeś eliksir zdrowia");
                            bohater.dodajprzedmiot(eliksir_zdrowia);
                        }
                        if (item == 2) {
                            System.out.println("Znalazłeś pancerz");
                            bohater.dodajprzedmiot(pancerz);
                        }
                        if (item == 3) {
                            System.out.println("Znalazłeś miecz");
                            bohater.dodajprzedmiot(miecz);
                        }
                        if (item == 4) {
                            System.out.println("Skrzynia jest pusta");
                        }
                        pokonany_pokoj = true;
                    }
                }
            }
            if (bohater.getHp() <= 0) {
                gra = false;
            } else {
                pietra++;
            }
        }
        System.out.println("Poległeś");
        System.out.println("Dotarłes do " + pietra + " piętra");
    }

    public static void Menu_ekwipunku(Postac postac) {
        boolean menu = true;
        while (menu) {
            System.out.println("1 wypisz statystyki. 2 użyj eliskiru. 3 dodaj pancerz. 4 użyj miecza. 5 wyjdz z menu");
            int akcja1 = scanner.nextInt();
            if (akcja1 == 1) {
                postac.wypisz();
            }
            if (akcja1 == 2) {
                postac.dodajhp(eliksir_zdrowia);
            }
            if (akcja1 == 3) {
                postac.dodajpancerz(pancerz);
            }
            if (akcja1 == 4) {
                postac.dodajatak(miecz);
            }
            if (akcja1 == 5) {
                menu = false;
            }
        }
    }
}
