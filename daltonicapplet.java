import javax.swing.*;
import java.lang.Object;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.JLabel;
import java.applet.*; 
import java.util.Random;


class bottone extends JButton{
//bottoni con coordinate e colore
 //attributi
int riga, colonna;
boolean v;


public bottone(int a, int b) { //costruttore
Random random = new Random();
boolean temp=random.nextBoolean();
this.v=temp;
this.riga=a;
this.colonna=b;
if (v==true) this.setBackground(Color.GREEN);
else this.setBackground(Color.RED);
}
//metodo di cambio di stato
public void cambio(){
if (v==false) {
this.setBackground(Color.GREEN);
v=true;
}
else {
this.setBackground(Color.RED);
v=false;
}
}



}


class griglia extends JPanel implements ActionListener {
//attributi
int i, j;
//setBackground(Color.BLACK);
JButton next=new JButton("Next");
bottone[][] bottoni=new bottone[3][3];
public  griglia() { //costruttore
this.setLayout(new GridLayout(3,3));
for (i=0;i<=2; i++) {
for (j=0;j<=2; j++) {
bottoni[i][j]=new bottone(i,j);
this.add(bottoni[i][j]);
bottoni[i][j].addActionListener(this);
}
}

}
public void actionPerformed(ActionEvent e){
Object p=e.getSource(); //dice quale pulsante e' stato premuto
bottone premuto;
int r, c;
if (p instanceof bottone) {
premuto=(bottone)p; //casting da object a bottone
r=premuto.riga;
c=premuto.colonna;
flippa(r, c);

}
}
public void flippa(int r, int c) {
this.bottoni[r][c].cambio();
if (r>0) this.bottoni[r-1][c].cambio();
if (c>0) this.bottoni[r][c-1].cambio();
if (r<2) this.bottoni[r+1][c].cambio();
if (c<2) this.bottoni[r][c+1].cambio();


}



}


class nuovo extends JPanel {
//setBackground(Color.black);
JButton next=new JButton("Un altro!!");
//
//Font f=new Font("Helvetica", Font.BOLD,14);
//next.setFont(f);
public nuovo() {
this.add(next);
}//costruttore
}//nuovo



public class daltonicapplet extends JApplet implements ActionListener{

griglia g=new griglia();
nuovo n=new nuovo();
Container c=getContentPane();

public void init(){
c.setLayout(new GridLayout(1,2));
c.setBackground(Color.BLACK);
c.add(n);
c.add(g);
n.setBackground(Color.BLACK);
g.setBackground(Color.BLACK);
this.n.next.addActionListener(this);
this.n.next.setBackground(Color.WHITE);
}//init

public void actionPerformed (ActionEvent e) {
Object o=e.getSource();
if (o==this.n.next) this.c.remove(g);
this.g=new griglia();
this.c.add(g);
c.validate();
}


}
