package view;



import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

import view.SelectMap;
import view.Menu;
import view.Win;






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
        
        jf.setVisible(true);
        jf.setSize(599,399);
        jf.setSize(600, 400);
     
        
        
        
        map=new Button("SelectMap");
        con.add(map);
        map.addMouseListener(this);
        
        option=new Button("Menu");
        con.add(option);
        option.addMouseListener(this);
        nameofpokemon=new Button("PokeDex");
        con.add(nameofpokemon);
        nameofpokemon.addMouseListener(this);
        win=new Button("Win");
        con.add(win);
        win.addMouseListener(this);
        selectchar=new Button("selectchar");
        con.add(selectchar);
        selectchar.addMouseListener(this);
        
        
    
    }
    Button option;
    Button map;
    Button nameofpokemon;
    Button win;
    Button selectchar;
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if(e.getSource()==map)
        {
            SelectMap map=new SelectMap();
            map.setVisible(true);
        }
        
        if(e.getSource()==option)
        {
            Menu option=new Menu();
            option.setVisible(true);
        }
        /*
        if(e.getSource()==nameofpokemon)
        {
            Nameofpokemon n=new Nameofpokemon();
            n.setVisible(true);
        }
        */
        if(e.getSource()==win)
        {
            Win w=new Win();
           win.setVisible(true);
        }
        /*
        if(e.getSource()==selectchar){
            Selectchar selectchar=new Selectchar();
            selectchar.setVisible(true);
        }
        */
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