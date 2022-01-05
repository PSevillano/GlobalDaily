package com.sevillano.globaldaily.Controller;


import java.util.List;

import com.sevillano.globaldaily.Entity.News;
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

    @GetMapping("/getAll")
    @ResponseBody
    public List<News> getNews(){
        List<News> news = newsRepository.getAllNews();
        
        return news;
        
    }
    
    
}
