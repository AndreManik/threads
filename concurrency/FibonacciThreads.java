package concurrency;

import java.util.concurrent.Callable;

public class FibonacciThreads implements Callable<Long>{
	
	private int n = 0;
	
	public FibonacciThreads(int n) {
		this.n = n;
	}
	
	public long fibonacci(int n) {
		if (n < 2) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public void run() {
		System.out.println(fibonacci(n));
	}
	
	public Long call() {
		return fibonacci(n);
	}
	
}
