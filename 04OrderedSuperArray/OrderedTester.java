public class OrderedTester{
    public static void main(String[]args){
	OrderedSuperArray a = new OrderedSuperArray(8);
	a.add("ball");
	a.add("all");
	a.add("d");
	a.add("aab");
	System.out.println(a);
	a.resize(5);
	System.out.println(a.find("d"));
	System.out.println(a);
    }
}
