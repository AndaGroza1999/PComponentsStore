package com.PComponents.controller;

import com.PComponents.model.User;
import com.PComponents.service.ProductService;
import com.PComponents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login(ModelAndView view) {
        view.setViewName("login");

        return view;
    }


    @GetMapping(value = "/register")
    public ModelAndView registration(ModelAndView view, User user) {
        view.addObject("user", user);
        view.setViewName("register");
        return view;
    }


    @PostMapping(value = "/register")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, ModelAndView view) {
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            view.setViewName("register");
        } else {
            userService.saveUser(user);
            view.addObject("successMessage", "User has been registered successfully");
            view.addObject("user", new User());
            view.setViewName("register");

        }
        return view;
    }

    @GetMapping(value = "/admin/adminHome")
    public ModelAndView adminHome(ModelAndView view) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        view.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        view.addObject("adminMessage", "This Page is available to Users with Admin Role");
        view.setViewName("admin/adminHome");
        return view;
    }

    @GetMapping(value = "/user/userHome")
    public ModelAndView userHome(ModelAndView view) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        view.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        view.addObject("userMessage", "This Page is available to Users with User Role");


        view.addObject("productsList", productService.findAllProducts());
        view.setViewName("user/userHome");
        return view;
    }
}