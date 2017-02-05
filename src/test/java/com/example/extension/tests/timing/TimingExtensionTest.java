package com.example.extension.tests.timing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.extension.timing.TimingExtension;

/**
 * Before and After Test Execution Callbacks
 *
 * Example shows how to use these callbacks to calculate and log the execution
 * time of a test method.
 *
 */

@ExtendWith(TimingExtension.class)
class TimingExtensionTests {

	@Test
	void sleep20ms() throws Exception {
		Thread.sleep(20);
	}

	@Test
	void sleep50ms() throws Exception {
		Thread.sleep(50);
	}

}
