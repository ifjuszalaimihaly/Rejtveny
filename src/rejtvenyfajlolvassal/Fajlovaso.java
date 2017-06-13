/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rejtvenyfajlolvassal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author Mihály
 */
public class Fajlovaso {

    private ArrayList<String> telepulesek = new ArrayList<String>();
    private char[][] betuk = new char[15][15];

    public ArrayList<String> getTelepulesek() {
        return telepulesek;
    }

    public char[][] getBetuk() {
        return betuk;
    }

    public boolean telepulesBeolvas() {
        try {
            Reader r = new InputStreamReader(new FileInputStream("telepules.txt"), "ISO8859_2");
            BufferedReader olvaso = new BufferedReader(r);
            String s ="";
            int i = 0;
            while (s != null) {
                s = olvaso.readLine();
                i++;
                telepulesek.add(s);
            }
            telepulesek.remove(null);
            if (i <= 1) {
                return false;
            }
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (NullPointerException ex) {
            return false;
        }
        return true;
    }

    public boolean tablatBeolvas() {
        try {
            Reader r = new InputStreamReader(new FileInputStream("tabla.txt"), "ISO8859_2");
            BufferedReader olvaso = new BufferedReader(r);
            String s="";
            int k = 0;
            for (int i = 0; i < 15; i++) {
                k++;
                s = olvaso.readLine();                
                if (s.length() != 15) {
                    return false;
                }
                for (int j = 0; j < 15; j++) {
                    betuk[i][j] = s.charAt(j);
                }
            }
            if (k != 15) {
                return false;
            }
            s=olvaso.readLine();
            if(s!=null){
                return false;
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;

        } catch (IOException ex) {
            return false;
        } catch (NullPointerException ex) {
            return false;
        }

    }
}
