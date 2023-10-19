package com.kafkaconsumer.repository;

import com.kafkaconsumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long> {
}
