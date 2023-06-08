package com.teste.conexao.repositorio;

import com.teste.conexao.modelo.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository  extends JpaRepository<UserModel, Long> {

    public List<UserModel> findAll();

    public UserModel findById(Integer id);

    public UserModel save(UserModel user);

    public void delete(UserModel user);
}
