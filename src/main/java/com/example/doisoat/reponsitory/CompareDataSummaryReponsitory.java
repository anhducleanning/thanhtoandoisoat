package com.example.doisoat.reponsitory;

import com.example.doisoat.model.CompareDataSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompareDataSummaryReponsitory  extends JpaRepository<CompareDataSummaryEntity,Integer >{
}
