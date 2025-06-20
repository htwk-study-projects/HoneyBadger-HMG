package com.github.htwkstudyprojects.honeybadgerhmg.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class CliConfigRepositoryTest {

    static class TestCase{
        String name;
        String[] args;
        boolean expectValid;

        TestCase(String name, String[] args, boolean expectValid) {
            this.name = name;
            this.args = args;
            this.expectValid = expectValid;
        }
    }
    

    @Test
    public void testLoadConfiguration_tableDriven(){
        IMazeConfigRepository repo = new CliConfigRepository();

       TestCase[] cases = new TestCase[] {
            new TestCase("Valid input with seed", new String[] {"-t", "honeycomb", "-r", "3", "-p", "50.0", "-el", "2", "-s", "12345"}, true),
            new TestCase("Valid input without seed", new String[] {"-t", "honeycomb", "-r", "2", "-p", "25.5", "-el", "1"}, true),
            new TestCase("Invalid rang (zero)", new String[] {"-t", "honeycomb", "-r", "0", "-p", "50.0", "-el", "2"}, false),
            new TestCase("Invalid percent (too high)", new String[] {"-t", "honeycomb", "-r", "3", "-p", "150.0", "-el", "2"}, false),
            new TestCase("Invalid percent (negative)", new String[] {"-t", "honeycomb", "-r", "3", "-p", "-5", "-el", "2"}, false),
            new TestCase("Missing rang", new String[] {"-t", "honeycomb", "-p", "50.0", "-el", "2"}, false),
            new TestCase("Missing percent", new String[] {"-t", "honeycomb", "-r", "3", "-el", "2"}, false),
            new TestCase("Missing type", new String[] {"-r", "3", "-p", "50.0", "-el", "2"}, false),
            new TestCase("Missing edge length", new String[] {"-t", "honeycomb", "-r", "3", "-p", "50.0"}, false),
            new TestCase("Invalid edge length (negative)", new String[] {"-t", "honeycomb", "-r", "3", "-p", "50.0", "-el", "-1"}, false),
            new TestCase("Unknown argument", new String[] {"-t", "honeycomb", "-r", "3", "-p", "50.0", "-el", "2", "-x"}, false)
        };


        for (TestCase tc : cases) {
            try {
                MazeConfigDto config = repo.loadConfiguration(tc.args);
                if (!tc.expectValid) {
                    fail("Test '" + tc.name + "' expected invalid but got valid config: " + config);
                }
                assertNotNull(config);
            } catch (IllegalArgumentException e) {
                if (tc.expectValid) {
                    fail("Test '" + tc.name + "' expected valid config but got error: " + e.getMessage());
                }
            }
        }
       
    }
}
