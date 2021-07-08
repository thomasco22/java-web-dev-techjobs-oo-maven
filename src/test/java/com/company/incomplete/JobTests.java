package com.company.incomplete;

import com.company.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobTests {

//    @BeforeAll
    private static final Job noArgJob = new Job();
    private static final Job noArgJobTwo = new Job();
    private static final Job fiveArgJob = new Job("Lifeguard", new Employer("Seaworld"), new Location("Florida"),
            new PositionType("Customer Facing"), new CoreCompetency("Swimming"));
    private static final Job thirdJob = new Job("Lifeguard", new Employer("Seaworld"), new Location("Florida"),
            new PositionType("Customer Facing"), new CoreCompetency(""));
    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    @Test
    public void testSettingJobId() {
        Assertions.assertFalse(noArgJob.equals(fiveArgJob));
        Assertions.assertEquals(1, noArgJob.getId());
        Assertions.assertEquals(2, noArgJobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job coolJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assertions.assertTrue(coolJob.getEmployer() instanceof Employer);
        Assertions.assertTrue(coolJob.getLocation() instanceof Location);
        Assertions.assertTrue(coolJob.getPositionType() instanceof PositionType);
        Assertions.assertTrue(coolJob.getCoreCompetency() instanceof CoreCompetency);
        Assertions.assertEquals("ACME", coolJob.getEmployer().getValue());
        Assertions.assertEquals(5, coolJob.getId());
        Assertions.assertEquals("Product tester", coolJob.getName());
        Assertions.assertEquals("Desert", coolJob.getLocation().getValue());
        Assertions.assertEquals("Quality control", coolJob.getPositionType().getValue());
        Assertions.assertEquals("Persistence", coolJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Assertions.assertFalse(noArgJob.equals(noArgJobTwo));
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        Assertions.assertTrue(fiveArgJob.toString().startsWith("\n"));
        Assertions.assertTrue(fiveArgJob.toString().endsWith("\n"));
    }

    @Test
    public void testToStringHasLabelsForEachField() {
        Assertions.assertTrue(fiveArgJob.toString().contains("ID:"));
        Assertions.assertTrue(fiveArgJob.toString().contains("Name:"));
        Assertions.assertTrue(fiveArgJob.toString().contains("Employer:"));
        Assertions.assertTrue(fiveArgJob.toString().contains("Location:"));
        Assertions.assertTrue(fiveArgJob.toString().contains("Position Type:"));
        Assertions.assertTrue(fiveArgJob.toString().contains("Core Competency:"));
    }

    @Test
    public void testToStringDataNotAvailable() {
        Assertions.assertTrue(thirdJob.toString().contains("Data not available"));
    }
}



