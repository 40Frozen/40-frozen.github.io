import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.io.*;

public class Quiz extends Applet implements ActionListener{
 private Button startButton;
 private Button [] antwort=new Button[5];
 private Label Frage;
 private Label Uberschrift;
 private Label [] text=new Label[4];
 private int i=0;
 private int korrekt=0;
 private int help=0;
 private int zahl;
 boolean bool=true;
 private Color Whine=new Color(212,0,0);

 Fragen fragerei=new Fragen();
 public void init() {

    setLayout(null);
    setBackground(Color.black);
    startButton=new Button("Ich will mein Wissen über die 3 geilen Typen beweisen!");
    startButton.setBounds(50,320,400,25);
    startButton.setForeground(Color.black);
    startButton.setBackground(Color.lightGray);
    add(startButton);
    Uberschrift=new Label("Das 40 Frozen Quiz");
    Uberschrift.setFont (new Font ("Verdana", Font.BOLD, 42));
    Uberschrift.setBounds(10,40,480,50);
    Uberschrift.setForeground(Whine);
    Uberschrift.setBackground(Color.black);
    Uberschrift.setAlignment(Label.CENTER);
    add(Uberschrift);
    text[0]=new Label("Hi Leute, was ihr hier gefunden habt, wird euch begeistern!");
    text[1]=new Label("Nicht nur, dass ihr hier euer Wissen über 40 Frozen präsentieren könnt,");
    text[2]=new Label("nein, ihr könnt auch neues Wissen hinzuerlangen.");
    text[3]=new Label("Alles, was ihr tun müsst, ist auf den Button zu klicken und los geht es.");
    for(int j=0;j<=3;j++)
      {text[j].setFont (new Font ("Arial", Font.BOLD, 13));
    text[j].setBounds(10,140+30*j,480,30);
    text[j].setForeground(Color.white);
    text[j].setBackground(Color.black);
    text[j].setAlignment(Label.CENTER);
    add(text[j]);
      }
    haupt();
   }

 public void delet() {
   remove(startButton);
   remove(Frage);
   for(int k=0;k<=4;k++)
     {remove(antwort[k]);
      antwort[k].removeActionListener(this);
     }
 }
 public void richtig() {
   zahl=Zufall.Zufallszahl(Fragen.anzahl2)-1;
   text[0]=new Label("Richtig! ("+korrekt+")");
   text[1]=new Label(fragerei.right[zahl]);
   text[0].setFont (new Font ("Arial", Font.BOLD, 54));
    text[0].setBounds(10,130,480,70);
    text[0].setForeground(Color.white);
    text[0].setBackground(Color.black);
    text[0].setAlignment(Label.CENTER);
    add(text[0]);
    text[1].setFont (new Font ("Arial", Font.BOLD, 16));
    text[1].setBounds(10,250,480,20);
    text[1].setForeground(Whine);
    text[1].setBackground(Color.black);
    text[1].setAlignment(Label.CENTER);
    add(text[1]);
    startButton=new Button("Ich will die nächste Frage!");
    startButton.setBounds(100,320,300,25);
    startButton.setForeground(Color.black);
    startButton.setBackground(Color.lightGray);
    add(startButton);
    startButton.addActionListener(this);
 }
 
 public void falsch() {
   zahl=Zufall.Zufallszahl(Fragen.anzahl2)-1;
   text[0]=new Label("Falsch!");
   text[1]=new Label(fragerei.wrong[zahl]);
   text[0].setFont (new Font ("Arial", Font.BOLD, 54));
    text[0].setBounds(10,130,480,70);
    text[0].setForeground(Color.white);
    text[0].setBackground(Color.black);
    text[0].setAlignment(Label.CENTER);
    add(text[0]);
    text[1].setFont (new Font ("Arial", Font.BOLD, 16));
    text[1].setBounds(10,250,480,20);
    text[1].setForeground(Whine);
    text[1].setBackground(Color.black);
    text[1].setAlignment(Label.CENTER);
    add(text[1]);
    startButton=new Button("Okay, ich will es noch einmal versuchen!");
    startButton.setBounds(100,320,300,25);
    startButton.setForeground(Color.black);
    startButton.setBackground(Color.lightGray);
    korrekt=0;
    add(startButton);
    startButton.addActionListener(this);
 }
 
 public void haupt() {
  if (i==0)
   {startButton.addActionListener(this);
    ++i;
   }
  else
  { startButton.removeActionListener(this);
    remove(startButton);
    for(int j=0;j<=3;j++)
      remove(text[j]);
    zahl=Zufall.Zufallszahl(Fragen.anzahl)-1;
    Frage=new Label(fragerei.frage[zahl]);
    int helpoo=(fragerei.frage[zahl]).length();
    int helpo=11+(77-helpoo)/5;
    Frage.setFont (new Font ("Arial", Font.BOLD, helpo));
    Frage.setBounds(10,120,480,45);
    Frage.setForeground(Color.white);
    Frage.setBackground(Color.black);
    Frage.setAlignment(Label.CENTER);
    add(Frage);
    for(int j=zahl*5;j<=zahl*5+4;j++)
      {int hilfe=j-zahl*5;
       antwort[hilfe]=new Button(fragerei.antwort[j]);
       antwort[hilfe].setBounds(80,200+40*hilfe,340,25);
       antwort[hilfe].setForeground(Color.black);
       antwort[hilfe].setBackground(Color.lightGray);
       add(antwort[hilfe]);
       antwort[hilfe].addActionListener(this);
      }
  }
}

  public void actionPerformed (ActionEvent ae) {
    if (ae.getSource() == startButton)
      haupt();
    else
      {for(int j=0;j<=4;j++)
         if (ae.getSource() == antwort[j])
           {if (fragerei.richtig[zahl]!=j+1 & fragerei.richtig[zahl]!=0)
              {delet();
              falsch();}
            else
              {++korrekt;
              delet();
              richtig(); }
            break;
           }
      }
    }
}

