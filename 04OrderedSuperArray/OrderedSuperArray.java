public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	this(10);
    }
    public OrderedSuperArray(int x){
	data=new String[x];
	size=0;
    }
    public String toString(){
	String ans="[ ";
	for (int i=0;i<size;i++){
	    ans+=data[i]+" ";
	}
	return ans+"]";
    }
    public int find(String target){
	int min=0;
	int max=size-1;
	int spot=(min+max)/2;
	while (data[spot]!=target&&min<=max){
	    if (data[spot].compareTo(target)>0){
		max=spot-1;
	    }
	    else{
		min=spot+1;
	    }
	    spot=(min+max)/2;
	}
	if (min<=max){
	    return spot;
	}
	else{
	    return -1;
	}
    }
    public void resize (int newCapacity){
	String[] newArray = new String[newCapacity];
	if (newCapacity>=data.length){
	    for (int i=0;i<data.length;i++){
		newArray[i]=data[i];
	    }
	}
	else{
	    for (int i=0;i<newCapacity;i++){
		newArray[i]=data[i];
	    }
	}
	data=newArray;
    }
    public int size(){
	int ans=0;
	for (int i=0;i<data.length;i++){
	    if (data[i]!=null){
		ans++;
	    }
	}
	return ans;
    }
    public void add(String e){
        int index=size();
	while (index>0&&get(index-1).compareTo(e)>0){
	    index--;
	}
	super.add(index,e);
    }
    public void clear(){
	for (int i=0;i<data.length;i++){
	    data[i]=null;
	}
    }
    public String get(int index){
	if (index<data.length&&index>=0){
	    return data[index];
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
	if (index<0||index>=data.length){
	    System.out.println("Index out of range.");
	    throw new IndexOutOfBoundsException();
	}
	String a=data[index];
	add(o);
	return remove(index);
    }
}
