package com.popezada.picpaysimplified.service;

import com.popezada.picpaysimplified.domain.user.User;
import com.popezada.picpaysimplified.domain.user.UserType;
import com.popezada.picpaysimplified.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do tipo lojista não pode realizar transações.");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(
                () -> new Exception("Usuário não encontrado")
        );
    }
    public void SaveUser(User user) {
        this.repository.saveAndFlush(user);
    }
}