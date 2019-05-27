
package com.hht.feeder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FeederApplicationTests.class})
public class FeederApplicationTests {

	@Test
	public void contextLoads() {
		assertTrue(null != this);
	}

}
