public class Driver{
    public static void main(String[]args){
	WordGrid a = new WordGrid(5,5);
	a.clear();
	a.wordBankReader();
	System.out.println(a);
	System.out.println(a.wordsInPuzzle());
    }
}
