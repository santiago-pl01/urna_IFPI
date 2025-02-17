package Novocadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
	
	private List<Partido> partidos;
	
	
	
	public TelaCadastroCandidato() {
		super("cadastro", 400, 400, false);
		
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
	}
			
	private void comandoBotao() {
		
		
	    String nome = campoNome.getText().trim();
	    String idTexto = campoCargo.getText().trim();
	    
	    // VERIFICA CAMPOS VAZIOS
	    if (nome.isEmpty() || idTexto.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        int numeroCandidato = Integer.parseInt(idTexto);

	         //VERIFICA SE O ID JÁ EXISTE NA LISTA
	        for (Partido c : partidos) {
	            if (Eleicao.getCandidato()) == numeroCandidato) {
	                JOptionPane.showMessageDialog(this, "NUMERO  já cadastrado! Escolha outro.", "Erro", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            
	        }

	        // ADICIONA NOVO ELEITOR
//	        candidatos.add(new Candidato(nome, id, numeroVotacao, cargo));
//	        JOptionPane.showMessageDialog(this, "Eleitor cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	        
	        // ATUALIZA O CONTADOR DE ELEITORES
	        contador.setText("Candidatos: " + partidos.size());
	        
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

