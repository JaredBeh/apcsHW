public class Driver{
    public static void main(String[]args){
	WordGrid a;
	if (args.length<2){
	    a = new WordGrid();
	    System.out.println("Please give arguments for the length and width of the word grid.");
	    System.exit(0);
	}
	else if (args.length==2){
	    a = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	}
	else if (args.length==3){
	    a = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
	}
	else{
	    a = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
	}
	a.wordBankReader();
	System.out.println(a.wordsInPuzzle()+a);
    }
}

