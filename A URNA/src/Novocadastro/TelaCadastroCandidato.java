package Novocadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Elementos.Candidato;
import Elementos.Cargo;
import Elementos.Partido;
import Urna.Eleicao;

public class TelaCadastroCandidato extends TelaGenerica {
	private JLabel textNome;
	private JLabel textID;
	private JLabel textCargo;
	private JLabel textNumeroVotação;
	private JLabel contador;
	private JTextField campoNome;
	private JTextField campoId;
	private JTextField campoCargo;
	private JTextField campoNumero;
	private JButton buttonAdd;
	private JComboBox<String> comboPartidos;
	private JComboBox<String> comboCargos;

	
	private List<Partido> partidos = new ArrayList<>();

	
	
	
	public TelaCadastroCandidato() {
		// DECLARAÇÃO DA CONFIGURAÇÃO DA TELA
		super("cadastro", 400, 400, false);
		
		// PERMITE QUE P CODIGO CONTINUE ATIVO, MESMO COM A CLASSE  FECHADA 	
	     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	

	
	public void iniciarComponentes() {
		//-------------------------------DECLARAR------------------------------------\\
		textNome = new JLabel("Nome");
		textID= new JLabel("Id");
		textCargo= new JLabel("Cargo");
		textNumeroVotação = new JLabel("N° vot.");
		contador= new JLabel("contador");
		campoNome = new JTextField(getName());
		campoId= new JTextField();
		campoCargo= new JTextField();
		campoNumero = new JTextField();
		buttonAdd = new JButton("adicionar candidato");
		
		//-------------------------------CONFIGURAR------------------------------------\\	

		textNome.setBounds(10, 20, 200, 50);
		textID.setBounds(10, 50, 200, 50);
		textCargo.setBounds(10, 85, 200, 50);
		textNumeroVotação.setBounds(10, 110, 200, 50);
		contador.setBounds(10, 150, 200, 60);
		campoNome.setBounds(50, 30, 200, 30);
		campoId.setBounds(50, 60, 200, 30);
		campoCargo.setBounds(50, 90, 200, 30);
		campoNumero.setBounds(50, 120, 200,30);
		buttonAdd.setBounds(100, 250, 140, 50);
		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comandoBotao();
			}
		});
		
		//-------------------------------ADICIONAR------------------------------------\\
			add(textNome);
			add(textID);
			add(textCargo);
			add(textNumeroVotação);
			add(contador);
			add(campoNome);
			add(campoId);
			add(campoCargo);
			add(campoNumero);
			add(buttonAdd);
			
			
			
			// JComboBox para selecionar Partido
			comboPartidos = new JComboBox<>();
			for (Partido p : partidos) { 
			    comboPartidos.addItem(p.getNome()); 
			}
			comboPartidos.setBounds(50, 170, 200, 30);
			add(comboPartidos);

			// JComboBox para selecionar Cargo
			comboCargos = new JComboBox<>();
			for (Cargo c : Cargo.values()) { 
			    comboCargos.addItem(c.name()); 
			}
			comboCargos.setBounds(50, 210, 200, 30);
			add(comboCargos);

	}

	
	
	private void comandoBotao() {
	    String nome = campoNome.getText().trim();
	    String numeroTexto = campoNumero.getText().trim();

	    // Verifica se os campos estão preenchidos
	    if (nome.isEmpty() || numeroTexto.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        int numeroCandidato = Integer.parseInt(numeroTexto);

	        // Pega o partido selecionado no JComboBox
	        String nomePartidoSelecionado = (String) comboPartidos.getSelectedItem();
	        Partido partidoEscolhido = null;
	        for (Partido p : partidos) {
	            if (p.getNome().equals(nomePartidoSelecionado)) {
	                partidoEscolhido = p;
	                break;
	            }
	        }

	        if (partidoEscolhido == null) {
	            JOptionPane.showMessageDialog(this, "Erro ao selecionar partido!", "Erro", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Pega o cargo selecionado no JComboBox
	        String cargoSelecionado = (String) comboCargos.getSelectedItem();
	        Cargo cargo = Cargo.valueOf(cargoSelecionado);

	        // Criar o candidato
	        Candidato novoCandidato = new Candidato(nome, numeroCandidato, partidoEscolhido, cargo);
	        partidoEscolhido.addCandidato(novoCandidato);

	        JOptionPane.showMessageDialog(this, "Candidato cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

	        // Atualizar o contador de candidatos
	        contador.setText("Candidatos: " + partidoEscolhido.getCandidatos().size());

	        // Limpar os campos
	        campoNome.setText("");
	        campoNumero.setText("");

	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "O número do candidato deve ser um número inteiro válido!", "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}

	

}
