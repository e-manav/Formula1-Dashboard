package com.electronica.formula_1.data;

public record CircuitInput(int circuitId, String circuitRef, String name, String location, String country, double lat,
                           double lng, int alt, String url) {
}
