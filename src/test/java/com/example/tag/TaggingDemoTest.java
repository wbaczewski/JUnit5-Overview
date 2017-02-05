package com.example.tag;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TaggingDemoTest {

	@Test
	@Tag("unit")
	@DisplayName("Test execute in maven test")
	void unitTest() {
		assertTrue(1 == 1);
	}

	@Tag("integration")
	@Test
	@DisplayName("Test exclude in maven test")
	void integrationTest() {
		assertTrue(1 == 1);
	}

}
