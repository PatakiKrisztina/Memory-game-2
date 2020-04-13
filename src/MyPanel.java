import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MyPanel extends JPanel{

	private ArrayList<JToggleButton> buttons;
	private ArrayList<JToggleButton> pressed;
	private JToggleButton thisbutton;
	
	public MyPanel() {
		setLayout(new GridLayout(4,4));
		buttons=new ArrayList<JToggleButton>();
		pressed=new ArrayList<JToggleButton>();
		for(int i=0;i<16;i++) {
			buttons.add(new JToggleButton(Integer.toString(i)));
			add(buttons.get(i));
			buttons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					thisbutton=(JToggleButton) e.getSource();
					pressed.add(thisbutton);
					//thisbutton.setForeground(Color.RED);
				}
				
			});
			
		}
		
	}

	public ArrayList<JToggleButton> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<JToggleButton> buttons) {
		this.buttons = buttons;
	}

	public ArrayList<JToggleButton> getPressed() {
		return pressed;
	}

	public void setPressed(ArrayList<JToggleButton> pressed) {
		this.pressed = pressed;
	}
}
