package com.example.Book.Manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book,Integer> {
}
