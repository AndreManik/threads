package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class FibonacciThread {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		ArrayList<Future<Long>> results = new ArrayList<>();
		
		for (int i = 0; i < 15; i++) {
			results.add(exec.submit(new FibonacciThreads(i + 30)));
		}
		
		for (Future<Long> fl : results) {
			try {
				System.out.println(fl.get());
			} catch (InterruptedException e) {
				System.out.println(e);
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
		}
		exec.shutdown();
	}
}
