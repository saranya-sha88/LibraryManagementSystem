package com.library.presentation.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.text.DateFormatter;

import org.jdesktop.swingx.JXDatePicker;

import com.library.services.txhistory.TransactionHistory;
import com.library.services.txhistory.TransactionHistoryInfo;

public class TransactionHistoryPanel extends JPanel implements ActionListener{
	
	private JTextField fromDate, toDate, memberId;
	private TransactionHistory txHistory;
	private JPanel transactionHeaderPanel;
	private TransactionHistoryResults transactionHistoryResults;
	
	
	public TransactionHistoryPanel()
	{
		txHistory = new TransactionHistory();
		initiateUI();
	}
	
	private void initiateUI()
	{
	
		transactionHeaderPanel = new JPanel();
		
		//JXDatePicker  datePicker = new JXDatePicker();
		//datePicker.setDate(new Date());

	    JLabel lFromDate = new JLabel("From date:", JLabel.TRAILING);
	    transactionHeaderPanel.add(lFromDate); 
	    fromDate = new JTextField(10);
	    lFromDate.setLabelFor(fromDate);
	    
	    //lmemberId.setText(datePicker.getDate().toString());
	    transactionHeaderPanel.add(fromDate);
	    
	    
	    
	    JLabel lToDate = new JLabel("To date:", JLabel.TRAILING);
	    transactionHeaderPanel.add(lToDate); 
	     toDate = new JTextField(10);
	    lToDate.setLabelFor(toDate);
	    transactionHeaderPanel.add(toDate);
	    
	    JLabel lMemberId = new JLabel("Library member Id:", JLabel.TRAILING);
	    transactionHeaderPanel.add(lMemberId); 
	     memberId = new JTextField(10);
	     lMemberId.setLabelFor(memberId);
	    transactionHeaderPanel.add(memberId);
	    
	    
		   JButton submit = new JButton("Submit");
		   transactionHeaderPanel.add(submit);
		   submit.addActionListener(this);
		   add(transactionHeaderPanel);
		   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Date fromDateObj,toDateObj;
		List<TransactionHistoryInfo> txInfo ;
		Calendar calendar;
		String fromDateVal,toDateVal,memberIdVal;
		int fYear,tYear,fMonth,tMonth;
		boolean isMonth = false;
		
		String DATE_FORMAT = "[0-9]{1,2}-[0-9]{2}-[0-9]{4}";
		
		fromDateVal = fromDate.getText();
		toDateVal = toDate.getText();
		memberIdVal = memberId.getText();
		
		if(null == fromDateVal || fromDateVal.equals(""))
		{
			JOptionPane.showMessageDialog( null,
			         "Please enter valid from date");
		}else if(null == toDate || toDate.equals(""))
		{
			JOptionPane.showMessageDialog( null,
			         "Please enter a valid to date");
		}else if(null == memberId || memberId.equals(""))
		{
			JOptionPane.showMessageDialog( null,
			         "Please enter valid memberId");
			
		}else if(!fromDateVal.matches(DATE_FORMAT)){
			
			JOptionPane.showMessageDialog( null,
			         "Please enter a from date in format MM-dd-yyyy");
		}else if(!toDateVal.matches(DATE_FORMAT))
		{
			JOptionPane.showMessageDialog( null,
			         "Please enter a  to date in format MM-dd-yyyy");
		}else{
			
			txInfo = txHistory.queryForTransactionHistory(fromDateVal, toDateVal, memberIdVal);
			transactionHistoryResults = new TransactionHistoryResults(txInfo);
			remove(transactionHeaderPanel);
			transactionHeaderPanel.setVisible(false);
			transactionHistoryResults.setPreferredSize(new Dimension(1000,1000));
			add(transactionHistoryResults);
			getRootPane().revalidate();
			
		}
		
	}

}
