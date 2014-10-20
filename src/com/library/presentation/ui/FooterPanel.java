package com.library.presentation.ui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class FooterPanel extends JPanel {

	public FooterPanel()
	{
		addLabel();
	}
	
	public void addLabel()
	{
		JLabel label = new JLabel("Footer");
		label.setBorder(BorderFactory.createEtchedBorder(
                EtchedBorder.RAISED));
		add(label);
	}
}
