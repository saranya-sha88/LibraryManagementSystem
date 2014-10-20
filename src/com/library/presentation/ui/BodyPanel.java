package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BodyPanel extends JPanel{
	
	private JPanel mainPanel;

	public BodyPanel(JPanel mainPanel)
	{
		//setPreferredSize(new Dimension(1366, 360));
		//center = new JPanel();
		this.mainPanel = mainPanel;
		addButtons();
	}
	
	
	private void addButtons()
	{
		/* JButton register = new JButton("Register");
		
		register.setBorder(BorderFactory.createEmptyBorder(25, 75, 25, 75));
		add(register);*/
		JMenuBar menuBar = new JMenuBar();
		//JMenu menu = new JMenu();
		
		JMenuItem register = new JMenuItem("Register");
		JMenuItem queryForItem = new JMenuItem("Query For Book/Video");
		JMenuItem checkout = new JMenuItem("Checkout Book/Video");
		JMenuItem returns = new JMenuItem("Return Book/Video");
		JMenuItem reserve = new JMenuItem("Reserve Book/Video");
		JMenuItem txHistory = new JMenuItem("Query For Transaction History");
		JMenuItem fine = new JMenuItem("Pay Fine");
		JMenuItem lostItem = new JMenuItem("Lost Book/Video");
		
		
		register.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//JOptionPane.showMessageDialog( null,
			      //      "You pressed: " + event.getActionCommand() );

				
				clearPanel();
				RegisterPanel rPanel = new RegisterPanel();
				mainPanel.add(rPanel,BorderLayout.CENTER);
				mainPanel.getRootPane().revalidate();
			}
			
		});

	queryForItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				clearPanel();
				QueryItemPanel queryPanel = new QueryItemPanel();
				mainPanel.add(queryPanel,BorderLayout.CENTER);
				mainPanel.getRootPane().revalidate();
			}
			
		});
		returns.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//JOptionPane.showMessageDialog( null,
			      //      "You pressed: " + event.getActionCommand() );

				
			//	clearPanel();
				ReturnPanel retPanel = new ReturnPanel();
				mainPanel.add(retPanel,BorderLayout.CENTER);
				mainPanel.getRootPane().revalidate();
			}
			
		});
		
		checkout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//JOptionPane.showMessageDialog( null,
			      //      "You pressed: " + event.getActionCommand() );

				
			//	clearPanel();
				CheckoutPanel checkoutPanel = new CheckoutPanel();
			   mainPanel.add(checkoutPanel,BorderLayout.CENTER);
				mainPanel.getRootPane().revalidate();
			}
			
		});
		
		txHistory.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//JOptionPane.showMessageDialog( null,
			      //      "You pressed: " + event.getActionCommand() );

				
			//	clearPanel();
				TransactionHistoryPanel txHistoryPanel = new TransactionHistoryPanel();
			   mainPanel.add(txHistoryPanel,BorderLayout.CENTER);
				mainPanel.getRootPane().revalidate();
			}	
		});
		
		
		
		register.setMaximumSize(new Dimension(400,50));
		register.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		checkout.setMaximumSize(new Dimension(400,50));
		checkout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		queryForItem.setMaximumSize(new Dimension(400,50));
		queryForItem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		returns.setMaximumSize(new Dimension(400,50));
		returns.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		reserve.setMaximumSize(new Dimension(400,50));
		reserve.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		txHistory.setMaximumSize(new Dimension(400,50));
		txHistory.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		fine.setMaximumSize(new Dimension(400,50));
		fine.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		lostItem.setMaximumSize(new Dimension(400,50));
		lostItem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//menu.add(menuItem);
		//menuBar.add(menu);
		add(register);
		add(queryForItem);
		add(checkout);
		add(returns);
		add(reserve);
		add(txHistory);
		add(fine);
		add(lostItem);
		
		
		
	}

	public void clearPanel()
	{
		Component[] components = mainPanel.getComponents();
		for(int i = 0;i<components.length;i++)
		{
			
			
			if(components[i].getClass().getName().toString().contains("com.library.presentation.ui.QueryItemPanel"))
			{
				components[i].setVisible(false);
			}else if(components[i].getClass().getName().toString().contains("com.library.presentation.ui.RegisterPanel"))
			{
				components[i].setVisible(false);
			}
		}
	}

}
