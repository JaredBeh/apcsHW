import java.util.*;
import java.io.*;
public class WordGrid{
    Random rnd;
    public boolean fillSpaces=true;
    private char[][]data;
    public String theWords="";
    public int rows,cols;
    public WordGrid(int numrows,int numcols){
	this(numrows,numcols,0);
	Random rnd2=new Random();
	rnd=rnd2;
    }
    public WordGrid(int numrows,int numcols,int newseed,int toFill){
	data=new char[numrows][numcols];
	rows=numrows;
	cols=numcols;
	rnd=new Random(newseed);
	clear();
	if (toFill==1){
	    fillSpaces=false;
	}
    }
    public WordGrid(){
	this(8,8);
    }
    public WordGrid(int numrows,int numcols,int newseed){
	this(numrows,numcols,newseed,0);
    }
    public String wordsInPuzzle(){
	return "Find these words\n"+theWords+"\n";
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
	boolean ans=!(word.length()==0) &&
	    row>=0 &&
	    col>=0 &&
	    (dx==1||dx==0||dx==-1) &&
	    (dy==1||dy==0||dy==-1) &&
	    !(dy==0&&dx==0) &&
	    (cols>=col+(dx*word.length())&&0<=col+(dx*word.length())) &&
	    (rows>=(row+(dy*word.length()))&&0<=row+(dy*word.length()));
	if (!ans){
	    return false;
	}
	int col2=col;
	for (int i=0;i<word.length();i++){
	    if (!(data[row+(dy*i)][col2+(dx*i)]==(word.charAt(i))) &&
		(data[row+(dy*i)][col2+(dx*i)]!='-')){
		return false;
	    }
	}
	for (int i=0;i<word.length();i++){
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
		    theWords+=currentWord+" ";
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found.");
	}
	if (fillSpaces){
	    for (int i=0;i<data.length;i++){
		for (int n=0;n<data[0].length;n++){
		    if (data[i][n]=='-'){
			data[i][n]=(char)(97+rnd.nextInt(26));
		    }
		}
	    }
	}
    }
}
