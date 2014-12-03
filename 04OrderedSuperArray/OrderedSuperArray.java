public class OrderedSuperArray{
    public String[] theArray;
    public int elementCounter;
    public OrderedSuperArray(){
	theArray=new String[10];
    }
    public OrderedSuperArray(int x){
	theArray=new String[x];
    }
    public String toString(){
	String ans="[ ";
	for (int i=0;i<theArray.length;i++){
	    ans+=theArray[i]+" ";
	}
	return ans+"]";
    }
    public void resize (int newCapacity){
	String[] newArray = new String[newCapacity];
	if (newCapacity>=theArray.length){
	    for (int i=0;i<theArray.length;i++){
		newArray[i]=theArray[i];
	    }
	}
	else{
	    for (int i=0;i<newCapacity;i++){
		newArray[i]=theArray[i];
	    }
	}
	theArray=newArray;
    }
    public int size(){
	int ans=0;
	for (int i=0;i<theArray.length;i++){
	    if (theArray[i]!=null){
		ans++;
	    }
	}
	return ans;
    }
    public void add(String e){
	boolean isRoom=(theArray.length==size());
	if (!isRoom){
	    resize(theArray.length*2);
	}
	boolean worked=false;
	for (int i=0;i<size();i++){
	    if (e.compareTo(theArray[i])>0){
		for (int n=size()-1;n>=i;n--){
		    theArray[n+1]=theArray[n];
		}
		theArray[i]=e;
		worked=true;
		break;
	    }
	}
	if (!worked){
	    for (int n=size()-1;n>=0;n--){
		theArray[n+1]=theArray[n];
	    }
	    theArray[0]=e;
	}
    }
    public void clear(){
	for (int i=0;i<theArray.length;i++){
	    theArray[i]=null;
	}
    }
    public String get(int index){
	if (index<theArray.length&&index>=0){
	    return theArray[index];
	}
	else{
	    System.out.println("Index out of range.");
	    throw new IndexOutOfBoundsException();
	    
	}
    }
    public void add(int index,String o){
	add(o);
    }
    public String set(int index, String o){
	if (index<0||index>=theArray.length){
	    System.out.println("Index out of range.");
	    throw new IndexOutOfBoundsException();
	}
	String a=theArray[index];
	add(o);
	return remove(index);
    }
    public String remove(int index){
	if (index<theArray.length&&index>=0){
	    String ans=theArray[index];
	    for (int i=index;i<theArray.length-1;i++){
		theArray[i]=theArray[i+1];
	    }
	    theArray[theArray.length-1]=null;
	    return ans;
	}
	else{
	    System.out.println("Error");
	    throw new IndexOutOfBoundsException();
	    
	}
    }
}
