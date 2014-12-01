public class Driver{
    public static void main(String[]args){
	WordGrid a = new WordGrid(10,10);
	a.clear();
	a.wordBankReader();
	System.out.println(a);
    }
}
