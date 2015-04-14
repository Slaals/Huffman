import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;


public class TreeBuilder {
	
	private Occurrence[] chars;
	private Tree tree;
	
	public TreeBuilder(Occurrence[] chars) {
		this.chars = chars;
	}

	public String algo1() {
		long t1 = System.currentTimeMillis();
	
		LinkedHashMap<Character, Integer> charsKey = new LinkedHashMap<Character, Integer>();
		
		// Trie du tableau : O(N log N)
		IntroSort.sort(this.chars);
		//MergeSort.sort(this.chars, this.chars.length);
		
		/*
		 *  Insertion des valeurs triées dans un LinkedHashMap en supprimant les occurrences à 0
		 *  NOTE : put = O(1)
		 */
		for(char c = 0; c < this.chars.length; c++) {
			if(this.chars[c].getOcu() > 0)
				charsKey.put(this.chars[c].getCharacter(), this.chars[c].getOcu());
		}

		this.tree = new Tree();
		
		Set<Character> s2 =  charsKey.keySet();
		for(Iterator<Character> it = s2.iterator(); it.hasNext();){
			Character c1 = it.next() ;
			
			this.tree.addNoeud( new Node( c1, charsKey.get(c1)) );
			
		}
		
		LinkedList<Node> a2 = this.tree.getArbre();
		
		for(int i = 0; i < a2.size()-1; i+=2){
			Node n1 = a2.get( i );
			Node n2 = a2.get( i+1);
			
			Node n3 = new Node( null, n1.getValeur()+n2.getValeur(), n1, n2 );
			n1.addParent( n3 );
			n2.addParent( n3 );
			
			n1.setValeurB( "0" );
			n2.setValeurB( "1" );
			
			int j = i;
			while( a2.get(j).getValeur() < n3.getValeur() ){
				j++;
				if( j == a2.size() ){
					break;
				}
			}
			this.tree.insertNoeud(n3,j);
	
		}
		
		this.tree.finalTab();
		
		/*Set<Map.Entry<Character, String>> s =  this.tree.getTreeCharKey().entrySet();
		for(Iterator<Map.Entry<Character, String>> it = s.iterator(); it.hasNext();){
			System.out.println(it.next());
		}*/
		
		long t2 = System.currentTimeMillis() - t1;
		
		return String.valueOf(t2);
		
	}
	
	public Tree getTree() {
		return this.tree;
	}
	
}
