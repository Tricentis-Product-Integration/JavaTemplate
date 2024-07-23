package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.DemoItem;
import com.example.service.IDemoService;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IDemoService demoService;

    @BeforeEach
    public void SetUp() {

        DemoItem demoItem1 = new DemoItem(1, "Item1");
        DemoItem demoItem2 = new DemoItem(2, "Item2");

        List<DemoItem> demoItems = new ArrayList<>(Arrays.asList(demoItem1, demoItem2));

        Mockito.when(demoService.GetDemoItems()).thenReturn(demoItems);
        Mockito.when(demoService.GetDemoItemById(1)).thenReturn(Optional.of(demoItem1));
    }

    @Test
    public void GetDemos_pass() throws Exception {
        this.mockMvc
            .perform(get("/demos")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[1].value", containsString("Item2")));
    }

    @Test
    public void GetDemoById_pass() throws Exception {    
        this.mockMvc
            .perform(get("/demos/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$.value", containsString("Item1")));
    }
}