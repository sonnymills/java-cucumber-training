package gildedrose;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GildedRoseController {
        @RequestMapping("/")
        public String index() {
            return "Welcome to The Gilded Rose!<br>I am Khajiit. Do you have coin?";
        }
    @RequestMapping("/inventory/list")
    public String inventory() {
        return "this is the inventory page";
    }
}
