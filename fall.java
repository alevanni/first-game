import javax.swing.*;
import java.lang.Object;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.JLabel;

class game extends JPanel implements KeyListener {
int x=50;
int y=0;
long t0 = System.currentTimeMillis();
long t;

int diametro=40;
public game() {
setFocusable(true);
this.addKeyListener(this);

}

public void paint(Graphics g){
super.paint(g);

Graphics2D g2d=(Graphics2D) g;
Graphics2D g2d2=(Graphics2D) g;
Graphics2D g2d3=(Graphics2D) g;

g2d.setColor(Color.WHITE); //background
g2d.fillRect(0,0,500,500);


g2d2.setColor(Color.MAGENTA); //ball
g2d2.fillOval(x,y,diametro, diametro);

g2d2.setColor(Color.BLACK); //floor
g2d2.fillRect(0,420,500, 50);
}//paint




public void move() { 
t=System.currentTimeMillis(); 
int deltat=(int)(t-t0); //time
//System.out.println(deltat);
if (y<380) y=y+ 5*(deltat^2)/1000; 
//System.out.println(y);
else y=380; //stop
}

public void move2(int i){
if (i==37) x=x-5 ;
if (i==39)  x=x+5;
}

public void keyPressed(KeyEvent e) {

this.move2(e.getKeyCode());
this.repaint();
}

public void keyReleased(KeyEvent e){


}
public void keyTyped(KeyEvent e){


}




}

public class fall {
public static void main(String [] args) throws InterruptedException
 {

JFrame f=new JFrame("Gravity");
game d1=new game();
Container c=f.getContentPane();
f.setSize(400,500);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c.add(d1);


while (true) {
d1.move();
d1.repaint();
Thread.sleep(20);
}
}
}
