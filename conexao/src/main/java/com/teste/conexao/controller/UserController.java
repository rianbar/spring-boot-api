package com.teste.conexao.controller;

import com.teste.conexao.modelo.ResponseModel;
import com.teste.conexao.modelo.UserModel;
import com.teste.conexao.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody  List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody  UserModel filter(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody UserModel insertUser(@RequestBody UserModel user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseModel  deleteUser(@PathVariable Integer id) {

        ResponseModel response = new ResponseModel();

        try {
            UserModel user = filter(id);
            this.userRepository.delete(user);
            response.setMessage("Ação executada com sucesso!");
        } catch (Exception e) {
            response.setMessage("Erro ao executar a ação " + e.getMessage());
        }
        return response;
    }
}
