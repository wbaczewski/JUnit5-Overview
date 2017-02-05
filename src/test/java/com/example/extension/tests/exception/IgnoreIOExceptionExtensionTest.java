package com.example.extension.tests.exception;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.extension.exception.IgnoreIOExceptionExtension;

@ExtendWith(IgnoreIOExceptionExtension.class)
class IgnoreIOExceptionExtensionTest {

	@Test
	void shouldHandleIOException() throws IOException {
		throw new IOException();
	}

}
