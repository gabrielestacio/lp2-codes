package Trabalho04.src.questao01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("LEIA & ESCREVA");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setBounds(117, 71, 202, 42);
		contentPane.add(titleLabel);
		
		JButton readButton = new JButton("Ler");
		readButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadScreen leitura = new ReadScreen();
				
				leitura.setVisible(true);
			}
		});
		readButton.setBounds(75, 123, 125, 21);
		contentPane.add(readButton);
		
		JButton writeButton = new JButton("Escrever");
		writeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteScreen escrever = new WriteScreen();
				
				escrever.setVisible(true);
			}
		});
		writeButton.setBounds(224, 123, 119, 21);
		contentPane.add(writeButton);
	}
}
