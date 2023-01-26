insert into genre(name) values ("Kryminał");
insert into genre(name) values ("Reportaż");
insert into genre(name) values ("Biografia");
insert into genre(name) values ("Literatura Piękna");
insert into genre(name) values ("Literatura Naukowa");
insert into genre(name) values ("Horror");

insert into library(address, city, name) values ("Ul. Jadwigi 2", "Zielona Góra", "Biblioteka Norwida");
insert into library(address, city, name) values ("Ul. Gdańska 10", "Sulechów", "Biblioteka Sulechów");
insert into library(address, city, name) values ("Ul. Zielona 76", "Babimost", "Biblioteka Babimost");

insert into author(name, surname, bio) values ("Remigiusz", "Mróź", "Remigiusz Bogusław Mróz – polski pisarz, autor powieści, prawnik; autor cyklu publicystycznego „Kurs pisania”, laureat Nagrody Czytelników Wielkiego Kalibru z 2016 za powieść pt. Kasacja. W 2017 ujawnił się jako Ove Løgmansbø, autor trzech powieści.");
insert into author(name, surname, bio) values ("Chris", "Carter", "Chris Carter to popularny pisarz znany z thrillerów i kryminałów. Jego wnikliwe i mroczne powieści zyskały fanów na całym świecie. Chris Carter przyszedł na świat w Brazylii 14 lipca 1965 roku, jednak z czasem przeniósł się do Stanów Zjednoczonych. Studiował psychologię i zaburzenia kryminalne.");
insert into author(name, surname, bio) values ("Olga", "Tokarczuk", "Olga Nawoja Tokarczuk – polska pisarka, eseistka, poetka i autorka scenariuszy, psychoterapeutka, laureatka Nagrody Nobla w dziedzinie literatury za rok 2018, laureatka The Man Booker International Prize 2018 za powieść Bieguni oraz dwukrotna laureatka Nagrody Literackiej „Nike” za powieści: Bieguni i Księgi Jakubowe.");
insert into author(name, surname, bio) values ("Joanna", "Gierak-Onoszko", "Joanna Ewa Gierak-Onoszko – polska dziennikarka, reportażystka, pisarka i felietonistka. W swoich reportażach i felietonach często poruszała kwestie społeczne, prawnicze i dotyczące praw człowieka.");
insert into author(name, surname, bio) values ("Albert", "Sweigart", "Albert Sweigart — programista, projektant oprogramowania i nauczyciel kodowania. Autor licznych książek o Pythonie dla początkujących. Sweigart urodził się w Houston, w stanie Teksas, a obecnie mieszka w San Francisco.");
insert into author(name, surname, bio) values ("Kobe", "Bryant", "Mentalność Mamby. Jak zwyciężać");

insert into publisher(name) values ("Czarne");
insert into publisher(name) values ("PWN");
insert into publisher(name) values ("Znak");
insert into publisher(name) values ("Muza");
insert into publisher(name) values ("Zysk i S-ka");

insert into user(name, surname, address, city, login, password, role, library_id_user) values ("Dawid","Ziółkowski","Ul. Francuska 23","Zielona Góra","ziolo101", "$2a$12$KBKcJ5kTuRhDB9HGxKBQbu64zOoodotZOrQaFDY9WjG8L4f9Z0mIq","ADMIN",1);
insert into user(name, surname, address, city, login, password, library_id_user) values ("Filip","Gałkowski","Ul. Morelowa 21/37","Zielona Góra","felippe", "$2a$12$KBKcJ5kTuRhDB9HGxKBQbu64zOoodotZOrQaFDY9WjG8L4f9Z0mIq",2);
insert into user(name, surname, address, city, login, password, library_id_user) values ("Wojciech","Majewski","Ul. Gorzowska 10A","Zielona Góra","wojtek2137","$2a$12$KBKcJ5kTuRhDB9HGxKBQbu64zOoodotZOrQaFDY9WjG8L4f9Z0mIq",3);
insert into user(name, surname, address, city, login, password, library_id_user) values ("Artur","Karczewski","Ul. Szkolna 17","Zielona Góra","artur123","$2a$12$KBKcJ5kTuRhDB9HGxKBQbu64zOoodotZOrQaFDY9WjG8L4f9Z0mIq",1);

insert into location(number_of_rack, number_of_shelf) values (1,1);
insert into location(number_of_rack, number_of_shelf) values (1,2);
insert into location(number_of_rack, number_of_shelf) values (2,1);
insert into location(number_of_rack, number_of_shelf) values (2,2);
insert into location(number_of_rack, number_of_shelf) values (3,1);

insert into book(title, amount, library_id_book, author_id_book, genre_id_book, location_id_book, publisher_id_book) values ("Behawiorysta",5 ,1 ,1 ,1 , 2, 1);
insert into book(title, amount, library_id_book, author_id_book, genre_id_book, location_id_book, publisher_id_book) values ("Dzieje Jakubowe",10 ,3 ,3 ,4 , 2, 3);
insert into book(title, amount, library_id_book, author_id_book, genre_id_book, location_id_book, publisher_id_book) values ("Egzekutor",2 ,2 ,2 ,1 , 1, 2);
insert into book(title, amount, library_id_book, author_id_book, genre_id_book, location_id_book, publisher_id_book) values ("Egzekutor",2 ,2 ,2 ,1 , 2, 2);
insert into book(title, amount, library_id_book, author_id_book, genre_id_book, location_id_book, publisher_id_book) values ("Egzekutor",2 ,1 ,2 ,1 , 1, 2);
insert into book(title, amount, library_id_book, author_id_book, genre_id_book, location_id_book, publisher_id_book) values ("27 Śmierci Tobyego Oboydoa",7 ,2 ,4 ,2 , 3, 5);
insert into book(title, amount, library_id_book, author_id_book, genre_id_book, location_id_book, publisher_id_book) values ("Sztuczne Sieci Neuronowe",0 ,3 ,5 ,5 , 4, 4);

INSERT INTO library_db.book_lend
(`from_lend`, `to_lend`, book_id_book_lend, user_id_book_lend, library_id_book_lend)
VALUES('2022-05-05', '2023-05-05', 1, 1, 1);

INSERT INTO library_db.book_lend
(`from_lend`, `to_lend`, book_id_book_lend, user_id_book_lend, library_id_book_lend)
VALUES('2022-08-08', '2022-12-12', 2, 2, 2);

INSERT INTO library_db.book_lend
(`from_lend`, `to_lend`, book_id_book_lend, user_id_book_lend, library_id_book_lend)
VALUES('2022-10-10', '2022-11-11', 3, 3, 3);
