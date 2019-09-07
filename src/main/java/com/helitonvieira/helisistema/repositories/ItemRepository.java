package com.helitonvieira.helisistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.helitonvieira.helisistema.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
