package com.example.resolvers;

import com.example.resolvers.annotations.TestAnnotationParameter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.ReflectionUtils;

public class TestAnnotationParameterResolver implements ParameterResolver {

	@Override
	public boolean supportsParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().isAnnotationPresent(TestAnnotationParameter.class);

	}

	@Override
	public Object resolveParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return ReflectionUtils.newInstance(parameterContext.getParameter().getType());

	}
}
