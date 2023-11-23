package com.challenge.talycap.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.talycap.infrastructure.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

   @Query("SELECT c FROM Client c WHERE c.ident =:ident AND UPPER(c.typeDoc) = UPPER(:typeDoc)")
   Optional<Client> getByIdentAndTypeDoc(final String ident, final String typeDoc);

}
