
public class WQU extends Percolation{
	public int[] sz;
	public WQU(int N){
		super(N);
		sz=new int[size];
		for (int i=0; i<size; i++)
			sz[i]=1;
	}
	
	public void union(int p, int q){
		int i=find(p), j=find(q);
		if (i==j)
			return;
		if (sz[i]<sz[j]){
			id[i]=j;
			sz[j]+=sz[i];
		}
		else{
			id[j]=i;
			sz[i]+=sz[j];
		}
	}
	
	public int find(int p){
		while (id[p]!=p)
			p=id[p];
		return p;
	}
}
