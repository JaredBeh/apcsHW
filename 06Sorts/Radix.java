public class Radix{
    public static int[] radix(int[] data){
	ArrayList<ArrayList<Integer>> buckets=new ArrayList<ArrayList<Integer>>();
	int passes=1;
	for (int i=0;i<data.length;i++){
	    buckets[data[i]%10*passes].add(data[i]);
	}
    }
}