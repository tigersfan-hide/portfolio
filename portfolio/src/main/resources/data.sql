--カテゴリーtable
INSERT IGNORE INTO categorys (id,category) VALUES (1,'焼肉');
INSERT IGNORE INTO categorys (id,category) VALUES (2,'ラーメン');
INSERT IGNORE INTO categorys (id,category) VALUES (3,'鉄板料理');
INSERT IGNORE INTO categorys (id,category) VALUES (4,'居酒屋');
INSERT IGNORE INTO categorys (id,category) VALUES (5,'イタリアン');
INSERT IGNORE INTO categorys (id,category) VALUES (6,'中華料理');
INSERT IGNORE INTO categorys (id,category) VALUES (7,'日本料理');
INSERT IGNORE INTO categorys (id,category) VALUES (8,'フレンチ');
INSERT IGNORE INTO categorys (id,category) VALUES (9,'韓国料理');
INSERT IGNORE INTO categorys (id,category) VALUES (10,'カフェ');
INSERT IGNORE INTO categorys (id,category) VALUES (11,'鍋料理');
INSERT IGNORE INTO categorys (id,category) VALUES (12,'名古屋名物');
INSERT IGNORE INTO categorys (id,category) VALUES (13,'その他');

-- 店舗table
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (1,1,'焼肉　神宮','image_yakiniyu1.jpg','愛知県名古屋市熱田区金山町1-16-16','050-5872-2335','名古屋老舗のお店。老舗の味をご堪能ください。','4,000~5,000','17:00~00:00 L.O. 23:30',46,'火曜日(祝日の場合は営業)');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (2,1,'焼肉　老中','image_yakiniyu2.jpg','愛知県名古屋市西区那古野2-19-23ZERO-NEXT E','050-5868-0811','名古屋老舗のお店。老舗の味をご堪能ください。','10,000~15,000','17:00~23:00',14,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (3,1,'肉亭　まぼたん','image_yakiniyu3.jpg','愛知県名古屋市中区大須3-30-4','050-5597-2840','名古屋老舗のお店。老舗の味をご堪能ください。','8,000~10,000','17:00~0:00',50,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (4,1,'和牛焼肉　ラスベガス','image_yakiniyu1.jpg','愛知県名古屋市千種区内山1-24-9ダイワ第2ビル 1F','050-5571-3511','名古屋老舗のお店。老舗の味をご堪能ください。','3,000~4,000','17:00~23:00 L.O. 22:30',54,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (5,1,'焼肉 牛力','image_yakiniyu2.jpg','愛知県名古屋市千種区仲田2-19-11 はとビル 1F','050-5590-3097','名古屋老舗のお店。老舗の味をご堪能ください。','4,000~5,000','17:00~00:00 L.O. 23:30',41,'年中無休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (6,1,'ホルモン焼肉 富や(とみや)','image_yakiniyu3.jpg','愛知県名古屋市中区新栄町3-8 今川ビル 3F','050-5589-9244','名古屋老舗のお店。老舗の味をご堪能ください。','5,000~6,000','17:00~23:30 L.O. 23:30',68,'火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (7,1,'飛騨牛焼肉 牛ざんまい','image_yakiniyu1.jpg','愛知県名古屋市熱田区金山町2-1-15','050-5600-9041','名古屋老舗のお店。老舗の味をご堪能ください。','4000~5,000','17:00~23:00',71,'年中無休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (8,1,'焼肉赤身にくがとう','image_yakiniyu2.jpg','愛知県名古屋市中区栄4-2-17','050-5596-6284','名古屋老舗のお店。老舗の味をご堪能ください。','5,000~6,000','11:30~14:30 L.O. 14:00'
'17:00~00:00 L.O. 23:30',86,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (9,2,'らぁ麺 紫陽花（ラアメン アジサイ）','image_ra-men1.jpg','愛知県名古屋市中川区八剱町4-20-1コーポ源 1F','052-355-0787','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00~15:00',14,'月曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (10,2,'麺家 獅子丸','image_ra-men2.jpg','愛知県名古屋市中村区亀島2-1-1','050-5589-4469','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00~14:30 L.O. 14:00'
'17:30~22:00 L.O. 21:30',13,'年中無休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (11,2,'らぁ麺や 汐そば雫','image_ra-men3.jpg','愛知県名古屋市瑞穂区下坂町4-15スターリア1F','050-5487-0693','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:30~15:00 L.O. 14:50',10,'年中無休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (12,2,'ラーメン専門店 徳川町 如水（じょすい）','image_ra-men1.jpg','愛知県名古屋市東区徳川町201','052-937-9228','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00~14:30'
'17:30~22:30 ',14,'火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (13,2,'らーめん奏','image_ra-men2.jpg','愛知県名古屋市昭和区阿由知通1-9','不明','名古屋老舗のお店。老舗の味をご堪能ください。','~999','11:30~14:00',7,'火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (14,2,'なるとや','image_ra-men3.jpg','愛知県名古屋市中区栄4-7-13 木村ビルディング1Ｆ','052-241-0511','名古屋老舗のお店。老舗の味をご堪能ください。','~999','11:30~14:00'
'18:00~22:30',14,'日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (15,2,'中華蕎麦 生る（チュウカソバ ナル）','image_ra-men1.jpg','愛知県名古屋市千種区豊年町3-18','052-717-6028','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:30 - 14:00'
'18:00 - 21:00',10,'月曜日、火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (16,2,'麺家 喜多楽（めんや きたら）','image_ra-men2.jpg','愛知県名古屋市中区橘1-28-6 近藤ビル　１Ｆ','052-332-5515','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00~14:00 L.O. 13:45'
'18:00~20:00 L.O. 19:45',16,'月曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (17,3,'広島流 お好み焼き 鉄板料理 がんす','image_teppann1.jpg','愛知県名古屋市東区東桜1-2-4','050-5593-5702','名古屋老舗のお店。老舗の味をご堪能ください。','3,000~4,000','17:30 - 23:30 L.O. 22:20',37,'日曜日、祝日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (18,3,'大人のおばんざいと鉄板料理 柚縁','image_teppann2.jpg','愛知県名古屋市中区栄3-10-11 サントウビル 1F','050-5590-4914','名古屋老舗のお店。老舗の味をご堪能ください。','3,000~4,000','17:00 - 00:00 L.O. 23:00',26,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (19,3,'鉄板料理 らくだ','image_teppann3.jpg','愛知県名古屋市東区東桜2-13-15','070-8983-6910','名古屋老舗のお店。老舗の味をご堪能ください。','8,000~9,000','17:00~0:00',18,'月曜日、日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (20,3,'東京もんじゃ 月島亭','image_teppann1.jpg','愛知県名古屋市北区大曽根3-14-38','050-5589-3576','名古屋老舗のお店。老舗の味をご堪能ください。','3,000~4,000','17:00 - 23:00 L.O. 23:00',76,'月曜日(祝日の場合は火曜定休)');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (21,3,'お好み焼 つなぐ','image_teppann2.jpg','愛知県名古屋市天白区原5-1105-2 加納上原ビル 1F','050-5592-6156','名古屋老舗のお店。老舗の味をご堪能ください。','2,000~3,000','11:00 - 14:00 L.O. 13:30'
'17:00 - 22:00 L.O. 21:30',26,'臨時休業あり');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (22,3,'名駅鉄板でれしし','image_teppann3.jpg','愛知県名古屋市中村区名駅5-23-19','050-5590-8643','名古屋老舗のお店。老舗の味をご堪能ください。','4,000~5,000','17:00 - 00:00 L.O. 23:00',70,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (23,3,'さいたにや','image_teppann1.jpg','愛知県名古屋市中区丸の内3-22-12 上明月ビル2F','052-951-8777','名古屋老舗のお店。老舗の味をご堪能ください。','2,000~3,000','17:00 - 3:00 L.O. 02:30',38,'日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (24,3,'神戸六甲道・ぎゅんた','image_teppann2.jpg','愛知県名古屋市中村区名駅3-28-12 大名古屋ビルヂング 3F','050-5594-1703','名古屋老舗のお店。老舗の味をご堪能ください。','2,000~3,000','11:00 - 15:00 L.O. 14:30'
'17:00 - 23:00 L.O. 22:00',31,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (25,4,'イチビキ','image_izakaya3.jpg','愛知県名古屋市中村区名駅南1-3-16','050-5597-3908','名古屋老舗のお店。老舗の味をご堪能ください。','4,000~5,000','11:30 - 13:00'
'17:30 - 20:00',38,'月曜日、隔週で火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (26,4,'おばんざい あんこ','image_izakaya1.jpg','愛知県名古屋市中村区名駅南1-10-19','052-581-3101','名古屋老舗のお店。老舗の味をご堪能ください。','3,000~4,000','15:00 - 00:00',10,'水曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (27,4,'千亀','image_izakaya2.jpg','愛知県名古屋市中区栄3-1-19 ソフランビル 2F','052-262-4848','名古屋老舗のお店。老舗の味をご堪能ください。','3,000~4,000','17:00 - 00:00 L.O. 23:15',30,'日曜日、祝日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (28,4,'海の日','image_izakaya3.jpg','愛知県名古屋市中区栄4-15-14 栄ハイホーム １Ｆ','052-265-5262','名古屋老舗のお店。老舗の味をご堪能ください。','6,000~7,000','18:00 - 23:00 L.O. 22:30',41,'日曜日(日曜日が振替休日の場合は翌月曜定休)');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (29,4,'炭焼 ちきんかばぶ','image_izakaya1.jpg','愛知県名古屋市中区栄4丁目16-8 栄メンバーズオフィスビルB1','052-262-3678','名古屋老舗のお店。老舗の味をご堪能ください。','8,000~10,000','18:00 - 00:00',10,'火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (30,4,'アロン','image_izakaya2.jpg','愛知県名古屋市中区新栄2-24-14 明治第10ビル 1F','052-253-9080','名古屋老舗のお店。老舗の味をご堪能ください。','5,000~6,000','18:00 - 03:00 L.O. 02:00',20,'月曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (31,4,'大甚 本店(だいじん)','image_izakaya3.jpg','愛知県名古屋市中区栄1-5-6','050-5600-9024','名古屋老舗のお店。老舗の味をご堪能ください。','3,000~4,000','15:45 - 21:15 L.O. 20:30(土のみL.O. 19:30)',120,'日曜日、祝日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (32,4,'大銀杏 栄店(おおいちょう)','image_izakaya1.jpg','愛知県名古屋市中区栄5-2-18','052-251-1260','名古屋老舗のお店。老舗の味をご堪能ください。','4,000~5,000','17:30 - 22:30 L.O. 22:00',38,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (33,5,'イル アオヤマ','image_italian2.jpg','愛知県名古屋市東区徳川1-17-38','052-508-7962','名古屋老舗のお店。老舗の味をご堪能ください。','30,000~40,000','18:00~23:00',9,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (34,5,'クッチーナ イタリアーナ ガッルーラ','image_italian3.jpg','愛知県名古屋市昭和区山里町70-2 山手アベニュー2F','052-680-7889','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','11:30 - 15:00 L.O. 13:00'
'18:00 - 22:00 L.O. 19:30',20,'月曜日、日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (35,5,'ヒロヴァーナ','image_italian1.jpg','愛知県名古屋市中村区名駅3-5-14 ジェイチル名駅ビル B1F','050-5890-7849','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','平日'
'17:00 - 20:00'
'土日祝'
'12:00 - 14:30'
'18:00 - 20:00',15,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (36,5,'ガプリス','image_italian2.jpg','愛知県名古屋市千種区池下1-2-6 ジャルダン池下 1F','070-8990-9585','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','18:00～0:00',10,'水曜日、日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (37,5,'かわ村','image_italian3.jpg','愛知県名古屋市千種区猫洞通4-34 ベルグレイＫＩ 1F','050-5590-8580','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','11:30 - 15:00'
'18:00 - 21:30',10,'水曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (38,5,'ヴィチーノ','image_italian1.jpg','愛知県名古屋市千種区春岡通7-58','052-762-3986','名古屋老舗のお店。老舗の味をご堪能ください。','10,000~15,000','11:30 - 13:30'
'18:00 - 20:30',20,'月曜日、火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (39,5,'日本のイタリア料理店 sai','image_italian2.jpg','愛知県名古屋市中区千代田2-8-17 グリーンハイツ鶴舞公園 1F','050-5457-0734','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','18:00～23:00',14,'水曜日、木曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (40,5,'アンティカ オステリア バーチョ','image_italian3.jpg','愛知県名古屋市東区筒井3-33-1','052-932-1919','名古屋老舗のお店。老舗の味をご堪能ください。','10,000~15,000','11:30 - 14:00 L.O. 14:00'
'17:30 - 23:00 L.O. 23:00',27,'月曜日(月曜が祝日の場合営業、火曜休み)');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (41,6,'眞善美（シンゼンビ）','image_chinese1.jpg','愛知県名古屋市東区東桜2-12-34 M,s GARDEN 2F','052-982-8820','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','18:30~21:00',11,'月曜日・隔週日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (42,6,'Joe,skitchen','image_chinese2.jpg','愛知県名古屋市中区丸の内3-9-19 正起ビル 1F','052-954-0225','名古屋老舗のお店。老舗の味をご堪能ください。','20,000~30,000','18:00～22:00',10,'日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (43,6,'沙龍（サロン）','image_chinese3.jpg','愛知県名古屋市東区東桜2-17-45','050-5589-5284','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','18:30 - 23:00',13,'月曜日、日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (44,6,'小菜一（シャオツァイイーディエ）','image_chinese1.jpg','愛知県名古屋市東区相生町43','050-5456-2930','名古屋老舗のお店。老舗の味をご堪能ください。','5,000~6,000','11:30 - 13:30'
'17:30 - 21:00',15,'月曜日、毎月1日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (45,6,'中国飯店 麗穂(レイホ)','image_chinese2.jpg','愛知県名古屋市中村区名駅4-7-1 ミッドランドスクエア 41F','050-5594-4564','名古屋老舗のお店。老舗の味をご堪能ください。','20,000~30,000','11:00 - 15:00 L.O. 14:30'
'17:30 - 22:00 L.O. 21:00',108,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (46,6,'好蘭','image_chinese3.jpg','愛知県名古屋市中区栄5-1-21 MLアシスト栄ビル 2F','052-291-4830','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','18:30～0:00',11,'月曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (47,6,'矢場味仙（ヤバミセン）','image_chinese1.jpg','愛知県名古屋市中区大須3-6-3','050-5596-9729','名古屋老舗のお店。老舗の味をご堪能ください。','2,000~3,000','11:30 - 13:40'
'17:00 - 00:40',364,'火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (48,6,'百老亭','image_chinese2.jpg','愛知県名古屋市千種区今池1-13-12','052-731-4462','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','17:00 - 20:00',20,'土曜日、日曜日、祝日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (49,7,'橦木町 しみず','image_wasyoku3.jpg','愛知県名古屋市東区橦木町3-24 プランドール橦木 1F','052-890-5515','名古屋老舗のお店。老舗の味をご堪能ください。','20,000~30,000','18:00～22:00',12,'日曜日、祝日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (50,7,'吉い(よしい)','image_wasyoku1.jpg','愛知県名古屋市中区新栄2-8-13 シャトー秋月 1F','052-241-0686','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','18:00～20:00',7,'日曜日、祝日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (51,7,'花いち','image_wasyoku2.jpg','愛知県名古屋市西区児玉2-4-13','052-524-2876','名古屋老舗のお店。老舗の味をご堪能ください。','10,000~15,000','17:00 - 22:00',10,'水曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (52,7,'肉屋 雪月花 NAGOYA','image_wasyoku3.jpg','愛知県名古屋市中村区名駅4-6-23 第三堀内ビル B1','052-433-1029','名古屋老舗のお店。老舗の味をご堪能ください。','20,000~30,000','17:00 - 23:00',14,'日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (53,7,'懐石 八泉（はちせん）','image_wasyoku1.jpg','愛知県名古屋市千種区猫洞通4-34','052-783-0600','名古屋老舗のお店。老舗の味をご堪能ください。','30,000~40,000','12:00 - 14:30'
'18:00 - 22:00',12,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (54,7,'おおたに','image_wasyoku2.jpg','愛知県名古屋市中村区豊国通4-7','050-5456-5165','名古屋老舗のお店。老舗の味をご堪能ください。','10,000~15,000','18:00～22:00',16,'日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (55,7,'柳家錦（ヤナギヤニシキ）','image_wasyoku3.jpg','愛知県名古屋市中区錦3-12-30 第2ワシントンアネックスビル 1F','052-212-5230','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','18:00 - 22:30',25,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (56,7,'京味 もと井','image_wasyoku1.jpg','愛知県名古屋市千種区西山元町1-58','052-750-5942','名古屋老舗のお店。老舗の味をご堪能ください。','20,000~30,000','12:00 - 14:30'
'18:00 - 21:00',26,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (57,8,'レミニセンス（Reminiscence）','image_french2.jpg','愛知県名古屋市東区筒井3-18-3','052-228-8337','名古屋老舗のお店。老舗の味をご堪能ください。','30,000~40,000','18:00～ 、18:30～',32,'ホームページに記載');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (58,8,'ラ・ヴァガボンド（LA VAGABONDE）','image_french3.jpg','愛知県名古屋市中区千代田2丁目14-24 キャノンピア鶴舞　１Ｆ','052-253-7343','名古屋老舗のお店。老舗の味をご堪能ください。','30,000~40,000','【Lunch】'
'［金曜日・土曜日］の週二日'
'12:00'
'【Dinner】'
'[月～土曜日]'
'18:00～18:30',16,'日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (59,8,'Maison DIA Mizuguchi（メゾン ダイア ミズグチ）','image_french1.jpg','愛知県名古屋市中区栄2-1-21 サンシャイン伏見ビル 1F','050-3160-2854','名古屋老舗のお店。老舗の味をご堪能ください。','20,000~30,000','11:30 - 14:00'
'18:00 - 23:30',30,'月曜日、日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (60,8,'マスドラヴァンド（Mas de Lavande）','image_french2.jpg','愛知県名古屋市中区東桜2-23-22 ホテルマイステイズ名古屋栄 B1F','052-325-2587','名古屋老舗のお店。老舗の味をご堪能ください。','15,000~20,000','18:00 - 23:00 L.O. 20:00',12,'日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (61,9,'しみず','image_korean3.jpg','愛知県名古屋市北区清水2丁目4-6 清水ビル１F','052-937-4321','名古屋老舗のお店。老舗の味をご堪能ください。','10,000~15,000','17:00 - 23:00',15,'月曜日、火曜日、日曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (62,9,'釜山(ぷさん)','image_korean1.jpg','愛知県名古屋市中村区藤江町3-45-1','052-471-7809','名古屋老舗のお店。老舗の味をご堪能ください。','4,000~5,000','17:30 - 21:00',22,'木曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (63,9,'韓日亭','image_korean2.jpg','愛知県名古屋市東区東桜2-3-4','050-5868-8379','名古屋老舗のお店。老舗の味をご堪能ください。','3,000~4,000','17:00 - 23:00 L.O. 22:40',40,'年中無休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (64,10,'ザ リスコ（THE RISCO）','image_cafe3.jpg','愛知県名古屋市中区平和1-16-6','050-5590-8019','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00 - 15:00'
'17:00 - 21:00 L.O. 20:30'
'日曜日、祝日'
'11:00 - 17:00 L.O. 16:30',18,'火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (65,10,'コーヒーハウス かこ','image_cafe1.jpg','愛知県名古屋市中村区名駅5-16-17 花車ビル南館　１Ｆ','052-586-0239','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','7:00 - 17:00',18,'元日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (66,10,'テーラ・テール(terre terre)','image_cafe2.jpg','愛知県名古屋市東区泉3-28-3','052-930-5445','名古屋老舗のお店。老舗の味をご堪能ください。','～999','9:00 - 18:00',16,'水曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (67,10,'ピエールプレシュウズ（PIERRE PRECIEUSE）','image_cafe3.jpg','愛知県名古屋市千種区丸山町3-83 メナージュマルヤマ','052-753-0070','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00 - 17:00 L.O.16:00',17,'月曜日、火曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (68,10,'パティスリーグラム（patisserie gramme','image_cafe1.jpg','愛知県名古屋市千種区猫洞通2-5 1F','052-753-6125','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','10:00 - 17:00',4,'火曜日、水曜日');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (69,10,'フルーツパーラー 弘法屋(KOBOYA)','image_cafe2.jpg','愛知県名古屋市千種区覚王山通8-70-1 名鉄パレサンクレア池下店　１F','052-764-5162','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00~18:00',16,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (70,11,'もつ藤','image_nabe3.jpg','愛知県名古屋市中区丸の内3-5-40','050-5593-2498','名古屋老舗のお店。老舗の味をご堪能ください。','5,000~6,000','月、火、水、木、日'
'17:00 - 23:00 L.O. 22:00'
'金、土'
'17:00 - 00:00 L.O. 23:00',43,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (71,11,'しゃぶしゃぶ・創作料理居酒屋 豚吟','image_nabe1.jpg','愛知県名古屋市中区栄4-9-10 愛信プラザビル 2F','050-5594-0708','名古屋老舗のお店。老舗の味をご堪能ください。','4,000~5,000','17:00 - 03:00',30,'年中無休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (72,11,'四川傳統火鍋 川嬌（センキョウ）','image_nabe2.jpg','愛知県名古屋市中区錦3-7-12 2F','052-684-8528','名古屋老舗のお店。老舗の味をご堪能ください。','5,000~6,000','17:00～24:00',25,'年中無休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (73,11,'水炊き吟醸もつ鍋 由乃','image_nabe3.jpg','愛知県名古屋市中区錦3-8-19 フジスター錦ビル 2F','050-5592-9701','名古屋老舗のお店。老舗の味をご堪能ください。','4,000~5,000','17:00 - 00:00 L.O. 23:15',62,'年中無休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (74,12,'山本屋本店 大門本店（やまもとやほんてん）','image_nagoya1.jpg','愛知県名古屋市中村区太閤通6-5','052-482-2428','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00 - 22:00 L.O. 21:30',70,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (75,12,'煮込うどん 山本屋本店 エスカ店（やまもとやほんてん）','image_nagoya2.jpg','愛知県名古屋市中村区椿町6-9 エスカ地下街','052-452-1889','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00 - 22:00 L.O. 21:30',58,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (76,12,'山本屋本店 守山店（やまもとやほんてん）','image_nagoya3.jpg','愛知県名古屋市守山区野萩町13-13','052-791-0194','名古屋老舗のお店。老舗の味をご堪能ください。','1,000~2,000','11:00 - 21:00 L.O. 20:30',100,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (77,12,'うな富士（うなふじ）','image_nagoya1.jpg','愛知県名古屋市昭和区白金1-1-4 プレザアント白金','052-881-0067','名古屋老舗のお店。老舗の味をご堪能ください。','5,000~6,000','11:00 - 14:00'
'17:00 - 21:00 L.O. 20:00',30,'不定休');
INSERT IGNORE INTO restaurants (restaurant_id,category_id,name,image_name,address,phone_number,description,budget,opening_hours,capacity,holiday ) VALUES (78,12,'あつた蓬莱軒 本店（蓬莱陣屋）','image_nagoya2.jpg','愛知県名古屋市熱田区神戸町503','050-5596-7539','名古屋老舗のお店。老舗の味をご堪能ください。','5,000~6,000','11:30 - 14:00'
'16:30 - 20:30',180,'水曜（祝日は営業）と第2・4木曜日');

--役割table
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_FREE');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_PAID');

--会員table
INSERT IGNORE INTO users (id, name, furigana, phone_number, email, birthday, password, occupation, role_id, delete_flag) VALUES (1, '侍 太郎', 'サムライ タロウ', '090-1234-5678', 'taro.samurai@example.com', 19971024, '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, 1, 1);
INSERT IGNORE INTO users (id, name, furigana, phone_number, email, birthday, password, occupation, role_id, delete_flag) VALUES (2, '侍 花子', 'サムライ ハナコ', '090-1234-5678', 'hanako.samurai@example.com', 19950504, '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2, 2, 1);
INSERT IGNORE INTO users (id, name, furigana, phone_number, email, birthday, password, occupation, role_id, delete_flag) VALUES (3, '侍 義勝', 'サムライ ヨシカツ', '090-1234-5678', 'yoshikatsu.samurai@example.com', 20050312, 'password3', 3, 1, 1);