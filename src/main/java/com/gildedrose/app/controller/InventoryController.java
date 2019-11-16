package com.gildedrose.app.controller;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Controller
public class InventoryController {

        @Autowired
        private HttpServletRequest request;

        @ModelAttribute("items")
        public Item getModelItems(){
            return new Item("thing1",3,4);
        }
        @RequestMapping("/")
        public String index() {
            return "<body>Welcome to The Gilded Rose!<br>I am Khajiit. Do you have coin?</body>";
        }
    @GetMapping(value = "/inventory/list")
    public String inventory(Item item, BindingResult result, Map<String, Object> model) {
            HttpSession session = request.getSession(true);
            session.setAttribute("gr", new GildedRose());
            model.put("items",getItemCollection());
            return "inventory";
    }

    public static Item[] getItems () {
            return new Item[]{new Item("thing1", 4, 5), new Item("thing2", 4, 4)};
        }
        private Collection<Item> getItemCollection(){
        List<Item> items = new ArrayList<>();

        Item thing1 = new Item("thing1", 3, 4);
        items.add(thing1);
        Item thing2 = new Item("thing2", 3, 4);
        items.add(thing2);
        return items;
    }
}
