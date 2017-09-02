package ${groupId}.cdi.factory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.logging.Logger;

/**
 * Creates a logger factory.
 * @author rodoufu
 */
public class LoggerProducer {

	/**
	 * Creates a logger.
	 * @param injectionPoint Where the logger is injected.
	 * @return The logger object.
	 */
	@Produces
    private Logger createLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass());
    }

}
