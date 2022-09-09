package com.example.doisoat.reponsitory;

import com.example.doisoat.model.CompareDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompareResponsitory extends JpaRepository<CompareDataEntity,Integer> {

}
