package Urna;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Tela extends JFrame {
	

	public Tela () {
		setVisible(true); // torna a interface visivel
		setSize(700, 700);// define o tamanho da interface
		setTitle("Urna Eletronica"); // titulo da interface
		setResizable(false);// não permite que o tamanho da tela seja alterdao
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ao fechar a interface o programa se encerra 
		
		
		
		
		// cria o espaço para digitação
		JTextField text = new JTextField();
		text.setBounds(60, 400, 250, 40);// 1-define a posição do botão(da esquerda pra direita), 2- define a altura,3- largura,4-tamanho
		add(text);
		
		// criação dos botões
		JButton jButton = new JButton("1");// cria o botão
		add (jButton);//adciona o butão á tela
		jButton.setBounds(350, 100, 90, 40);// 1-define a posição do botão(da esquerda pra direita), 2- define a altura,3- largura,4-tamanho
		jButton.addActionListener(e -> text.setText(text.getText() + "1"));// faz com que ao acionar o botão, ele retone o numero 1


		JButton jButtonTow = new JButton("2");// botão 2
		add (jButtonTow);
		jButtonTow.setBounds(450, 100, 90, 40);
		jButtonTow.addActionListener(e -> text.setText(text.getText() +"2"));
		
		JButton jButtonTree = new JButton("3");// botão 3
		add (jButtonTree);
		jButtonTree.setBounds(550, 100, 90, 40);
		jButtonTree.addActionListener(e -> text.setText(text.getText() +"3"));
		
		JButton jButtonFour = new JButton("4");// botão 4
		add (jButtonFour);
		jButtonFour.setBounds(350,150, 90, 40);
		jButtonFour.addActionListener(e -> text.setText(text.getText() + "4"));
		
		JButton jButtonFive = new JButton("5");// botão 5
		add (jButtonFive);
		jButtonFive.setBounds(450, 150, 90, 40);
		jButtonFive.addActionListener(e -> text.setText(text.getText() + "5"));
		
		
		JButton jButtonSix = new JButton("6");// botão 6
		add (jButtonSix);
		jButtonSix.setBounds(550, 150, 90, 40);
		jButtonSix.addActionListener(e -> text.setText(text.getText() + "6"));
		
		JButton jButtonSeven = new JButton("7");// botão 7
		add (jButtonSeven);
		jButtonSeven.setBounds(350,200, 90, 40);
		jButtonSeven.addActionListener(e -> text.setText(text.getText() + "7"));
		
		JButton jButtonHeight = new JButton("8");// botão 8
		add (jButtonHeight);
		jButtonHeight.setBounds(450, 200, 90, 40);
		jButtonHeight.addActionListener(e -> text.setText(text.getText() + "8"));
		
		JButton jButtonNine = new JButton("9");// botão 9
		add (jButtonNine);
		jButtonNine.setBounds(550, 200, 90, 40);
		jButtonNine.addActionListener(e -> text.setText(text.getText() + "9"+ ""));
		
		JButton jButtonzero= new JButton("0");
		add(jButtonzero);
		jButtonzero.setBounds(450,250,90,40);
		jButtonNine.addActionListener(e -> text.setText(text.getText() + "0"+ ""));
		
		JButton jButtonNull = new JButton("Nulo");// botão nulo
		add (jButtonNull);
		jButtonNull.setForeground(Color.black);// define a cor da fonte
		jButtonNull.setBackground(Color.orange);// define a cor  de fundo
		jButtonNull.setBounds(370, 300, 100, 40);
		
		JButton jButtonBranco = new JButton("Branco");// botão branco
		add (jButtonBranco);
		jButtonBranco.setForeground(Color.black);
		jButtonBranco.setBackground(Color.white);
		jButtonBranco.setBounds(480, 300, 100, 40);
		
		JButton jButtonConfirmar = new JButton("Confirmar"); // botão confirmar
		add (jButtonConfirmar);
		jButtonConfirmar.setForeground(Color.white);
		jButtonConfirmar.setBackground(Color.GREEN);
		jButtonConfirmar.setBounds(70, 470, 100, 40);
		
		JButton jButtonCancelar = new JButton("cancelar");// botão cancelar
		add (jButtonCancelar);
		jButtonCancelar.setForeground(Color.white);
		jButtonCancelar.setBackground(Color.red);
		jButtonCancelar.setBounds(180, 470, 100, 40);
		jButtonCancelar.addActionListener(e -> text.setText(""));
		
		
		
	}

		


}
