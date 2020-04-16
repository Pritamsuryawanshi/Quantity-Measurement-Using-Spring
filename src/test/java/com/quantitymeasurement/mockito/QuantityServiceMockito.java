package com.quantitymeasurement.mockito;

import com.google.gson.Gson;

import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.dto.ResponseDTO;
import com.quantitymeasurement.enums.SubUnits;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.quantitymeasurement.controllers.QuantityControllers;
import com.quantitymeasurement.enums.Units;
import com.quantitymeasurement.service.QuantityService;


import static com.quantitymeasurement.enums.Units.*;
import static com.quantitymeasurement.enums.SubUnits.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        Units[] expectedUnits = {LENGTH, WEIGHT, VOLUME, TEMPERATURE};
        given(service.getMainUnits()).willReturn(expectedUnits);
        mvc.perform(get("/units"))
                .andExpect(content().json(Arrays.toString(expectedUnits)));
    }

    @Test
    public void whenCalledForSubUnits_ShouldReturnSubUnits() throws Exception {
        List<SubUnits> expectedSubUnits = Arrays.asList(INCH, FEET);
        given(service.getSubUnits(LENGTH)).willReturn(expectedSubUnits);
        mvc.perform(get("/units/LENGTH"))
                .andExpect(content().json(String.valueOf(expectedSubUnits)));
    }

    @Test
    public void whenConversion_ShouldReturnSubUnits() throws Exception {
        Gson gson = new Gson();
        ConvertDTO convertDTO = new ConvertDTO(1.0, FEET, INCH);
        String jsonData = gson.toJson(convertDTO);
        ResponseDTO responseDTO = new ResponseDTO(30.48, "Converted Successful", 200);
        String json = gson.toJson(responseDTO);
        given(service.convert(any())).willReturn(30.48);
        mvc.perform(post("/units/convert")
                .content(jsonData)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

    @Test
    public void whenConversions_ShouldReturnSubUnits() throws Exception {
        Gson gson = new Gson();
        ConvertDTO convertDTO = new ConvertDTO(35, FAHRENHEIT, CELSIUS);
        String jsonData = gson.toJson(convertDTO);
        ResponseDTO responseDTO = new ResponseDTO(1.66667, "Converted Successful", 200);
        String json = gson.toJson(responseDTO);
        given(service.convert(any())).willReturn(1.66667);
        mvc.perform(post("/units/convert")
                .content(jsonData)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }
}
