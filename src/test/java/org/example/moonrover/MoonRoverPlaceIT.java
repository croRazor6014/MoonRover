package org.example.moonrover;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.moonrover.model.Coordinates;
import org.example.moonrover.model.Direction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *  created by lovro.vrlec@gmail.com on Mar,2023
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MoonRoverPlaceIT {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void testPlaceRoverNorth() throws Exception {


        Coordinates coordinatesPlace = new Coordinates(3,3, Direction.North);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testPlaceRoverSouth() throws Exception {

        Coordinates coordinatesPlace = new Coordinates(1,1, Direction.North);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testPlaceRoverEast() throws Exception {

        Coordinates coordinatesPlace = new Coordinates(3,3, Direction.East);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testPlaceRoverWest() throws Exception {

        Coordinates coordinatesPlace = new Coordinates(3,3, Direction.West);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testIllegalPlaceRoverNorth() throws Exception {

        Coordinates coordinatesPlace = new Coordinates(3,2, Direction.North);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testIllegalPlaceRoverWest() throws Exception {

        Coordinates coordinatesPlace = new Coordinates(2,2, Direction.North);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testIllegalPlaceRoverEast() throws Exception {

        Coordinates coordinatesPlace = new Coordinates(2,4, Direction.North);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testIllegalPlaceRoverSouth() throws Exception {

        Coordinates coordinatesPlace = new Coordinates(6,3, Direction.North);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/rover/place")
                        .content( mapper.writeValueAsString(coordinatesPlace))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }





}
