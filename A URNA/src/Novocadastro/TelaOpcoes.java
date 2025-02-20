package Novocadastro;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaOpcoes extends TelaGenerica {
	
	private JButton cadastroEleitor;
	private JButton cadastroCandidato;
	private JButton iniciarEleição;

	private ActionListener adicionarEleitorListener;
	private ActionListener adicionarCandidatoListener;
	private ActionListener iniciarEleicaoListener;
	
	
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


		cadastroEleitor.addActionListener(e -> {
            if (adicionarEleitorListener != null) {
                adicionarEleitorListener.actionPerformed(e);
            }
        });

		cadastroCandidato.addActionListener(e -> {
            if (adicionarCandidatoListener != null) {
                adicionarCandidatoListener.actionPerformed(e);
            }
        });
		
		iniciarEleição.addActionListener(e -> {
            if (iniciarEleicaoListener != null) {
                iniciarEleicaoListener.actionPerformed(e);
            }
        });
		
		
		add(cadastroEleitor);
		add(cadastroCandidato);
		add(iniciarEleição);
	}

	public void setAdicionarEleitorListener(ActionListener listener) {
		this.adicionarEleitorListener = listener;
	}

	public void setAdicionarCandidatoListener(ActionListener listener) {
		this.adicionarCandidatoListener = listener;
	}

	public void setIniciarEleicaoListener(ActionListener listener) {
		this.iniciarEleicaoListener = listener;
	}
	
}
