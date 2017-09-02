package ${groupId};

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import ${groupId}.cdi.CdiMockitoRunner;

/**
 * Unit test for simple App.
 */
@RunWith(CdiMockitoRunner.class)
public class MainTest {
	private @Inject Main main;
	private @Mock Main mainMock;

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testApp() {
		Assert.assertNotNull(main);
		Assert.assertNotNull(mainMock);
	}
}
