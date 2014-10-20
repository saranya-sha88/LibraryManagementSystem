package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	
	public HeaderPanel(){
		setBackground(new Color(165,42,42));
		setPreferredSize(new Dimension(1366, 150));
		setLocation(0, 0);
		//setLayout(layout);
		showImage();
	}
	
	private void showImage()
	{
		
		try {
			image = ImageIO.read(new File("C:\\Users\\Saranya\\Desktop\\studies\\summer-2013\\OOA\\project\\ui\\libraryRed.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 358, 0, image.getWidth(null), image.getHeight(null), null);
	    }
	
	

}
