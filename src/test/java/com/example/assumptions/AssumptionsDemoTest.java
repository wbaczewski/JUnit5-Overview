package com.example.assumptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AssumptionsDemoTest {

	@Test
	void shouldExecuteOnlyOnMonday() {
		assumeTrue(DayOfWeek.MONDAY == (LocalDate.now().getDayOfWeek()));

		assertTrue(1 == 1);
	}

	@Test
	void shouldExecuteEveryDay() {
		assumingThat(DayOfWeek.MONDAY == (LocalDate.now().getDayOfWeek()), () -> {
			// perform these assertions every Monday
			assertEquals("Today is Monday", "Today is Monday");
		});

		// perform these assertions every day of the week
		assertEquals("Some day of weak", "Some day of weak");
	}

}
