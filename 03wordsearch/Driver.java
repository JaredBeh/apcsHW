public class Driver{
    public static void main(String args[]){
	WordGrid a = new WordGrid(10,10);
	a.clear();
        System.out.println(a.add("test",2,5,-1,0));
	System.out.println(a);
    }
}
