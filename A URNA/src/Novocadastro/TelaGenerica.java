package Novocadastro;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class TelaGenerica extends JFrame{
	
	
	
	public TelaGenerica(String titulo, int altura, int largura, boolean resizable) {
		setTitle(titulo);
		setSize(altura, largura);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(resizable);
		
		//paloma
		
	}
	 
	
	public void fechar() {
		dispose();
	}
}
