public class PercolationStats {
	int N, T;
	double sample[];
	double mean=0, stddev, lo, hi;
	double start, end, runtime;
	public PercolationStats(int N, int T, String arg){
		this.N=N;
		this.T=T;
		sample=new double[T];
		
		start=System.currentTimeMillis();
		if (arg.equals("Quick Find"))
			for (int i=0; i<T; i++){
				Percolation qf=new QF(N);
				sample[i]=qf.test(N);
				}
		
		if (arg.equals("Weighted Quick Union"))
			for (int i=0; i<T; i++){
				Percolation wqu=new WQU(N);
				sample[i]=wqu.test(N);
				}
		end=System.currentTimeMillis();
		runtime=end-start;
	}
	
	// sample mean of percolation threshold
	public double mean(){
		double sum=0;
		for (int i=0; i<T; i++)
			sum+=sample[i];
		mean=sum/T;
		return mean;
	}
		
	// sample standard deviation of percolation threshold 
	public double stddev(){
		double sigma_2, sum=0;
		for (int i=0; i<T; i++)
			sum+=(sample[i]-mean)*(sample[i]-mean);
		sigma_2=sum/(T-1);
		stddev=Math.sqrt(sigma_2);
		return stddev;
		}
		
	//returns lower bound of the 95% confidence interval 
	public double confidenceLo(){
		lo=mean-1.96*stddev/Math.sqrt(T);
		return lo;
	}
		
	//returns upper bound of the 95% confidence interval
	public double confidenceHi(){
		hi=mean+1.96*stddev/Math.sqrt(T);
		return hi;
	}
}
