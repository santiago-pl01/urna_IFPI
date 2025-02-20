package Novocadastro;

//import java.awt.*;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.util.List;
import javax.swing.*; // Essa importação inclui todas as classes do pacote javax.swing, mas pode deixar como antes se quiser.


// import javax.swing.JButton;
// import javax.swing.JComboBox;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JTextField;

//import Elementos.Candidato;
import Elementos.Cargo;
import Elementos.Partido;
//import Urna.Urna; 


public class TelaCadastroCandidato extends TelaGenerica {
	private JLabel textNome;
	private JLabel textID;
	//private JLabel textCargo;
	private JLabel textNumeroVotação;
	private JLabel contador;
	private JTextField campoNome;
	private JTextField campoId;
	//private JTextField campoCargo;
	private JTextField campoNumero;
	private JButton buttonAdd;
	private JComboBox<String> comboPartidos;
	private JComboBox<String> comboCargos;

	// Atributos para armazenar a lista de partidos
	private List<Partido> partidos;

	//
	//private Urna urna; 

	
	public TelaCadastroCandidato(List<Partido> partidos) { // a lista de partidos tinha que esta definida aqui no costrutor k.
		// DECLARAÇÃO DA CONFIGURAÇÃO DA TELA
		super("cadastro", 400, 400, false);
		this.partidos = partidos;
		//this.urna = urna;
		
		// PERMITE QUE P CODIGO CONTINUE ATIVO, MESMO COM A CLASSE  FECHADA 	
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null); // permite posicionar os componentes na tela
		iniciarComponentes(); // tinha que ter o metodo aqui para o costrutor funcionar
		
	}
	

	
	public void iniciarComponentes() {
		//-------------------------------DECLARAR------------------------------------\\

		// comentei algumas linhas abaixo para que funcionasse na hora de testar, mas precisa arrumar para aparecer la.
		textNome = new JLabel("Nome");
		textID= new JLabel("Id");
		//textCargo= new JLabel("Cargo");
		textNumeroVotação = new JLabel("N° vot.");
		contador= new JLabel("contador: 0");
		campoNome = new JTextField();
		campoId= new JTextField();
		//campoCargo= new JTextField();
		campoNumero = new JTextField();
		buttonAdd = new JButton("adicionar candidato");
		
		//-------------------------------CONFIGURAR------------------------------------\\	

		// Alteraçao nos tamanhos e posicoes dos componentes, do jeito antigo abaixo a tela ficava branca, nao sei pq.
		// @Palomano, voce pode mudar se quiser, para reorganizer os componentes.
		textNome.setBounds(10, 20, 200, 30);
		campoNome.setBounds(120, 20, 200, 30);
		textID.setBounds(10, 60, 200, 30);
		campoId.setBounds(120, 60, 200, 30);
		textNumeroVotação.setBounds(10, 100, 200, 30);
		campoNumero.setBounds(120, 100, 200, 30);
		buttonAdd.setBounds(120, 250, 200, 30);
		contador.setBounds(10, 200, 200, 30);

		// Forma antiga abaixo

		// textNome.setBounds(10, 20, 200, 30);
		// campoNome.setBounds(50, 30, 200, 30); 
		// textID.setBounds(10, 50, 200, 50);
		// //textCargo.setBounds(10, 85, 200, 50);
		// textNumeroVotação.setBounds(10, 110, 200, 50);
		// contador.setBounds(10, 150, 200, 60);
		// campoNome.setBounds(50, 30, 200, 30);
		// campoId.setBounds(50, 60, 200, 30);
		// campoCargo.setBounds(50, 90, 200, 30);
		// campoNumero.setBounds(50, 120, 200,30);
		// buttonAdd.setBounds(100, 250, 140, 50);


		// Essa funcao abaixo foi removida pq nao era mais usada aqui.

		// buttonAdd.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		comandoBotao();
		// 	}
		// });
		
		//-------------------------------ADICIONAR------------------------------------\\

			// Foi organizado para ficar mais facil de entender e com suas respetivas posicoes
		add(textNome);
		add(campoNome);
		add(textID);
		add(campoId);
		add(textNumeroVotação);
		add(campoNumero);
		add(buttonAdd);
		add(contador);
		

		// Forma antiga abaixo

		// add(textNome);
		// add(textID);
		// add(textCargo);
		// add(textNumeroVotação);
		// add(contador);
		// add(campoNome);
		// add(campoId);
		// add(campoCargo);
		// add(campoNumero);
		// add(buttonAdd);
			
			
		// Nao fo mexido nada nos JComboBox abaixo

		// JComboBox para selecionar Partido
		comboPartidos = new JComboBox<>();
		for (Partido p : partidos) { 
		    comboPartidos.addItem(p.getNome()); 
		}
		comboPartidos.setBounds(120, 140, 200, 30); // Foi mudado o tamnaho da caixa
		add(comboPartidos);

		// JComboBox para selecionar Cargo
		comboCargos = new JComboBox<>();
		for (Cargo c : Cargo.values()) { 
		    comboCargos.addItem(c.name()); 
		}
		comboCargos.setBounds(120, 180, 200, 30); // Foi mudado o tamnaho da caixa
		add(comboCargos);

		// Por algum motivo a mesma funcao que estava la em cima era usada aqui.

		// Botão para adicionar candidato ele saio la de cima para ficar aqui em baixo
		// buttonAdd.addActionListener(new ActionListener() {
		//     @Override
		//     public void actionPerformed(ActionEvent e) {
		//         comandoBotao();
		//     }
		// });

	}


	// Removida toda a logica antiga de adiconar candidato, Urna esta com essa responsabilidade.
	public void setAdicionarCandidatoListener(ActionListener listener) {
		buttonAdd.addActionListener(listener);
		
	}

	public String getNome() {
		return campoNome.getText().trim();
	}
	public String getNumero() {
		return campoNumero.getText().trim();
	}
	public String getPartidoSelecionado() {
		return (String) comboPartidos.getSelectedItem();
	}
	public String getCargoSelecionado() {
		return (String) comboCargos.getSelectedItem();
	}

	public void setContador(int quantidade) {
		contador.setText("Candidatos: " + quantidade);
	}

	// Fora os outros metodos a cima, foi adicionado esse aqui, para limpar os campos, semelhante ao que esta comentado la em baixo.
	// Mas de uma forma que eu podsse usar la em Urna melhor, pois virou um metodo.
	public void clearInput() {
	    campoNome.setText("");
	    campoId.setText("");
	    campoNumero.setText("");
	}
	
	// private void comandoBotao() {
	//     String nome = campoNome.getText().trim();
	//     String numeroTexto = campoNumero.getText().trim();

	//     // Verifica se os campos estão preenchidos
	//     if (nome.isEmpty() || numeroTexto.isEmpty()) {
	//         JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
	//         return;
	//     }

	//     try {
	//         int numeroCandidato = Integer.parseInt(numeroTexto);

	//         // Pega o partido selecionado no JComboBox
	//         String nomePartidoSelecionado = (String) comboPartidos.getSelectedItem();
	//         Partido partidoEscolhido = null;
	//         for (Partido p : partidos) {
	//             if (p.getNome().equals(nomePartidoSelecionado)) {
	//                 partidoEscolhido = p;
	//                 break;
	//             }
	//         }

	//         if (partidoEscolhido == null) {
	//             JOptionPane.showMessageDialog(this, "Erro ao selecionar partido!", "Erro", JOptionPane.ERROR_MESSAGE);
	//             return;
	//         }

	//         // Pega o cargo selecionado no JComboBox
	//         String cargoSelecionado = (String) comboCargos.getSelectedItem();
	//         Cargo cargo = Cargo.valueOf(cargoSelecionado);

	//         // Criar o candidato
	//         Candidato novoCandidato = new Candidato(nome, numeroCandidato, partidoEscolhido, cargo);
	//         partidoEscolhido.setCandidato(novoCandidato);

	//         JOptionPane.showMessageDialog(this, "Candidato cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

	//         // Atualizar o contador de candidatos
	//         contador.setText("Candidatos: " + partidoEscolhido.getCandidatos().size());

	//         // Limpar os campos
	//         campoNome.setText("");
	//         campoNumero.setText("");

	//     } catch (NumberFormatException e) {
	//         JOptionPane.showMessageDialog(this, "O número do candidato deve ser um número inteiro válido!", "Erro", JOptionPane.ERROR_MESSAGE);
	//     }
	// }
}
