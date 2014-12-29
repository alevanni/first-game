import javax.swing.*;
import java.lang.Object;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.JLabel;

class game extends JPanel implements KeyListener {
int x=0;
int y=0;
int x2=10;
int y2=350;
int xa=1;
int ya=1;
int larghezzapalla=20;
int larghezzarettangolo=50;
int altezzarettangolo=20;
public game() {
setFocusable(true);
this.addKeyListener(this);

}

public void paint(Graphics g){
super.paint(g);
Graphics2D g2d0=(Graphics2D) g;
Graphics2D g2d=(Graphics2D) g;
Graphics2D g2d2=(Graphics2D) g;

g2d.setColor(Color.WHITE);
g2d.fillRect(0,0,400,400);

g2d.setColor(Color.RED);
g2d.fillOval(x,y,larghezzapalla,larghezzapalla);

g2d2.setColor(Color.BLUE);
g2d2.fillRect(x2,y2,larghezzarettangolo,altezzarettangolo);
}//paint


public void moveball() { //simula anche il rimbalzo

if (x + xa < 0) xa = 1;
if (x + xa > getWidth() - larghezzapalla) xa = -1;
if (y + ya < 0) ya = 1;
if (y + ya > getHeight() - larghezzapalla) ya = -1;
if ( ( x+xa+larghezzapalla/2>=x2 && x+xa+(larghezzapalla/2)<=x2+larghezzarettangolo )  && ( y2-(y+ ya)==larghezzapalla) ) ya=-1;
 

x=x+xa;
y=y+ya;
}


public void move(int i) {  
if (i==37) x2=x2-5 ;
if (i==39)  x2=x2+5;
}

public void keyPressed(KeyEvent e) {

this.move(e.getKeyCode());
this.repaint();
}

public void keyReleased(KeyEvent e){


}
public void keyTyped(KeyEvent e){


}




}

public class prova {
public static void main(String [] args) throws InterruptedException
 {

JFrame f=new JFrame("Sono la prima animazione di Alessia!");
game d1=new game();
Container c=f.getContentPane();
f.setSize(400,400);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c.add(d1);


while (true) {
d1.moveball();
d1.repaint();
Thread.sleep(10);
}
}
}
