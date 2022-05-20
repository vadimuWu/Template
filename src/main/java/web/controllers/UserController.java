package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import web.models.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/users";
    }

    @GetMapping(value = "users")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "users/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "users/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping("users/delete")
    public String deleteUserById(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));
        return "show";
    }

}

//@Controller
//@RequestMapping("/people")
//public class PeopleController {
//
//    private final PersonService personService;
//
//    @Autowired
//    public PeopleController(PersonService personService) {
//        this.personService = personService;
//    }
//
//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("people", personService.index());
//        return "people/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personService.show(id));
//        return "people/show";
//    }
//
//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("person") Person person) {
//        return "people/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("person") @Valid Person person,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "people/new";
//
//        personService.save(person);
//        return "redirect:/people";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("person", personService.show(id));
//        return "people/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult
////                         @PathVariable("id") int id
//    ) {
//        if (bindingResult.hasErrors())
//            return "people/edit";
//
//        personService.update( person);
//        return "redirect:/people";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        personService.delete(id);
//        return "redirect:/people";
//    }
//}

