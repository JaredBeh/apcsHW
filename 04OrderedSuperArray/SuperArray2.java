public class SuperArray2{
    public String[] theArray;
    public int elementCounter;
    public SuperArray2(){
	theArray=new String[10];
    }
    public SuperArray2(int x){
	theArray=new String[x];
    }
    public String toString(){
	String ans="[ ";
	for (int i=0;i<theArray.length;i++){
	    ans+=theArray[i]+" ";
	}
	return ans+"]";
    }
    public int find(String target){
	for (int x=0;x<theArray.length;x++){
	    if (theArray[x]==target){
		return x;
	    }
	}
	return -1;
    }
    public void selectionSort(){
	for (int n=0;n<size();n++){
	    String a=theArray[n];
	    int index=0;
	    for (int i=n;i<size();i++){
		if (theArray[i].compareTo(a)<0){
		    a=theArray[i];
		    index=i;
		}
	    }
	    toString();
	    theArray[index]=theArray[n];
	    theArray[n]=a;
	    toString();
	}
    }
	public void insertionSort(){
	for (int i=0;i<theArray.length-1;i++){
	    if (theArray[i]!=null && theArray[i+1]!=null && theArray[i].compareTo(theArray[i+1])>0){
		String a=theArray[i+1];
		int index=0;
		for (int n=0;n<i+1;n++){
		    if (a.compareTo(theArray[n])<=0){
			index=n;
			break;
		    }
		}
		for (int n=i+1;n>index;n--){
		    theArray[n]=theArray[n-1];
		}
		theArray[index]=a;
	    }
	}
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
	boolean isRoom=false;
	for (int i=0;i<theArray.length;i++){
	    if (theArray[i]==null){
		theArray[i]=e;
		isRoom=true;
		break;
	    }
	}
	if (!isRoom){
	    resize(theArray.length*2);
	    theArray[theArray.length/2]=e;
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
	if (index<theArray.length){
	    resize(theArray.length+1);
	    for (int i=theArray.length-1;i>index;i--){
		theArray[i]=theArray[i-1];
	    }
	}
	else{
	    resize(index+1);
	}
	theArray[index]=o;
    }
    public String set(int index, String o){
	if (index<0||index>=theArray.length){
	    System.out.println("Index out of range.");
	    throw new IndexOutOfBoundsException();
	    //return null;
	}
	String x=theArray[index];
	theArray[index]=o;
	return x;
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
