import javax.swing.JFrame;
import java.util.Random;
import java.util.ArrayList;


public class Ventana extends JFrame{
	private static Random r = new Random();
	private static GPS origen = new GPS(655,550);
	private static Taxi taxi=new Taxi(origen);
	private static Agente agente= new Agente();
	private static Dibujar paint = new Dibujar(taxi);
	private static ArrayList<Solicitud> array = new ArrayList<Solicitud>();
public Ventana(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(paint);
		setTitle("Agente Taxista");
		setSize(900,700);
		setLocationRelativeTo(null);
		setResizable(false);		
	}
	public static void main(String[] args){
		Ventana inter=new Ventana();
		inter.setVisible( true );
	
		//Agente
		generar_solicitudes();
		paint.dibujasol(array);
		for(int i=0;i<array.size();i++){
			System.out.println(agente.agregarSolicitud(array.get(i), taxi));
			
		}
		int t=0;
		while(t!=agente.lenghtqueue()){
			Solicitud res=agente.removerSolicitud();
			movertaxi(res.getOrigen());
			for(int j=0;j<array.size();j++){
				//System.out.println(array.get(j).equals(res));
				if(array.get(j).equals(res)){	
				array.remove(j);
			}
			retraso(100);
			paint.dibujades1(res,true);
			retraso(100);
			movertaxi(res.getDestino());
			paint.dibujades1(res,false);
			}	
			t++;
			}
		}
static ArrayList<Solicitud> generar_solicitudes(){
	int x1,y1,x2,y2,i,q;
	i=0;
	while(i!=5){
	 x1 = r.nextInt(800);
	 y1 = r.nextInt(600);
	 x2= r.nextInt(800);
	 y2 = r.nextInt(600);
	 q=r.nextInt(5)+1;
	GPS origenUsuario= new GPS(x1,y1);
	GPS destinoUsuario=new GPS(x2,y2);
	Solicitud s=new Solicitud(origenUsuario,destinoUsuario,q);
	array.add(s);
	i++;
	}
	return array;
	
}
static void movertaxi(GPS destino){
	taxi.setDestino(destino);
	GPS next=origen;

	if (taxi.ubicacion.getX()<destino.getX()){
		while (next.getX()!=destino.getX()){
		    next.setX(next.getX()+1);
			retraso(10);
			paint.go(next);
		}}
	if (taxi.ubicacion.getX()>destino.getX()){
		while (next.getX()!=destino.getX()){
		    next.setX(next.getX()-1);
			retraso(10);
			paint.go(next);
		}}
	if (taxi.ubicacion.getY()<destino.getY()){
		while (next.getY()!=destino.getY()){
		    next.setY(next.getY()+1);
			retraso(10);
			paint.go(next);
		}}
	
	if (taxi.ubicacion.getY()>destino.getY()){
		while (next.getY()!=destino.getY()){
		    next.setY(next.getY()-1);
			retraso(10);
			paint.go(next);
		}}	
	
}
static void retraso (int x){	
	try{
        Thread.sleep(x); 
      }catch(InterruptedException e){}	
 }
 }
