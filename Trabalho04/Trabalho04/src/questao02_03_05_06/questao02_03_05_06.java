package Trabalho04.src.questao02_03_05_06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import javax.swing.JTabbedPane;

public class questao02_03_05_06 extends JFrame {

	private JPanel painelGeral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				questao02_03_05_06 frame = new questao02_03_05_06();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public questao02_03_05_06() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 498);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		
		JMenuItem addNewFile = new JMenuItem("Novo arquivo");
		menuArquivo.add(addNewFile);
		
		JMenuItem closeFile = new JMenuItem("Fechar Arquivo");
		menuArquivo.add(closeFile);
		
		JMenuItem openFile = new JMenuItem("Abrir arquivo...");
		menuArquivo.add(openFile);
		
		JMenuItem saveFile = new JMenuItem("Salvar Como...");
		menuArquivo.add(saveFile);
		
		painelGeral = new JPanel();
		painelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelGeral.setLayout(new BorderLayout(0, 0));
		setContentPane(painelGeral);

		JTabbedPane painelAbas = new JTabbedPane(JTabbedPane.TOP);
		painelGeral.add(painelAbas, BorderLayout.CENTER);
		
		
		TextArea textArea = new TextArea();
		
		painelAbas.addTab("Aba 1", null, textArea, null);
	
		
		JFileChooser chooser = new JFileChooser(".");

		//Abrir Arquivo
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File arquivo;
				int response;
				
				try {
					
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					response = chooser.showOpenDialog(null);
					
					if(response == JFileChooser.APPROVE_OPTION) {
						arquivo = chooser.getSelectedFile();
					
						FileReader leitorArq = new FileReader(arquivo);
						BufferedReader leitorBuff = new BufferedReader(leitorArq);	
						
						String linha = leitorBuff.readLine();
						while (linha != null) {

							Component currentTextArea =  painelAbas.getSelectedComponent();
							
							if(currentTextArea.getClass().toString().equals("class java.awt.TextArea")) {
								
								((TextArea)currentTextArea).append(linha + "\n");
								linha = leitorBuff.readLine();
							}	
						}
						
					}else if(response == JFileChooser.CANCEL_OPTION){
						System.out.println("CANCEL_OPTION");
						
					}else {
						throw new RuntimeException("Erro desconhecido: Nao consegui ler");
					}
					
				} catch (Exception error) {
					error.printStackTrace();
				}
			}
		});
		
		
		//Adicionar Novo arquivo
		addNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					try {
						
						JPanel panel_2 = new JPanel();
						JScrollPane scrollPane_2 = new JScrollPane();
						panel_2.add(scrollPane_2);
						
						TextArea textArea_2 = new TextArea();
						
						scrollPane_2.setViewportView(textArea_2);
						
						painelAbas.addTab("Aba " + ((painelAbas.getTabCount())+1), null, textArea_2);
					
					}catch(Exception error) {
						error.printStackTrace();
					}
				}
		});
		
		//Fechar Arquivo
		closeFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painelAbas.removeTabAt(painelAbas.getTabCount()-1);
			}
		});
		
		//Salvar arquivo
		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response;
				File arquivo;
				
				try {
					response = chooser.showSaveDialog(null);
					
					if(response == JFileChooser.APPROVE_OPTION) {	
						arquivo = chooser.getSelectedFile();
						FileWriter escritorArq = new FileWriter(arquivo);
						BufferedWriter escritaTxt = new BufferedWriter(escritorArq);
							
						Component currentTextArea =  painelAbas.getSelectedComponent();
		
						if(currentTextArea.getClass().toString().equals("class java.awt.TextArea")) {
							escritaTxt.append(((TextArea)currentTextArea).getText());
							escritaTxt.flush();
							escritaTxt.close();
						}
	
					}else if(response == JFileChooser.CANCEL_OPTION){
						System.out.println("CANCEL_OPTION");
						
					}else {
						throw new RuntimeException("Erro desconhecido: Nao consegui ler");
					}

				} catch (Exception error) {
					error.printStackTrace();
				}
			}
		});
	}
}
