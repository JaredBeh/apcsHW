public class arrayTester{
    public static void main(String args[]){
	SuperArray a = new SuperArray();
	SuperArray b = new SuperArray(4);
	System.out.println(a);
	System.out.println(b);
	try{
	    a.resize(1);
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Error in index");
	}
	System.out.println(a.size());
	try{
	    a.add(new Integer(3));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Error in index");
	}
	try{
	    a.add(new String("hola"));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Error in index");
	}
	System.out.println(a);
	try{
	    System.out.println(""+a.get(2)+a.get(1));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Error in index");
	}
	try{
	    a.add(2,new Integer(4));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Error in index");
	}
	System.out.println(a);
	try{
	    a.add(2,new Integer(5));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Error in index");
	}
	System.out.println(a);
	try{
	    a.set(7,new Integer(8));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Error in index");
	}
	System.out.println(a);
	try{
	    a.remove(1);
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Error in index");
	}
	System.out.println(a);
    }
}
