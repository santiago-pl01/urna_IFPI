package cadastroCandidato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Novocadastro.Eleitor;
import Novocadastro.TelaGenerica;

public class TelaCadastroCandidato extends TelaGenerica {
	private JLabel textNome;
	private JLabel textID;
	private JLabel textCargo;
	private JLabel textNumeroVotação;
	private JLabel contador;
	private JTextField campoNome;
	private JTextField campoId;
	private JTextField campoCargo;
	private JButton buttonAdd;
	
	private List<Candidato> candidatos;
	
	Mesario2 mesario2 = new Mesario2();
	
	
	public TelaCadastroCandidato(List<Candidato> candidatos) {
		super("cadastro", 400, 400, false);
		this.candidatos = candidatos;
		
		if (candidatos == null) {
			this.candidatos = new ArrayList<>();
		} else {
			this.candidatos= candidatos;
		}
		
		iniciarComponentes();
		
		
	}
	
	public void iniciarComponentes() {
		//-------------------------------DECLARAR------------------------------------\\
		textNome = new JLabel("Nome");
		textID= new JLabel("Id");
		textCargo= new JLabel("Cargo");
		textNumeroVotação = new JLabel("N° de votação");
		contador= new JLabel("contador");
		campoNome = new JTextField(getName());
		campoId= new JTextField();
		campoCargo= new JTextField();
		buttonAdd = new JButton();
		
		//-------------------------------CONFIGURAR------------------------------------\\	

		textNome.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		textID.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		textCargo.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		textNumeroVotação.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		contador.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		campoNome.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		campoId.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		campoCargo.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		buttonAdd.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
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
			add(buttonAdd);
	}
			
	private void comandoBotao() {
	    String nome = campoNome.getText().trim();
	    String idTexto = campoId.getText().trim();
	    
	    // VERIFICA CAMPOS VAZIOS
	    if (nome.isEmpty() || idTexto.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        int id = Integer.parseInt(idTexto);

	        // VERIFICA SE O ID JÁ EXISTE NA LISTA
	        for (Candidato c : candidatos) {
	            if (c.getId() == id) {
	                JOptionPane.showMessageDialog(this, "ID já cadastrado! Escolha outro.", "Erro", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	        }

	        // ADICIONA NOVO ELEITOR
	        candidatos.add(new Candidato(nome, id, numeroVotacao, cargo));
	        JOptionPane.showMessageDialog(this, "Eleitor cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	        
	        // ATUALIZA O CONTADOR DE ELEITORES
	        contador.setText("Eleitores: " + candidatos.size());
	        
	        //COMO PEGAR UM METADO DE OUTRA CLASSE
	        //Mesario.printEleitor();

	        // LIMPA OS CAMPOS
	        campoNome.setText("");
	        campoId.setText("");

	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "O ID deve ser um número inteiro válido!", "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}

		
	}

