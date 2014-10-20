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


public class CheckoutResults extends JPanel {
	
	private List<LibraryItemInfo> libraryItemInfo;
	private String[] columns = {"ID","TITLE","START DATE","DUE DATE"};
	
	
	public CheckoutResults(List<LibraryItemInfo> libraryItemInfo)
	{
		this.libraryItemInfo = libraryItemInfo;
		setSize(300,1000);
		setVisible(true);
		setLocation(300,250);
		initiateResult();
	}
	
	public void initiateResult()
	{
		
		JPanel results = new JPanel();
		
		results.add(Box.createRigidArea(new Dimension(0,250)));
		
		JLabel label = new JLabel("Checkedout Items");
		label.setFont(new Font("Aerial",Font.BOLD,14));
		results.add(label);
	
		results.setLayout(new BoxLayout(results,BoxLayout.Y_AXIS));
		
		ResultTableModel tableModel = new ResultTableModel();
		
		JTable table = new JTable(tableModel);
		label.setLabelFor(table);
		table.setPreferredScrollableViewportSize(new Dimension(1000,1000));
		 table.setRowHeight(30);
		setColumnWidth(table);
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
		
		int rowCount = libraryItemInfo.size();


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
			
			String[][] data = new String[rowCount][4];
			int i =0;
			
			
			if(libraryItemInfo.size() > 0)
			{
		     for(LibraryItemInfo itemInfo: libraryItemInfo)
		     {

		    		 data[i][0] = itemInfo.getId();
			    	  data[i][1] = itemInfo.getTitle();
			    	  data[i][2] = itemInfo.getDateBorrowed();
			    	  data[i][3] = itemInfo.getDateDue();
		    	
		    	  
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
