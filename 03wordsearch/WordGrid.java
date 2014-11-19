public class WordGrid{
    private char[][]data;
    public int rows,cols;
    public WordGrid(int rows,int cols){
	data=new char[rows][cols];
	this.rows=rows;
	this.cols=cols;
    }
    private void clear(){
	for (int i=0;i<rows;i++){
	    for (int k=0;k<cols;k++){
		data[i][k]=' ';
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
    public boolean addWordHorizontal(String word,int row,int col){
	boolean ans=!(word.length()==0) &&
	    row>=0 &&
	    rows>=(row+word.length());
	return ans;
	    
    }
    public static void main(String args[]){
	WordGrid a = new WordGrid(3,4);
	a.data[0][0]='a';
	a.data[0][1]='b';
	a.data[2][3]='c';
	a.data[1][3]='d';
	System.out.println(a);
	a.clear();
	System.out.println(a);
    }
}
