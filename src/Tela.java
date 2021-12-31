/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 201907300961
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Tela 
{
   private JFrame f;
   private JPanel p;
   private JLabel l1, l2, l3;
   private JTextField t1, t2, t3;
   private JButton cadastrar, listar;  
   private JTextArea a;
           
   public void iniciarTela()
   {
       f = new JFrame();
           p = new JPanel();
           l1 = new JLabel("Nome");
           l2 = new JLabel("Telefone");  
           l3 = new JLabel("Email");
           t1 = new JTextField(10);
           t2 = new JTextField(10);
           t3 = new JTextField(25);
           
           cadastrar = new JButton("Cadastrar");
           
           cadastrar.addActionListener(new ActionListener(){
               
               public void actionPerformed(ActionEvent e){
                   try {
                       FileWriter fw = new FileWriter("agenda.txt");
                       PrintWriter pw = new PrintWriter(fw);
                       pw.append(t1.getText() + "\n" +"\n");
                       pw.append(t2.getText() + "\n" + " ");
                       pw.append(t3.getText() + "\n" + " ");
                       pw.close();
                       fw.close();
                   } catch (IOException ex) {
                       Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  
               }
               
           });
           
           
           listar = new JButton("Consultar");
           
           listar.addActionListener(new ActionListener(){
               
               public void actionPerformed(ActionEvent e){
                   FileReader fr = null;
                   try {
                       fr = new FileReader("agenda.txt");
                       BufferedReader bf = new BufferedReader(fr);
                       String s = null;
                       
                       a.setText("");
                       while((s = bf.readLine())!= null)
                       {
                           a.append(s + "\n");
                       }
                                              
                   } catch (IOException ex) {
                       Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  
               }
               
           });
           
           a = new JTextArea(10, 20);
           
           p.add(l1);
           p.add(t1);
           p.add(l2);
           p.add(t2);           
           p.add(l3);           
           p.add(t3);
           p.add(cadastrar);
           p.add(listar);
           p.add(a);
           
           f.getContentPane().add(p);
           f.setSize(800, 600);
           f.setVisible(true);                                
    }   
   
   public static void main(String[]args)
    {
        Tela t = new Tela();
        t.iniciarTela();
    }

    
   
    
}

    
