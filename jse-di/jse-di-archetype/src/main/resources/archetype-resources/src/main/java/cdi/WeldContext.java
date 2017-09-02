package ${groupId}.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class WeldContext {
	public static final WeldContext INSTANCE = new WeldContext();

	private final Weld weld;
	private final WeldContainer container;

	private WeldContext() {
		weld = new Weld();
		container = weld.initialize();
	}

	public <T> T getBean(Class<T> type) {
		return container.select(type).get();
	}

}
