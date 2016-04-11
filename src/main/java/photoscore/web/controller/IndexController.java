package photoscore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lanegg on 16/4/9.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(value = "/")
    public String index(Model model) {

        return "redirect:/home";

    }

    @RequestMapping(value = "/home")
    public String home(Model model) {

        model.addAttribute("title", "我今天好看吗?");
        model.addAttribute("nav_value", "nav_index");
        return "home";

    }

    @RequestMapping(value = "/base")
    public String base() {



        return "base";
    }

}
