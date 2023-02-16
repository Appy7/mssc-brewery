package guru.springframework.msscbrewery;

//package org.springframework.test.context.junit4;

//import org.junit.runners.model.InitializationError;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.controller.BeerController;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.security.RunAs;
import java.awt.*;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunAs(SpringRunner.class)
@WebMvcTest(BeerController.class)
@SpringBootTest
@AutoConfigureMockMvc
class MsscBreweryApplicationTests {


	@MockBean
	BeerService beerService;

	@Autowired
	MockMvc mockMvc;

	BeerDto validBeer;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void contextLoads() {

		assertNotNull(mockMvc);
	}


	@BeforeEach
	public void  setup(){

		validBeer=BeerDto.builder().id((UUID.randomUUID()))
				.beerName("Sashan")
				.beerStyle("AhuriKAsa")
				.upc(8989887878789L).build();
	}

	@Test
	public void getBeer() throws Exception{
		//given(beerService.getBeerById(any(UUID.class))).willReturn(beerDto);
       given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

	   mockMvc.perform
			   (get("/api/v1/beer/"+ validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
			   .andExpect(jsonPath("$.beerName", is("Beer1")));
	}


	@Test
	public void handlePost() throws Exception{

		BeerDto beerDto = validBeer;
		beerDto.setId(null);
		BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		given(beerService.saveNewBeer(any())).willReturn(beerDto);

		mockMvc.perform(post("/api/v1/beer/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(beerDtoJson))
				.andExpect(status().isCreated());


	}


	@Test
	public void handlePut() throws Exception{
		BeerDto beerDto = validBeer;
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		//when
		mockMvc.perform(put("/api/v1/beer/" + validBeer.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(beerDtoJson))
				.andExpect(status().isNoContent());

		then(beerService).should().updateBeer(any(), any());

	}



}
