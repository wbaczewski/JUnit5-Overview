package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.resolvers.TestAnnotationParameterResolver;
import com.example.resolvers.TestParameterResolutionServiceResolver;
import com.example.resolvers.annotations.TestAnnotationParameter;

// @ExtendWith(TestParameterResolutionServiceResolver.class)
// @ExtendWith(TestAnnotationParameterResolver.class)
@ExtendWith({ TestAnnotationParameterResolver.class, TestParameterResolutionServiceResolver.class })
class TestParameterResolutionServiceTest {

	@Test
	void parameterResolution(TestParameterResolutionService testService) {
		assertEquals(1, 1);
		testService.doNothing();
	}

	@Test
	void annotationParameterResolution(@TestAnnotationParameter TestAnnotationParameterResolutionService testService) {
		assertEquals(1, 1);
		testService.doNothing();
	}
}
