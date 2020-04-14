package com.quantitymeasurement.mockito;

import static com.quantitymeasurement.enums.Units.*;
import static com.quantitymeasurement.enums.Units.TEMPERATURE;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.quantitymeasurement.enums.Units;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class LayerTesting {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnUnits() throws Exception {
        Units[] expectedArray = {LENGTH, WEIGHT, VOLUME, TEMPERATURE};
        mockMvc.perform(get("/units"))
                .andExpect(content().json(Arrays.toString(expectedArray)));
    }
}
