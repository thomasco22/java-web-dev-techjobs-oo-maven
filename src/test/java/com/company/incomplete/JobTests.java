package com.company.incomplete;

import com.company.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JobTests {

//    @BeforeAll
    private static final Job noArgJob = new Job();
    private static final Job fiveArgJob = new Job("Lifeguard", new Employer("Seaworld"), new Location("Florida"),
            new PositionType("Customer Facing"), new CoreCompetency("Swimming"));
    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    @Test
    public void testSettingJobId() {
        Assertions.assertEquals(1, noArgJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assertions.assertEquals(true, fiveArgJob instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Assertions.assertFalse(noArgJob.equals(fiveArgJob));
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {

    }

    @Test
    public void testToStringHasLabelsForEachField() {

    }

    @Test
    public void testToStringDataNotAvailable() {

    }
}
