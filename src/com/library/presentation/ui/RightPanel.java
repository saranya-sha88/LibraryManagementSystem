package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RightPanel extends JPanel implements ActionListener{

	private static JPanel panel;

	public RightPanel(JPanel mainPanel)
	{
		//setPreferredSize(new Dimension(1366, 360));
		//center = new JPanel();
		this.panel = mainPanel;
		addButton();
	}
	
	
	private void addButton()
	{
		JButton login = new JButton("Login");
		login.setSize(400, 400);
		add(login);
		login.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LoginPanel lPanel = new LoginPanel();
		panel.add(lPanel,BorderLayout.CENTER);
		panel.getRootPane().revalidate();
		
	}
	
	public static void changePanel()
	{
		AdminPanel aPanel = new AdminPanel();
		panel.add(aPanel,BorderLayout.CENTER);
		panel.getRootPane().revalidate();
		
	}

}
