package com.example.page;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {

	static class Task implements Callable<String>{
		private int i;

		public Task(int i){
			this.i = i;
		}

		@Override
		public String call() throws Exception {
			//
			int i=0;
			while (i<100){
				i++;
				System.out.println(Thread.currentThread().getName() + "执行完任务：" + i);
			}

			Thread.sleep(1);
			return Thread.currentThread().getName() + "执行完任务：" + i;
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		testExecutorCompletionService();
	}

	private static void testExecutorCompletionService() throws InterruptedException, ExecutionException{
		int numThread = 5;
		ExecutorService executor = Executors.newFixedThreadPool(numThread);
		CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
		for(int i = 0;i<numThread;i++ ){
			completionService.submit(new CompletionServiceTest.Task(i));
		}

		for(int i = 0;i<numThread;i++ ){
			System.out.println(completionService.take().get());
		}
		executor.shutdown();
		System.out.println("==========================");
	}
}