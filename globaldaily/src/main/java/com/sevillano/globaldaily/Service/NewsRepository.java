package com.sevillano.globaldaily.Service;

import java.util.List;

import com.sevillano.globaldaily.Entity.News;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{

    @Query(value="select * from news", nativeQuery=true)
    List<News> getAllNews();

    @Query(value="select * from news where news_type like 'Tecnologia'", nativeQuery=true)
    List<News> getAllTecnoNews();

    @Query(value="select * from news where news_type like 'Deporte'", nativeQuery=true)
    List<News> getAllSportNews();

}
