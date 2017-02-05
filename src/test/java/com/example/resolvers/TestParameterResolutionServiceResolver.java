package com.example.resolvers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import com.example.service.TestParameterResolutionService;

public class TestParameterResolutionServiceResolver implements ParameterResolver {

	@Override
	public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return (parameterContext.getParameter().getType() == TestParameterResolutionService.class);
	}

	@Override
	public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return new TestParameterResolutionService();
	}

}
