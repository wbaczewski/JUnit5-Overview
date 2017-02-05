package com.example.assertions;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.model.Person;

class AssertionsDemoTest {

	private static final String FIRST_NAME = "John";
	private static final String LAST_NAME = "Doe";

	private Person person;

	@BeforeEach
	void init() {
		person = new Person(FIRST_NAME, LAST_NAME);
	}

	@Test
	@DisplayName("Standard assertions")
	void standardAssertions() {
		assertEquals(FIRST_NAME, person.getFirstName());
		assertEquals(LAST_NAME, person.getLastName(), "The optional assertion message is now the last parameter.");
		assertFalse(Strings.isNullOrEmpty(person.getFullName()),
				() -> "Assertion messages can be lazily evaluated -- " + "to avoid constructing complex messages unnecessarily.");
	}

	@Test
	@DisplayName("Grouped assertions")
	void shouldPersonInfoMatch() {
		// In a grouped assertion all assertions are executed, and any
		// failures will be reported together.
		//@formatter:off
		assertAll("person",
				() -> assertEquals(FIRST_NAME, person.getFirstName()),
				() -> assertEquals(LAST_NAME, person.getLastName())
		);
		//@formatter:on

	}

	@Test
	@DisplayName("Exception testing")
	void firstNameShouldNotBeEmpty() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			new Person(null, "Doe");
		});
		assertEquals("First name can not be empty", exception.getMessage());
	}

	@Test
	@DisplayName("Timeout not exceeded")
	void shouldSayLessThanTwoMinutes() {
		// The following assertion succeeds.
		assertTimeout(ofMinutes(2), () -> {
			// Perform task that takes less than 2 minutes.
			person.saySomething();
		});
	}

	@Test
	@Disabled
	@DisplayName("Timeout exceeded")
	void shouldSayMoreThanTenMs() {
		// The following assertion fails with an error message similar to:
		// execution exceeded timeout of 10 ms by 91 ms
		assertTimeout(ofMillis(10), () -> {
			// Simulate task that takes more than 10 ms.
			person.saySomething();
		});
	}

	@Test
	@Disabled
	@DisplayName("Timeout exceeded with preemptive termination")
	void timeoutExceededWithPreemptiveTermination() {
		// The following assertion fails with an error message similar to:
		// execution timed out after 10 ms
		assertTimeoutPreemptively(ofMillis(10), () -> {
			// Simulate task that takes more than 10 ms.
			person.saySomething();
		});
	}
}
