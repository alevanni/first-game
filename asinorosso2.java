import javax.swing.*;
import java.lang.Object;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.JLabel;
import java.io.BufferedOutputStream;
import javax.imageio.ImageIO;
import java.io.File;
import java.lang.Math;

class mappa extends JPanel implements MouseListener, MouseMotionListener  {
int [] x=new int[10]; //dimesioni dei rettangoli
int [] y=new int[10];
int [] h=new int[10];
int [] l=new int[10];
int [][] posizioni=new int[5][4];
int a=40;
int b=2*a+10;
int spazio=10;
int x0, y0;
int auxx, auxy;
int damuovere;
int giu, destra;
Graphics2D [] bordi=new Graphics2D[5];
Graphics2D [] pezzi=new Graphics2D[10];
public mappa(){
x[0]=50;
y[0]=50;  //si dispongono i pezzi
l[0]=a;
h[0]=b;


x[1]=200;
y[1]=50;
l[1]=a;
h[1]=b;

x[2]=50;
y[2]=150;
l[2]=a;
h[2]=b;

x[3]=200;
y[3]=150;
l[3]=a;
h[3]=b;

x[4]=100;
y[4]=150;
l[4]=b;
h[4]=a;

x[5]=50;
y[5]=250;
l[5]=a;
h[5]=a;

x[6]=100;
y[6]=200;
l[6]=a;
h[6]=a;

x[7]=150;
y[7]=200;
l[7]=a;
h[7]=a;

x[8]=200;
y[8]=250;
l[8]=a;
h[8]=a;

x[9]=100;
y[9]=50;
l[9]=b;
h[9]=b;

posizioni[0][0]=0; //si posizionano i pezzi
posizioni[1][0]=0;

posizioni[0][3]=1 ;
posizioni[1][3]=1;

posizioni[2][0]=2 ;
posizioni[3][0]=2;

posizioni[2][3]=3;
posizioni[3][3]=3;

posizioni[2][1]=4;
posizioni[2][2]=4;

posizioni[0][1]=9;
posizioni[0][2]=9;
posizioni[1][1]=9;
posizioni[1][2]=9;

posizioni[4][0]=5; //quadratini
posizioni[3][1]=6;
posizioni[3][2]=7;
posizioni[4][3]=8;

posizioni[4][1]=-1; //spazi vuoti
posizioni[4][2]=-1;

setFocusable(true);
this.addMouseListener(this);
this.addMouseMotionListener(this);
}

public void paint(Graphics g){
int i=0;
super.paint(g);
for (i=0; i<5; i++) {
bordi[i]=(Graphics2D) g;
bordi[i].setColor(Color.YELLOW);
}


bordi[0].fillRect(0,0,290, 40);
bordi[1].fillRect(0,0,40, 340);
bordi[2].fillRect(250,0,40,340);
bordi[3].fillRect(0,300,90, 40);
bordi[4].fillRect(200,300,90, 40);

for (i=0; i<10; i++) {
pezzi[i]=(Graphics2D) g;
pezzi[i].setColor(Color.ORANGE);
pezzi[i].fillRect(x[i],y[i],l[i],h[i]);
}

}//paint

public boolean controllo(int colonna, int riga) {
if ( Math.abs(colonna)<Math.abs(riga)   ) return controlloupdown(riga); 
else return controlloleftright(colonna); 
}

public boolean controlloupdown(int riga) {
if (riga<0){ //devo salire
try {
if (posizioni[(y0-50)/50 -1][x0/50 -1]==-1 && posizioni[(y0-50)/50 -1][(x0+l[damuovere])/50 -1]==-1) {
giu=-1;
destra=0;
return true;
}//if
else return false;
}//try
catch (IndexOutOfBoundsException e) {
return false;
}

}//if
else {
try {
if (posizioni[(y0+h[damuovere]+10)/50 -1][x0/50 -1]==-1 && posizioni[(y0+h[damuovere]+10)/50 -1][(x0+l[damuovere])/50 -1]==-1) {
giu=1;
destra=0;
return true;
}//if
else return false;
}//try
catch (IndexOutOfBoundsException e) {
return false;
}//catch

}//else
}

public boolean controlloleftright(int colonna) {
if (colonna>0){ //devo andare a destra
try {
if (posizioni[y0/50 -1][(x0+l[damuovere]+10)/50 -1]==-1 && posizioni[(y0+h[damuovere])/50 -1][(x0+l[damuovere]+10)/50 -1]==-1) {
giu=0;
destra=1;
return true;
}//if
else return false;
 }//try
catch (IndexOutOfBoundsException e) {
return false;
}



}//if

else { //devo andare a sinistra
try {
if (posizioni[(y0)/50 -1][(x0-10)/50 -1]==-1 && posizioni[(y0+h[damuovere])/50 -1][(x0-10)/50 -1]==-1) {
giu=0;
destra=-1;
 return true;
  }//if
else return false;
 
}//try

catch (IndexOutOfBoundsException e) {
return false;
}//catch
}//else
}



public void mouseClicked(MouseEvent e) {


}


public void mouseInputListener(MouseEvent e) {
}

public void mouseExited(MouseEvent e) {
}

public void mouseEntered(MouseEvent e) {
}

public void mouseReleased(MouseEvent e) {

if (damuovere !=-1) {
//System.out.println(x[damuovere]);
if (controllo(e.getX()-auxx, e.getY()-auxy) ) {

x[damuovere]=x[damuovere]+destra*50; //puo' andare a destra o a sinistra
y[damuovere]=y[damuovere]+giu*50; //puo' andare su o giu
repaint();
riposiziona();
}//if 
else {
x[damuovere]=x0;
y[damuovere]=y0;
}//else

}//if
}

public void riposiziona() {
posizioni[y0/50 -1][x0/50 -1]=-1;
posizioni[(y0+h[damuovere])/50 -1][x0/50 -1]=-1;
posizioni[(y0)/50 -1][(x0+l[damuovere])/50 -1]=-1;
posizioni[(y0+h[damuovere])/50 -1][(x0+l[damuovere])/50 -1]=-1;
posizioni[ y[damuovere]/50 -1 ][ x[damuovere]/50 -1 ]=damuovere;
posizioni[ (y[damuovere] +h[damuovere])/50 -1][ x[damuovere]/50 -1 ]=damuovere;
posizioni[ y[damuovere]/50 -1 ][ (x[damuovere] +l[damuovere])/50 -1]=damuovere;
posizioni[ (y[damuovere]+h[damuovere])/50 -1][ (x[damuovere]+l[damuovere])/50 -1]=damuovere;
}

public void mousePressed(MouseEvent e) {
this.auxx=e.getX();
this.auxy=e.getY();
damuovere=posizioni[(auxy-50)/50][(auxx-50)/50];
//System.out.println(damuovere);

if (damuovere !=-1) {
this.x0=x[damuovere]; //mi tengo le posizioni iniziali, cosi' se non muovo, torno dove prima
this.y0=y[damuovere];
}//if
}

public void mouseDragged(MouseEvent e){



}

public void mouseMoved(MouseEvent e) {  

}



}



public class asinorosso2 {
public static void main(String [] args)  {

JFrame f=new JFrame("Tira fuori il quadrato!");
mappa d1=new mappa();
Container c=f.getContentPane();
f.setSize(290,380);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c.add(d1);
}
}
