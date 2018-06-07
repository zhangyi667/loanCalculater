package com.zopa;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);
        System.out.println(String.format(
                "Has run %d tests, with %d failures. Time in total %d milli seconds.",
                result.getRunCount(),
                result.getFailureCount(),
                result.getRunTime())
        );
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
