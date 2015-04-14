import java.util.*;
import java.util.Map.Entry;

public class Tree {
	public LinkedList<Node> arbre;
	private LinkedHashMap<Character, String> treeCharKey;
	private LinkedHashMap<String, Character> treeBinaryKey;
	
	public Tree(){
		this.arbre = new LinkedList<Node>();
	}
	
	public void addNoeud( Node n ){
		arbre.offerLast(n);
	}
	
	public void insertNoeud( Node n, int index ){
		arbre.add(index, n);
	}
	
	public LinkedList<Node> getArbre( ){
		return arbre;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(Entry<Character, String> en : this.treeCharKey.entrySet()) {
			str += en.getKey() + " => " + en.getValue() + System.getProperty("line.separator");
		}
		return str;
	}

	public void readArbre(){
		for(Iterator<Node> it = arbre.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
	}
	
	public void finalTab(){
		LinkedHashMap<String,Character> lhmBinary = new LinkedHashMap<String,Character>();
		LinkedHashMap<Character,String> lhmChar = new LinkedHashMap<Character, String>();
		
		for( int i = 0 ; i < arbre.size(); i++){
			
			Node n = arbre.get(i);
			Node n1 = n;
			if( n.getChar() != null ){
				
				while(n1.getParent().getParent() != null){
					n.setValeurB(n1.getParent().getValeurB()+n.getValeurB());
					n1 = n1.getParent();
				}
				lhmBinary.put(arbre.get(i).getValeurB(), arbre.get(i).getChar());
				lhmChar.put(arbre.get(i).getChar(), arbre.get(i).getValeurB());
			}
			
		}
		
		this.treeBinaryKey = lhmBinary;
		this.treeCharKey = lhmChar;
	}
	
	public LinkedHashMap<String, Character> getTreeBinaryKey() {
		return this.treeBinaryKey;
	}
	
	public LinkedHashMap<Character, String> getTreeCharKey() {
		return this.treeCharKey;
	}
}

