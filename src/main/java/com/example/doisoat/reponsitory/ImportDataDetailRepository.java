package com.example.doisoat.reponsitory;

import com.example.doisoat.model.CompareDataEntity;
import com.example.doisoat.model.ImportDataDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportDataDetailRepository  extends JpaRepository<ImportDataDetailEntity,Long> {
}
