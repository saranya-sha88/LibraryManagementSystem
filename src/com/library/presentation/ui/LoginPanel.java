package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import com.library.services.adminoperations.Login;
import com.library.services.useroperations.MemberInfo;

public class LoginPanel extends JPanel implements ActionListener{

	private SpringLayout layout ;
	private JTextField uname,passwd;
	public LoginPanel ()
	{
		layout = new SpringLayout();
		invoke();
		
	}
	public void invoke()
	{
		SpringLayout.Constraints constraints;
		
		   setLayout(layout);
		

		

		    JLabel lUsername = new JLabel("Username:", JLabel.TRAILING);
		    add(lUsername); 
		    uname = new JTextField(10);
		    setConstraints(uname);
		    lUsername.setLabelFor(uname);
		    add(uname);
		    
		    
		    JLabel password = new JLabel("Password:", JLabel.TRAILING);
		    add(password); 
		    passwd = new JTextField(10);
		    setConstraints(passwd);
		    password.setLabelFor(passwd);
		    add(passwd);
		    
		    
			   JButton submit = new JButton("Submit");
			   add(submit);
			   constraints = layout.getConstraints(submit);
			   constraints.setX(Spring.constant(400));
		       constraints.setY(Spring.constant(200));
			   SpringUtilities.makeCompactGrid(this, 2, 2,300, 100, 6, 6);
			   
			   submit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String unameVal,passwdVal;
		unameVal = uname.getText();
		passwdVal = passwd.getText();
	
		
		
		if((unameVal == null)||(unameVal.equals("")))
		{	
			JOptionPane.showMessageDialog( null,
			         "Please enter a valid username ");
		}
		else if((passwdVal == null)||(passwdVal.equals("")))
		{	
			JOptionPane.showMessageDialog( null,
			         "Please enter a valid password ");
		}
		else 
		{
			boolean valid;
			Login log = new Login();
			valid = log.validate(unameVal,passwdVal);
			if(valid == true)
			{
				remove(this);
				//clearPanel();
			RightPanel.changePanel();
			repaint();
			//AdminPanel aPanel = new AdminPanel();
	
			
			}
			else
			{
			JOptionPane.showMessageDialog( null,
			         "Please enter valid username and password ");
			}
		}
setVisible(false);
		
	}

	
	  private void setConstraints(JTextField textField)
	  {
		   SpringLayout.Constraints constraints;
		    constraints = layout.getConstraints(textField);
		    constraints.setWidth(Spring.constant(150));
		    constraints.setHeight(Spring.constant(30));
	  }
		public void clearPanel()
		{
			Component[] components = this.getComponents();
			for(int i = 0;i<components.length;i++)
			{
				
				
				if(components[i].getClass().getName().toString().contains("com.library.presentation.ui.LoginPanel"))
				{
					System.out.println(components[i].getClass().getName());
					components[i].setVisible(false);
				}
			}
		}
}
