import java.awt.*;

import javax.swing.ImageIcon;

public class Taxi {

	private String taxi="taxi.png";
	GPS ubicacion;
	GPS destino;
	int cupo;
	private Image imagen;

	public Taxi(GPS u){
		ubicacion=u;
		ImageIcon img=new ImageIcon(this.getClass().getResource(taxi));
		imagen=img.getImage();
	}
	
	public void mover(GPS d){
		destino=d;
		ubicacion.setX((destino.getX()));
		ubicacion.setY((destino.getY()));
	}
	public Image getimagen(){
	return imagen;	
	}
	
	public GPS getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(GPS ubicacion) {
		this.ubicacion = ubicacion;
	}
	public GPS getDestino() {
		return destino;
	}
	public void setDestino(GPS destino) {
		this.destino = destino;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

}
