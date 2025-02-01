package Urna;

import Elementos.Candidato;
import Elementos.Partido;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class Urna {
    private Eleicao eleicao;
    private Tela tela;

    public Urna(List<Partido> partidos) { // Recebe a lista de partidos
        this.eleicao = new Eleicao(partidos); // Cria a eleição
        this.tela = new Tela(); // Cria a tela

        setupCloseAction(); // Configuração para exibir resultados ao fechar a tela
        initialize(); // Inicia a tela
    }

    private void setupCloseAction() {
        tela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exibirResultados(); // Chama o método para exibir os resultados
                tela.dispose(); // Fecha a janela
            }
        });
    }

    private void initialize() {
        setupButtonActions(); // Configura as ações dos botões
    }

    private void setupButtonActions() { // Configura as ações dos botões
        JButton confirmButton = tela.getConfirmButton(); // Obtém o botão confirmar
        JButton nullButton = tela.getNullButton(); // Obtém o botão nulo
        JButton blankButton = tela.getBlankButton(); // Obtém o botão em branco
        JButton cancelButton = tela.getCancelButton(); // Obtém o botão cancelar

        confirmButton.addActionListener(_ -> handleVote()); // Adiciona ação ao botão confirmar
        nullButton.addActionListener(_ -> handleNullVote()); // Adiciona ação ao botão nulo
        blankButton.addActionListener(_ -> handleBlankVote()); // Adiciona ação ao botão em branco
        cancelButton.addActionListener(_ -> tela.clearInput()); // Limpa o campo de texto ao cancelar
    }

    private void handleVote() {
        String input = tela.getInputText(); // Obtém a entrada do campo de texto
        try {
            int numeroCandidato = Integer.parseInt(input); // Converte a entrada para um número
            Candidato candidato = eleicao.getCandidato(numeroCandidato); // Obtém o candidato com o número
            if (candidato != null) { // Verifica se o candidato foi encontrado
                eleicao.adicionarVoto(candidato); // Adiciona o voto ao candidato
                JOptionPane.showMessageDialog(tela, "Voto registrado para " + candidato.getNome());
            } else {
                JOptionPane.showMessageDialog(tela, "Candidato não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(tela, "Número inválido. Tente novamente.");
        }
        tela.clearInput(); // Limpa o campo de entrada após a votação
    }

    private void handleNullVote() { // Trata a votação nulo
        eleicao.addVotoNulo(); // Adiciona um voto nulo
        JOptionPane.showMessageDialog(tela, "Voto nulo registrado.");
        tela.clearInput(); // Limpa o campo de entrada
    }

    private void handleBlankVote() { // Trata a votação em branco
        eleicao.addVotoEmBranco(); // Adiciona um voto em branco
        JOptionPane.showMessageDialog(tela, "Voto em branco registrado.");
        tela.clearInput(); // Limpa o campo de entrada
    }

    public void exibirResultados() { // Exibe os resultados
        eleicao.exibirResultados();
    }
}
