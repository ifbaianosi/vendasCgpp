package br.com.cgpp.vendas.utils;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class BackgroundFocusField {

	private JTextField jTextField;
	
	private static Color backgroundColor = new Color(255, 255, 204);
	//private static Color backgroundColor = new Color(204, 255, 204);
	
	private static Color foregroundColor = new Color(51, 51, 51);
	
	public BackgroundFocusField() {
		super();
	}
	
	public static void requestFocus (final JTextField jtextfield){		
		
		jtextfield.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				jtextfield.setBackground(backgroundColor);
				jtextfield.setForeground(foregroundColor);
			}
		});
		
		jtextfield.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				jtextfield.setBackground(Color.WHITE);
				jtextfield.setForeground(new Color (51, 51, 51));
			}
		});
	}

	public static void requestFocus(final JSpinner jSpinner) {
		jSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				((JSpinner.DefaultEditor)jSpinner.getEditor()).getTextField().setBackground(backgroundColor);
				((JSpinner.DefaultEditor)jSpinner.getEditor()).getTextField().setForeground(foregroundColor);
			}
		});
		
		jSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				((JSpinner.DefaultEditor)jSpinner.getEditor()).getTextField().setBackground(Color.WHITE);
				((JSpinner.DefaultEditor)jSpinner.getEditor()).getTextField().setBackground(new Color (51, 51, 51));
			}
		});
	}

	public static void requestFocus(final JTextArea jTextArea) {
		jTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				jTextArea.setBackground(backgroundColor);
				jTextArea.setForeground(foregroundColor);
			}
		});
		
		jTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				jTextArea.setBackground(Color.WHITE);
				jTextArea.setForeground(new Color (51, 51, 51));
			}
		});
	}
	/*
	public static void requestFocus(final JComboBox jComboBox) {
		jComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				UIManager.put("ComboBox.selectionBackground", cor);
			}
		});
		
		jComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				UIManager.put("ComboBox.selectionBackground", Color.WHITE);
			}
		});
	}*/
	
	 
	
}
