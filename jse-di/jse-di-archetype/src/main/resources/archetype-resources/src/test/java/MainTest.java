package ${groupId};

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import ${groupId}.cdi.CdiMockitoRunner;

/**
 * Unit test for simple App.
 */
@RunWith(CdiMockitoRunner.class)
public class MainTest {
	private @Inject Main main;

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testApp() {
		Assert.assertNotNull(main);
		Assert.assertTrue(true);
	}
}
