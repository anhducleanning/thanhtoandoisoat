package com.example.doisoat.reponsitory;

import com.example.doisoat.model.ImportDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportDataReponsitory extends JpaRepository<ImportDataEntity,Integer> {
}
