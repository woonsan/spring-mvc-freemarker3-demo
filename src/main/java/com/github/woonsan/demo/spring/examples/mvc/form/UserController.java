package com.github.woonsan.demo.spring.examples.mvc.form;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<User> users = new LinkedList<>();

        for (String id : userRepository.getUserIds()) {
            users.add(userRepository.getUser(id));
        }

        model.addAttribute("users", users);

        return "userlist";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") String id, Model model) {
        User user = userRepository.getUser(id);
        model.addAttribute("user", user);
        return "useredit";
    }

}
