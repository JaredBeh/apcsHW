public class SuperTester{
    public static void main(String[]args){
	SuperArray2 a=new SuperArray2();
	a.insertionSort();
	a.add("c");
	a.add("d");
	a.add("c");
	a.insertionSort();
	System.out.println(a);
	a.add("a");
	a.resize(4);
	a.insertionSort();
	System.out.println(a);
    }
}