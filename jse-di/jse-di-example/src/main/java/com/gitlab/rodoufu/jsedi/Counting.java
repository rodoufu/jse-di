package com.gitlab.rodoufu.jsedi;

import java.util.Random;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.gitlab.rodoufu.jsedi.pojo.Product;
import com.gitlab.rodoufu.jsedi.pojo.Staff;
import com.gitlab.rodoufu.jsedi.pojo.Store;

public class Counting implements Runnable {
	private int value;
	private @Inject Instance<Staff> staff;
	private @Inject Instance<Product> product;
	private @Inject Instance<Store> store;

	public Counting() {
		value = new Random().nextInt(100);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.printf("%2d - %2d - application scoped: %s, thread scoped: %s, normal scoped: %s\n", value, i,
					store.get().getName(), staff.get().getName(), product.get().getName());
		}
	}

}
