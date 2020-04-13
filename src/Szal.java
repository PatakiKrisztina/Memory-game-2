import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

public class Szal extends Thread {

	private MyFrame f;
	private MyPanel p;
	private ArrayList<JToggleButton> buttons;
	private ArrayList<JToggleButton> pressed;
	private ArrayList<JToggleButton> randomed;
	private Random r;
	private int hany,melyik,talalatok;
	private JLabel label;
	
	public Szal(MyFrame f) {
		this.f = f;
		r=new Random();
		randomed=new ArrayList<JToggleButton>();
	}

	@Override
	public void run() {
		talalatok=0;
		for (int k = 0; k < 3; k++) {
			p = f.getP();
			buttons = p.getButtons();
			for (int i = 0; i < buttons.size(); i++) {
				buttons.get(i).setEnabled(false);
			}
			
			hany=r.nextInt(4)+1;
			for(int i=0;i<hany;i++) {
				melyik=r.nextInt(16);
				buttons.get(melyik).setBackground(Color.RED);
				randomed.add(buttons.get(melyik));	
			}
			p.setButtons(buttons);
			p.repaint();
			f.setP(p);
			f.repaint();
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i=0;i<randomed.size();i++) {
				randomed.get(i).setBackground(UIManager.getColor("Button.background"));
			}
			
			p.setButtons(buttons);
			p.repaint();
			f.setP(p);
			f.repaint();
			
			for (int i = 0; i < buttons.size(); i++) {
				buttons.get(i).setEnabled(true);
			}
			
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			p=f.getP();
			pressed=p.getPressed();
			
			for(int i=0;i<pressed.size();i++) {
				if(randomed.contains(pressed.get(i))) {
					talalatok++;
				}
			}
			
			System.out.println("talalatok= "+talalatok);
			label=f.getLabel();
			label.setText("Talalatok: "+talalatok);
			label.repaint();
			f.setLabel(label);
			f.repaint();
			while(pressed.size()>0) {
				pressed.remove(0);
			}
			while(randomed.size()>0) {
				randomed.remove(0);
			}
			p.setPressed(pressed);
			f.setP(p);
		}
	}
}
