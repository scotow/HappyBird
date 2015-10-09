package HappyBird;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author debaerdm
 * Les coordonnees et toutes les methodes en rapport avec elles.
 * 
 */
public class Coordonnee {
    
    protected double x;
    protected double y;
    
    /**
     * cree des coordonnees
     * @param x : la position x
     * @param y : la position y
     */
    public Coordonnee(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * applique la formule de Bezier sur les Coordonnees
     * @param pb : les coordonnees a appliquer
     * @return les nouvelles coordonnees du point
     */
    public Coordonnee CalculPointBez(Coordonnee pb){
        return new Coordonnee(this.x-pb.getX(), this.y-pb.getY());
    }
    /*-------------------Les getters----------------------------------------------*/
    
    /**
     * retourne la position x
     * @return x : la position x
     */
    
    public double getX(){
        return this.x;
    }
    
    /**
     * retourne la position y
     * @return y : la position y
     */
    public double getY(){
        return this.y;
    }

    /*-------------------Les setters----------------------------------------------*/

    public void setX(double x){this.x = x;}

    public void setY(double y){this.y = y;}
    
    /*----------------------------------------------------------------------------*/
    
    
    /**
     * ajoute aux coordonnees des valeurs 
     * @param x : la valeur a ajouter a x
     * @param y : la valeur a ajouter a y
     */
    public void ajout(double x, double y){
        this.x += x;
        this.y += y;
    }
    
    /**
     * test l'egalite de deux coordonnee
     * @param c les coordonnees a comparer
     * @return vrai si elles sont egales
     */
    public boolean equals(Coordonnee c){
        return this.x == c.x && this.y == c.y;
    }
    
    /**
     * affiche les coordonnees
     * @return la chaine caractere voulue
     */
    public String toString(){
        return "x : " + this.x + "\ty : " + this.y;
    }
}
