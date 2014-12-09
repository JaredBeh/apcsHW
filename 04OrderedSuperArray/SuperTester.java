public class SuperTester{
    public static void main(String[]args){
	SuperArray a=new SuperArray();
	a.insertionSort();
	a.add("c");
	a.add("d");
	a.add("c");
	a.add("b");
	a.insertionSort();
	System.out.println(a);
	a.add("a");
	a.resize(5);
	a.selectionSort();
	System.out.println(a.find("c"));
	System.out.println(a);
    }
}
