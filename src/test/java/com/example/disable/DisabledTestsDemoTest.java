package com.example.disable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DisabledTestsDemoTest {

	@Test
	@Disabled
	@DisplayName("Test will be skipped")
	void shouldBeSkipped() {
	}

	@Test
	@DisplayName("Test will be executed")
	void shouldBeExecuted() {
	}

}
