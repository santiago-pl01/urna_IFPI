package Novocadastro;

import java.awt.Color;
import javax.swing.*;

public class TelaUrna extends JFrame {
    private JTextField text;
    private JButton confirmButton;
    private JButton nullButton;
    private JButton blankButton;
    private JButton cancelButton;

    public TelaUrna() {
    	
    	setVisible(true); // torna a interface visível
        setSize(700, 700); // define o tamanho da interface
        setTitle("Urna Eletrônica"); // título da interface
        setResizable(false); // não permite que o tamanho da tela seja alterado
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ao fechar a interface o programa se encerra
        //iniciarCompontente();
        getContentPane().setBackground(Color.LIGHT_GRAY); // Define a cor de fundo da janela

    	
    
		//-------------------------------DECLARAR------------------------------------\\
    	  JButton jButton = new JButton("1");
    	  JButton jButtonTow = new JButton("2");
    	  JButton jButtonTree = new JButton("3");
    	  JButton jButtonFour = new JButton("4");
    	  JButton jButtonFive = new JButton("5");
          JButton jButtonSix = new JButton("6");
          JButton jButtonSeven = new JButton("7");
          JButton jButtonHeight = new JButton("8");
          JButton jButtonNine = new JButton("9");
          JButton buttonZero = new JButton("0");
          confirmButton = new JButton("Confirmar");
          nullButton = new JButton("Nulo");
    	  blankButton = new JButton("Branco"); 
    	  cancelButton = new JButton("Cancelar");
    	  text = new JTextField();
    	  
    	//-------------------------------CONFIGURAR------------------------------------\\
    	  jButton.setBounds(350, 100, 90, 40);//1
          jButtonTow.setBounds(450, 100, 90, 40);//2
      	  jButtonTree.setBounds(550, 100, 90, 40);//3
      	  jButtonFour.setBounds(350,150, 90, 40);//4
      	  jButtonFive.setBounds(450, 150, 90, 40);//5
      	  jButtonSix.setBounds(550, 150, 90, 40);//6
      	  jButtonSeven.setBounds(350,200, 90, 40);//7
       	  jButtonHeight.setBounds(450, 200, 90, 40);//8
      	  jButtonNine.setBounds(550, 200, 90, 40);//9
      	  buttonZero.setBounds(450, 250, 90, 40);
        confirmButton.setBounds(70, 470, 100, 40);
        nullButton.setBounds(390, 300, 100, 40);
        blankButton.setBounds(500, 300, 100, 40);
        cancelButton.setBounds(180, 470, 100, 40);
        text.setBounds(60, 400, 250, 40);
        
        
        //-------------------------------CORES------------------------------------\\     	  
      	  
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.GREEN);
        
        nullButton.setForeground(Color.black);
        nullButton.setBackground(Color.orange);
        
        blankButton.setForeground(Color.black);
        blankButton.setBackground(Color.white);
        
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.red);
      	  
      	//-------------------------------CONFIGURAR CAMPO------------------------------------\\
    	  jButton.addActionListener(_ -> text.setText(text.getText() + "1"));
    	  jButtonTow.addActionListener(_ -> text.setText(text.getText() +"2"));
    	  jButtonTree.addActionListener(_ -> text.setText(text.getText() +"3"));
    	  jButtonFour.addActionListener(_ -> text.setText(text.getText() + "4"));
    	  jButtonFive.addActionListener(_ -> text.setText(text.getText() + "5"));
    	  jButtonSix.addActionListener(_ -> text.setText(text.getText() + "6"));
    	  jButtonSeven.addActionListener(_ -> text.setText(text.getText() + "7"));
    	  jButtonHeight.addActionListener(_ -> text.setText(text.getText() + "8"));
    	  jButtonNine.addActionListener(_ -> text.setText(text.getText() + "9"+ ""));
    	  buttonZero.addActionListener(_ -> text.setText(text.getText() + "0"));
    	  
    	  
    	  
    	  
    	//-------------------------------ADICIONAR------------------------------------\\
    	  add (jButton); 
    	  add (jButtonTow);
    	  add (jButtonTree);
    	  add (jButtonFour);
    	  add (jButtonFive);
    	  add (jButtonSix);
    	  add (jButtonSeven);
    	  add (jButtonHeight);
    	  add (jButtonNine);       
    	  add(buttonZero);
    	  add(confirmButton); 
    	  add(nullButton);
    	  add(blankButton);
    	  add(cancelButton);
    	  add(text);
 
        getContentPane().setBackground(Color.LIGHT_GRAY); // Define a cor de fundo da janela
      
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
