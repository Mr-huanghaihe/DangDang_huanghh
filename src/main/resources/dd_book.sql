DROP TABLE dd_book
CREATE TABLE dd_book(
ID VARCHAR2(40 BYTE) NOT NULL ,
NAME VARCHAR2(90 BYTE) NULL ,
AUTHOR VARCHAR2(90 BYTE) NULL ,
COVER VARCHAR2(40 BYTE) NULL ,
PRESS VARCHAR2(90 BYTE) NULL ,
PRESS_DATE DATE NULL ,
EDITION VARCHAR2(30 BYTE) NULL ,
PRINT_DATE DATE NULL ,
IMPRESSION VARCHAR2(30 BYTE) NULL ,
ISBN VARCHAR2(20 BYTE) NULL ,
WORD_NUM NUMBER(10) NULL ,
PAGE_NUM NUMBER(10) NULL ,
SIZES VARCHAR2(30 BYTE) NULL ,
PAPER VARCHAR2(30 BYTE) NULL ,
PACK VARCHAR2(30 BYTE) NULL ,
PRICE FLOAT NULL ,
DPRICE FLOAT NULL ,
CREATE_DATE DATE NULL ,
EDITOR_RECOMMEND VARCHAR2(4000 BYTE) NULL ,
CONTENT_ABSTRACT VARCHAR2(4000 BYTE) NULL ,
AUTHOR_ABSTRACT VARCHAR2(4000 BYTE) NULL ,
DIRECTOR VARCHAR2(4000 BYTE) NULL ,
MEDIA_COMMENTARY VARCHAR2(4000 BYTE) NULL ,
CATEGORY_ID VARCHAR2(40 BYTE) NULL ,
SALE NUMBER(10) NULL ,
STOCK NUMBER NULL
)
update dd_book set sale=4 where id='5734e68f-244d-4ed4-8c97-12ac37a7616d'
select * from dd_book

select f.id f_id,f.name f_name,f.parentId f_parentId,f.levels f_levels,
			   s.id s_id,s.name s_name,s.parentId s_parentId,s.levels s_levels
			   from category f left join category s on f.id=s.parentId
			   where f.levels='1'
select a.*,rownum from
		(select id, name, author, cover, press, press_date, edition, print_date, impression, isbn, word_num, page_num, sizes, paper, 
				pack, price, dprice, create_date, editor_recommend, content_abstract, author_abstract, director, media_commentary, category_id, sale, stock
				from dd_book order by sale desc) a where rownum between 1 and 8 and sale!=0
INSERT INTO dd_book VALUES ('1', '东周列国志', '冯梦龙', 'dzlgz.jpg', '民主与建设出版社', TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'), '第三版', TO_DATE('2018-12-12 16:32:08', 'YYYY-MM-DD HH24:MI:SS'), '第五次印刷', '9787551123426', '50000', '500', '16开', '胶版纸', '精装', '20', '19', TO_DATE('2019-01-07 16:34:07', 'YYYY-MM-DD HH24:MI:SS'), '当当网此版本销售火爆！写尽东周五百年群雄争霸颠覆历史格局的传奇巨著！', '古典小说精品系列： 《芈月传》小说原著及编剧蒋胜男读的首本书《 东周列国志 》 ', '作者很低调，没有做简介', '买了就知道目录了，我就不多介绍了', '媒体也说很好看的一本书', '0840113e-9828-455e-8b12-5cb2e10b5436', '0', '1000');
INSERT INTO dd_book VALUES ('2', '搜神记', '马银琴', 'ssj.jpg', '中华书局出版社', TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'), '第三版', TO_DATE('2018-12-12 16:32:08', 'YYYY-MM-DD HH24:MI:SS'), '第五次印刷', '9787551123426', '50000', '500', '16开', '胶版纸', '精装', '20', '19', TO_DATE('2019-01-07 16:34:07', 'YYYY-MM-DD HH24:MI:SS'), '中华经典名著全书全注全译丛书', '中华经典名著全书全注全译丛书', '作者很低调，没有做简介', '买了就知道目录了，我就不多介绍了', '媒体也说很好看的一本书', '0840113e-9828-455e-8b12-5cb2e10b5436', '0', '1000');
INSERT INTO dd_book VALUES ('4', '聊斋志异', '蒲松龄', 'lzzy.jpg', '民主与建设出版社', TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'), '第三版', TO_DATE('2018-12-12 16:32:08', 'YYYY-MM-DD HH24:MI:SS'), '第五次印刷', '9787551123426', '50000', '500', '16开', '胶版纸', '精装', '15', '14', TO_DATE('2019-01-07 16:34:07', 'YYYY-MM-DD HH24:MI:SS'), '中国古代灵异与志怪小说的集大成者，收录近500篇知名小说', '清代小说家蒲松龄代表作，中国古代灵异、志怪小说的集大成者。', '作者很低调，没有做简介', '高序
唐序
聊斋自志
卷一
考城隍
耳中人
尸变
喷水
瞳人语
画壁
山魈
咬鬼
捉狐
收中怪', '媒体也说很好看的一本书', 'f0dbdcb6-1857-4063-8759-090265c217c6', '0', '1000');