package com.example.model;

import org.springframework.core.style.ToStringCreator;
import org.springframework.util.Assert;

import com.google.common.base.Joiner;

import lombok.Getter;

@Getter
public class Person {

	private final String firstName;
	private final String lastName;
	private final String fullName;

	public Person(String firstName, String lastName) {
		Assert.hasText(firstName,"First name can not be empty");
		Assert.hasText(lastName,"Last name can not be empty");

		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = Joiner.on(" ").join(firstName, lastName);

	}

	public void saySomething() throws InterruptedException {
		Thread.sleep(100);
	}

	@Override
	public String toString() {
		// @formatter:off
		return new ToStringCreator(this)
				.append("firstName", firstName)
				.append("lastName", lastName)
				.append("fullName", fullName)
				.toString();
		// @formatter:on
	}
}
