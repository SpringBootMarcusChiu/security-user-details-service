package com.marcuschiu.securityuserdetailsservice.repo;

import com.marcuschiu.securityuserdetailsservice.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
    List<Authorities> findAllByUsername(String username);
}