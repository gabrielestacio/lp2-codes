package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Choice;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReadWriteScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadWriteScreen frame = new ReadWriteScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReadWriteScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(223, 496, 548, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(226, 518, 266, 35);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1.setText(updateStatus(1));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(210, 0, 576, 563);
		contentPane.add(tabbedPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tabbedPane, popupMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		tabbedPane.addTab("Sem T\u00EDtulo *", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 561, 452);
		panel_1.add(textArea);
		textArea.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				JTextArea edit = (JTextArea)e.getSource();
				
				int line = 1;
				
				try {
					int caretpos = edit.getCaretPosition();
					line = edit.getLineOfOffset(caretpos);
				
					line += 1;
				}
				catch(Exception error) {
					error.getStackTrace();
				}
				
				lblNewLabel_1.setText(updateStatus(line));
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 23, 199, 540);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
		JLabel filesTitle = new JLabel("Arquivos");
		filesTitle.setBounds(6, 4, 190, 13);
		contentPane.add(filesTitle);
		
		/*try {
			BufferedReader input = new BufferedReader(new FileReader("saida.txt"));
			String completo = new String();
			String texto = new String();
			
			if((completo = input.readLine()) == null) {
				completo = "";
			}
			else {
				while((texto = input.readLine()) != null) {
					completo = completo + "\n" + texto;
				}
				
				completo = completo + "\n";
			}
			textArea.setText(completo);
			input.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		JButton saveButton = new JButton("Salvar");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		saveButton.setBounds(343, 523, 100, 30);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textArea.getText();
				
				try {
					PrintStream output = new PrintStream("saida.txt");
					
					output.print(texto);
					output.close();
				}
				catch(Exception er){
					er.getStackTrace();
				}
			}
		});
		contentPane.add(saveButton);
		
		JButton backButton = new JButton("Voltar");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(453, 523, 100, 30);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(backButton);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(233, 523, 100, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		contentPane.add(btnNewButton);
		contentPane.setLayout(null);*/
		
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 10, 551, 418);
		panel_1.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(448, 448, 101, 22);
		panel_1.add(menuBar);
		
		try {
			File novo = new File("saida.txt");
			String label = novo.getAbsolutePath();  
			lblNewLabel.setText(label);
		}
		catch(Exception er) {
			er.getStackTrace();
		}
	}
	
	private String updateStatus(int line) {
		return ("Linha: " + line);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
