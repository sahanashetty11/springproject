package com.example.demo.springproject;

import com.example.demo.springproject.controller.BooksController;
import com.example.demo.springproject.entity.Books;
import com.example.demo.springproject.service.BooksService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;
import java.awt.print.Book;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BooksController.class)
class SpringprojectApplicationTests {

	@MockBean
	private BooksService booksService;

	@Autowired
	private MockMvc mockMvc;



	@Test
	public void booktitleTest() throws Exception {
		Books books=new Books();
		books.setId(1);
		books.setTitle("sahana");
		Mockito.when(booksService.title(books.getId())).thenReturn(books.getTitle());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/title");
		MvcResult result = (MvcResult) mockMvc.perform(requestBuilder).andReturn();
		assertEquals(result.getResponse().getContentAsString(),books.getTitle(),"sahana");
	}

	@Test
	public void addTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
				.content("{\"id\":1,\"title\":\"sahana\"}")
				.contentType(MediaType.APPLICATION_JSON);
	mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void deleteTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/delete/1");
		MvcResult result=mockMvc.perform(requestBuilder)
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void findTest() throws Exception {
		Books books=new Books();
		books.setId(1);
		books.setTitle("sahana");
		Mockito.when(booksService.findbyid(books.getId())).thenReturn(books);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/find/1");
		MvcResult result=mockMvc.perform(requestBuilder)
				.andReturn();
		Assert.assertEquals("{\"id\":1,\"title\":\"sahana\"}",result.getResponse().getContentAsString());

	}

}
