package HappyBird.model;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.Timer;

import HappyBird.Object.Constante;
import HappyBird.Object.Coordonnee;
import HappyBird.Object.Courbe;
import HappyBird.Object.Obstacle;
import HappyBird.Object.Oiseau;

public class PlateauModel extends Observable {
	
	private List<Coordonnee> ListeDePoint = new ArrayList<>(4);
	private List<Obstacle> ListeDObstacles = new ArrayList<>(10);
	private Oiseau oiseau = new Oiseau(Constante.BIRD_BODY_RADIUS*2, Constante.Y_FRAME-(Constante.BIRD_BODY_RADIUS*3));
	private Courbe courbe = new Courbe();
	private double t = 0;
	private double speed = 0.0002;	
	private int waiting = 0;
	private int simulation = 10;
	private Timer flyTimer;
	private List<Rectangle> rectangles = new ArrayList<>();
	private List<Coordonnee> coordDeriver = new ArrayList<>();
	
	public List<Obstacle> getListeDObstacles() {
		return ListeDObstacles;
	}
	
	public Oiseau getOiseau() {
		return oiseau;
	}
	
	public Courbe getCourbe() {
		return courbe;
	}
	
	public List<Coordonnee> getListeDePoint() {
		return ListeDePoint;
	}
	
	public List<Rectangle> getRectangles() {
		return rectangles;
	}
	
	public List<Coordonnee> getCoordonneeDerive() {
		return coordDeriver;
	}
	
	public Obstacle getObstacle(int index){
		return ListeDObstacles.get(index);
	}
	
	public Coordonnee getPoint(int index){
		return ListeDePoint.get(index);
	}
	
	public Coordonnee getOiseauPostion() {
		return oiseau.getPostionCoordonnee();
	}
	
	public Coordonnee getObstaclePostion(int index){
		return ListeDObstacles.get(index).getPostionCoordonnee();
	}
	
	public Color getOiseauColor(){
		return oiseau.getOiseauColor();
	}
	
	public Color getObstaclesColor(int index){
		return ListeDObstacles.get(index).getObstacleColor();
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public double getT() {
		return t;
	}
	
	public int getWaiting() {
		return waiting;
	}
	
	public int getSimulation() {
		return simulation;
	}
	
	public Timer getFlyTimer() {
		return flyTimer;
	}
	
	public void clearPoint(){
		ListeDePoint.clear();
		setChanged();
		notifyObservers();
	}
	
	public void clearObstacles(){
		ListeDObstacles.clear();
		setChanged();
		notifyObservers();
	}
	
	public void addPoint(Coordonnee coordonnee){
		ListeDePoint.add(coordonnee);
		//System.out.println("Point placer à "+coordonnee.toString()+".");
		setChanged();
		notifyObservers();
	}
	
	public void addRectangle(Rectangle rectangle){
		rectangles.add(rectangle);
		setChanged();
		notifyObservers();
	}
	
	public void addCoordonneeDerive(Coordonnee coordonnee){
		coordDeriver.add(coordonnee);
		setChanged();
		notifyObservers();
	}
	
	public Rectangle getRectangleByIndex(int index){
		return rectangles.get(index);
	}
	
	public Coordonnee getCoordonneeDeriveByIndex(int index){
		return coordDeriver.get(index);
	}
	
	public void removePoint(Coordonnee coordonnee){
		ListeDePoint.remove(coordonnee);
		setChanged();
		notifyObservers();
	}
	
	public void addObstacles(Obstacle obstacle){
		ListeDObstacles.add(obstacle);
		setChanged();
		notifyObservers();
	}
	
	public void removeObstacles(Obstacle obstacle){
		ListeDObstacles.remove(obstacle);
		setChanged();
		notifyObservers();
	}
	
	public void setObstaclesColor(Color color, int index){
		ListeDObstacles.get(index).setObstacleColor(color);
		setChanged();
		notifyObservers();
	}
	
	public void setOiseauColor(Color color){
		oiseau.setOiseauColor(color);
		setChanged();
		notifyObservers();
	}
	
	public void setOiseauPosition(double x, double y) {
		this.oiseau.setPosition(x, y);
		//System.out.println("Oiseau placer à ("+x+";"+y+").");
		setChanged();
		notifyObservers();
	}
	
	public void setObstaclesPosition(double x, double y, int index){
		ListeDObstacles.get(index).setPosition(x, y);
		setChanged();
		notifyObservers();
	}
	
	public void setFlyTimer(Timer flyTimer) {
		this.flyTimer = flyTimer;
		setChanged();
		notifyObservers();
	}
	
	public void setT(double t) {
		this.t = t;
		setChanged();
		notifyObservers();
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
		setChanged();
		notifyObservers();
	}
	
	public void setWaiting(int waiting) {
		this.waiting = waiting;
		setChanged();
		notifyObservers();
	}
	
	public void setSimulation(int simulation) {
		this.simulation = simulation;
		setChanged();
		notifyObservers();
	}
	
	public void stopFly(){
		this.flyTimer.stop();
		setChanged();
		notifyObservers();
	}
	
	public void clearRectangles(){
		rectangles.clear();
		setChanged();
		notifyObservers();
	}
	
	public void clearCoordonneeDerive(){
		coordDeriver.clear();
		setChanged();
		notifyObservers();
	}
	
}
