package com.library.presentation.ui;

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
import com.library.services.memberoperations.ReturnItem;
import com.library.services.validation.Validation;

public class ReturnPanel extends JPanel implements ActionListener{
	
	JTextField tmemberId,titemId;
	SpringLayout layout;
	public ReturnPanel()
	{
		layout = new SpringLayout();
		invoke();
		
	}
	public void invoke()
	{
		SpringLayout.Constraints constraints;
		
		   setLayout(layout);
		

		

		    JLabel lmemberId = new JLabel("Member Id:", JLabel.TRAILING);
		    add(lmemberId); 
		    tmemberId = new JTextField(10);
		    setConstraints(tmemberId);
		    lmemberId.setLabelFor(tmemberId);
		    add(tmemberId);
		    
		    
		    JLabel litemId = new JLabel("Library-item Id:", JLabel.TRAILING);
		    add(litemId); 
		    titemId = new JTextField(10);
		    setConstraints(titemId);
		    litemId.setLabelFor(titemId);
		    add(titemId);
		    
		    
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
		
		String memberVal,itemVal;
		memberVal = tmemberId.getText();
		itemVal = titemId.getText();
	
		
		
		if((memberVal == null)||(memberVal.equals("")))
		{	
			JOptionPane.showMessageDialog( null,
			         "Please enter a valid member ID ");
		}
		else if((itemVal == null)||(itemVal.equals("")))
		{	
			JOptionPane.showMessageDialog( null,
			         "Please enter a valid Libary item Id ");
		}
		else 
		{
			boolean isValid=false,retValid=true;
			ReturnItem ret = new ReturnItem();
			Validation valid = new Validation();
			
			
			isValid= valid.validateMemberId(memberVal);
			if(isValid == false)
			{
				JOptionPane.showMessageDialog( null,
				         "Invalid member Id!");
			}
			else if(isValid == true)
			{
				isValid = valid.validateItemId(itemVal);
				if(isValid == false)
				{
					JOptionPane.showMessageDialog( null,
				         "Invalid item Id");
				}
				else 
				{
				//	isValid = ret.checkMemberItemAssociation(memberVal,itemVal);
				}
			}
			if(isValid)
			{
				retValid = ret.returnBookVideo(memberVal, itemVal);
				JOptionPane.showMessageDialog( null,
				         "Return Successfull!!!!");
			}
			
			if(!retValid)
			{
				JOptionPane.showMessageDialog( null,
			         "Fines to be paid!!!!");
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
	


	



}
