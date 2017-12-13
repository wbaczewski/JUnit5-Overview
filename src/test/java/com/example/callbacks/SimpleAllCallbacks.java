package com.example.callbacks;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

@Slf4j
public class SimpleAllCallbacks implements AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback, BeforeAllCallback,
		BeforeEachCallback, BeforeTestExecutionCallback {

	@Override
	public void afterAll(final ExtensionContext extensionContext) throws Exception {

	}

	@Override
	public void afterEach(final ExtensionContext extensionContext) throws Exception {

	}

	@Override
	public void afterTestExecution(final ExtensionContext extensionContext) throws Exception {

	}

	@Override
	public void beforeAll(final ExtensionContext extensionContext) throws Exception {

	}

	@Override
	public void beforeEach(final ExtensionContext extensionContext) throws Exception {

	}

	@Override
	public void beforeTestExecution(final ExtensionContext extensionContext) throws Exception {

	}
}
