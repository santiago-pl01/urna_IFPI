package Novocadastro;
// import java.awt.event.ActionEvent; // Importa a classe ActionEvent nao usada
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
		
		

		// Fiz algumas alterações, com relação aos botoes, pois da forma antiga ela criavam uma Janela, mas Urna faz isso, e ficava duas Janelas.
		// Abaixo esta como era antes

		// cadastroEleitor.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		TelaCadastroEleitor telaCadastroEleitor = new TelaCadastroEleitor(null);
		// 		telaCadastroEleitor.setVisible(false);
		// 		// ComandoBotaoEleitor();
		// 	}
		// });



		// Agora esses botoes estao ligados ao botao da Urna que cria as telas.
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
	
	// public void ComandoBotaoEleitor() {
		
	// }
	
    // public void ComandoBotaoCandidato() {
		
	// }
    
    // public void ComandoBotaoEleicao() {
		
	// }
}
