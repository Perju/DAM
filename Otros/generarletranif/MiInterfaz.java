/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generarletranif;

import generarletranif.DNI.DNI;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jupa
 */
public class MiInterfaz extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JPanel panel = new JPanel();
    private JButton obtenerLetra;
    private JTextField textDNI = new JTextField();
    private JLabel labelNIF = new JLabel();
    public MiInterfaz(){
        setTitle("Obtener letra NIF");
        setSize(500,400);
        addWindowListener(new ManejadorInterfaz());
        Container contentpane= getContentPane();
        obtenerLetra = new JButton("Obtener Letra");
        obtenerLetra.addActionListener(this);
        panel.setLayout(new GridLayout(3,1));
        textDNI.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textDNI);
        panel.add(obtenerLetra);
        labelNIF.setHorizontalAlignment(JTextField.CENTER);
        panel.add(labelNIF);
        contentpane.add(panel);
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        if(accion == "Obtener Letra"){
            String texto = "";
            try {
                texto = textDNI.getText()+"-"+DNI.obtenerLetra(textDNI.getText());
            } catch (Exception ex) {
                texto=ex.getMessage();
            }
            labelNIF.setText(texto);
        }
    }
}
