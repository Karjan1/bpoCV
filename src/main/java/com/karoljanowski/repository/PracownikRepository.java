package com.karoljanowski.repository;

import com.karoljanowski.domain.Pracownik;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Karol Janowski on 2017-08-04.
 */
public interface PracownikRepository extends CrudRepository<Pracownik,Integer>{
    List<Pracownik> findAll();
    void delete(Pracownik pracownik);
}
