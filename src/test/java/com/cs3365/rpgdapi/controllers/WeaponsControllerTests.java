package com.cs3365.rpgdapi.controllers;

import com.cs3365.rpgdapi.models.Weapon;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WeaponsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private WeaponsService mockWeaponsService;

    @Test
    public void shouldSucceed() throws Exception {
        // Given
        UUID id = UUID.randomUUID();
        Weapon weapon = new Weapon.WeaponBuilder("Test Weapon", "sword").build();
        String body = mapper.writeValueAsString(weapon);
        Mockito.when(mockWeaponsService.createWeapon(Mockito.any())).thenReturn(id);

        // When
        ResultActions response = this.mockMvc.perform(post("/weapons")
                                                              .contentType(MediaType.APPLICATION_JSON)
                                                              .accept(MediaType.APPLICATION_JSON)
                                                              .content(body));
        // Then
        response.andExpect(status().isCreated());
    }

    @Test
    public void shouldFailForInvalidAttackPower() throws Exception {
        // Given
        Weapon weapon = new Weapon.WeaponBuilder("Test Weapon", "sword")
                                    .attackPower(-1.0)
                                    .build();
        String body = mapper.writeValueAsString(weapon);

        // When
        ResultActions response = this.mockMvc.perform(post("/weapons")
                                                              .contentType(MediaType.APPLICATION_JSON)
                                                              .accept(MediaType.APPLICATION_JSON)
                                                              .content(body));

        // Then
        response.andExpect(status().isBadRequest())
                .andExpect(content().string("The attackPower attribute must be greater than or equal to 0.0."));
    }
}
