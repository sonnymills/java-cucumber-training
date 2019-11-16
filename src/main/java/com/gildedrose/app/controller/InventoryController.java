package com.gildedrose.app.controller;

import com.gildedrose.DataStore;
import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class InventoryController {

    @Autowired
    private HttpServletRequest request;

    @ModelAttribute("items")
    public Item getModelItems() {
        return new Item("thing1", 3, 4);
    }

    @RequestMapping("/")
    public String index() {
        return "<body>Welcome to The Gilded Rose!<br>I am Khajiit. Do you have coin?</body>";
    }

    @GetMapping(value = "/inventory/list")
    public String inventory(Item item, BindingResult result, Map<String, Object> model) {
        HttpSession session = request.getSession(true);
        session.setAttribute("gr", new GildedRose());
        model.put("items", getItemList());
        return "inventory";
    }

    public List<Object> getItemList() {
        DataStore ds = DataStore.getDataStoreInstance();
        return ds.getObjectList();
    }
}
