package br.com.sigi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigi.model.User;

public interface UserRespository extends JpaRepository<User, Long> {



}
