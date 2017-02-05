package com.example.extension.timing;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimingExtension implements AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback, BeforeAllCallback,
		BeforeEachCallback, BeforeTestExecutionCallback {

	@Override
	public void afterTestExecution(TestExtensionContext context) throws Exception {
		Method testMethod = context.getTestMethod().get();
		long start = getStore(context).remove(testMethod, long.class);
		long duration = System.currentTimeMillis() - start;

		log.info(String.format("Method [%s] took %s ms.", testMethod.getName(), duration));
	}

	@Override
	public void beforeTestExecution(TestExtensionContext context) throws Exception {
		getStore(context).put(context.getTestMethod().get(), System.currentTimeMillis());
		log.info("Before test execution");
	}

	private Store getStore(TestExtensionContext context) {
		return context.getStore(Namespace.create(getClass(), context));
	}

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

}
