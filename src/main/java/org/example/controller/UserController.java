package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


//anotacao que permite a criacao de metodos que serao chamados via Web utilizando o protocolo HTTP
@RestController
public class UserController {
    //estatica pois sera usada em mais de um metodo
    public static List<UserDTO> users = new ArrayList<>();

    //anotacao que inicia o metodo logo depois que o conteiner inicializa a class UserController.
    //metodo para inicializar a lista apenas uma vez, que insere tres usuarios na lista
    @PostConstruct
    public void initiateList(){

        UserDTO userDTO = new UserDTO();
        userDTO.setName("Eduardo");
        userDTO.setCpf("123");
        userDTO.setAddress("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelephone("1234-3454");
        userDTO.setDateRegister(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setAddress("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelephone("1234-3454");
        userDTO2.setDateRegister(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setAddress("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelephone("1234-3454");
        userDTO3.setDateRegister(new Date());

        // adiciona as listagem de usuários na lista users
        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }
    //anotacao que recebe um parametro que busca o caminho para acessar este metodo
    @GetMapping("/")
    public String getMessage() {
        return "Spring boot is working!";
    }

    /// Retorna uma lista de objetos UserDTO representando todos os usuários disponíveis
    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;
    }


    //Retorna um usuário com base no cpf
    @GetMapping("/users/{cpf}")
    public List<UserDTO> getUsersFilter(@PathVariable String cpf) {

        for(UserDTO userFilter : users){
            if(userFilter.getCpf().equals(cpf)){
                return Collections.singletonList(userFilter);
            }
        }
        return null;
    }
    @PostMapping("/newUser")
    public UserDTO insert(@RequestBody UserDTO userDTO){
        userDTO.setDateRegister(new Date());
        users.add(userDTO);
        return userDTO;
    }


}


