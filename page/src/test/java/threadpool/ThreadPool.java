package threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.concurrent.*;

/**
 * @program: embeddedTomcatSample
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-04 13:47
 **/
public class ThreadPool {
	public static ExecutorService newFixedThreadPool(int nThreads) {
		return new ThreadPoolExecutor(nThreads, nThreads,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}

	public static ExecutorService newCachedThreadPool() {
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
				.setNameFormat("demo-pool-%d").build();
		ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

		singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
		singleThreadPool.shutdown();

		return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
				60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
	}
	public static void main(String[] args){
		newCachedThreadPool();

	}

}
