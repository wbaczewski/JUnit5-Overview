package com.example.extension.exception;

import java.io.IOException;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class IgnoreIOExceptionExtension implements TestExecutionExceptionHandler {

	@Override
	public void handleTestExecutionException(final ExtensionContext extensionContext, final Throwable throwable) throws Throwable {
		if (throwable instanceof IOException) {
			return;
		}
		throw throwable;
	}
}
