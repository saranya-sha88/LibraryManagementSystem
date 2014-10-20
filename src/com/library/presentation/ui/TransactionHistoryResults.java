package com.library.presentation.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import com.library.services.accessitems.LibraryItemInfo;
import com.library.services.txhistory.TransactionHistoryInfo;

public class TransactionHistoryResults extends JPanel{
	
	private List<TransactionHistoryInfo> txHistoryInfo;
	private String[] columns = {"TITLE","BORROW DATE","DUE DATE","STATUS","RESERVEDID","FINESPAID","FINESOVERDUE","FINEPAIDDATE","RETURNEDDATE"};
	
 	public TransactionHistoryResults(List<TransactionHistoryInfo> txHistoryInfo)
 	{
 		this.txHistoryInfo = txHistoryInfo;
 		initiateResult();
 	}
 	
 	public void initiateResult()
	{
		
		JPanel results = new JPanel();
		
		results.setLayout(new BoxLayout(results,BoxLayout.Y_AXIS));
		//results.add(Box.createRigidArea(new Dimension(0,250)));
		
		JLabel label = new JLabel("Transaction History results");
		label.setFont(new Font("Aerial",Font.BOLD,14));
		results.add(label);
	
		
		
		ResultTableModel tableModel = new ResultTableModel();
		
		JTable table = new JTable(tableModel);
		label.setLabelFor(table);
		table.setPreferredScrollableViewportSize(new Dimension(1000,1000));
		 table.setRowHeight(30);
		//setColumnWidth(table);
		setHeaderFontAndColor(table);
		JScrollPane scrollPane = new JScrollPane (table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		results.add(scrollPane);
		add(results);
		
	}
	
	private void setColumnWidth(JTable table)
	{
		int i = 0;
		
		for(i=0;i<4;i++)
		{
			TableColumn column = table.getColumnModel().getColumn(i);
			  if(i == 0)
			  {
				 column.setPreferredWidth(70); 
			  }else if(i == 1){
				column.setPreferredWidth(175);
		      }
				//column.setPreferredWidth(200);
			
		}
	}
	
	private void setHeaderFontAndColor(JTable table)
	{
		table.getTableHeader().setFont(new Font("Plain",Font.BOLD,12));
		table.getTableHeader().setBackground(new Color(245,218,185));
		
	}
	
	private class ResultTableModel extends AbstractTableModel{
		
		int rowCount = txHistoryInfo.size();


		@Override
		public int getRowCount() {
		   
			return rowCount;
		}

		@Override
		public int getColumnCount() {
			
			return columns.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			String[][] data = new String[rowCount][9];
			int i =0;
			
			
			if(txHistoryInfo.size() > 0)
			{
		     for(TransactionHistoryInfo txInfo: txHistoryInfo)
		     {

		    		 data[i][0] = txInfo.getTitle();
			    	  data[i][1] = txInfo.getDateBorrowed();
			    	  data[i][2] = txInfo.getDueDate();
			    	  data[i][3] = txInfo.getStatus();
			    	  data[i][4] = txInfo.getReservedMember();
			    	  data[i][5] = String.valueOf(txInfo.getFinesPaid());
			    	  data[i][6] = String.valueOf(txInfo.getFinesOverdue());
			    	  data[i][7] = txInfo.getFinePaidDate();
			    	  data[i][8] = txInfo.getReturnedDate();
			
		    	  i++;
		    	  
		     }
			}
			
			
			return data[rowIndex][columnIndex];
		}
		
		@Override
        public String getColumnName(int column) {
            return columns[column];
        }
		
		@Override
        public boolean isCellEditable(int row, int column)
        {
		  return false;	
        }
        }
		
	
	

}
