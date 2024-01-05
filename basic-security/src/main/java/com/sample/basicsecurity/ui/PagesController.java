package com.sample.basicsecurity.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/")
    public String entryHomePage() {
        return "index.html";
    }

    @GetMapping("/user")
    public String entryUserPage() {
        return "user.html";
    }

    @GetMapping("/manager")
    public String entryManagerPage() {
        return "manager.html";
    }

    @GetMapping("/admin")
    public String entryAdminPage() {
        return "admin.html";
    }

}
