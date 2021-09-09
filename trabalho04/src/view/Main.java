package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.io.*;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 586, 563);
		tabbedPane.setBorder(new CompoundBorder());
		tabbedPane.setForeground(SystemColor.windowText);
		tabbedPane.setBackground(SystemColor.control);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.desktop);
		tabbedPane.addTab("Sem T\u00EDtulo *", null, panel_1, null);
		panel_1.setLayout(null);
		
		//Questão 4: Label que exibe a linha que está sendo editada
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 491, 266, 35);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		
		lblNewLabel_1.setText(updateStatus(1));
		
		//Questão 4: Label que exibe o caminho do arquivo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 462, 548, 20);
		panel_1.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextArea textArea = new JTextArea(10,10);
		textArea.setBounds(0, 0, 581, 430);
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
		panel_1.add(textArea);
		
		//Questão 3: Aplicação de barras de rolagem para redimensionamento da área de exibição
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 10, 561, 418);
		panel_1.add(scrollPane);		
		
		JPanel panel = new JPanel();
		panel.setBounds(590, 23, 195, 540);
		panel.setBorder(new CompoundBorder());
		contentPane.add(panel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(684, 0, 101, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Op\u00E7\u00F5es");
		mnNewMenu.setBounds(674, 0, 111, 24);
		menuBar.add(mnNewMenu);
		
		JMenuItem newAction = new JMenuItem("Novo");
	    JMenuItem openAction = new JMenuItem("Abrir");
	    JMenuItem saveAction = new JMenuItem("Salvar");
	    JMenuItem saveAsAction = new JMenuItem("Salvar Como...");
	    JMenuItem closeAction = new JMenuItem("Fechar");
	    JMenuItem aboutAction = new JMenuItem("Sobre");
	    mnNewMenu.add(newAction);
	    mnNewMenu.add(openAction);
	    mnNewMenu.add(saveAction);
	    mnNewMenu.add(saveAsAction);
	    mnNewMenu.add(closeAction);
	    mnNewMenu.add(aboutAction);

		
	}
	
	//Questão 4: Função que atualiza a linha que está sendo editada
	private String updateStatus(int line) {
		return ("Linha: " + line);
	}
	
	//Questão 1: Ler o arquivo
	private String read() {
		try {
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
			input.close();
			return completo;
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		return "ERRO! Caiu numa exceção :/";
	}
	
	//Questão 1: Escrever no arquivo
	private void write(String texto, String nome) {
		try {
			PrintStream output = new PrintStream(nome + ".txt");	
			
			output.print(texto);
			output.close();
		}
		catch(Exception er){
			er.getStackTrace();
		}
	}
	
	
	
}
