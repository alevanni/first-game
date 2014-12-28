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

class serpente extends JPanel implements KeyListener {
//int x=400;
//int y=400;
int dimensione=15;
int i=0;
int [] x=new int[dimensione]; 
int [] y=new int[dimensione]; 
int [] a=new int[dimensione]; //tutti 1
int [] b=new int[dimensione]; //tutti 0
int [] premuto=new int[dimensione];
int [] auxx=new int[dimensione];
int [] auxy=new int[dimensione];
 

public serpente() {
setFocusable(true);
this.addKeyListener(this);

 

a[0]=1;
x[0]=400;
y[0]=400;
premuto[0]=0;
auxx[0]=0;
auxy[0]=0;
for (i=1; i<dimensione; i++){
a[i]=1;
b[i]=0;
premuto[i]=0;
auxx[i]=0;
auxy[i]=0;
x[i]=x[i-1]-a[i]*20;
y[i]=y[i-1]-b[i]*20;

}//for


}//costruttore

public void paint(Graphics g){
int i;
super.paint(g);

Graphics2D [] corpo=new Graphics2D[dimensione];

Graphics2D sfondo=(Graphics2D) g;
sfondo.setColor(Color.BLACK);
sfondo.fillRect(0,0, 800,800);

for (i=0; i<dimensione; i++){
corpo[i]=(Graphics2D) g;

corpo[i].setColor(Color.CYAN);

corpo[i].setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
corpo[i].fillOval(x[i],y[i], 40, 40);
}


}//paint

public void move0() {
for (i=0; i<dimensione; i++) move(i, auxx[i], auxy[i], premuto[i] );
}

public void move(int i, int m, int n, int tasto) {
if (tasto!=0){
if (x[i]==m && y[i]==n) { //sono arrivata all'angolo
if (tasto==37 && a[0]!=1) {
b[i]=-0;
a[i]=-1; 
}//if

if (tasto==38 && b[0]!=1) {
b[i]=-1;
a[i]=0; 
}//if

if (tasto==39 && a[0]!=-1) {
a[i]=1;
b[i]=0;
}//if

if (tasto==40 && b[0]!=-1) {
b[i]=1;
a[i]=0;
}//if

try {
premuto[i+1]=tasto; 
auxx[i+1]=m;
auxy[i+1]=n;
}
catch (IndexOutOfBoundsException e) {}




}//if
}




x[i]=x[i]+a[i]*2; //mando avanti e vedo se devo ricominciare
y[i]=y[i]+b[i]*2;
if (x[i]>=800) x[i]=0; 
if (x[i]<0) x[i]=800-20;
if (y[i]>=800) y[i]=0;
if (y[i]<0) y[i]=800-20; 


}



public void keyPressed(KeyEvent e) {

this.premuto[0]=e.getKeyCode();
if (premuto[0]<=40 && premuto[0]>=37){

auxx[0]=x[0];
auxy[0]=y[0];


}//if

}

public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e){}



}//serpente



public class snake2 {

public static void main(String [] args) throws InterruptedException {

JFrame f=new JFrame("Sono la prima animazione di Alessia!");
serpente d1=new serpente();
Container c=f.getContentPane();
f.setSize(800,800);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c.add(d1);


while (true) {
d1.move0();

Thread.sleep(10);
d1.repaint();
}
}

}
