package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import com.library.services.useroperations.MemberInfo;
import com.library.services.useroperations.MemberShipId;

public class CustomDialogBox extends JDialog{
	private MemberInfo memberInfo;
	boolean feePaid = false;
	private String memberId;
	
	public CustomDialogBox()
	{
		//this.panel = panel;
		memberId = "";
		setSize(300,100);
		setVisible(true);
		setLocation(650,550);
	}
	
	public void displayMessage(String msg)
	{
		
		 //JOptionPane optionPane = new JOptionPane("Please ENTER your NAME here");
	
		JPanel panel = new JPanel();

	    getContentPane().add(panel);
		panel.setPreferredSize(new Dimension(300,100));
	    panel.add(new JLabel(msg));
	    JButton okButton = new JButton("OK");
	    panel.add(okButton);
	    pack();
		
	    okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
			}			
		});
	    
	    //setLocation(500,800);
	    
		
		//add(optionPane);
		
	
		
	}
	public void getRegFee(final MemberInfo memberInfo)
	{
		SpringLayout.Constraints constraints;
		JPanel panel = new JPanel();
		JPanel tPanel = new JPanel();
		panel.setPreferredSize(new Dimension(300,150));
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
	
	    getContentPane().add(panel);
	    
	    //setLayout(layout);
	    
		//panel.setPreferredSize(new Dimension(500,500));
		
		JLabel message1 = new JLabel("Hey,you are not a resident of Spingfield!!");
		//setConstraints(layout,message1);
		message1.setAlignmentX(1);
	    panel.add(message1);


		JLabel message2 = new JLabel("Pay 10$ Registration fee.");
		//setConstraints(layout,message2);
		message2.setAlignmentX(1);
	    panel.add(message2);

	    
	    
	    final JLabel label = new JLabel();
	    label.setAlignmentX(1);
	    panel.add(label);
	    

	    
	    

	    final JTextField text = new JTextField(5);
	    tPanel.add(text);
	    //setConstraints(layout,text);
	    panel.add(tPanel);

	    
	    JPanel bPanel = new JPanel();
	    
	   // panel.setAlignmentX(CENTER_ALIGNMENT);
	    
	    //Box box = Box.createHorizontalBox();
	   //box.setPreferredSize(new Dimension(70,70));
	    
	    //box.add(Box.createRigidArea(new Dimension(50,10)));
	    JButton okButton = new JButton("OK");
	    bPanel.add(okButton);
	    //setConstraints(layout,okButton);
	    
	    ////box.add(okButton);
	    
	   //box.add(Box.createRigidArea(new Dimension(10,10)));
	    //panel.add(okButton);
	 
		  
	  //  panel.add(Box.createRigidArea(new Dimension(50,10)));
	    
	    JButton cancelButton = new JButton("CANCEL");
	    bPanel.add(cancelButton);
	    //setConstraints(layout,cancelButton);
	    //box.add(cancelButton);
	   // box.setAlignmentY(CENTER_ALIGNMENT);
	   // panel.add(box);
        panel.add(bPanel);
		  
	    
	    
	    pack();
	    //SpringUtilities.makeCompactGrid(panel, 6, 1,200,200,2, 2);
	    okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String fee;
				fee = text.getText();
				if("10".equals(fee))
					feePaid = true;
				
			    if(feePaid == true)
			    {
			    	MemberShipId memberShip = new MemberShipId(memberInfo);
			    	memberId = memberShip.issueMembershipCard(memberInfo);
					/*JOptionPane.showMessageDialog( null,
					         "You member id :" + memberId );*/
			    	//JPanel p = new JPanel();
			    	label.setText("You are a member now!"+memberId);
			    	label.setForeground(Color.green);
			    	//pack();
	
			    	
			    }
			    else
			    {
			    	//displayMessage("Please pay 10$ !!!");
					//JOptionPane.showMessageDialog( null,
					  //       "Please pay 10$ !" );
			    	label.setText("Registration requires 10$");
			    	label.setForeground(Color.red);
			    	//pack();
			    }


			}			
		});
	    
	   /* okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
				setVisible(false);
			}			
		});*/
	    cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				event.getActionCommand();
				setVisible(false);
				//getRootPane().setVisible(false);
			}			
		});
	    

		
	}

	  private void setConstraints(SpringLayout layout,JLabel label)
	  {
		   SpringLayout.Constraints constraints;
		    constraints = layout.getConstraints(label);
		    constraints.setWidth(Spring.constant(150));
		    constraints.setHeight(Spring.constant(30));
	  }
	  private void setConstraints(SpringLayout layout,JButton button)
	  {
		   SpringLayout.Constraints constraints;
		    constraints = layout.getConstraints(button);
		    constraints.setWidth(Spring.constant(150));
		    constraints.setHeight(Spring.constant(30));
	  }
	  private void setConstraints(SpringLayout layout,JTextField text)
	  {
		   SpringLayout.Constraints constraints;
		    constraints = layout.getConstraints(text);
		    constraints.setWidth(Spring.constant(150));
		    constraints.setHeight(Spring.constant(30));
	  }


}
