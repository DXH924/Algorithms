import java.lang.Math;
public class Percolation{
	static int[][] a;
	static int[] id;
	
	public int size;
	public int cnt=0;
	public int top, bottom;
	public Percolation(int N){
		a=new int[N][N];
		size=N*N+2;
		top=size-2;
		bottom=size-1;
		id=new int[size];
		
		for (int i=0; i<size; i++)
			id[i]=i;
		
		
		for (int i=0; i<N; i++)
			id[i]=id[top];
		for (int i=size-2-N; i<size-2; i++)
			id[i]=id[bottom];
	}
	
	public void open(int i, int j){
		a[i][j]=1;
		cnt++;
	}
	
	public boolean isOpen(int i, int j){
		return a[i][j]==1;
	}
	
	public boolean isFull(int i, int j){
		return a[i][j]==0;
	}
	
	public void union(int p, int q){
		int pID=find(p), qID=find(q);
		if (pID==qID)
			return;
		for (int i=0; i<size; i++)
			if (id[i]==pID)
				id[i]=qID;
	}
	
	public int find(int p){
		return id[p];
	}
	
	public boolean connected(int i, int j){
		return find(i)==find(j);
	}
	public boolean percolates(){
		if (connected(top, bottom)) 
			return true;
		return false;
	}
	
	public void set(int N){
		 	int i=(int)(Math.random()*N);
			int j=(int)(Math.random()*N);
			if (isOpen(i, j))
				return;
			open(i,  j);//设置open格点
			int p, q=0;//p为(i,j)的格子,q为p相邻的格子
			p=i*N+j;
			if (i-1>=0){
				q=p-N;
				if (a[i-1][j]==1)
					union(p, q);
			}	
			if (j+1<N){
				q=p+1;
				if (a[i][j+1]==1)
					union(p, q);
			}	
			if (i+1<N){
				q=p+N;
				if (a[i+1][j]==1)
					union(p, q);
			}
			if (j-1>=0){
				q=p-1;
				if (a[i][j-1]==1)
					union(p, q);
			}	
	}
	
	public double test(int N){
		while (!percolates()){
			int i=(int)(Math.random()*N);
			int j=(int)(Math.random()*N);
			set(N);
		}
		double mean=cnt*1.0/(size-2);
		return mean;
	}
}
