package com.halo.eventer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.halo.eventer.festival.controller.FestivalController;
import com.halo.eventer.festival.dto.FestivalCreateDto;
import com.halo.eventer.festival.repository.FestivalRepository;
import com.halo.eventer.festival.service.FestivalService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@Disabled
public class FestivalTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//
//
//
//    @Test
//    void checkCreateDuplicatedException()throws Exception{
//
//        FestivalCreateDto festivalCreateDto = new FestivalCreateDto("1","2","3","4");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonContent = objectMapper.writeValueAsString(festivalCreateDto);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/festival")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonContent);
//
//
//        mockMvc.perform(requestBuilder);
//
//
//    }
}
