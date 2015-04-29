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


public class Info implements MouseListener{

  
	static JFrame jf;


	public static void main(String[] args) 
    {
        Info info= new Info();
        info.action();
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
        instruction=new Button("Instruction");
        con.add(instruction);
        instruction.addMouseListener(this);
        
        
    
    }
    Button option;
    Button map;
    Button nameofpokemon;
    Button instruction;
    
   
    @Override
    public void mouseClicked(MouseEvent e) 
    {
    	
        if(e.getSource()==map)
        {
            SelectMap map=new SelectMap();
            map.setVisible(false);
            
        }
        
        if(e.getSource()==option)
        {
            Menu option=new Menu();
            option.setVisible(false);
        }
       
       
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