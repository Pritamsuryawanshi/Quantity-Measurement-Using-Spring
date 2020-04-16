package com.quantitymeasurement.mockito;

import static com.quantitymeasurement.enums.SubUnits.*;
import static com.quantitymeasurement.enums.Units.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.quantitymeasurement.enums.SubUnits;
import com.quantitymeasurement.enums.Units;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void shouldReturnSubUnits() throws Exception {
        List<SubUnits> list = Arrays.asList(INCH, FEET, YARD, CENTIMETER);
        mockMvc.perform(get("/units/LENGTH"))
                .andExpect(content().json(String.valueOf((list))));
    }
}
