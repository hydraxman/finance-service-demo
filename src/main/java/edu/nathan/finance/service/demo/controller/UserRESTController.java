package edu.nathan.finance.service.demo.controller;

import edu.nathan.finance.service.demo.model.Result;
import edu.nathan.finance.service.demo.model.UserEntity;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {

    private final List<UserEntity> users = List.of(
            new UserEntity(0, "Nathan", "123@qq.com", "123", "admin", "active", "2021-01-01", "Jerry")
    );

    @GetMapping("/{id}")
    public Result getUser(@PathVariable int id) {
        UserEntity userEntity = users.get(id);
        Result result = new Result();
        result.setCode(200);
        result.setData(userEntity);

        WebMvcLinkBuilder linkToAllUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).list());
        result.add(linkToAllUsers.withRel("all-users").withName("All Users").withType("GET"));
        WebMvcLinkBuilder linkToCreate = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).createUser(null));
        result.add(linkToCreate.withRel("create-user").withName("Create User").withType("POST"));
        return result;
    }

    @GetMapping("/list")
    public List<UserEntity> list() {
        return users;
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        user.setId(users.size());
        users.add(user);
        return user;
    }
}
