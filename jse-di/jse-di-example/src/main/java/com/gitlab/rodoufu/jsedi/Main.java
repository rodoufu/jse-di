package com.gitlab.rodoufu.jsedi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.gitlab.rodoufu.jsedi.cdi.WeldContext;

public class Main {
	private @Inject Instance<Counting> count;

	public static void main(String[] args) {
		WeldContext.INSTANCE.getBean(Main.class).execute();
	}

	/**
	 * Using ApplicationScoped, ThreadScoped and NormalScoped objects.
	 */
	private void execute() {
		System.out.println("Begin");
		
		try {
			final ExecutorService executor = Executors.newWorkStealingPool();
			for (int i = 0; i < 3; i++) {
				executor.submit(count.get());
			}
			executor.shutdown();
			executor.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("End");
	}

}
