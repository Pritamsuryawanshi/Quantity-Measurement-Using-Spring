package com.quantitymeasurement.mockito;

import com.quantitymeasurement.enums.SubUnits;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.quantitymeasurement.controllers.QuantityControllers;
import com.quantitymeasurement.enums.Units;
import com.quantitymeasurement.service.QuantityService;

import static com.quantitymeasurement.enums.Units.*;
import static com.quantitymeasurement.enums.SubUnits.*;


@WebMvcTest(QuantityControllers.class)
public class QuantityServiceMockito {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuantityService service;

    @Test
    public void contexLoads() throws Exception {
        assertThat(mvc).isNotNull();
    }

    @Test
    public void whenCalledForMainUnits_ShouldReturnMainUnits() throws Exception {
        Units[] expectedArray = {LENGTH, WEIGHT, VOLUME, TEMPERATURE};
        given(service.getMainUnits()).willReturn(expectedArray);
        mvc.perform(get("/units"))
                .andExpect(content().json(Arrays.toString(expectedArray)));
    }

    @Test
    public void whenCalledForMainUnits1_ShouldReturnMainUnits() throws Exception {
        List<SubUnits> list = Arrays.asList(INCH, FEET);
        given(service.getSubUnits(LENGTH)).willReturn(list);
        mvc.perform(get("/units/LENGTH"))
                .andExpect(content().json(String.valueOf(list)));
    }
}
