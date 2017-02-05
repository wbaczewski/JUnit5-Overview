package com.example.disable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Disabled
class DisabledClassDemoTest {

	@Test
	@DisplayName("Test will be skipped")
	void shouldThrowException() throws Exception {
		throw new Exception("Skipped exception");
	}

}
