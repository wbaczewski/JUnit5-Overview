package com.example.extension.tests.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import com.example.extension.mockito.MockitoExtension;
import com.example.model.Person;

@ExtendWith(MockitoExtension.class)
class MyMockitoTest {

	@BeforeEach
	void init(@Mock Person person) {
		when(person.getFullName()).thenReturn("Dilbert");
	}

	@Test
	void simpleTestWithInjectedMock(@Mock Person person) {
		assertEquals("Dilbert", person.getFullName());
	}

}
