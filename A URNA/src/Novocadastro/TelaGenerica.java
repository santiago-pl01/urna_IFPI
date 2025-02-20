package Novocadastro;

import javax.swing.JFrame;

public abstract class TelaGenerica extends JFrame{
	
	
	
	public TelaGenerica(String titulo, int altura, int largura, boolean resizable) {
		setTitle(titulo);
		setSize(altura, largura);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(resizable);
		

		
	}
	 
	public void fechar() {
		dispose();
	}
}
