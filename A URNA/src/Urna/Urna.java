package Urna;

import Elementos.Candidato;
import Elementos.Cargo;
import Elementos.Partido;
//import Elementos.Eleitor; // Importa a classe Eleitor nao usada.
import Elementos.Mesario;
import Novocadastro.TelaCadastroCandidato;
import Novocadastro.TelaCadastroEleitor;
import Novocadastro.TelaOpcoes;
import Novocadastro.TelaUrna;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class Urna {
    private List<Partido> partidos;
    private TelaOpcoes telaOpcoes;
    private TelaUrna telaUrna;
    private Eleicao eleicao;
    private Mesario mesario;
    //private TelaCadastroEleitor telaCadastroEleitor;

    // Construtor da Urna com a lista de partidos como argumento.
    public Urna(List<Partido> partidos) {
        this.partidos = partidos;
        this.eleicao = new Eleicao(partidos);
        this.mesario = new Mesario(); // Inicializa o mesário.
        this.telaOpcoes = new TelaOpcoes();
        setupTelaOpcoes();
    }

    // Esse é o metodo que cria a tela de opções e configura os listeners.
    private void setupTelaOpcoes() {
        telaOpcoes.setVisible(true);
        telaOpcoes.setAdicionarEleitorListener(_ -> abrirTelaCadastroEleitor());
        telaOpcoes.setAdicionarCandidatoListener(_ -> abrirTelaCadastroCandidato());
        telaOpcoes.setIniciarEleicaoListener(_ -> iniciarEleicao());
    }

    // Esse metodo abre a tela de cadastro de eleitores e configura o listener. Nela esta a logica para adicionar eleitores.
    private void abrirTelaCadastroEleitor() {
        TelaCadastroEleitor telaCadastroEleitor = new TelaCadastroEleitor(); // Cria uma nova tela de cadastro de eleitores.
        telaCadastroEleitor.setAdicionarEleitorListener(_ -> { // Configura o listener para adicionar eleitores.
            String nome = telaCadastroEleitor.getNome(); // Metodo para obter o nome.
            String idTexto = telaCadastroEleitor.getId(); // Metodo para obter o ID.
            try {
                int id = Integer.parseInt(idTexto); // Converte o ID para inteiro.
                if (mesario.getEleitorByID(id) != null) { // Verifica se o ID ja foi cadastrado e mostra uma mensagem de erro caso seja verdadeiro.
                    JOptionPane.showMessageDialog(telaCadastroEleitor, "ID já cadastrado! Escolha outro.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    mesario.addEleitor(nome, id); // Adiciona o eleitor ao mesario caso seja falso.
                    telaCadastroEleitor.setContador(mesario.contarEleitores()); // Atualiza a quantidade de eleitores na tela de mostra uma mensagem de sucesso.
                    JOptionPane.showMessageDialog(telaCadastroEleitor, "Eleitor cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    telaCadastroEleitor.clearInput(); // Limpa o campo de entrada
                }
            } catch (NumberFormatException ex) { // Caso o ID nao seja um numero inteiro mostra uma mensagem de erro.
                JOptionPane.showMessageDialog(telaCadastroEleitor, "O ID deve ser um número inteiro válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        telaCadastroEleitor.setVisible(true); // A tela de cadastro de eleitores fica visivel.
    }

    private void abrirTelaCadastroCandidato() { 
    TelaCadastroCandidato telaCadastroCandidato = new TelaCadastroCandidato(partidos); // Cria uma nova tela de cadastro de candidatos.
    telaCadastroCandidato.setAdicionarCandidatoListener(_ -> { // Configura o listener para adicionar candidatos.
        String nome = telaCadastroCandidato.getNome(); // Método para obter o nome.
        String numeroTexto = telaCadastroCandidato.getNumero(); // Método para obter o número.
        String partidoSelecionado = telaCadastroCandidato.getPartidoSelecionado(); // Método para obter o partido.
        String cargoSelecionado = telaCadastroCandidato.getCargoSelecionado(); // Método para obter o cargo.

        // Verifica se os campos estão preenchidos usando isEmpty, e mostra uma mensagem de erro caso algum seja vazio.
        if (nome.isEmpty() || numeroTexto.isEmpty() || partidoSelecionado == null || cargoSelecionado == null) {
            JOptionPane.showMessageDialog(telaCadastroCandidato, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int numeroCandidato = Integer.parseInt(numeroTexto); // Converte o número para inteiro.
            // Aqui você deve verificar se o número do candidato já existe e adicionar o candidato.
            Partido partidoEscolhido = null; // Variável para armazenar o partido escolhido.
            for (Partido p : partidos) { // Percorre a lista de partidos para encontrar o partido escolhido.
                if (p.getNome().equals(partidoSelecionado)) { // Trocado == para equals assim fazendo a verificação de igualdade.
                    partidoEscolhido = p; // Armazena o partido escolhido.
                    break;
                }
            }
            if (partidoEscolhido != null) { // Verifica se o partido foi encontrado e mostra uma mensagem de erro caso seja nulo.

                if (partidoEscolhido.candidatoExistente(numeroCandidato)) { // Verifica se o partido ja possui um candidato cadastrado e mostra uma mensagem de erro caso seja verdadeiro.
                    JOptionPane.showMessageDialog(telaCadastroCandidato, "Partido ja possui um candidato cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Cargo cargo = Cargo.valueOf(cargoSelecionado); // Converte o cargo selecionado para o enum Cargo usando o mêtodo valueOf().
                Candidato novoCandidato = new Candidato(nome, numeroCandidato, partidoEscolhido, cargo); // Cria um novo candidato com os dados fornecidos.
                partidoEscolhido.setCandidato(novoCandidato); // Adiciona o novo candidato ao partido escolhido e mostra uma mensagem de sucesso.
                JOptionPane.showMessageDialog(telaCadastroCandidato, "Candidato cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                telaCadastroCandidato.setContador(partidoEscolhido.contarCandidatos()); // Atualiza a quantidade de candidatos na tela.
                // Limpar os campos após o cadastro
                telaCadastroCandidato.clearInput(); // Método para limpar os campos.
            } else {
                JOptionPane.showMessageDialog(telaCadastroCandidato, "Partido não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) { // Caso o número nao seja um numero inteiro mostra uma mensagem de erro.
            JOptionPane.showMessageDialog(telaCadastroCandidato, "O número do candidato deve ser um número inteiro válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    });
    telaCadastroCandidato.setVisible(true); // A tela de cadastro de candidatos fica visivel.
    }

    // Metodo para iniciar a eleicao abrindo a tela de votacao e fechando a tela de opcoes.
    private void iniciarEleicao() { // Inicia a eleição.
        telaOpcoes.setVisible(false); // Fecha a tela de opções.
        telaUrna = new TelaUrna(); // Cria uma nova tela de votação.
        setupTelaUrna(); // Configura a tela de votação com os listeners.
        telaUrna.setVisible(true); // Abre a tela de votação.
    }

    // Metodo para configurar a tela de votacao com os listeners.
    private void setupTelaUrna() {
        telaUrna.getConfirmButton().addActionListener(_ -> processarVoto()); // Adiciona um listener para o botão confirmar.
        telaUrna.getBlankButton().addActionListener(_ -> { // Adiciona um listener para o botão branco.
            eleicao.addVotoEmBranco(); // Adiciona um voto em branco na eleição e mostra uma mensagem.
            JOptionPane.showMessageDialog(telaUrna, "Voto em branco registrado."); 
            telaUrna.clearInput(); // Limpa o campo de entrada.
        });
        telaUrna.getCancelButton().addActionListener(_ -> { // Adiciona um listener para o botão cancelar.
           telaUrna.clearInput(); // Limpa o campo de entrada.
        });

        // Adiciona um listener para quando a tela de votação for fechada.
        telaUrna.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // Quando a tela de votação for fechada exibe os resultados.
                exibirResultados(); // Exibe os resultados da eleição
                telaUrna.dispose(); // Fecha a tela de votação
            }
        });
    }

    // Metodo para processar o voto.
    private void processarVoto() {
        String input = telaUrna.getInputText(); // Obtem o texto do campo de entrada.
        try {
            int numeroCandidato = Integer.parseInt(input); // Converte o texto para um número inteiro.
            Candidato candidato = eleicao.getCandidato(numeroCandidato); // Busca o candidato pelo número.
            if (candidato != null) { // Verifica se o candidato foi encontrado.
                eleicao.adicionarVoto(candidato); // Adiciona o voto ao candidato e mostra uma mensagem de sucesso.
                JOptionPane.showMessageDialog(telaUrna, "Voto registrado para " + candidato.getNome());
            } else {
                JOptionPane.showMessageDialog(telaUrna, "Candidato não encontrado."); // Caso o candidato nao seja encontrado mostra uma mensagem de erro.
            }
        } catch (NumberFormatException e) { // Caso o texto nao seja um numero inteiro mostra uma mensagem de erro.
            JOptionPane.showMessageDialog(telaUrna, "Número inválido. Tente novamente.");
        }
        telaUrna.clearInput(); // Limpa o campo de entrada após a votação
    }

    private void exibirResultados() {
        eleicao.exibirResultados(); // Exibe os resultados da eleição
    }
}