package com.quantitymeasurement.mockito;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HTTPRequestMockito {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void unitsShouldReturnAllTheUnits() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + "units",
                String.class)).contains("LENGTH", "WEIGHT", "VOLUME", "TEMPERATURE");
    }

    @Test
    public void subUnitsShouldReturnAllTheSubUnits() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + "units" + "/LENGTH",
                String.class)).contains("FEET", "INCH", "YARD", "CENTIMETER");
    }

    @Test
    public void subUnitsShouldReturnAllTheSubUnits1() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + "units" + "/WEIGHT",
                String.class)).contains("KG", "GRAM", "TONNE");
    }

    @Test
    public void subUnitsShouldReturnAllTheSubUnits2() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + "units" + "/VOLUME",
                String.class)).contains("LITRE", "GALLON", "ML");
    }

    @Test
    public void subUnitsShouldReturnAllTheSubUnits3() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + "units" + "/TEMPERATURE",
                String.class)).contains("CELSIUS", "FAHRENHEIT");
    }
}
