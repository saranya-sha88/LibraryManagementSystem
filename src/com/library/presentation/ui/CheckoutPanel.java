package com.library.presentation.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import com.library.services.accessitems.LibraryItemInfo;
import com.library.services.adminoperations.Login;
import com.library.services.memberoperations.CheckoutItem;
import com.library.services.memberoperations.ReturnItem;
import com.library.services.validation.Validation;

public class CheckoutPanel extends JPanel implements ActionListener{
	
	JTextField tmemberId,titemId;
	SpringLayout layout;
	
	public CheckoutPanel()
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
		
		String memberVal,itemVal,videoLimit = null,fbookLimit = null,nfbookLimit = null;
		boolean isValidCheckout = false;
		Map<String,String> checkOutLimit;
		List<LibraryItemInfo> libraryItemInfo;
		memberVal = tmemberId.getText();
		itemVal = titemId.getText();
	    CheckoutItem checkoutItem = new CheckoutItem();
	    
		
	    checkOutLimit = checkoutItem.checkMaximumCheckouts(memberVal);
	    
	    if(null != checkOutLimit && checkOutLimit.size() > 0)
	    {
	    	if(checkOutLimit.containsKey("V"))
	    	{
	    		videoLimit = checkOutLimit.get("V");
	    	}
	    	
	    	if(checkOutLimit.containsKey("FB"))
	    	{
	    		fbookLimit = checkOutLimit.get("FB");
	    	}
	    	
	    	if(checkOutLimit.containsKey("NFB"))
	    	{
	    		nfbookLimit = checkOutLimit.get("NFB");
	    	}
	    }
	    
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
			boolean isValid=false,retValid=true, isItemAvail = true;
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
					isItemAvail = checkoutItem.isItemAvailable(itemVal);
					
					if(!isItemAvail)
					{
						JOptionPane.showMessageDialog( null,
						         "Sorry, Item not available");
					}
					else{
						
						if(itemVal.contains("V"))
						{
							if(null != videoLimit && "EXCEEDED".equalsIgnoreCase(videoLimit))
							{
								JOptionPane.showMessageDialog( null,
								         "Your are permitted to checkout only 2 videos");
							}else{
								isValidCheckout = true;
							}
						}else if(itemVal.startsWith("F"))
						{
							if(null != fbookLimit && "EXCEEDED".equalsIgnoreCase(fbookLimit))
							{
								JOptionPane.showMessageDialog( null,
								         "Your are permitted to checkout only 3 fiction books");
							}else{
								isValidCheckout = true;
							}
							
						}else if(itemVal.startsWith("NF"))
						{
							if(null != nfbookLimit && "EXCEEDED".equalsIgnoreCase(nfbookLimit))
							{
								JOptionPane.showMessageDialog( null,
								         "Your are permitted to checkout only 2 non-fiction books");
							}else{
								isValidCheckout = true;
							}
							
						}
					}
				}
			}
		}
		
		if(isValidCheckout)
		{
		
				libraryItemInfo = checkoutItem.checkout(memberVal, itemVal);
				//setVisible(false);
				showCheckoutItems(libraryItemInfo);
				getRootPane().revalidate();
			
		}else{
			
			    JOptionPane.showMessageDialog( null,
			         "Checkout not successfull");
			
		}
//		/setVisible(false);
		
	}

	
	  private void setConstraints(JTextField textField)
	  {
		   SpringLayout.Constraints constraints;
		    constraints = layout.getConstraints(textField);
		    constraints.setWidth(Spring.constant(150));
		    constraints.setHeight(Spring.constant(30));
	  }
	
	  
	  private void showCheckoutItems(List<LibraryItemInfo> libraryItemInfo)
	  {
		CheckoutResults checkoutResults =new CheckoutResults(libraryItemInfo);
		//checkoutResults.setPreferredSize(new Dimension(500,500));
		add(checkoutResults);
		 	
	  }


	



}
