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
            new TestCase("Valid input with seed", new String[] {"-r", "3", "-p", "50.0", "-s", "12345"}, true),
            new TestCase("Valid input without seed", new String[] {"-r", "2", "-p", "25.5"}, true),
            new TestCase("Invalid rang (zero)", new String[] {"-r", "0", "-p", "50.0"}, false),
            new TestCase("Invalid percent (too high)", new String[] {"-r", "3", "-p", "150.0"}, false),
            new TestCase("Invalid percent (negative)", new String[] {"-r", "3", "-p", "-5"}, false),
            new TestCase("Missing rang", new String[] {"-p", "50.0"}, false),
            new TestCase("Missing percent", new String[] {"-r", "3"}, false),
            new TestCase("Unknown argument", new String[] {"-r", "3", "-p", "50.0", "-x"}, false)
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
