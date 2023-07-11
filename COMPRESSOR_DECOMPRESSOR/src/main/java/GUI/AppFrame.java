/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author anoop
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    JLabel greet;
    JLabel intro;
    
    AppFrame(){
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

        greet = new JLabel("Hello,");
        greet.setFont(new Font("SERIF", Font.ITALIC,50));
        greet.setBounds(30, 10, 200, 100);
        intro = new JLabel("Click below to start with your compression/Decompression...");
        intro.setFont(new Font("Courier", Font.PLAIN,20));
        intro.setBounds(75, 125, 750, 100);
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(  245,  300,  200, 40);
        compressButton.addActionListener(this);

        decompressButton = new JButton( "Select file to decompress");
        decompressButton.setBounds( 475,  300, 200, 40);
        decompressButton.addActionListener(this);

        this.add(greet);
        this.add(intro);
        this.add( compressButton);
        this.add( decompressButton);
        
        this.setSize( 950, 500);
        this.setLayout(null);
        this.setTitle("Compressor/Decompressor_Application");
        this.getContentPane().setBackground(Color.cyan);
        this.setVisible( true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response= filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION);
            File file = new File(filechooser.getSelectedFile().getAbsolutePath());
            
            try{
                compressor.method(file);
                JOptionPane.showMessageDialog(null,"Compression Successful.");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.toString());
            }
        }
        
        if(e.getSource() == decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response= filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION);
            File file = new File(filechooser.getSelectedFile().getAbsolutePath());
            
            try{
                decompressor.method(file);
                JOptionPane.showMessageDialog(null,"Decompression Successful.");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.toString());
            }
        }
    }
}
