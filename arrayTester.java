public class arrayTester{
    public static void main(String args[]){
	SuperArray a = new SuperArray();
	SuperArray b = new SuperArray(4);
	System.out.println(a);
	System.out.println(b);
	a.resize(1);
	System.out.println(a.size());
	a.add(new Integer(3));
	a.add(new String("hola"));
	System.out.println(a);
	System.out.println(""+a.get(2)+a.get(1));
	a.add(2,new Integer(4));
	System.out.println(a);
	a.add(2,new Integer(5));
	System.out.println(a);
	a.set(7,new Integer(8));
	System.out.println(a);
    }
}
