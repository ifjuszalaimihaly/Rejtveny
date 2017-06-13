/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rejtvenyfajlolvassal;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Mihály
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static Ablak jatek;

    public static Ablak getJatek() {
        return jatek;
    }

    public static void setJatek(Ablak jatek) {
        Main.jatek = jatek;
    }

    public static Kereso getKereso() {
        return kereso;
    }

    public static void setKereso(Kereso kereso) {
        Main.kereso = kereso;
    }

    public static Fajlovaso getOlvaso() {
        return olvaso;
    }

    public static void setOlvaso(Fajlovaso olvaso) {
        Main.olvaso = olvaso;
    }
    private static Kereso kereso;
    private static Fajlovaso olvaso;

    public static void main(String[] args) {
        olvaso = new Fajlovaso();
        boolean b = olvaso.telepulesBeolvas();
        if (!b) {
            JOptionPane.showMessageDialog(jatek, "Nem lehet a település neveket beolvasni", "A program leállt", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        b=olvaso.tablatBeolvas();
        
        if(!b){
             JOptionPane.showMessageDialog(jatek, "Nem lehet a táblát beolvasni", "A program leállt", JOptionPane.ERROR_MESSAGE);
             return;
        }
        jatek = new Ablak("Rejtvény");
        kereso = new Kereso();
        if(olvaso.getTelepulesek().size()<=1){
                  JOptionPane.showMessageDialog(jatek, "Nincs megfejtés", "Ellenőrizd a bemeneti fájlokat", JOptionPane.ERROR_MESSAGE);
        }
        try{
            Thread.sleep(3000);
        } catch (InterruptedException ex){
            
        }
        for(int i=0; i<olvaso.getTelepulesek().size(); i++){
            String s=olvaso.getTelepulesek().get(i);
            jatek.getTelepulesek()[i].setBackground(Kereso.getSzin2());
            kereso.keres(s);
           
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex){
                
            }
            
            jatek.getTelepulesek()[i].setBackground(new Color(238, 238, 238));
        }
        for(Pont p: kereso.getOssztalalat()){
            jatek.IJdikBetutSzinez(p.getX(), p.getY(), Kereso.getSzin2());
        }
        if(kereso.getHiba()==1){
            JOptionPane.showMessageDialog(jatek, "A megfejtés: " + kereso.getMegfejtes(), "A fenn maradt település", JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane.showMessageDialog(jatek, "Nincs megfejtés", "Ellenőrizd a bemeneti fájlokat", JOptionPane.ERROR_MESSAGE);
        }
    }

}
