public class SuperArray{
    int size;
    String[] data;

    public SuperArray(){
	this(10);
    }

    public SuperArray(int startCapacity){
	size = 0;
	data = new String[ startCapacity ];
    }
    public void selectionSort(){
	int swapcounter=0;
	while (swapcounter<size-1){
	    String value=data[swapcounter];
	    int index=swapcounter;
	    for (int i=swapcounter+1;i<size;i++){
		if (data[i].compareTo(value)<0){
		    value=data[i];
		    index=i;
		}
	    }
	    if (index!=swapcounter){
		data[index]=data[swapcounter];
		data[swapcounter]=value;
	    }
	    swapcounter++;
	}
    }
    public void insertionSort(){
	for (int n=1;n<size();n++){
	    String value = data[n];
	    int i=n;
	    while (i>0&&data[i-1].compareTo(value)>0){
		data[i]=data[i-1];
		i--;
	    }
	    data[i]=value;
	}
    }
    public int find(String target){
	for (int i=0;i<size();i++){
	    if (data[i]==target){
		return i;
	    }
	}
	return -1;
    }
    public String toString(){
	String res = "[";
	for(int i = 0; i < size; i++){
	    res += data[i];
	    if(i != size - 1){
		res += " ";
	    }
	}
	return res + "]";
    }

    public void add(String o){
	if(size() == data.length){
	    resize(size * 2);
	}
	data[ size ] = o;
	size++;
    }
    public void add(int index, String o){
	if(index < 0 || index > size() ){
	    throw new IndexOutOfBoundsException();
	}				
	if(size() == data.length){
	    resize( size * 2 );
	}
	for(int i = data.length - 1; i > index; i--){
	    data[i] = data[i - 1];
	}
	data[ index ] = o;
	size++;
    }

    public int size(){
	return size;
    }

    public void clear(){
	size = 0;
    }

    public void resize(int newCapacity){
	String[] newData = new String[newCapacity];
	int max = Math.min(newCapacity,size);
	for(int i = 0; i < max; i++){
	    newData[i]= data[i];
	}
	data = newData;
    }
		
    public String set(int index, String o){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String temp = data[index];
	data[index]= o;
	return temp;
    }

    public String get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public String remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}

	String temp = data[index];
	while(index < size() - 1){
	    data[index] = data[index + 1];
	    index++;
	}
	size--;
	if(size < data.length / 4){
	    resize(data.length / 2);
	}
	return temp;
    }
}
