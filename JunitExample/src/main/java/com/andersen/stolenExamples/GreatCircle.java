package com.andersen.stolenExamples;

/**
 * Calculations on the great circle.
 */
public final class GreatCircle {
    /**
     * Length of a 1 degree of a meridian on the Earth.
     */
    private static final double MERIDIAN_DEGREE_LEN = 111.12;

    /**
     * Calculates great circle distance between two points.
     * @param latDeparture 1st point's latitude.
     * @param lonDeparture 1st point's longitude.
     * @param latDestination 2nd point's latitude.
     * @param lonDestination 2nd point's longitude.
     * @return Distance in meters.
     */
    public static double distance(
            final double latDeparture, final double lonDeparture,
            final double latDestination, final double lonDestination
    ) {
        double latDepartureRadians = Math.toRadians(latDeparture);
        double lonDepartureRadians = Math.toRadians(lonDeparture);
        double latDestinationRadians = Math.toRadians(latDestination);
        double lonDestinationRadians = Math.toRadians(lonDestination);
       
        return MERIDIAN_DEGREE_LEN
        * Math.toDegrees(
        Math.acos(
                Math.sin(latDepartureRadians)
                        * Math.sin(latDestinationRadians)
                        + Math.cos(latDepartureRadians)
                        * Math.cos(latDestinationRadians)
                        * Math.cos(lonDestinationRadians - lonDepartureRadians)));    } 
}
