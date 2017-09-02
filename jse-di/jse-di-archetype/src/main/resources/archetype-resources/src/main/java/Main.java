package ${groupId};

import javax.inject.Inject;

import ${groupId}.cdi.WeldContext;

/**
 * The main application.
 * @author rodoufu
 */
public class Main {
	private @Inject HelloWorld helloWorld;

	/**
	 * Just starts the CDI container and calls the <i>execute</i> method.
	 * @param args
	 */
	public static void main(String[] args) {
		WeldContext.INSTANCE.getBean(Main.class).execute();
	}

	/**
	 * Application implementation.
	 */
	private void execute() {
		System.out.println(helloWorld.getMessage());
		// Here goes your implementation
	}

}
