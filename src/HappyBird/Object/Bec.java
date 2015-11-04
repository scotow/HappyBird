package HappyBird.Object;

/**
 * Created by Benjamin on 04/11/15.
 */
public class Bec {

    private Coordonnee coordonnee;
    private final Oiseau oiseau;

    public Bec(Oiseau oiseau){
        coordonnee = new Coordonnee(0, 0);
        this.oiseau = oiseau;
    }

    public void update(){

    }

    public Coordonnee getCoordonnee(){
        return coordonnee;
    }

    public void setPosition(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }
}
