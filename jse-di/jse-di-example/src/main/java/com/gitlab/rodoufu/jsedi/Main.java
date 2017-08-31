package com.gitlab.rodoufu.jsedi;

import com.gitlab.rodoufu.jsedi.cdi.WeldContext;

public class Main {

	public static void main(String[] args) {
		WeldContext.INSTANCE.getBean(Main.class).execute();
	}

	private void execute() {
		System.out.println("Funcionou");
	}

}
