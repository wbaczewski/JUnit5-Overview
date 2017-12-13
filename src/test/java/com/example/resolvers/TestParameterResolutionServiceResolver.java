package com.example.resolvers;

import com.example.service.TestParameterResolutionService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class TestParameterResolutionServiceResolver implements ParameterResolver {

	@Override
	public boolean supportsParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return (parameterContext.getParameter().getType() == TestParameterResolutionService.class);
	}

	@Override
	public Object resolveParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return new TestParameterResolutionService();

	}
}
