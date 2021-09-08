package Trabalho04.src.questao01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ReadScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadScreen frame = new ReadScreen();
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
	public ReadScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton backButton = new JButton("Voltar");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		backButton.setBounds(174, 232, 85, 21);
		contentPane.add(backButton);
		
		JLabel readLabel = new JLabel("");
		readLabel.setVerticalAlignment(SwingConstants.TOP);
		readLabel.setBounds(10, 10, 416, 212);
		contentPane.add(readLabel);
		
		try {	
			BufferedReader input = new BufferedReader(new FileReader("saida.txt"));
			String completo = "<html>" + input.readLine();
			String texto = new String();
		
			while((texto = input.readLine()) != null) {
				System.out.println(texto);
				completo = completo + "<br>" + texto;
			}
			
			completo = completo + "</html>";
			
			System.out.println(completo);
			readLabel.setText(completo);
			input.close();
		}
		catch(Exception err) {
			err.getStackTrace();
		}
	}
}
