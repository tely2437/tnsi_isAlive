package com.tnsi.isalive.messagerie.controller;

import com.tnsi.isalive.messagerie.others.Form;
import com.tnsi.isalive.messagerie.others.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RequestController {

    @GetMapping("/form")
    public String formRequest(Model model){
        model.addAttribute("form", new Form());
        return "form";
    }

    @PostMapping("/form")
    public String formSubmit(){

        return "result";
    }

    @RequestMapping(value = "/login_check", method = RequestMethod.POST)
    @ResponseBody
    public String submittedOk(@RequestBody Logged logg, HttpSession session){
        session.setAttribute("username",logg.getUsername());
        session.setAttribute("accessToken",logg.getAccessToken());
        session.setAttribute("tokenType",logg.getTokenType());

        System.out.println(session.getAttribute("username"));

        return ("ok");
    }


}


