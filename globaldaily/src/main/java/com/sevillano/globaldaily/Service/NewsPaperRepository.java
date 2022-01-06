package com.sevillano.globaldaily.Service;

import java.util.List;

import com.sevillano.globaldaily.Entity.NewsPaper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsPaperRepository extends JpaRepository<NewsPaper, Long>{
    @Query(value="select * from news_paper", nativeQuery=true)
    List<NewsPaper> getAllNewsLetters();
}
