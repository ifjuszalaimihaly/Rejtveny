/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rejtvenyfajlolvassal;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Mihály
 */
public class Ablak extends JFrame {

    private Panel tabla;
    private Panel telepulespanel;
    private Label[][] betumatrix;
    private Label[] telepulesek;
    private String telepulesnev = new String();

    public Label[][] getBetumatrix() {
        return betumatrix;
    }

    public void setBetumatrix(Label[][] betumatrix) {
        this.betumatrix = betumatrix;
    }

    public Panel getTabla() {
        return tabla;
    }

    public void setTabla(Panel tabla) {
        this.tabla = tabla;
    }

    public String getTelepulesnev() {
        return telepulesnev;
    }

    public void setTelepulesnev(String telepulesnev) {
        this.telepulesnev = telepulesnev;
    }

    public Label[] getTelepulesek() {
        return telepulesek;
    }

    public Ablak(String title) {
        super(title);
        init();
    }

    public void init() {
        this.setBounds(20, 20, 750, 480);
        this.setResizable(false);
        this.setLayout(null);
        this.addWindowListener(new Ablakbezaro());
        initTabla();
        initBevitelpanel();
        this.setVisible(true);
        this.requestFocus();
    }

    public void initTabla() {
        tabla = new Panel();
        tabla.requestFocus();
        tabla.setBounds(0, 0, 450, 450);
        tabla.setBackground(Color.white);
        this.add(tabla);
        betumatrix = new Label[15][15];
        genral(15, 30, 30);

    }

    public void initBevitelpanel() {
        telepulespanel = new Panel();
        telepulespanel.setLayout(new GridLayout(30, 2));
        telepulespanel.setBounds(450, 0, 300, 450);
        this.add(telepulespanel);
        telepulesek = new Label[Main.getOlvaso().getTelepulesek().size()];
        for (int i = 0; i < Main.getOlvaso().getTelepulesek().size(); i++) {
            telepulesek[i] = new Label(Main.getOlvaso().getTelepulesek().get(i));
            telepulespanel.add(telepulesek[i]);
        }
    }

    public void genral(int cellaszam, int pozicoi, int szelesseg) {
        tabla.setLayout(null);
        for (Integer i = 0; i < cellaszam; i++) {
            for (Integer j = 0; j < cellaszam; j++) {
                Character c = Main.getOlvaso().getBetuk()[j][i];
                betumatrix[j][i] = new Label(c.toString());
                betumatrix[j][i].setBounds(i * pozicoi, j * pozicoi, szelesseg, szelesseg);
                tabla.add(betumatrix[j][i]);
            }
        }

    }

    public void IJdikBetutSzinez(int i, int j, Color szin) {
        betumatrix[i][j].setBackground(szin);
    }

}

class Ablakbezaro extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        Main.getJatek().dispose();
        System.exit(0);
    }
}
