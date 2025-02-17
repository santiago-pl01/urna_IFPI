package Novocadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaOpcoes extends TelaGenerica {
	
	private JButton cadastroEleitor;
	private JButton cadastroCandidato;
	private JButton iniciarEleição;
	
	
	public TelaOpcoes() {
		super("opções", 500, 500, false);
		
		iniciarComponetes();		
	}
	
	public void iniciarComponetes() {
		
		cadastroEleitor = new JButton("Add eleitor");
		cadastroCandidato = new JButton("add candidato");
		iniciarEleição = new JButton("iniciar eleição");
		
		cadastroEleitor.setBounds(10, 200, 200, 30);
		cadastroCandidato.setBounds(10, 300, 200, 30);
		iniciarEleição.setBounds(10, 400, 200, 30);
		
		
		cadastroEleitor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroEleitor().setVisible(true);
				ComandoBotaoEleitor();
			}
		});
		
		cadastroCandidato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new TelaCadastroCandidato().setVisible(true);
				ComandoBotaoCandidato();
			}
		});
		
		iniciarEleição.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaUrna().setVisible(true);
	
				ComandoBotaoEleicao();
			}
		});
		
		
		add(cadastroEleitor);
		add(cadastroCandidato);
		add(iniciarEleição);
		
	}
	
	public void ComandoBotaoEleitor() {
		
	}
	
    public void ComandoBotaoCandidato() {
		
	}
    
    public void ComandoBotaoEleicao() {
		
	}
	
	
	

}
