// Define the package name for this class: A package is a namespace that organizes related classes and interfaces
package com.mycompany.app;

// Import the DateTime class from the Joda-Time library
import org.joda.time.DateTime;

// Define a public class named "App"
public class App {
    // Print some text
    public static void main(String[] args) {
        System.out.println("Hello, from Maven. Time:");

        // Use Joda-Time to get and print the current date and time
        DateTime currentTime = new DateTime();
        System.out.println(currentTime.toString("yyyy-MM-dd HH:mm:ss"));
    }
}

