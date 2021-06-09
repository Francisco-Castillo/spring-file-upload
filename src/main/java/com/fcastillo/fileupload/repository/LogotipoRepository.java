package com.fcastillo.fileupload.repository;

import com.fcastillo.fileupload.entity.Logotipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogotipoRepository extends JpaRepository<Logotipo, Long>{
    
}
