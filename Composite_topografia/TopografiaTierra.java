package P2_E11;

public class TopografiaTierra extends Topografia {
 @Override
 public double proporcionAgua() {
     return 0.0;
 }

 @Override
 protected boolean equalsTopografia(Topografia otra) {
     return otra instanceof TopografiaTierra;
 }
}
