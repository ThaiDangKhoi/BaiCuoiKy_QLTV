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
("Nhi???u T??c Gi???","...","1928/12/12"),
("Th?? Nghi","Vi???t Nam","1985/12/12"),
("Cao Minh","Trung Qu???c","1974/12/12"),
("Dale Carnegie","Hoa K???","1888/11/24"),
("T Harv Eker","toronto","1954/6/10"),
("Michael Goodwin","Hoa K???","1939/4/28"),
("?????ng Thu??? Tr??m","Vi???t Nam","1942/11/26"),
("Huy???n Tho???i Marvel - Stan Lee","Hoa K???","1968/8/29");
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
("Nh?? Gi??? Kim", 1, 1, "2020/12/12", "NXB H???i Nh?? V??n", "nha__.png"),
("C?? M???t Ng??y,B??? M??? S??? Gi?? ??i",2,2,"2020/12/12","	NXB Th??? Gi???i", "co__.png"),
("T???NG C?? M???t Ng?????i, Y??u T??i Nh?? Sinh M???nh",3,3,"2020/12/12","NXB V??n H???c", "tung__.png"),
("Thi??n T??i B??n Tr??i, K??? ??i??n B??n Ph???i",4,4,"2021/12/12","NXB Th??? Gi???i", "thien__.png"),
("?????c Nh??n T??m",5,5,"2021/12/12","NXB T???ng H???p TPHCM", "dac__.png"),
("B?? M???t T?? Duy Tri???u Ph??",6,6,"2000/12/12","NXB T???ng H???p TPHCM", "bi__.png"),
("Economix - C??c N???n Kinh T??? V???n H??nh",7,7,"2002/12/12","NXB D??n Tr??", "econmix__.png"),
("Nh???t K?? ?????ng Th??y Tr??m",8,8,"2018/12/12","NXB H???i Nh?? V??n", "nhat__.png"),
("Huy???n Tho???i Marvel - Stan Lee",9,9,"2018/12/12","NXB V??n H???c", "huyen__.png"),
("Huy???n Tho???i Marvel - Stan Lee",1,1,"2018/12/12","NXB V??n H???c", "huyen__.png");
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

