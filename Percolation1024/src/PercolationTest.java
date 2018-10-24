import java.util.*;
public class PercolationTest {
	public static void main(String[] args){
		int N, T;
		String arg1="Quick Find";
		String arg2="Weighted Quick Union";
		System.out.println("enter N and T:");
		Scanner input=new Scanner(System.in);
		N=input.nextInt();
		T=input.nextInt();
		for (int i=0; i<5; i++, N*=2){
			PercolationStats qf=new PercolationStats(N, T, arg1);
			PercolationStats wqu=new PercolationStats(N, T, arg2);
			show(qf, arg1);
			show(wqu, arg2);
			System.out.println("When N = "+N+" ,");
			System.out.println(arg2+" is "+qf.runtime/wqu.runtime+" times faster than "+arg1);
			System.out.println();
		}					
	}
	
	public static void show(PercolationStats t, String arg){
		System.out.println(arg);
		System.out.println("N = "+t.N+", T = "+t.T);
		System.out.println("mean           = "+t.mean());
		System.out.println("stddev         = "+t.stddev());
		System.out.println("confidenceLow  = "+t.confidenceLo());
		System.out.println("confidenceHigh = "+t.confidenceHi());
		System.out.println("running time   = "+t.runtime+"ms\n");
	}
}
