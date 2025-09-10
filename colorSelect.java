package exerc1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class colorSelect extends JFrame implements ActionListener {
	private JCheckBox b1,b2;
	private JPanel painel;
	private JComboBox<String> b3;
	private JButton ok, c;
	
	public colorSelect() {
		super("ColorSelect");
		setLayout(new BorderLayout(5,5));
		
		b3 =new JComboBox<String>();
		add(b3, BorderLayout.NORTH);
		b3.addItem("RED");
		b3.addItem("GREEN");
		b3.addItem("BLUE");
		b3.addItem("BLACK");
		b3.addItem("WHITE");
		
		painel = new JPanel();
		painel.setLayout(new GridLayout(2, 1));
		
		JPanel button = new JPanel();
		b1 = new JCheckBox("Background");
		b2 = new JCheckBox("Foreground");
		button.add(b1);
		button.add(b2);
	
		
		ok = new JButton("OK");
		c = new JButton("CANCELAR");

		JPanel main = new JPanel();
		main.add(ok);
		main.add(c);
		
		painel.add(button);
		painel.add(main);
		
		add(painel, BorderLayout.CENTER);
		
		ok.addActionListener(this);
	    c.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == ok) {
            
            String selectedColorName = (String) b3.getSelectedItem();
            Color selectedColor = null;

            
            switch (selectedColorName) {
                case "RED":
                    selectedColor = Color.RED;
                    break;
                case "GREEN":
                    selectedColor = Color.GREEN;
                    break;
                case "BLUE":
                    selectedColor = Color.BLUE;
                    break;
                case "BLACK":
                    selectedColor = Color.BLACK;
                    break;
                case "WHITE":
                    selectedColor = Color.WHITE;
                    break;
            }

          
            if (selectedColor != null) {
                
                if (b1.isSelected()) {
                    
                    painel.setBackground(selectedColor);
                   
                    for(Component comp : painel.getComponents()){
                        if(comp instanceof JPanel){
                            ((JPanel) comp).setBackground(selectedColor);
                        }
                    }
                }
                
                if (b2.isSelected()) {
                    b1.setForeground(selectedColor);
                    b2.setForeground(selectedColor);
                    ok.setForeground(selectedColor);
                    c.setForeground(selectedColor);
                }
            }
        }
       
        else if (e.getSource() == c) {
            System.exit(0); 
        }
    }
	

	
	
	public static void main(String[] args) {
		colorSelect is = new colorSelect();
		is.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		is.setVisible(true);
		is.setSize(350, 180);
		is.setResizable(false);
		is.setLocationRelativeTo(null);
		
				
	}
}
