ALTER TABLE globaldaily.news MODIFY complete_text TEXT NOT NULL;

insert into globaldaily.news(id,complete_text,country,date_news,link_img,origin,title)
value (1,'aaaaa','ES','12/01/1995','www.google.com','Marca','bbbbbb');
insert into globaldaily.news(id,complete_text,country,date_news,link_img,origin,title)
value (2,'aaaaa','ES','12/01/1995','www.google.com','Marca','bbbbbb');
insert into globaldaily.news(id,complete_text,country,date_news,link_img,origin,title)
value (3,'aaaaa','ES','12/01/1995','www.google.com','Marca','bbbbbb');


insert into globaldaily.news_paper(id,name,tag,link_to_download,country)
value (1,'LaVanguardia','Tecnologia','https://www.lavanguardia.com/rss/tecnologia.xml','ES');
insert into globaldaily.news_paper(id,name,tag,link_to_download,country)
value (2,'LaVanguardia','Deporte','https://www.lavanguardia.com/rss/deportes.xml','ES');