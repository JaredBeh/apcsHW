public class SuperArray{
    public Object[] theArray;
    public int elementCounter;
    public SuperArray(){
	theArray=new Object[10];
    }
    public SuperArray(int x){
	theArray=new Object[x];
    }
    public String toString(){
	String ans="[ ";
	for (int i=0;i<theArray.length;i++){
	    ans+=theArray[i]+" ";
	}
	return ans+"]";
    }
    public void resize (int newCapacity){
	Object[] newArray = new Object[newCapacity];
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
    public void add(Object e){
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
    public Object get(int index){
	if (index<theArray.length&&index>=0){
	    return theArray[index];
	}
	else{
	    System.out.println("Index out of range.");
	    throw new IndexOutOfBoundsException();
	    
	}
    }
    public void add(int index,Object o){
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
    public Object set(int index, Object o){
	if (index<0||index>=theArray.length){
	    System.out.println("Index out of range.");
	    throw new IndexOutOfBoundsException();
	    //return null;
	}
	Object x=theArray[index];
	theArray[index]=o;
	return x;
    }
    public Object remove(int index){
	if (index<theArray.length&&index>=0){
	    Object ans=theArray[index];
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
