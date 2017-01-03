package com.softgroup.test;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IntegersInStringFounderTest {

    @Test
    public void testGetMin() throws Exception {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(4);
        integers.add(7);
        integers.add(1);
        int expectedResult = 1;
        Assert.assertEquals(expectedResult, IntegersInStringFounder.getMin(integers));
    }

    @Test
    public void testGetMax() throws Exception {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(4);
        integers.add(7);
        integers.add(1);
        int expectedResult = 7;
        Assert.assertEquals(expectedResult, IntegersInStringFounder.getMax(integers));
    }

}
