public class Set {
    private static final int SIZE = 10; // default size of initial set
                                
    private int[] set;      // array referece to the set
    private int size;       // current size of the set
    private int next;       // index to next available slot in the set array
    
    
    public Set() {
        int size = SIZE;
        set = new int[size];
        next = 0;
    }
 
    
    public Set(int[] arr) {
        this();
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }
    
    public Set clone() {
        Set clone = new Set(set);
        return clone;
    }

    public void insert(int k) {
        if(member(k) == false){
            if(next == SIZE){
                resize();
                set[next] = k;
                next++;
            }else{
                set[next] = k;
                next++;
            }
        }
    }
  
    private void resize() {
        size *= 2;

	// Create a new array double the size
        int[] temp = new int[size];

	// Copy all the elements from the current set
	// to the new set
        for(int i = 0; i < set.length; ++i) {
            temp[i] = set[i];
        }

	// Assign to the set reference the newly
	// resized array that represents the set.
        set = temp;
    }

    public  String toString()  {
        String s = "";
        for (int i = 0; i < this.next ; i++) {
            if (i != next  - 1) {
                s += this.set[i];
                s += ",";
            } else {
                s += this.set[i];
            }
        }
        return s;
    } 
     
    public int cardinality() {
        int count = next ;
        return count;
    }
    
    public  boolean isEmpty() {
        boolean check = false;
        if (next  == 0) {
            check = true;
        }
        return check;
    }
      
    public boolean member(int k) {
        boolean check = false;
        for (int i = 0; i < set.length; i++) {
            if (set[i] == k) {
                check = true;
            }
        }
        return check;
    }    
   
    public  boolean subset(Set S) {
        boolean check = false;
        for (int i = 0; i < S.cardinality(); i++) {
            if (S.member(set[i]) == true) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }
    
    public  boolean equal(Set S) {
        boolean check = false;
        if(S.next == next){
            check = true;
        }else if (subset(S) == false) {
            check = false;
        } 
        return check;
    }
       
    public void delete(int k) {
        for (int i = 0; i < set.length; i++) {
            if (set[i] == k) {
                set[i] = 0;
            }else{
                break;
            }
        }
        for (int j = 0; j < set.length-1; j++) {
            set[j] = set[j + 1];
        }
        next -= 1;
    }   
  
    public Set union(Set S) {
        int combonext  = S.next  + next ;
        int [] arr = new int [combonext ];
        Set union = new Set(arr);
        int counter = 0;
        for (int i = 0; i < this.next ; i++) {
           if(union.member(this.set[i])== false){
             union.insert(this.set[i]);
             counter +=1;
           }
        }
        for (int i = 0; i < S.next ; i++) {
           if(union.member(S.set[i])== false){
             union.insert(S.set[i]);
             counter +=1;
           }
        }
        union.next  = counter;
        return union;
    }
   
    public Set intersection(Set S) {
        Set inter = new Set();
        for (int i = 0; i < this.next; i++) {
            if (S.member(set[i]) == true) {
                inter.insert(set[i]);
            }
        }
        return inter;
    }
    
    public Set setdifference(Set S) {
        Set setdifference = new Set();
           for(int i =0; i<S.next; i++){
            
            if(set[i] == 0){
                setdifference.insert(set[i]);
            }
              if(S.member(set[i])== false){
                setdifference.insert(set[i]);
              }
           }
           return setdifference;
    }
      
}
