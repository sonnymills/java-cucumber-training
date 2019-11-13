package gildedrose;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GildedRoseController {
        @RequestMapping("/")
        public String index() {
            return "<body>Welcome to The Gilded Rose!<br>I am Khajiit. Do you have coin?</body>";
        }
    @GetMapping({"/inventory/list","inventory"})
    public static String inventory(Model model) {
        Item[] items = getItems();
        GildedRose gr = new GildedRose(items);
        model.addAttribute("name","name");
        return "inventory";
    }

    public static Item[] getItems() {
        return new Item[] { new Item("thing 1",4,5),new Item("thing 2", 4,4)};
    }
}
