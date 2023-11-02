/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpfinal;

import Data.CuartelData;
import Entidades.Cuartel;

/**
 *
 * @author ramir
 */
public class TpFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Cuartel c = new Cuartel(2, "La finur", "San justo 82", 402, 584, "2665-123440", "lafinur@gmail.com");
        CuartelData cd = new CuartelData();
//        cd.agregarCuartel(c);
        for (Cuartel asd : cd.cuartelesCercaDelLugarDeSiniestro(404, 586)) {
            System.out.println(asd);
        }
    }
    
}
