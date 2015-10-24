 

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public class Agente {
	private Queue<Solicitud> solicitudes = new ArrayDeque<Solicitud>();
	//private ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
	private boolean soli;
        
	
        public Agente(){}
	
	public boolean isSoli() {
		return soli;
	}

	public void setSoli(boolean soli) {
		this.soli = soli;
	}
	


	public String agregarSolicitud(Solicitud peticion,Taxi taxi){
		String retorno="";
        taxi.setDestino(peticion.destino);        
                        
		if ( ((this.distanciaM(taxi)>this.distanciaMSol(peticion, taxi))
				&&((4 - taxi.cupo)>=peticion.cPasajeros))||(taxi.cupo==0 && peticion.cPasajeros<=4)){
			solicitudes.add(peticion);
			retorno+=("*** Solicitud Aceptada:\n"
			+peticion);
			setSoli(true);
		}else{
			retorno+=("*** Solicitud Rechazada, se encuentra muy lejos o no hay cupo");
			retorno+=(taxi);
			retorno+=(peticion);
			setSoli(false);
		}
		return retorno;
	}
	public Solicitud removerSolicitud(){
		return solicitudes.poll();
	}
	public boolean haySolicitudes(){
		return !solicitudes.isEmpty();
	}
	
	public int distanciaM(Taxi taxi){
		
          return Math.abs((taxi.getDestino().getX())-(taxi.getUbicacion().getX()))+
				Math.abs((taxi.getDestino().getY())-(taxi.getUbicacion().getY()));
	}

	public int lenghtqueue(){
		return solicitudes.size();
		
	}
	public int distanciaMSol(Solicitud peticion, Taxi taxi){

		return Math.abs(peticion.getOrigen().getX()-taxi.getUbicacion().getX())+
				Math.abs(peticion.getOrigen().getY()-taxi.getUbicacion().getY());
	}

}
