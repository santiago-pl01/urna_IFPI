package Novocadastro;

import javax.swing.*; // Essa importação inclui todas as classes do pacote javax.swing, mas pode deixar como antes se quiser.
import java.awt.event.ActionListener;


public class TelaCadastroEleitor extends TelaGenerica{
	
	private JLabel textNome;
	private JLabel textID;
	private JLabel contador;
	private JTextField campoNome;
	private JTextField campoId;
	private JButton buttonAdd;
	

	
	

	public TelaCadastroEleitor() {
		super("Cadastro", 400, 400, false);

		// Altera o comportamento ao fechar esta tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		iniciarComponetes();
	}
	
	public void iniciarComponetes() {
		//-------------------------------DECLARAR------------------------------------\\
		textNome = new JLabel("nome");
		textID= new JLabel("id");
		contador = new JLabel("Eleitores");
		campoNome= new JTextField();
		campoId= new JTextField();
		buttonAdd = new JButton("adicionar eleitor");
		
		//-------------------------------CONFIGURAR------------------------------------\\
		textNome.setBounds(10, 20,200, 50 );
		textID.setBounds(10, 50, 200, 50);
		contador.setBounds(10, 100, 200, 60);
		campoNome.setBounds(50, 30, 200, 30);
		campoId.setBounds(50, 60, 200, 30);
		buttonAdd.setBounds(100, 250, 140, 50);



		//-------------------------------ADICIONAR------------------------------------\\
		add(textNome);
		add(textID);
		add(contador);
		add(campoNome);
		add(campoId);
		add(buttonAdd);
	}

	// Removida a logica para adicionar eleitor, Urna esta com essa responsabilidade.

	public void setAdicionarEleitorListener(ActionListener listener) {
		buttonAdd.addActionListener(listener);
		
	}
	public String getNome() {
		return campoNome.getText().trim();
	}
	public String getId() {
		return campoId.getText().trim();
	}
	public void setContador(int contador) {
		this.contador.setText("Eleitores: " + contador);
	}
	
	public void clearInput() {
	    campoNome.setText("");
	    campoId.setText("");
	}
}
