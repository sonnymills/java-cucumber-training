package com.gildedrose.app.controller;

import com.gildedrose.DataStore;
import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class InventoryControllerTest {


   @Test
   public void contextLoads() throws Exception { }

   @Autowired
   private MockMvc mockMvc;

   @Before
   public void setup(){
      DataStore ds = DataStore.getDataStoreInstance();
      Item item = new Item("controller_test",1,1);
      ds.addObject(item.name,item);
   }

   @Test
   public void shouldReturnStatus200forInventoryList() throws Exception {
      this.mockMvc.perform(get("/inventory/list")).andDo(print()).andExpect(status().isOk());
   }

}
