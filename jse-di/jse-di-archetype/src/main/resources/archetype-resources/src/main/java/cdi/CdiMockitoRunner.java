package ${groupId}.cdi;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;

/**
 * Create a test case, populates the injection points and the mocks. 
 * @author rodoufu
 */
public class CdiMockitoRunner extends BlockJUnit4ClassRunner {

	/**
	 * Manages the test.
	 * @param clazz Test class.
	 * @throws InitializationError In case of error.
	 */
	public CdiMockitoRunner(Class<Object> clazz) throws InitializationError {
		super(clazz);
	}

	/**
	 * Creates the test.
	 * @return The test case object.
	 */
	@Override
	protected Object createTest() {
		final Object bean = WeldContext.INSTANCE.getBean(getTestClass().getJavaClass());
		MockitoAnnotations.initMocks(bean);
		return bean;
	}

}
