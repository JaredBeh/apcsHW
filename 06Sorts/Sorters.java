public class Sorters{
    int[] data;
    int size;
    public Sorters(int a){
	data=new int[a];
    }
    public Sorters(){
	this(10);
    }
    public int getSize(){
	int ans=0;
	for (int i=0;i<data.length;i++){
	    if (data[i]!=null){
		ans++;
	    }
	}
	return ans;
    }
    public String toString(){
	String ans="";
	for (int i=0;i<getSize();i++){
	    ans+=data[i]+"  ";
	}
    }
    public void bubbleSort(){
	boolean swapped=false;
	int b=getSize()-1;
	do{
	    swapped=false;
	    for (int i=0;i<b;i++){
		if (data[i].compareTo(data[i+1])>0){
		    swapped=true;
		    int tempVar=data[i];
		    data[i]=data[i+1];
		    data[i+1]=tempVar;
		}
	    }
	}while(swapped);
    }
    public static void main (String[]args){
	Sorter a=new Sorter();
	a.bubbleSort();
	System.out.println(a);
    }
}