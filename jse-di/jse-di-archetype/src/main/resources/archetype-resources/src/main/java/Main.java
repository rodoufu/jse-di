package ${groupId};

import javax.inject.Inject;

import ${groupId}.cdi.WeldContext;

public class Main {
	private @Inject HelloWorld helloWorld;

	public static void main(String[] args) {
		WeldContext.INSTANCE.getBean(Main.class).execute();
	}

	private void execute() {
		System.out.println(helloWorld.getMessage());
		// Here goes your implementation
	}

}
