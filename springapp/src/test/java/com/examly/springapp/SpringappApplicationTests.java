package test.java.com.examly.springapp;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class SpringappApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	@Transactional
    public void BE_Add_User() throws Exception {
        String newProduct = "{\"email\":\"test@gmail.com\",\"password\":\"Test@123\",\"username\":\"test123\",\"mobileNumber\":\"9876543210\",\"active\":\"true\",\"role\":\"user\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/signup")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newProduct)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Add_Product() throws Exception {
        String newProduct = "{\"productId\":\"01\",\"imageUrl\":\"beetroot.com\",\"productName\":\"beetroot\",\"price\":\"35\",\"description\":\"fresh vegetables\",\"quantity\":\"30\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newProduct)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
	@Transactional
    public void BE_Get_Product() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/admin")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Update_Product() throws Exception {
        String newProduct = "{\"productId\":\"01\",\"imageUrl\":\"beetroot.com\",\"productName\":\"beetroot\",\"price\":\"30\",\"description\":\"fresh vegetables\",\"quantity\":\"30\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/productEdit")
		.param("productId","01")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newProduct)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
}
