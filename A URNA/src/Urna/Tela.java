package Urna;

import java.awt.Color;
import javax.swing.*;

public class Tela extends JFrame {
    private JTextField text;
    private JButton confirmButton;
    private JButton nullButton;
    private JButton blankButton;
    private JButton cancelButton;

    public Tela() {
        setVisible(true); // torna a interface visível
        setSize(700, 700); // define o tamanho da interface
        setTitle("Urna Eletrônica"); // título da interface
        setResizable(false); // não permite que o tamanho da tela seja alterado
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ao fechar a interface o programa se encerra

        getContentPane().setBackground(Color.LIGHT_GRAY); // Define a cor de fundo da janela

        // cria o espaço para digitação
        text = new JTextField();
        text.setBounds(60, 400, 250, 40); // define a posição do campo de texto
        add(text);


        // Adicionando botões numéricos de 1 a 9 e 0
        
        JButton jButton = new JButton("1");// botão 1
        add (jButton);//adciona o butão á tela
        jButton.setBounds(350, 100, 90, 40);// 1-define a posição do botão(da esquerda pra direita), 2- define a altura,3- largura,4-tamanho
        jButton.addActionListener(_ -> text.setText(text.getText() + "1"));// faz com que ao acionar o botão, ele retone o numero 1
       
        JButton jButtonTow = new JButton("2");// botão 2
        add (jButtonTow);
        jButtonTow.setBounds(450, 100, 90, 40);
        jButtonTow.addActionListener(_ -> text.setText(text.getText() +"2"));

        JButton jButtonTree = new JButton("3");// botão 3
        add (jButtonTree);
        jButtonTree.setBounds(550, 100, 90, 40);
        jButtonTree.addActionListener(_ -> text.setText(text.getText() +"3"));

        JButton jButtonFour = new JButton("4");// botão 4
        add (jButtonFour);
        jButtonFour.setBounds(350,150, 90, 40);
        jButtonFour.addActionListener(_ -> text.setText(text.getText() + "4"));

        JButton jButtonFive = new JButton("5");// botão 5
        add (jButtonFive);
        jButtonFive.setBounds(450, 150, 90, 40);
        jButtonFive.addActionListener(_ -> text.setText(text.getText() + "5"));

        JButton jButtonSix = new JButton("6");// botão 6
        add (jButtonSix);
        jButtonSix.setBounds(550, 150, 90, 40);
        jButtonSix.addActionListener(_ -> text.setText(text.getText() + "6"));

        JButton jButtonSeven = new JButton("7");// botão 7
        add (jButtonSeven);
        jButtonSeven.setBounds(350,200, 90, 40);
        jButtonSeven.addActionListener(_ -> text.setText(text.getText() + "7"));

        JButton jButtonHeight = new JButton("8");// botão 8
        add (jButtonHeight);
        jButtonHeight.setBounds(450, 200, 90, 40);
        jButtonHeight.addActionListener(_ -> text.setText(text.getText() + "8"));

        JButton jButtonNine = new JButton("9");// botão 9
        add (jButtonNine);
        jButtonNine.setBounds(550, 200, 90, 40);
        jButtonNine.addActionListener(_ -> text.setText(text.getText() + "9"+ ""));

        JButton buttonZero = new JButton("0");// botão 0
        buttonZero.setBounds(450, 250, 90, 40);
        buttonZero.addActionListener(_ -> text.setText(text.getText() + "0"));
        add(buttonZero);

        // criação dos botões
        confirmButton = new JButton("Confirmar"); // botão confirmar
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.GREEN);
        confirmButton.setBounds(70, 470, 100, 40);
        add(confirmButton); // Adiciona o botão à tela
        
        nullButton = new JButton("Nulo"); // botão nulo
        nullButton.setForeground(Color.black);
        nullButton.setBackground(Color.orange);
        nullButton.setBounds(390, 300, 100, 40);
        add(nullButton); // Adiciona o botão à tela

        blankButton = new JButton("Branco"); // botão branco
        blankButton.setForeground(Color.black);
        blankButton.setBackground(Color.white);
        blankButton.setBounds(500, 300, 100, 40);
        add(blankButton); // Adiciona o botão à tela
        
        cancelButton = new JButton("Cancelar"); // botão cancelar
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.red);
        cancelButton.setBounds(180, 470, 100, 40);
        add(cancelButton); // Adiciona o botão à tela

        // Chama revalidate e repaint após adicionar todos os componentes
        revalidate(); // Atualiza o layout
        repaint(); // Atualiza a tela
    }
    // Métodos para obter os botões
    public JButton getConfirmButton() { // Método para obter o botão confirmar
        return confirmButton;
    }
    public JButton getNullButton() { // Método para obter o botão nulo
        return nullButton;
    }
    public JButton getBlankButton() { // método para obter o botão branco
        return blankButton;
    }
    public JButton getCancelButton() { // Método para obter o botão cancelar
        return cancelButton;
    }
    public String getInputText() { // Método para obter o texto do campo de entrada
        return text.getText();
    }
    public void clearInput() { // Método para limpar o campo de entrada
        text.setText("");
    }
    public void fechar(){
        setVisible(false);
    }
}
