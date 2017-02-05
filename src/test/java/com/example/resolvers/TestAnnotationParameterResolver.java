package com.example.resolvers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.ReflectionUtils;

import com.example.resolvers.annotations.TestAnnotationParameter;

public class TestAnnotationParameterResolver implements ParameterResolver {

	@Override
	public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return parameterContext.getParameter().isAnnotationPresent(TestAnnotationParameter.class);

	}

	@Override
	public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return ReflectionUtils.newInstance(parameterContext.getParameter().getType());
	}

}
