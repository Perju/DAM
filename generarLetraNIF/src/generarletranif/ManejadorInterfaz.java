/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generarletranif;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author jupa
 */
public class ManejadorInterfaz extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.out.print("Saliendo");
        System.exit(0);
    }
}
