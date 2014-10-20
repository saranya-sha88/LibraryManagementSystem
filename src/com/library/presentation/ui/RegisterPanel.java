package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import com.library.services.useroperations.MemberInfo;
import com.library.services.useroperations.MemberShipId;

public class RegisterPanel extends JPanel implements ActionListener{
	
	private SpringLayout layout ;
	String[] labels = {"Name    ", "County    ", "Phone Number    ", "Email    "};
	int numPairs = labels.length;
	private JTextField name,county,phone,email;
	private MemberInfo memberInfo;
	private MemberShipId memberShip;
	private String memberId;
	private final String COUNTY = "spingfield";
	
	public RegisterPanel()
	{
		layout = new SpringLayout();
		 setLayout(layout);
		invoke();
	}

	public void invoke()
	{
	//Create and populate the panel.
		SpringLayout.Constraints constraints;
	
	  
		JPanel tpanel= new JPanel();
		tpanel.setPreferredSize(new Dimension(800,100));
		tpanel.setLayout(new BoxLayout(tpanel,BoxLayout.LINE_AXIS));
	    JLabel title = new JLabel("Registration");
	    title.setHorizontalAlignment(JLabel.CENTER);
	    title.setLocation(500, 5);
	    tpanel.add(title);
	    
	    tpanel.setVisible(true);
	   
	
	    

		

	    JLabel labelname = new JLabel(labels[0], JLabel.TRAILING);
	    add(labelname); 
	    name = new JTextField(10);
	    setConstraints(name);
	    labelname.setLabelFor(name);
	    add(name);
	    
	    
	    JLabel labelCounty = new JLabel(labels[1], JLabel.TRAILING);
	    add(labelCounty); 
	    county = new JTextField(10);
	    setConstraints(county);
	    labelCounty.setLabelFor(county);
	    add(county);
	    
	    JLabel labelPh = new JLabel(labels[2], JLabel.TRAILING);
	    add(labelPh); 
	    phone = new JTextField(10);
	    setConstraints(phone);
	    labelPh.setLabelFor(phone);
	    add(phone);
	    
	    JLabel labelEmail = new JLabel(labels[3], JLabel.TRAILING);
	    add(labelEmail); 
	    email = new JTextField(10);
	    setConstraints(email);
	    labelEmail.setLabelFor(email);
	    add(email);
	    
	    
	    
	    
	 
	   JButton submit = new JButton("Submit");
	   add(submit);
	   constraints = layout.getConstraints(submit);
	   constraints.setX(Spring.constant(450));
       constraints.setY(Spring.constant(250));
	   SpringUtilities.makeCompactGrid(this, numPairs, 2,300, 100, 6, 6);
	//Lay out the panel.
	   
	   submit.addActionListener(this);
	   add(tpanel);

	}
	
  private void setConstraints(JTextField textField)
  {
	   SpringLayout.Constraints constraints;
	    constraints = layout.getConstraints(textField);
	    constraints.setWidth(Spring.constant(150));
	    constraints.setHeight(Spring.constant(30));
  }

@Override
public void actionPerformed(ActionEvent event) {
	// TODO Auto-generated method stub
	String nameVal,countyVal,emailVal,phoneVal;
	nameVal = name.getText();
	countyVal = county.getText();
	emailVal = email.getText();
	phoneVal = phone.getText();
	
	CustomDialogBox dialog = new CustomDialogBox();
	memberInfo = new MemberInfo();
	
	
	if((nameVal == null)||(nameVal.equals("")))
	{	
		dialog.displayMessage("Please enter a valid name");
	}
	else if((countyVal == null)||(countyVal.equals("")))
	{
		dialog.displayMessage("Please enter a valid county");
	}
	else if((phoneVal == null)||(phoneVal.equals("")))
	{
		dialog.displayMessage("Please enter a valid phone number");
		//JOptionPane.showMessageDialog( null,
		  //       "Please enter a valid phone number ");
	}
	else if((emailVal == null)||(emailVal.equals("")))
	{
		dialog.displayMessage("Please enter a valid email ID");
	}
	else if(!COUNTY.equalsIgnoreCase(countyVal))
	{
		memberInfo.setCounty(countyVal);
		memberInfo.setName(nameVal);
		
		memberInfo.setPhoneNumber(phoneVal);
		memberInfo.setEmail(emailVal);
		dialog.getRegFee(memberInfo);
		
	
		
			
	}
	else
	{
	
	memberInfo.setCounty(countyVal);
	memberInfo.setName(nameVal);
	
	memberInfo.setPhoneNumber(phoneVal);
	memberInfo.setEmail(emailVal);
	
	memberShip = new MemberShipId(memberInfo);
	memberId = memberShip.issueMembershipCard(memberInfo);
	
	
	JOptionPane.showMessageDialog( null,
         "You member id :" + memberId );
	}
	
	//setVisible(false);
}
}
