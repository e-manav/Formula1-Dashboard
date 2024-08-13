package com.electronica.formula_1.data;

import com.electronica.formula_1.model.Circuit;
import org.springframework.batch.item.ItemProcessor;

import java.util.logging.Logger;

public class CircuitItemProcessor implements ItemProcessor<CircuitInput, Circuit> {

    private static final Logger logger = Logger.getLogger(CircuitItemProcessor.class.getName());

    @Override
    public Circuit process(CircuitInput item) throws Exception {
        Circuit circuit = new Circuit();

        final String id = item.circuitId();
        final String ref = item.circuitRef();
        final String name = item.name();
        final String location = item.location();
        final String country = item.country();
        final String lat = item.lat();
        final String lng = item.lng();
        final String alt = item.alt();
        final String url = item.url();

        circuit.setCircuitId(id);
        circuit.setCircuitRef(ref);
        circuit.setName(name);
        circuit.setLocation(location);
        circuit.setCountry(country);
        circuit.setLat(lat);
        circuit.setLng(lng);
        circuit.setAlt(alt);
        circuit.setUrl(url);
        logger.info("Converting (" + item + ") Stringo (" + circuit + ")");
        return circuit;
    }
}
