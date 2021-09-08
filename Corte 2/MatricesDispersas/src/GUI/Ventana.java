package GUI;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
	
	private static int WIDTH = 800;
	private static int HEIGHT = 600;
	private JPanel contentPanel, optionsPanel, graphPanel;
	
	public Ventana(String title) {
		setTitle(title);
		setLayout(null);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void loadComponents() {
		// Content Panel.
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		
		optionsPanel = new JPanel();
		contentPanel.add(optionsPanel);
		
		
		
		
		setVisible(true);
	}

	@Override
    public void actionPerformed(ActionEvent event) {
       
    }
}