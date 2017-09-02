package ${groupId}.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Context for CDI.
 * @author rodoufu
 */
public class WeldContext {
	public static final WeldContext INSTANCE = new WeldContext();

	private final Weld weld;
	private final WeldContainer container;

	private WeldContext() {
		weld = new Weld();
		container = weld.initialize();
	}

	/**
	 * Get a instance.
	 * @param type Type of the object to be created.
	 * @return The object.
	 */
	public <T> T getBean(Class<T> type) {
		return container.select(type).get();
	}

}
