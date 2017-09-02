package ${groupId}.cdi;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;

public class CdiMockitoRunner extends BlockJUnit4ClassRunner {

	public CdiMockitoRunner(Class<Object> clazz) throws InitializationError {
		super(clazz);
	}

	@Override
	protected Object createTest() {
		final Object bean = WeldContext.INSTANCE.getBean(getTestClass().getJavaClass());
		MockitoAnnotations.initMocks(bean);
		return bean;
	}

}
