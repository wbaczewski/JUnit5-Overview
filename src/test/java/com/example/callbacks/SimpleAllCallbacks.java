package com.example.callbacks;

import org.junit.jupiter.api.extension.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleAllCallbacks implements AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback, BeforeAllCallback,
		BeforeEachCallback, BeforeTestExecutionCallback {
	@Override
	public void afterAll(ContainerExtensionContext containerExtensionContext) throws Exception {
		log.info("After all execution");
	}

	@Override
	public void beforeAll(ContainerExtensionContext containerExtensionContext) throws Exception {
		log.info("Before all execution");
	}

	@Override
	public void afterEach(TestExtensionContext testExtensionContext) throws Exception {
		log.info("After each execution");
	}

	@Override
	public void beforeEach(TestExtensionContext testExtensionContext) throws Exception {
		log.info("Before each execution");
	}

	@Override
	public void afterTestExecution(TestExtensionContext testExtensionContext) throws Exception {
		log.info("After test execution");
	}

	@Override
	public void beforeTestExecution(TestExtensionContext testExtensionContext) throws Exception {
		log.info("Before test execution");
	}
}
