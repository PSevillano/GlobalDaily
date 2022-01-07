package com.sevillano.globaldaily.Controller;


import java.util.List;

import com.sevillano.globaldaily.Entity.News;
import com.sevillano.globaldaily.Entity.NewsPaper;
import com.sevillano.globaldaily.Service.NewsPaperRepository;
import com.sevillano.globaldaily.Service.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class NewsRestController {
    
    @Autowired
    public NewsRepository newsRepository;
    @Autowired
    public NewsPaperRepository newsPaperRepository;

    @GetMapping("/getAll")
    @ResponseBody
    public List<News> getNews(){
        List<News> news = newsRepository.getAllNews();
        
        return news;
        
    }

    @GetMapping("/getAllNewsPaper")
    @ResponseBody
    public List<NewsPaper> getNewsPaper(){
        List<NewsPaper> newsPaper = newsPaperRepository.getAllNewsLetters();
          
        return newsPaper;
        
    } 

    @GetMapping("/getAllTecnoNews")
    @ResponseBody
    public List<News> getTecnoNews(){

        List<News> news = newsRepository.getAllTecnoNews();
        
        return news;
        
    }

    @GetMapping("/getAllSportsNews")
    @ResponseBody
    public List<News> getSportsNews(){

        List<News> news = newsRepository.getAllSportNews();
        
        return news;
        
    }
    
    
}
