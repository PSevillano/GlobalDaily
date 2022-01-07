package com.sevillano.globaldaily.RSSSchedulers;

import java.io.IOException;
import java.util.List;

import com.sevillano.globaldaily.Entity.News;
import com.sevillano.globaldaily.Entity.NewsPaper;
import com.sevillano.globaldaily.Service.NewsPaperRepository;
import com.sevillano.globaldaily.Service.NewsRepository;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class RssScrapper {

    Logger logger = LoggerFactory.getLogger(RssScrapper.class);
    
    @Autowired
    public NewsRepository newsRepository;
    @Autowired
    public NewsPaperRepository newsPaperRepository;

    public RssScrapper(){}

    public boolean compareDates(String date){

        boolean res = true;

        String[] now = new String[2];
        String[] dateRes = new String[2];
        now = java.time.LocalDateTime.now().toString().split("T");
        dateRes = date.split("T");
        //System.out.println(Now[0]);
        if(!now[0].equals(dateRes[0])){
            res=false;
        }
        return res;
    }

    @Scheduled(cron = "0 22 9 * * *")
    public void saveDataVanguardia(){

        List<NewsPaper> newsPapers = newsPaperRepository.getAllNewsLetters();
        logger.info("Empezamos");
        for(NewsPaper newsPaper : newsPapers){
            String blogUrl = newsPaper.getLinkToDownload();
            try {
                Document doc = Jsoup.connect(blogUrl).get();
                for (Element item : doc.select("item")) {
                    if(compareDates(item.select("pubDate").text()) && item.select("description").text() != ""){
                        News news = new News();
                        news.setTitle(item.select("title").text());
                        news.setCompleteText(item.select("description").text());
                        news.setCountry(newsPaper.getCountry());
                        news.setOrigin(newsPaper.getName());
                        news.setDateNews(item.select("pubDate").text());
                        news.setLinkImg(item.select("enclosure").attr("url"));
                        news.setNewsType(newsPaper.getTag());
                        newsRepository.save(news);
                    }
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        logger.info("Acabamos");
    }


    
}
