public class OrderedTester{
    public static void main(String[]args){
	OrderedSuperArray a = new OrderedSuperArray(4);
	a.add("ball");
	a.add("all");
	a.set(2,"aa");
	System.out.println(a);
	String[]b={"a","e","d","c"};
	a.resize(11);
	System.out.println(a.find("d"));
    }
}
