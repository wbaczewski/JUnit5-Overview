package com.example.extension.timing;

import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

@Slf4j
public class TimingExtension implements AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback, BeforeAllCallback,
		BeforeEachCallback, BeforeTestExecutionCallback {

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		Method testMethod = context.getTestMethod().get();
		long start = getStore(context).remove(testMethod, long.class);
		long duration = System.currentTimeMillis() - start;

		log.info(String.format("Method [%s] took %s ms.", testMethod.getName(), duration));
	}

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		getStore(context).put(context.getTestMethod().get(), System.currentTimeMillis());
		log.info("Before test execution");
	}

	private Store getStore(ExtensionContext context) {
		return context.getStore(Namespace.create(getClass(), context));
	}

	@Override
	public void afterAll(ExtensionContext containerExtensionContext) throws Exception {
		log.info("After all execution");
	}

	@Override
	public void beforeAll(ExtensionContext containerExtensionContext) throws Exception {
		log.info("Before all execution");
	}

	@Override
	public void afterEach(ExtensionContext testExtensionContext) throws Exception {
		log.info("After each execution");
	}

	@Override
	public void beforeEach(ExtensionContext testExtensionContext) throws Exception {
		log.info("Before each execution");
	}

}
