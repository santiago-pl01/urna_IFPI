package Novocadastro;

import javax.swing.*; // Essa importação inclui todas as classes do pacote javax.swing, mas pode deixar como antes se quiser.
// import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList; // Importa a classe ArrayList nao usada
//import java.util.List; // Importa a classe List nao usada

//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;

//import Elementos.Eleitor;
//import Elementos.Mesario;

public class TelaCadastroEleitor extends TelaGenerica{
	
	private JLabel textNome;
	private JLabel textID;
	private JLabel contador;
	private JTextField campoNome;
	private JTextField campoId;
	private JButton buttonAdd;
	
	//private List<Eleitor> eleitores;
	
	//Mesario mesario = new Mesario();
	
	

	public TelaCadastroEleitor() {
		super("Cadastro", 400, 400, false);
		//this.eleitores = eleitores;
		
		// Altera o comportamento ao fechar esta tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		// FIRIFICA SE A LISTA É NU
	    //if (eleitores == null) {
	    //    this.eleitores = new ArrayList<>();
	    //} else {
	        //this.eleitores = eleitores;
	    //}
		
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


		// Essa funcao abaixo foi removida pq nao era mais usada aqui.

		// buttonAdd.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		comandoBotao();
		// 	}
		// });
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


	// private void comandoBotao() {    
	//     // **REMOVA ESTA LINHA** 
	//     // this.eleitores = new ArrayList<>(); 

	//     String nome = campoNome.getText().trim();
	//     String idTexto = campoId.getText().trim();
	    
	//     // VERIFICA CAMPOS VAZIOS
	//     if (nome.isEmpty() || idTexto.isEmpty()) {
	//         JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
	//         return;
	//     }

	//     try {
	//         int id = Integer.parseInt(idTexto);

	//         // VERIFICA SE O ID JÁ EXISTE NA LISTA
	//         for (Eleitor eleitor : eleitores) {
	//             if (eleitor.getId() == id) {
	//                 JOptionPane.showMessageDialog(this, "ID já cadastrado! Escolha outro.", "Erro", JOptionPane.ERROR_MESSAGE);
	//                 return;
	//             }
	//         }

	//         // ADICIONA NOVO ELEITOR
	//         eleitores.add(new Eleitor(nome, id));
	//         JOptionPane.showMessageDialog(this, "Eleitor cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	        
	        
	//         // ATUALIZA O CONTADOR DE ELEITORES
	//         contador.setText("Eleitores: " + eleitores.size());
	        
	//         //COMO PEGAR UM METADO DE OUTRA CLASSE
	//         //Mesario.printEleitor();

	//         // LIMPA OS CAMPOS
	//         campoNome.setText("");
	//         campoId.setText("");

	//     } catch (NumberFormatException e) {
	//         JOptionPane.showMessageDialog(this, "O ID deve ser um número inteiro válido!", "Erro", JOptionPane.ERROR_MESSAGE);
	//     }
	// }

}
