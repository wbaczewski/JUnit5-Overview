package com.example.dynamic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class DynamicTestsDemoTest {

	// This will result in a JUnitException!
	@TestFactory
	@Disabled
	List<String> dynamicTestsWithInvalidReturnType() {
		return Arrays.asList("Hello");
	}

	@TestFactory
	Collection<DynamicTest> dynamicTestsFromCollection() {
		//@formatter:off
		return Arrays.asList(
				dynamicTest("1st dynamic test", () -> assertTrue(true)),
				dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2))
		);
		//@formatter:on

	}

	@TestFactory
	Iterable<DynamicTest> dynamicTestsFromIterable() {
		//@formatter:off
		return Arrays.asList(
				dynamicTest("3rd dynamic test", () -> assertTrue(true)),
				dynamicTest("4th dynamic test", () -> assertEquals(4, 2 * 2))
		);
		//@formatter:on

	}

	@TestFactory
	Iterator<DynamicTest> dynamicTestsFromIterator() {
		//@formatter:off
		return Arrays.asList(
				dynamicTest("5th dynamic test", () -> assertTrue(true)),
				dynamicTest("6th dynamic test", () -> assertEquals(4, 2 * 2))
		).iterator();
		//@formatter:off

	}

	@TestFactory
	Stream<DynamicTest> dynamicTestsFromStream() {
		return Stream.of("A", "B", "C").map(str ->
				dynamicTest("test" + str, () -> {assertTrue(str.length() == 1);}));
	}

	@TestFactory
	Stream<DynamicTest> dynamicTestsFromIntStream() {
		// Generates tests for the first 10 even integers.
		//@formatter:off
		return IntStream.iterate(0, n -> n + 2)
				.limit(10)
				.mapToObj(n ->
						dynamicTest("test" + n, () -> assertTrue(n % 2 == 0))
				);
		//@formatter:on
	}

}
