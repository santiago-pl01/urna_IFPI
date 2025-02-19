package Novocadastro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

import Elementos.Candidato;
import Elementos.Cargo;
import Elementos.Partido;

public class TelaCadastroCandidato extends TelaGenerica {
    private JLabel textNome;
    private JLabel textID;
    //private JLabel textCargo;
    private JLabel textNumeroVotação;
    private JLabel contador;
    private JTextField campoNome;
    private JTextField campoId;
    private JTextField campoNumero;
    private JButton buttonAdd;
    private JComboBox<String> comboPartidos;
    private JComboBox<String> comboCargos;

    private List<Partido> partidos; // Atributo para armazenar a lista de partidos

    public TelaCadastroCandidato(List<Partido> partidos) {
        super("Cadastro de Candidato", 400, 400, false);
        this.partidos = partidos; // Armazena a lista de partidos
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // Usando layout absoluto para definir posições

        iniciarComponentes(); // Chama o método para inicializar os componentes
    }

    public void iniciarComponentes() {
        // Declaração dos componentes
        textNome = new JLabel("Nome");
        textID = new JLabel("Id");
        //textCargo = new JLabel("Cargo");
        textNumeroVotação = new JLabel("N° vot.");
        contador = new JLabel("Candidatos: 0");
        campoNome = new JTextField();
        campoId = new JTextField();
        campoNumero = new JTextField();
        buttonAdd = new JButton("Adicionar Candidato");

        // Configuração dos componentes
        textNome.setBounds(10, 20, 200, 30);
        campoNome.setBounds(120, 20, 200, 30);
        textID.setBounds(10, 60, 200, 30);
        campoId.setBounds(120, 60, 200, 30);
        textNumeroVotação.setBounds(10, 100, 200, 30);
        campoNumero.setBounds(120, 100, 200, 30);
        buttonAdd.setBounds(120, 250, 200, 30);
        contador.setBounds(10, 200, 200, 30);

        // Adiciona os componentes à tela
        add(textNome);
        add(campoNome);
        add(textID);
        add(campoId);
        add(textNumeroVotação);
        add(campoNumero);
        add(buttonAdd);
        add(contador);

        // JComboBox para selecionar Partido
        comboPartidos = new JComboBox<>();
        for (Partido p : partidos) {
            comboPartidos.addItem(p.getNome());
        }
        comboPartidos.setBounds(120, 140, 200, 30);
        add(comboPartidos);

        // JComboBox para selecionar Cargo
        comboCargos = new JComboBox<>();
        for (Cargo c : Cargo.values()) {
            comboCargos.addItem(c.name());
        }
        comboCargos.setBounds(120, 180, 200, 30);
        add(comboCargos);

        // Adiciona ação ao botão
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comandoBotao();
            }
        });
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
            partidoEscolhido.setCandidato(novoCandidato);

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