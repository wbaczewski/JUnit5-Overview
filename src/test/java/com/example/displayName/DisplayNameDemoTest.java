package com.example.displayName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
public class DisplayNameDemoTest {

	@Test
	@DisplayName("Custom test name containing spaces")
	void testWithDisplayNameContainingSpaces() {
	}

	@Test
	@DisplayName("╯°□°）╯")
	void testWithDisplayNameContainingSpecialCharacters() {
	}

	@Test
	@DisplayName("😱 \uD83D\uDE00 \uD83D\uDE31 \uD83D\uDE08 \uD83D\uDC4C \uD83D\uDC4D \uD83D\uDC9A ")
	void testWithDisplayNameContainingEmoji() {
	}
}
