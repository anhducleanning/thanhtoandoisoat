package com.example.doisoat.reponsitory;

import com.example.doisoat.model.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionReponsitory extends JpaRepository<SessionEntity,Integer> {
}
