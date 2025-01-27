package mk.iwec.paymentsDemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.List;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@WebMvcTest
@AutoConfigureMockMvc
 class GenericControllerTest<D,E> {

    @Autowired
    protected MockMvc mockMvc;

    @Mock
    protected GenericServiceImpl<D,E,UUID> service;

    @Autowired
    private ObjectMapper objectMapper;

    protected String baseURL;
    protected D sampleDTO;
    protected UUID sampleID;
    protected D updatedDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleID = UUID.randomUUID();
    }
    @Test
    void testGetById() throws Exception {

        when(service.findById(sampleID)).thenReturn(sampleDTO);


        mockMvc.perform(get(baseURL + "/" + sampleID))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(sampleDTO)));

        verify(service).findById(sampleID);
    }
    @Test
    void testGetAllWithPagination() throws Exception {

        Pageable pageable = PageRequest.of(0, 2);
        List<D> dtos = List.of(sampleDTO);
        Page<D> dtoPage = new PageImpl<>(dtos, pageable, dtos.size());

        when(service.findAll(pageable)).thenReturn(dtoPage);


        mockMvc.perform(get(baseURL)
                        .param("page", "0")
                        .param("size", "2"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(dtoPage)));

        verify(service).findAll(pageable);
    }
    @Test
    void testCreate() throws Exception {

        when(service.save(sampleDTO)).thenReturn(sampleDTO);


        MvcResult result = mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) post(baseURL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(sampleDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(sampleDTO)))
                .andReturn();


        verify(service).save(sampleDTO);

        String responseContent = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(sampleDTO), responseContent);
    }

    @Test
     void testUpdate() throws Exception {

        when(service.update(sampleID, sampleDTO)).thenReturn(sampleDTO);

        mockMvc.perform(put("/your-api-endpoint/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedDTO)));
        verify(service).update(sampleID, sampleDTO);
    }
    @Test
    void testDelete() throws Exception {

        mockMvc.perform(delete(baseURL + "/" + sampleID))
                .andExpect(status().isNoContent());

        verify(service).deleteById(sampleID);
    }
}
