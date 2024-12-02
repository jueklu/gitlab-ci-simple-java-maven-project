package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    @Test
    public void testMainOutput() {
        // Capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the main method
        App.main(new String[]{});

        // Verify the output contains the greeting
        String output = outContent.toString();
        assertTrue("Output should contain the greeting", output.contains("Hello, from Maven. Time:"));

        // Verify the output contains a correctly formatted timestamp
        DateTime now = new DateTime();
        String expectedDate = now.toString("yyyy-MM-dd");
        assertTrue("Output should contain the current date", output.contains(expectedDate));

        // Reset the console output
        System.setOut(System.out);
    }
}

