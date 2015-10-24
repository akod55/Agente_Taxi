import java.awt.Image;

import javax.swing.ImageIcon;



public class Solicitud {
	GPS origen;
	GPS destino;
	private Image imagen,imagen1,imagen2,imagen3,imagen4;
	int cPasajeros;
	public Solicitud(GPS origen, GPS destino, int cPasajeros) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.cPasajeros = cPasajeros;
		ImageIcon img1=new ImageIcon(this.getClass().getResource("Solicitud.png"));
		imagen=img1.getImage();
		ImageIcon img2=new ImageIcon(this.getClass().getResource("Destino1.png"));
		imagen1=img2.getImage();
		ImageIcon img3=new ImageIcon(this.getClass().getResource("Destino2.png"));
		imagen2=img3.getImage();
		ImageIcon img4=new ImageIcon(this.getClass().getResource("Destino3.png"));
		imagen3=img4.getImage();
		ImageIcon img5=new ImageIcon(this.getClass().getResource("Destino4.png"));
		imagen4=img5.getImage();
	}
	
	public GPS getOrigen() {
		return origen;
	}
	public void setOrigen(GPS origen) {
		this.origen = origen;
	}
	public GPS getDestino() {
		return destino;
	}
	public void setDestino(GPS destino) {
		this.destino = destino;
	}
	public int getcPasajeros() {
		return cPasajeros;
	}
	public void setcPasajeros(int cPasajeros) {
		this.cPasajeros = cPasajeros;
	}
	public Image getimagenSol(){
	return imagen;	
	}
	public Image getimagen1(){
	return imagen1;	
	}
	public Image getimagen2(){
	return imagen2;	
	}
	public Image getimagen3(){
	return imagen3;	
	}
	public Image getimagen4(){
	return imagen4;	
	}
	@Override
	public String toString() {
		return "Solicitud [origen=" + origen + ", destino=" + destino + ", cPasajeros= " + cPasajeros + "]";
	}
	
	
}
