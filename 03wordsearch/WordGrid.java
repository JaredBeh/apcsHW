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
    public String reverseString(String s){
	String ans="";
	for (int i=s.length()-1;i>=0;i--){
	    ans+=s.charAt(i);
	}
	return ans;
    }
    public boolean addWordUpLeft(String word,int row,int col){
	return addWordDownRight(reverseString(word),1+row-word.length(),1+col-word.length());
    }
    public boolean addWordUp(String word,int row,int col){
	return addWordVertical(reverseString(word),1+row-word.length(),col);
    }
    public boolean addWordBackwards(String word,int row,int col){
	return addWordHorizontal(reverseString(word),row,1+col-word.length());
    }
    public boolean addWordHorizontal(String word,int row,int col){
	boolean ans=!(word.length()==0) &&
	    row>=0 &&
	    col>=0 &&
	    row<=rows &&
	    cols>=(col+word.length());
	if (!ans){
	    return false;
	}
	for (int i=col;i<col+word.length();i++){
	    if (data[row][i]==(' ') || data[row][i]==word.charAt(i-col)){
		continue;
	    }
	    else{
		return false;
	    }
	}
	for (int i=col;i<col+word.length();i++){
	    data[row][i]=word.charAt(i-col);
	}
	return ans;
	    
    }
    public boolean addWordVertical(String word,int row,int col){
	boolean ans=!(word.length()==0) &&
	    row>=0 &&
	    col>=0 &&
	    col<=cols &&
	    rows>=(row+word.length());
	if (!ans){
	    return false;
	}
	for (int i=row;i<row+word.length();i++){
	    if (data[i][col]==(' ') || data[i][col]==word.charAt(i-row)){
		continue;
	    }
	    else{
		return false;
	    }
	}
	for (int i=row;i<row+word.length();i++){
	    data[i][col]=word.charAt(i-row);
	}
	return ans;
	    
    }
    public boolean addWordDownRight(String word,int row,int col){
	boolean ans=!(word.length()==0) &&
	    row>=0 &&
	    col>=0 &&
	    cols>=(col+word.length()) &&
	    rows>=(row+word.length());
	if (!ans){
	    return false;
	}
	int col2=col;
	for (int i=row;i<row+word.length();i++){
	    if (data[i][col2]==(' ') || data[i][col2]==word.charAt(i-row)){
		col2++;
		continue;
	    }
	    else{
		return false;
	    }
	}
	for (int i=row;i<row+word.length();i++){
	    data[i][col]=word.charAt(i-row);
	    col++;
	}
	return ans;
	    
    }
    public static void main(String args[]){
	WordGrid a = new WordGrid(4,4);
	a.data[0][0]='a';
	a.data[0][1]='b';
	a.data[2][3]='c';
	a.data[1][3]='d';
	System.out.println(a);
	a.clear();
	System.out.println(a);
	a.addWordHorizontal("Sup",0,1);
	System.out.println(a);
	System.out.println(a.addWordUpLeft("dac",3,3));
	System.out.println(a);
	/*a.addWordHorizontal("dlc",1,1);
	a.addWordHorizontal("sho",1,0);
	System.out.println(a);
	a.clear();
	a.addWordVertical("ones",0,0);
	a.addWordVertical("da",1,0);
	a.addWordHorizontal("ya",1,1);
	a.addWordVertical("bal",0,2);
	System.out.println(a);
	System.out.println(a.addWordVertical("a",0,0));
	if (a.addWordVertical("test",0,3)){
	    System.out.println("worked");
	}
	System.out.println(a);*/
    }
}
