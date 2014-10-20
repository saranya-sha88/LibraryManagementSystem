package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class AdminPanel extends JPanel implements ActionListener {

	private BoxLayout layout;
	
	//JPanel panel;
	public AdminPanel()
	{

		//panel = new JPanel();
		layout = new BoxLayout(this,BoxLayout.X_AXIS);
		setLocation(300,100);
		setPreferredSize(new Dimension(500,500));
		setVisible(true);
		addMenus();
	}
		
		
		private void addMenus()
		{
			/* JButton register = new JButton("Register");
			300, 100
			register.setBorder(BorderFactory.createEmptyBorder(25, 75, 25, 75));
			add(register);*/
			setLayout(layout);
			
			this.setForeground(Color.lightGray);
			JPanel menuPanel = new JPanel();

			this.add(menuPanel, BorderLayout.WEST);
			
			menuPanel.setPreferredSize(new Dimension(200,100));
			menuPanel.setVisible(true);
			//JMenu menu = new JMenu();
			
			JButton query1 = new JButton("Query Total Library Items ");
			query1.setLocation(300, 100);
			query1.setSize(200,200);
			menuPanel.add(query1);
			JButton query2 = new JButton("Query Total Library members ");
			query1.setLocation(350, 100);
			query1.setSize(200,200);
			menuPanel.add(query2);
			JButton query3 = new JButton("Query Total Checkedout Books ");
			query1.setLocation(400, 100);
			query1.setSize(200,200);
			menuPanel.add(query3);
			JButton query4 = new JButton("Query Title of most checkedout Items ");
			query1.setLocation(450, 100);
			query1.setSize(200,200);
			menuPanel.add(query4);
			JButton query5 = new JButton("Query Total fines ");
			query1.setLocation(500, 100);
			query1.setSize(200,200);
			menuPanel.add(query5);
			JButton query6 = new JButton("Add new library item");
			query1.setLocation(550, 100);
			query1.setSize(200,200);
			menuPanel.add(query6);
			/*JMenuItem register = new JMenuItem("Query");// Total Library Items");
			JMenuItem queryForItem = new JMenuItem("Query");// Total Members");
			JMenuItem checkout = new JMenuItem("Query");// Total Checkedout Books");
			JMenuItem returns = new JMenuItem("Query"); //Title of most checked out Library Items");
			JMenuItem reserve = new JMenuItem("Query");// Total Fines");
			JMenuItem txHistory = new JMenuItem("Add");// New Library Item");
			JMenuItem fine = new JMenuItem("Show Graph");*/
			
			
			query1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					//JOptionPane.showMessageDialog( null,
				      //      "You pressed: " + event.getActionCommand() );
					//RegisterPanel rPanel = new RegisterPanel();
					//mainPanel.add(rPanel,BorderLayout.CENTER);
					//mainPanel.getRootPane().revalidate();
				}
				
			});
			
		/*	register.setMaximumSize(new Dimension(50,50));
			register.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
			
			checkout.setMaximumSize(new Dimension(50,50));
			checkout.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
			
			queryForItem.setMaximumSize(new Dimension(50,50));
			queryForItem.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			
			returns.setMaximumSize(new Dimension(50,50));
			returns.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			
			reserve.setMaximumSize(new Dimension(50,50));
			reserve.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			
			txHistory.setMaximumSize(new Dimension(50,50));
			txHistory.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			
			fine.setMaximumSize(new Dimension(50,50));
			fine.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			
			
			//menu.add(menuItem);
			//menuBar.add(menu);
			menuPanel.add(register);
			menuPanel.add(queryForItem);
			menuPanel.add(checkout);
			menuPanel.add(returns);
			menuPanel.add(reserve);
			menuPanel.add(txHistory);
			menuPanel.add(fine);
			add(menuPanel);*/
				
			
			
		}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
