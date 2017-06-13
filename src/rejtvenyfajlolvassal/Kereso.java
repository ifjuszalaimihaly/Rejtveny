/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rejtvenyfajlolvassal;

import java.awt.Color;
import java.util.ArrayList;


/**
 *
 * @author Mihály
 */
public class Kereso {

    private char[][] betuktabla = new char[15][15];
    private char[][] tukrozotttabla = new char[15][15];
    private static Color szin1 = Color.WHITE;
    private static Color szin2 = Color.BLUE;
    private String megfejtes=new String();
    private int hiba=0;

    private Pont[] talalat;
    private ArrayList<Pont> ossztalalat = new ArrayList<>();

    public static Color getSzin1() {
        return szin1;
    }

    public static void setSzin1(Color szin1) {
        Kereso.szin1 = szin1;
    }

    public static Color getSzin2() {
        return szin2;
    }

    public static void setSzin2(Color szin2) {
        Kereso.szin2 = szin2;
    }

    public ArrayList<Pont> getOssztalalat() {
        return ossztalalat;
    }

    public int getHiba() {
        return hiba;
    }

    public String getMegfejtes() {
        return megfejtes;
    }
    
    

    public void keres(String telepules) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Main.getJatek().IJdikBetutSzinez(i, j, szin1);
            }
        }
        betukTablatKeszit();

        int talalt = 0;
        try {
            talalat = vizszinteskeres(betuktabla, telepules);
            for (Pont talalat1 : talalat) {
                Main.getJatek().IJdikBetutSzinez(talalat1.getX(), talalat1.getY(), szin2);
                if (talalat1 != null) {
                    ossztalalat.add(talalat1);
                }
            }
        } catch (NullPointerException e) {
            talalt++;
        }
        try {
            talalat = fuggolegeskeres(betuktabla, telepules);
            for (Pont talalat1 : talalat) {
                Main.getJatek().IJdikBetutSzinez(talalat1.getX(), talalat1.getY(), szin2);
                if (talalat1 != null) {
                    ossztalalat.add(talalat1);
                }
            }
        } catch (NullPointerException e) {
            talalt++;
        }
        try {
            talalat = atlosankeres(betuktabla, telepules);
            for (Pont talalat1 : talalat) {
                Main.getJatek().IJdikBetutSzinez(talalat1.getX(), talalat1.getY(), szin2);
                if (talalat1 != null) {
                    ossztalalat.add(talalat1);
                }
            }
        } catch (NullPointerException e) {
            talalt++;
        }
        try {
            talalat = atlosankeres2(betuktabla, telepules);
            for (Pont talalat1 : talalat) {
               
                Main.getJatek().IJdikBetutSzinez(talalat1.getX(), talalat1.getY(), szin2);                
                if (talalat1 != null) {
                    ossztalalat.add(talalat1);
                }

            }
        } catch (NullPointerException e) {
            talalt++;
        }
        try {
            talalat = vizszinteskeres(betuktabla, forditva(telepules));          
            for (Pont talalat1 : talalat) {
                Main.getJatek().IJdikBetutSzinez(talalat1.getX(), talalat1.getY(), szin2);
                if (talalat1 != null) {
                    
                    ossztalalat.add(talalat1);
                }
            }

        } catch (NullPointerException e) {
            talalt++;
        }
        try {
            talalat = fuggolegeskeres(betuktabla, forditva(telepules));           
            for (Pont talalat1 : talalat) {
                Main.getJatek().IJdikBetutSzinez(talalat1.getX(), talalat1.getY(), szin2);
                if (talalat1 != null) {                   
                    ossztalalat.add(talalat1);
                }
            }
        } catch (NullPointerException e) {
            talalt++;
        }
        try {
            talalat = atlosankeres(betuktabla, forditva(telepules));            
            for (Pont talalat1 : talalat) {
                Main.getJatek().IJdikBetutSzinez(talalat1.getX(), talalat1.getY(), szin2);
                if (talalat1 != null) {
                    ossztalalat.add(talalat1);
                }
            }
        } catch (NullPointerException e) {
            talalt++;
        }
        try {
            talalat = atlosankeres2(betuktabla, forditva(telepules));
            for (Pont talalat1 : talalat) {

                Main.getJatek().IJdikBetutSzinez(talalat1.getX(), talalat1.getY(), szin2);
                if (talalat1 != null) {
                    ossztalalat.add(talalat1);
                }

            }
        } catch (NullPointerException e) {
            talalt++;
        }

        if (talalt == 8) {
            megfejtes=telepules;
            hiba++;
        }
    }

    private void betukTablatKeszit() {
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 15; i++) {
                betuktabla[i][j] = Main.getJatek().getBetumatrix()[i][j].getText().charAt(0);
            }
        }
    }

    public String forditva(String szo) {
        String s = "";
        for (int i = szo.length() - 1; i >= 0; i--) {
            s += szo.charAt(i);
        }
        return s;
    }

    private static Pont[] fuggolegeskeres(char[][] szavak, String s) {
        Pont p[] = new Pont[s.length()];
        for (int i = 0; i < s.length(); i++) {
            p[i] = new Pont();
        }
        for (int i = 0; i < szavak.length; i++) {
            for (int j = 0; j <= szavak.length - s.length(); j++) {
                String t = "";
                for (int k = 0; k < s.length(); k++) {
                    t += szavak[i][j + k];
                    if (s.charAt(k) == t.charAt(k)) {
                        p[k].setX(i);
                        p[k].setY(j + k);
                        if (s.equals(t)) {
                            boolean rendezett = true;
                            for (int l = 1; l < p.length; l++) {
                                if (p[l - 1].getX() != p[l].getX()) {
                                    rendezett = false;
                                    break;
                                }
                                if (p[l - 1].getY() + 1 != p[l].getY()) {
                                    rendezett = false;
                                }
                            }
                            if (rendezett) {
                                return p;
                            } else {
                                return null;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private static Pont[] vizszinteskeres(char[][] szavak, String s) {
        Pont p[] = new Pont[s.length()];
        for (int i = 0; i < s.length(); i++) {
            p[i] = new Pont();
        }
        for (int i = 0; i <= szavak.length - s.length(); i++) {
            for (int j = 0; j < szavak.length; j++) {
                String t = "";
                for (int k = 0; k < s.length(); k++) {
                    t += szavak[i + k][j];
                    if (s.charAt(k) == t.charAt(k)) {
                        p[k].setX(i + k);
                        p[k].setY(j);
                        if (s.equals(t)) {
                            boolean rendezett = true;
                            for (int l = 1; l < p.length; l++) {
                                if (p[l - 1].getY() != p[l].getY()) {
                                    rendezett = false;
                                    break;
                                }
                                if (p[l - 1].getX() + 1 != p[l].getX()) {
                                    rendezett = false;
                                }
                            }
                            if (rendezett) {
                                return p;
                            } else {
                                return null;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private static Pont[] atlosankeres(char[][] szavak, String s) {
        Pont p[] = new Pont[s.length()];
        for (int i = 0; i < s.length(); i++) {
            p[i] = new Pont();
        }
        for (int i = 0; i <= szavak.length - s.length(); i++) {
            for (int j = 0; j <= szavak.length - s.length(); j++) {
                String t = "";
                for (int k = 0; k < s.length(); k++) {
                    t += szavak[i + k][j + k];
                    if (s.charAt(k) == t.charAt(k)) {
                        p[k].setX(i + k);
                        p[k].setY(j + k);
                        if (s.equals(t)) {
                            boolean rendezett = true;
                            for (int l = 1; l < p.length; l++) {
                                if (p[l - 1].getX() + 1 != p[l].getX() && p[l - 1].getY() != p[l].getY()) {
                                    rendezett = false;
                                }
                            }
                            if (rendezett) {
                                return p;
                            } else {
                                return null;
                            }
                        }
                    }
                }
            }

        }
        return null;
    }

    private static Pont[] atlosankeres2(char[][] szavak, String s) {
        Pont p[] = new Pont[s.length()];
        for (int i = 0; i < s.length(); i++) {
            p[i] = new Pont();
        }
        for (int i = szavak.length - 1; i >= s.length() - 1; i--) {
            for (int j = 0; j <= szavak.length - s.length(); j++) {
                String t = "";
                for (int k = 0; k < s.length(); k++) {
                    t += szavak[i - k][j + k];
                    if (s.charAt(k) == t.charAt(k)) {
                        p[k].setX(i - k);
                        p[k].setY(j + k);
                        if (s.equals(t)) {
                            boolean rendezett = true;
                            for (int l = 1; l < p.length; l++) {
                                if (p[l - 1].getX() < p[l].getX()) {
                                    rendezett = false;
                                }
                                if (p[l - 1].getY() > p[l].getY()) {
                                    rendezett = false;
                                }
                            }
                            if (rendezett) {
                                return p;
                            } else {
                                return null;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

}
