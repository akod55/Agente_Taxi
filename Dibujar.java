import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.*;
public class Dibujar extends JPanel {

	private Taxi taxi;
	private static ArrayList<Solicitud> sol = new ArrayList<Solicitud>();
	private Solicitud dest1,dest2,dest3,dest4;
	private Timer timer;
	private Boolean f=false,d1=false,d2=false,d3=false,d4=false;
	public Dibujar(Taxi taxi1){
		
		setBackground(Color.GRAY);
		setFocusable(true);
		taxi=taxi1;
		
	}
    public void dibujasol(ArrayList <Solicitud> s){
    	sol=s; 	
    	f=true;
    }
    public void dibujades1(Solicitud s,boolean r){
    	dest1=s; 	
    	d1=r;
    }
    public void dibujades2(Solicitud s,boolean r){
    	dest2=s;
    	d2=r;
    }
    public void dibujades3(Solicitud s,boolean r){
    	dest3=s; 
    	d3=r;
    }
    public void dibujades4(Solicitud s,boolean r){
    	dest4=s; 
    	d4=r;
    }
	public void paint(Graphics grafica){
		super.paint(grafica);
		if(f==true){
		Graphics2D solicitud= (Graphics2D) grafica;
		int i=0;
		while(i!=sol.size()){
		solicitud.drawImage(sol.get(i).getimagenSol(),sol.get(i).getOrigen().getX(),sol.get(i).getOrigen().getY(),null);
		i++;}}
		if(d1==true){
		Graphics2D des1= (Graphics2D) grafica;
		des1.drawImage(dest1.getimagen1(),dest1.getDestino().getX(),dest1.getDestino().getY(),null);}
		if(d2==true){
		Graphics2D des2= (Graphics2D) grafica;
		des2.drawImage(dest2.getimagen2(),dest2.getDestino().getX(),dest2.getDestino().getY(),null);}
		if(d3==true){
		Graphics2D des3= (Graphics2D) grafica;
		des3.drawImage(dest3.getimagen3(),dest3.getDestino().getX(),dest3.getDestino().getY(),null);}
		if(d4==true){
		Graphics2D des4= (Graphics2D) grafica;
		des4.drawImage(dest4.getimagen4(),dest4.getDestino().getX(),dest4.getDestino().getY(),null);}
		Graphics2D car= (Graphics2D) grafica;
		car.drawImage(taxi.getimagen(),taxi.getUbicacion().getX(),taxi.getUbicacion().getY(),null);			
	}

	
	public void go (GPS destino){
		taxi.mover(destino);
		repaint();
		}


}
