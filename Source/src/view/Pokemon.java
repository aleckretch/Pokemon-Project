package view;



import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
//import sun.applet.Main;


public class Pokemon implements MouseListener{

    
    public static void main(String[] args) 
    {
        Pokemon pm= new Pokemon();
        pm.action();
    }
    public  void action() {
            JFrame jf=new JFrame();
        Container con=jf.getContentPane();
         
        jf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        con.setLayout(new FlowLayout());
        jf.setSize(600, 400);
        jf.setVisible(true);
        map=new Button("SelectMap");
        con.add(map);
        
        map.addMouseListener(this);
        option=new Button("Option");
        con.add(option);
        option.addMouseListener(this);
        nameofpokemon=new Button("nameofpokemon");
        con.add(nameofpokemon);
        nameofpokemon.addMouseListener(this);
        win=new Button("Win");
        con.add(win);
        win.addMouseListener(this);
        
        
        
    
    }
    Button option;
    Button map;
    Button nameofpokemon;
    Button win;
    Button selectchar;
	private Object item;
	private Object safariball;
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if(e.getSource()==map)
        {
            SelectMap map=new SelectMap();
            map.setVisible(true);
        }
       
	
       /* if(e.getSource()==safariball)
        {
            SafariBall n=new SafariBall();
            n.setVisible(true);
        } */
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }



    
}