package ${groupId};

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import ${groupId}.cdi.WeldContext;

public class Main {

	public static void main(String[] args) {
		WeldContext.INSTANCE.getBean(Main.class).execute();
	}

	private void execute() {
		System.out.println("Hello World");
		// Here goes your implementation
	}

}
