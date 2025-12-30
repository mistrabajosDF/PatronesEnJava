package P2_E11;

public class TopografiaAgua extends Topografia {
 @Override
 public double proporcionAgua() {
     return 1.0;
 }

 @Override
 protected boolean equalsTopografia(Topografia otra) {
     return otra instanceof TopografiaAgua; //retorna true si es topo de agua     
 }
}
