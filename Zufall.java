import java.util.Random;

public class Zufall {

    public static int Zufallszahl (int n){
        int ergebnis;
        // Erzeugt eine Zufallszahl
        Random ZufGen = new Random();
        // Projiziert die oben erzeugte Zufallszahl in den
        // Wertebereich {1, ..., n}
        ergebnis=Math.abs(ZufGen.nextInt() % n)+ 1;
        return ergebnis;
      }
}
