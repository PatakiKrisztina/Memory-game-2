import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{

	private JLabel label;
	private MyPanel p;
	private Szal szal;
	
	public MyFrame() {
		setVisible(true);
		setBounds(0,0,1000,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		label=new JLabel("Talalatok: 0");
		p=new MyPanel();
		add(p,BorderLayout.CENTER);
		add(label,BorderLayout.SOUTH);
		
		szal=new Szal(this);
		szal.start();
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public MyPanel getP() {
		return p;
	}

	public void setP(MyPanel p) {
		this.p = p;
	}
}
