package com.xiom.akusu.options.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

import com.xiom.akusu.SudokuCommonTest;

public class OptionsProcessorTest extends SudokuCommonTest {

	@Test
	public void parseOptionsTest() {
		System.out.println("Test options: " + Arrays.toString(TEST_OPTIONS));

		Map<String, String[]> testMapResults = optionsProcessor.parse(TEST_OPTIONS);

		// Grab all the results
		String[] arg1Results = testMapResults.get(ARG1);
		String[] arg2Results = testMapResults.get(ARG2);
		String[] arg3Results = testMapResults.get(ARG3);

		System.out.println(ARG1 + "=" + Arrays.toString(arg1Results));
		System.out.println(ARG2 + "=" + Arrays.toString(arg2Results));
		System.out.println(ARG3 + "=" + Arrays.toString(arg3Results));

		// Check that nothing came back null
		assertNotNull(arg1Results);
		assertNull(arg2Results);
		assertNotNull(arg3Results);

		// Verify lengths
		assertEquals(arg1Results.length, ARG1_RESULTS.length);
		// assertEquals(arg2Results.length, ARG2_RESULTS.length);
		assertEquals(arg3Results.length, ARG3_RESULTS.length);

		// Verify values
		assertTrue(Arrays.equals(arg1Results, ARG1_RESULTS));
		assertTrue(Arrays.equals(arg2Results, ARG2_RESULTS));
		assertTrue(Arrays.equals(arg3Results, ARG3_RESULTS));
	}
}
