package gildedrose;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GildedRoseController {
        @RequestMapping("/")
        public String index() {
            return "<body>Welcome to The Gilded Rose!<br>I am Khajiit. Do you have coin?</body>";
        }
    @RequestMapping("/inventory/list")
    public String inventory() {
        return "<body><h2>this is the inventory page<h2></body>";
    }
}
