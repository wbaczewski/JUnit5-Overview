package com.example.dynamic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.example.Calculator;
import com.example.resolvers.TestAnnotationParameterResolver;
import com.example.resolvers.annotations.TestAnnotationParameter;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@ExtendWith(TestAnnotationParameterResolver.class)
class CalculatorDynamicTest {

	@TestFactory
	Stream<DynamicTest> addition(@TestAnnotationParameter Calculator calculator) {
		//@formatter:off
		List<CalculationTestDataSet<Integer>> calculationDataSet = Arrays.asList(
				new CalculationTestDataSet<>(0, 0,0),
				new CalculationTestDataSet<>(0, 1,1),
				new CalculationTestDataSet<>(1, 0,1),
				new CalculationTestDataSet<>(-1, 1,0),
				new CalculationTestDataSet<>(-1, -1,-2)
		);

		return calculationDataSet.stream().map(data ->
				dynamicTest(data.first + " + " + data.second + " = " + data.expectedResult,
						() -> {
					int result = calculator.add(data.first, data.second);
					assertThat(result).isEqualTo(data.expectedResult);
				})
		);
		//@formatter:on

	}

	private static class CalculationTestDataSet<T> {
		private T first;
		private T second;
		private T expectedResult;

		private CalculationTestDataSet(T first, T second, T expectedResult) {
			this.first = first;
			this.second = second;
			this.expectedResult = expectedResult;
		}
	}
}
