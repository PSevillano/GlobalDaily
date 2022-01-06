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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RssScrapper {
    
    @Autowired
    public NewsRepository newsRepository;
    @Autowired
    public NewsPaperRepository newsPaperRepository;

    public RssScrapper(){}

    public boolean compareDates(String date){

        boolean res = true;

        String[] now = new String[2];
        now = java.time.LocalDateTime.now().toString().split("T");
        //System.out.println(Now[0]);
        if(!now.equals(date)){
            res=false;
        }
        return res;
    }


    public void saveDataVanguardia(){

        List<NewsPaper> newsPapers = newsPaperRepository.getAllNewsLetters();


        for(NewsPaper newsPaper : newsPapers){
            String blogUrl = newsPaper.getLinkToDownload();
            News news = new News();
            try {
                Document doc = Jsoup.connect(blogUrl).get();
                for (Element item : doc.select("item")) {
                    if(compareDates(item.select("pubDate").text())){
                        news.setTitle(item.select("title").text());
                        news.setCompleteText(item.select("description").text());
                        news.setCountry(newsPaper.getCountry());
                        news.setOrigin(newsPaper.getName());
                        news.setDateNews(item.select("pubDate").text());
                        news.setLinkImg(item.select("media:content").attr("url"));
                        newsRepository.save(news);
                    }
                }
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        }

        
    }


    
}
