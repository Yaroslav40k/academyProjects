package com.andersen.stolenExamplesTests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.andersen.stolenExamples.GreatCircle;

@RunWith(Parameterized.class)
public class GreatCircleTest {
    @Parameterized.Parameters(name = "{index}: Distance: {4}, Point 1: {0}/{1}, Point 2: {2}/{3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //{55.596111, 37.2675, 59.8002778, 30.2625, 861.624}, // Uncomment to see a error message
                {55.596111, 37.2675, 59.8002778, 30.2625, 624.861}, // Vnukovo to Pulkovo distance
                {55.596111, 37.2675, 55.596111, 37.2675, 0}, // Same point
                {0, -180, 0, 180, 0}, // Same point
                {-90, 0, 90, 0, 20001.6}, // Northern-Southern hemispheres
                {0, 0, 0, 180, 20001.6} // Western-Eastern hemispheres
        });
    }


    private double latDeparture;
    private double lonDeparture;
    private double latDestination;
    private double lonDestination;
    private double distance;

    public GreatCircleTest(double latDeparture, double lonDeparture, double latDestination, double lonDestination, double distance) {
        this.latDeparture = latDeparture;
        this.lonDeparture = lonDeparture;
        this.latDestination = latDestination;
        this.lonDestination = lonDestination;
        this.distance = distance;
    }

    @Test
    public void testDistance() {
        assertEquals(distance, GreatCircle.distance(latDeparture, lonDeparture, latDestination, lonDestination), 0.01);
    }
}