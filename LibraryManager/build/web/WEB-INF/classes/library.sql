drop database if EXISTS book;

CREATE DATABASE book;

use book;

-- Admin

create table tb_adminAccount(
    email   varchar(256) PRIMARY KEY,
    password    varchar(256)    
);

insert into tb_adminAccount value ("admin@gmail.com", "admin");

create table tb_adminInfo(
    email   varchar(256) PRIMARY KEY,
    fullName    varchar(256),
    birthday    date,
    address     varchar(256),
    phone       varchar(10),
    CONSTRAINT foreign key (email) REFERENCES tb_adminAccount(email)
);

insert into tb_adminInfo values ("admin@gmail.com", "Thai Dang Khoi", 
"2002/04/23", "Da Nang", "0947700783");

-- / Admin

-- User
create table tb_userAccount(
    email   varchar(256) PRIMARY KEY,
    password    varchar(256)    
);

insert into tb_userAccount values ("khoi@gmail.com", "12345"),
("sy@gmail.com", "12345"),
("nam@gmail.com", "12345"),
("abc@gmail.com", "12345"),
("xyz@gmail.com", "12345");


create table tb_userInfo(
    email   varchar(256) PRIMARY KEY,
    fullName    varchar(256),
    birthday    date,
    address     varchar(256),
    phone       varchar(10),
    CONSTRAINT foreign key (email) REFERENCES tb_userAccount(email)
);

insert into tb_userInfo values 
("khoi@gmail.com", "Thai Dang Khoi", "2002/04/23", "Da Nang", "0947700783"),
("sy@gmail.com", "Nguyen Trung Sy", "2002/04/23", "Da Nang", "0947700783"),
("nam@gmail.com", "Ho Hoang Nam", "2002/04/23", "Da Nang", "0947700783"),
("abc@gmail.com", "ABC", "2002/04/23", "Da Nang", "0947700783"),
("xyz@gmail.com", "XYZ", "2002/04/23", "Da Nang", "0947700783");
-- /User

-- Book category
create table tb_bookCategory(

    bookCategoryId      int auto_increment primary key,
    bookCategoryName    varchar(256)
);

insert into tb_bookCategory(bookCategoryName) values
("Tieu thuyet"),
("Truyen ngan"),
("Ngon tinh"),
("Tam ly"),
("Ren luyen nhan cach"),
("Quan tri-lanh dao"),
("Phan tich kinh te"),
("Chinh tri"),
("Nghe thuat-giai tri");
-- /Book category

-- Author
create table tb_author(
    authorId        int auto_increment primary key,
    authorName      varchar(256),
    authorAddress   varchar(256),
    birthday        date
);

insert into tb_author(authorName, authorAddress, birthday) values
("Paulo Coelho", "Rio de Janeiro", "1947/08/24"),
("Nhiều Tác Giả","...","1928/12/12"),
("Thư Nghi","Việt Nam","1985/12/12"),
("Cao Minh","Trung Quốc","1974/12/12"),
("Dale Carnegie","Hoa Kỳ","1888/11/24"),
("T Harv Eker","toronto","1954/6/10"),
("Michael Goodwin","Hoa Kỳ","1939/4/28"),
("Đặng Thuỳ Trâm","Việt Nam","1942/11/26"),
("Huyền Thoại Marvel - Stan Lee","Hoa Kỳ","1968/8/29");
-- /Author


-- Book
create table tb_book(

    bookId      int auto_increment primary key,
    bookName    varchar(256),
    authorId    int,
    bookCategoryId  int,
    nxb         date,
    description varchar(256),
    imageSrc    varchar(256),
    CONSTRAINT FOREIGN KEY (authorId) REFERENCES tb_author(authorId),

    CONSTRAINT FOREIGN KEY (bookCategoryId) REFERENCES tb_bookCategory(bookCategoryId)
);

insert into tb_book(bookName, authorId, bookCategoryId, nxb, description, imageSrc) values
("Nhà Giả Kim", 1, 1, "2020/12/12", "NXB Hội Nhà Văn", "nha__.png"),
("Có Một Ngày,Bố Mẹ Sẽ Già Đi",2,2,"2020/12/12","	NXB Thế Giới", "co__.png"),
("TỪNG Có Một Người, Yêu Tôi Như Sinh Mệnh",3,3,"2020/12/12","NXB Văn Học", "tung__.png"),
("Thiên Tài Bên Trái, Kẻ Điên Bên Phải",4,4,"2021/12/12","NXB Thế Giới", "thien__.png"),
("Đắc Nhân Tâm",5,5,"2021/12/12","NXB Tổng Hợp TPHCM", "dac__.png"),
("Bí Mật Tư Duy Triệu Phú",6,6,"2000/12/12","NXB Tổng Hợp TPHCM", "bi__.png"),
("Economix - Các Nền Kinh Tế Vận Hành",7,7,"2002/12/12","NXB Dân Trí", "econmix__.png"),
("Nhật Ký Đặng Thùy Trâm",8,8,"2018/12/12","NXB Hội Nhà Văn", "nhat__.png"),
("Huyền Thoại Marvel - Stan Lee",9,9,"2018/12/12","NXB Văn Học", "huyen__.png"),
("Huyền Thoại Marvel - Stan Lee",1,1,"2018/12/12","NXB Văn Học", "huyen__.png");
-- /Book

-- borrow request
create table tb_borrow_request(
    email   varchar(256),
    bookId      int,
    borrowDay   date,
    state       bit default(0),
    CONSTRAINT FOREIGN KEY (email) REFERENCES tb_userAccount(email),
    CONSTRAINT FOREIGN KEY (bookId) REFERENCES tb_book(bookId),
    CONSTRAINT primary key (email, bookId)
);

-- book borrow
create table tb_borrow_book(
    email   varchar(256),
    bookId      int,
    borrowDay   date,
    CONSTRAINT FOREIGN KEY (email) REFERENCES tb_userAccount(email),
    CONSTRAINT FOREIGN KEY (bookId) REFERENCES tb_book(bookId),
    CONSTRAINT primary key (email, bookId)
);

-- Category (Danh muc)
create table tb_category(
    categoryId      int AUTO_INCREMENT PRIMARY KEY,
    categoryName    varchar(256)
);

insert into tb_category(categoryName) values
("Book"),
("Author"),
("Book Category"),
("User"),
("Tunover");
-- /Category

