package com.library.presentation.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.library.services.accessitems.Book;
import com.library.services.accessitems.BookInfo;
import com.library.services.accessitems.LibraryItemInfo;
import com.library.services.accessitems.LibraryItemInterface;
import com.library.services.accessitems.Video;
import com.library.services.accessitems.VideoInfo;

public class ResultPanel extends JPanel {
	
	private String searchCriteria;
	private LibraryItemInterface bookItems,videoItems;
	private List<LibraryItemInfo> bookList,videoList;
	private String[] columns = {"ID","TITLE","AUTHOR","DIRECTOR","LOCATION","STATUS","PRICE"};
	
	
	public ResultPanel(String searchCriteria)
	{
		this.searchCriteria = searchCriteria;
		bookItems = new Book();
		videoItems = new Video();
		initiateResult();
	}
	
	public void initiateResult()
	{
		bookList = bookItems.queryForItem(searchCriteria);
		videoList = videoItems.queryForItem(searchCriteria);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setPreferredSize(new Dimension(100,100));
		JLabel label = new JLabel("Search results");
		label.setFont(new Font("Aerial",Font.BOLD,14));
		headerPanel.add(label);
	
		JPanel results = new JPanel();
		results.setLayout(new BoxLayout(results,BoxLayout.Y_AXIS));
		
		ResultTableModel tableModel = new ResultTableModel();
		
		JTable table = new JTable(tableModel);
		 table.setPreferredScrollableViewportSize(new Dimension(1000,200));
		 table.setRowHeight(30);
		//table.setPreferredSize(new Dimension(1000,500));
		setColumnWidth(table);
		setHeaderFontAndColor(table);
		JScrollPane scrollPane = new JScrollPane (table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		//JLabel header = new JLabel("List of book and video available in Library match,ing your search criteria");
		results.add(Box.createRigidArea(new Dimension(0,100)));
		results.add(scrollPane);
		//results.add(table);
		add(label);
		add(results);
		
	}
	
	private void setColumnWidth(JTable table)
	{
		int i = 0;
		
		for(i=0;i<7;i++)
		{
			TableColumn column = table.getColumnModel().getColumn(i);
			  if(i == 0)
			  {
				 column.setPreferredWidth(70); 
			  }else if(i == 1){
				column.setPreferredWidth(175);
		      }else if(i==3){
		    	  column.setPreferredWidth(120);
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
		
		int rowCount = bookList.size() + videoList.size();
		BookInfo bookInfo;
		VideoInfo videoInfo;

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
			
			String[][] data = new String[rowCount][7];
			int i =0;
			
			
			if(bookList.size() > 0)
			{
		     for(LibraryItemInfo itemInfo: bookList)
		     {
		    	  bookInfo = (BookInfo)itemInfo;
		    	  data[i][0] = bookInfo.getId();
		    	  data[i][1] = bookInfo.getTitle();
		    	  data[i][2] = bookInfo.getAuthor();
		    	  data[i][3] = "N/A";
		    	  data[i][4] = bookInfo.getLocation();
		    	  data[i][5] = bookInfo.getStatus();
		    	  data[i][6] = String.valueOf(bookInfo.getPrice());
		    	  
		    	  i++;
		    	  
		     }
			}
			
			if(videoList.size() > 0)
			{
				 for(LibraryItemInfo itemInfo: videoList)
			     {
			    	  videoInfo = (VideoInfo)itemInfo;
			    	  data[i][0] = videoInfo.getId();
			    	  data[i][1] = videoInfo.getTitle();
			    	  data[i][2] = "N/A";
			    	  data[i][3] = videoInfo.getDirector();
			    	  data[i][4] = videoInfo.getLocation();
			    	  data[i][5] = videoInfo.getStatus();
			    	  data[i][6] = String.valueOf(videoInfo.getPrice());
			    	  
			    	  i++;
			    	  
			     }
			}
			
			
			if(videoList.size() == 0 && bookList.size() == 0)
			{
				data[0][0] = "No matching results found";
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
