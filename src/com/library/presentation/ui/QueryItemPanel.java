/**
 * 
 */
package com.library.presentation.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

/**
 * @author Saranya
 *
 */
public class QueryItemPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private SpringLayout springLayout;
	private SpringLayout.Constraints constraints;
	private JPanel queryPanel;
	private JTextField textField;

	public QueryItemPanel()
	{
		springLayout = new SpringLayout();
		setPreferredSize(new Dimension(1000,700));
		initiateQueryPanel();
	}

	public void initiateQueryPanel()
	{
		
		queryPanel = new JPanel();
		queryPanel.setPreferredSize(new Dimension(750,750));
	    queryPanel.setLayout(springLayout);
	    ImageIcon image = new ImageIcon("C:\\Users\\Saranya\\Desktop\\studies\\summer-2013\\OOA\\project\\ui\\search_icon.png");
	    JLabel searchCriteria = new JLabel(image);
	    searchCriteria.setText("Search Item");
	    queryPanel.add(searchCriteria);
	    textField = new JTextField();
	    constraints = springLayout.getConstraints(textField);
	    constraints.setWidth(Spring.constant(300));
	    constraints.setHeight(Spring.constant(50));
	    searchCriteria.setLabelFor(textField);
	    
	    queryPanel.add(textField);
	   
	    
	    JButton search = new JButton("Search");
	    constraints = springLayout.getConstraints(search);
	    constraints.setX(Spring.constant(300));
	    constraints.setY(Spring.constant(180));
	    search.addActionListener(this);
	    
	    
	    queryPanel.add(search);
	    
	    SpringUtilities.makeCompactGrid(queryPanel, 1, 2,100, 100, 6, 6);
	    
	    add(queryPanel);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String searchCriteria;
		searchCriteria = textField.getText();
		ResultPanel resultPanel = new ResultPanel(searchCriteria);
		remove(queryPanel);
		queryPanel.setVisible(false);
		resultPanel.setLayout(springLayout);
		resultPanel.setPreferredSize(new Dimension(1000,750));
		add(resultPanel);
		getRootPane().revalidate();
		
		
	}
}
