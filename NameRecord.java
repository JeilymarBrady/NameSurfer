import java.util.Scanner ;

public class NameRecord{

	String name ;
	int[] rank ;
	final static int START = 1900 ;
	final static int DECADES = 12 ;
	
	/**
	* Construct a name record from a String like this
	* Abigail 0 0 0 0 854 654 615 317 150 50 14
	*/
	public NameRecord(String str) {
		Scanner sc = new Scanner( str ) ;
		name = sc.next() ;
		rank = new int[DECADES] ;
		int i = 0 ;
		while ( sc.hasNext() ) {
			rank[i] = sc.nextInt() ;
			i++ ;
		}	
	}
	
	public String getName() {
		return name ;
	}
	
	public int getRank(int decade ) {
		if ( decade < 0 || decade >= DECADES )
			return -1 ;
		return rank[decade] ;
	}
	
	public int bestDecade() {
		int result = 10000 ;
		int index = -1 ;
		for( int i = 0; i < DECADES; i++ ) 
			if( rank[i] > 0 && rank[i] < result ) {
				result = rank[i] ;
				index = i ;
			}
		return START + index * 10 ;
	}
	
	public String toString() {
		String result = name ;
		for(int i = 0; i < DECADES; i++ )
			result = result + " " + rank[i] ;
		return result ;
	}
	
	public int startsWithChar( char ch, NameRecord[] data ) {
		int count = 0 ;
		for(int i = 0; i < data.length; i++ ) {
			String name = data[i].getName() ;
			char letter = name.charAt(0) ;
			if( letter == ch )
				count++ ;
		}
		return count ; 
	}
	
	
}
