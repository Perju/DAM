package EjerciciosDI2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Ejercicio18 extends JFrame implements ItemListener, AdjustmentListener{
	Container panel;
	JPanel p1, p2;
	JLabel l1, msg;
	JComboBox<String> cb1;
	int altura, anchura ,profundidad;
	String lista[] = {"Altura", "Anchura", "Profundidad"};
	JScrollBar bar1;
	
	public Ejercicio18() {
		super("Controles");
		setLayout(new BorderLayout());
		p1 = new JPanel(new GridLayout(1, 3, 10, 10));
		p1.setBackground(Color.LIGHT_GRAY);
		l1 = new JLabel("Elegir:", JLabel.RIGHT);
		l1.setBackground(Color.YELLOW);
		p1.add(l1);
		cb1 = new JComboBox<String>();
		altura=anchura=profundidad=0;
		for(String s: lista) {
			cb1.addItem(s);
		}
		cb1.addItemListener(this);
		p1.add(cb1);
		bar1 = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 100);
		bar1.addAdjustmentListener(this);
		p1.add(bar1);
		p2 = new JPanel(new BorderLayout());
		p2.setBackground(Color.LIGHT_GRAY);
		msg = new JLabel("Altura:", JLabel.CENTER);
		msg.setForeground(Color.BLUE);
		p2.add(msg, "North");
		add(p1,"North");
		add(p2, "South");
		setSize(300,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio18 app = new Ejercicio18();
	}

	// metodo de la interfaz ItemListener
	@Override
	public void itemStateChanged(ItemEvent e) {
		switch (e.getItem().toString()) {
		case "Altura":
			msg.setText("Altura: "+altura);
			bar1.setValue(altura);
			break;
		case "Anchura":
			msg.setText("Anchura: "+anchura);
			bar1.setValue(anchura);
			break;
		case "Profundidad":
			msg.setText("Profundiad: "+profundidad);
			bar1.setValue(profundidad);
			break;
		}
	}
	
	// metodo de la interfaz AdjustmentListener
	@Override
	public void adjustmentValueChanged(AdjustmentEvent a) {
		switch (cb1.getSelectedItem().toString()) {
		case "Altura":
			altura=a.getValue();
			msg.setText("Altura: "+altura);
			break;
		case "Anchura":
			anchura=a.getValue();
			msg.setText("Anchura: "+anchura);
			break;
		case "Profundidad":
			profundidad=a.getValue();
			msg.setText("Profundiad: "+profundidad);
			break;
		}
	}
}
