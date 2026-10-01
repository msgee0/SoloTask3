/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package solotask3;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List; 
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Panel; 
import java.awt.Scrollbar;
import java.awt.TextArea; 
import java.awt.TextField; 
import java.awt.Choice;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BellaRegistration extends Frame implements ActionListener {
 
    TextField nameField; 
    Choice levelChoice;
    Checkbox soprano, mezzo, alto, tenor, bass;
    TextArea notes;
    Button registerbut, clearbut, exitbut;
    List songList;
    
    public BellaRegistration(){
        setTitle("Barden Bella Choir Registration");
        setSize(800,600);
        setResizable(true);
        
        Label title = new Label ("Barden Bella Registration", Label.CENTER);
        title.setFont(new Font("Serif", Font.BOLD,24));
        title.setForeground(Color.YELLOW);
        title.setBackground(Color.BLACK);
        title.setBounds(10,40,800,40);
        add(title);
        
        int sideX = 20 , sideY = 100;
        registerbut = new Button ("Register");
        registerbut.setFont(new Font("Serif", Font.BOLD,16));
        registerbut.setBounds(sideX, sideY, 100, 30);
        add (registerbut); 
        
        clearbut = new Button ("Clear");
        clearbut.setFont(new Font("Serif", Font.BOLD,16));
        clearbut.setBounds(sideX, sideY + 40, 100, 30);
        add (clearbut);
        
        Label vpLabel = new Label ("Voice Parts: ");
        vpLabel.setFont(new Font("Serif", Font.PLAIN,14));
        vpLabel.setBounds (sideX, sideY + 90, 100, 20);
        add(vpLabel);
        
        soprano = new Checkbox ("Soprano");
        mezzo = new Checkbox ("Mezzo");
        alto = new Checkbox ("Alto");
        tenor = new Checkbox ("Tenor");
        bass = new Checkbox ("Bass"); 
        
        soprano.setBounds(sideX, sideY + 120, 100, 20);
        mezzo.setBounds(sideX, sideY + 145, 100, 20); 
        alto.setBounds(sideX, sideY + 170, 100, 20);
        tenor.setBounds(sideX, sideY + 195, 100, 20);
        bass.setBounds(sideX, sideY + 215, 100, 20); 
        
        add(soprano);
        add(mezzo);
        add(alto);
        add(tenor);
        add(bass);
        
        exitbut = new Button("Exit");
        exitbut.setBounds(sideX, sideY + 250, 100, 30);
        add(exitbut);
        
        int labelX = 170, fieldX = 300, y = 100;
        
        Label nameL = new Label ("Student Name: ");
        nameL.setFont(new Font("Serif", Font.PLAIN, 14));
        nameL.setBounds(labelX, y, 130, 25);
        add(nameL);
        
        nameField = new TextField(20);
        nameField.setBounds(fieldX, y, 200, 25);
        add(nameField);
        
        y+= 40;
        Label levelL = new Label ("Student Level: ");
        levelL.setFont(new Font("Serif", Font.PLAIN, 14));
        levelL.setBounds(labelX, y, 130, 25);
        add(levelL);
        
        levelChoice = new Choice();
        levelChoice.add("Junior Level");
        levelChoice.add("Senior Level");
        levelChoice.add("Graduate");
        levelChoice.setBounds(fieldX, y, 200, 25);
        add(levelChoice);
        
        int songX= 170, songY = 200;
        Label songs = new Label ("Songs to be Used:");
        songs.setFont(new Font("Serif", Font.BOLD, 16));
        songs.setBounds(songX,songY, 200, 25);
        add(songs); 
        
        songList = new List (); 
        songList.add("Hail Holy Queen");
        songList.add("Sing a New Song");
        songList.add("Anima Christi");
        songList.add("Panis Angelicus");
        songList.add("Gloria"); 
        songList.add("Riff-Off");
        songList.add("Random"); 
        songList.setFont(new Font("Serif", Font.ITALIC, 15));
        songList.setBounds(songX, songY + 30, 200, 100);
        add(songList);
        
        int notesX = 160, notesY = 350;
        notes = new TextArea ("Registered Members\n", 5, 40);
        notes.setFont(new Font("Serif", Font.PLAIN, 14)); 
        notes.setBounds(notesX,notesY, 400, 120);
        add(notes); 
        
        Label blankSpace = new Label ("");
        blankSpace.setBounds(notesX, notesY + 130, 400,20);
        add(blankSpace);
        
        registerbut.addActionListener(this);
        clearbut.addActionListener(this);
        exitbut.addActionListener(e -> System.exit(0));
        
        addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                   System.exit(0);
               }
   
    });
        
        setVisible(true);
}
    @Override 

public void actionPerformed(ActionEvent e) {
    if(registerbut == e.getSource()) {
        StringBuilder sb = new StringBuilder(); 
        sb.append("Student Name: ").append(nameField.getText()).append("\n");
        sb.append("Student Level: ").append(levelChoice.getSelectedItem()).append("\n");
        sb.append("Songs to be Used (Select one): ").append(songList.getSelectedItem()).append("\n");
        sb.append("Voice Parts: ");
        if (soprano.getState()) sb.append("Soprano ");
        if (mezzo.getState()) sb.append("Mezzo ");
        if (alto.getState()) sb.append("Alto ");
        if (tenor.getState()) sb.append("Tenor ");
        if (bass.getState()) sb.append("Bass ");
        sb.append("\n\n");
        
        notes.append(sb.toString());
      
    } else if (clearbut == e.getSource()) {
        nameField.setText("");
        levelChoice.select(0);
        songList.deselect(songList.getSelectedIndex());
        soprano.setState(false);
        mezzo.setState(false);
        alto.setState(false);
        tenor.setState(false);
        bass.setState(false);
        notes.setText("Registered Members \n");
    }
}

public static void main (String[]args){
 new BellaRegistration() {};

}
}

