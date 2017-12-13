package com.example.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionDemoTest {

	private static final String TEST_STRING_NUMBER = "test";

	@Test
	void shouldParseStringParameterToIntegerAssertThrows() {
		assertThrows(NumberFormatException.class, () -> {
			Integer.valueOf(TEST_STRING_NUMBER);
		});

	}

	@Test
	void shouldParseStringParameterToIntegerExpectThrows() {

		//	Assertions.expectThrows() has been deprecated in favor of Assertions.assertThrows().
		Throwable exceptionFromExpectThrows = assertThrows(NumberFormatException.class,
				() -> Integer.valueOf(TEST_STRING_NUMBER));

		Throwable exceptionWithAssertThrows = assertThrows(NumberFormatException.class,
				() -> Integer.valueOf(TEST_STRING_NUMBER));

		assertEquals("For input string: \"" + TEST_STRING_NUMBER + "\"", exceptionFromExpectThrows.getMessage());
		assertEquals("For input string: \"" + TEST_STRING_NUMBER + "\"", exceptionWithAssertThrows.getMessage());
		assertEquals(exceptionFromExpectThrows.getMessage(), exceptionWithAssertThrows.getMessage());
	}

	@Test
	void shouldParseStringParameterToIntegerTryCatchIdiom() {
		try {
			Integer.valueOf(TEST_STRING_NUMBER);
		} catch (IllegalArgumentException e) {
			assertEquals("For input string: \"" + TEST_STRING_NUMBER + "\"", e.getMessage());
		}
	}
}
