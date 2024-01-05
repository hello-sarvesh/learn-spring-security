package com.sample.basicsecurity.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/")
    public String entryHomePage() {
        return "index.html";
    }
}
