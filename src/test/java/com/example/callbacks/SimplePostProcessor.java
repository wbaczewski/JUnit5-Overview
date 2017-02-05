package com.example.callbacks;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimplePostProcessor implements TestInstancePostProcessor {
	@Override
	public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {
		log.info("postProcessTestInstance()");
	}
}
