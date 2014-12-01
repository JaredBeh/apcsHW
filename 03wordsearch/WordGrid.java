import java.util.*;
import java.io.*;
public class WordGrid{
    Random rnd;
    private char[][]data;
    private ArrayList<String> theWords=new ArrayList<String>(100);
    public int rows,cols;
    public WordGrid(int numrows,int numcols){
	data=new char[numrows][numcols];
	rows=numrows;
	cols=numcols;
	rnd=new Random();
    }
    public WordGrid(int numrows,int numcols,int newseed){
	this(numrows,numcols);
	rnd.setSeed(newseed);
    }
    public String wordsInPuzzle(){
	String ans="";
	for (int i=0;i<theWords.size();i++){
	    ans+=theWords.get(i)+" ";
	}
	return ans;
    }
    public void clear(){
	for (int i=0;i<rows;i++){
	    for (int k=0;k<cols;k++){
		data[i][k]='-';
	    }
	}
    }
    public String toString(){
	String ans="";
	for (int i=0;i<rows;i++){
	    for (int k=0;k<cols;k++){
		ans+=data[i][k]+" ";
	    }
	    ans+="\n";
	}
	return ans;
    }
    public String reverseString(String s){
	String ans="";
	for (int i=s.length()-1;i>=0;i--){
	    ans+=s.charAt(i);
	}
	return ans;
    }
    public boolean tryAdd(String word){
	for (int n=0;n<50;n++){
	    if (add(word,rnd.nextInt(rows),rnd.nextInt(cols),rnd.nextInt(2),rnd.nextInt(2))){
		return true;
	    }
	}
	return false;
    }
    public boolean add(String word,int row,int col,int dx,int dy){
	System.out.println(row+(dy*word.length()));
	boolean ans=!(word.length()==0) &&
	    row>=0 &&
	    col>=0 &&
	    (dx==1||dx==0||dx==-1) &&
	    (dy==1||dy==0||dy==-1) &&
	    (cols>=col+(dx*word.length())||0<=col+(dx*word.length())) &&
	    (rows>=(row+(dy*word.length()))||0<=row+(dy*word.length()));
	if (!ans){
	    return false;
	}
	char[][]data2=data;
	int col2=col;
	for (int i=0;i<word.length();i++){
	    if (!(data[row+(dy*i)][col2+(dx*i)]==(word.charAt(i))) &&
		(data[row+(dy*i)][col2+(dx*i)]!='-')){
		data=data2;
		return false;
	    }
	    data[row+dy*i][col2+dx*i]=word.charAt(i);
	}
	return true;
    }
    public void wordBankReader(){
	try{
	    File file = new File("wordbank.txt");
	    Scanner scnr = new Scanner(file);
	    String currentWord="";
	    while (scnr.hasNextLine()){
		currentWord=scnr.nextLine();
		if (tryAdd(currentWord)){
		    theWords.add(currentWord);
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found.");
	}
    }
}
