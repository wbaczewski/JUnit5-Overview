package com.example.callbacks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ SimpleAllCallbacks.class, SimplePostProcessor.class })
class CallbacksTest {

	@Test
	void shouldLogAllCallbacks() {

	}
}
