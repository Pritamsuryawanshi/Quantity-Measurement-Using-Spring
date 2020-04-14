package com.quantitymeasurement.mockito;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.quantitymeasurement.controllers.QuantityControllers;
import com.quantitymeasurement.enums.Units;
import com.quantitymeasurement.service.QuantityService;

import static com.quantitymeasurement.enums.Units.*;


@WebMvcTest(QuantityControllers.class)
public class QuantityServiceMockito {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuantityService service;

    @Test
    public void whenCalledForMainUnits_ShouldReturnMainUnits() throws Exception {
        Units[] expectedArray = {LENGTH, WEIGHT, VOLUME, TEMPERATURE};
        given(service.getMainUnits()).willReturn(expectedArray);
        mvc.perform(get("/units"))
                .andExpect(content().json(Arrays.toString(expectedArray)));
    }
}
