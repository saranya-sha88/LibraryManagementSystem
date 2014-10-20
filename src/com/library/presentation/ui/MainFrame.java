/**
 * 
 */
package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Saranya
 *
 */
public class MainFrame extends JFrame{
	
	public MainFrame(){
		initiateMainFrame();
		
	}
	
	private void initiateMainFrame()
	{
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		mainPanel.setBackground(new Color(245,245,220));
		mainPanel.setPreferredSize(new Dimension(1366,768));
		
		
		
		//JPanel panel = new JPanel(new BorderLayout());
		HeaderPanel header = new HeaderPanel();
		BodyPanel body = new BodyPanel(mainPanel);
		FooterPanel footer = new FooterPanel();
		RightPanel login = new RightPanel(mainPanel);
		
		//JPanel center = new JPanel();
		//RegisterPanel register = new RegisterPanel();
		//center.add(register);
		body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
		
		mainPanel.add(header, BorderLayout.NORTH);
		mainPanel.add(body,BorderLayout.WEST);
		mainPanel.add(footer,BorderLayout.SOUTH);
		mainPanel.add(login,BorderLayout.EAST);
		//mainPanel.add(body.getCenter(),BorderLayout.CENTER);
	
		add(mainPanel);
		setTitle("BookMarker Library");
		setPreferredSize(new Dimension(1366, 768));
		pack();
		validate();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame mainFrame = new MainFrame();
		

	}

	
	

}
