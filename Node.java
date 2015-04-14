public class Node {
	
	private Node parent;
	private Character charactere;
	private Node[] enfants; 
	private int valeur;
	private String valeurBinaire;
	
	public Node( Character c, int v ){
		parent = null;
		enfants = new Node[2];
		charactere = c;
		valeur = v;
	}
	
	public Node( Character c, int v, Node e1, Node e2 ){
		parent = null;
		enfants = new Node[2];
		enfants[0] = e1;
		enfants[1] = e2;
		charactere = c;
		valeur = v;
	}
	
	public void addParent( Node p){
		parent = p;
	}
	
	public void addEnfants( Node e1, Node e2){
		enfants[0] = e1;
		enfants[1] = e2;
	}
	
	public void setValeur( int v){
		valeur = v;
	}
	
	public int getValeur(){
		return valeur;
	}
	
	public void setValeurB( String v){
		valeurBinaire = v;
	}
	
	public String getValeurB(){
		return valeurBinaire;
	}
	
	
	public Character getChar(){
		return charactere;
	}
	
	public Node getParent(){
		return parent;
	}
	
	public String toString(){
		return "Noeud de valeur "+valeur+" : "+ valeurBinaire;
	}
}
