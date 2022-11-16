use cats;
CREATE TABLE University (
	id int auto_increment primary key not null,
    `name` varchar(50) not null,
    details varchar(200) not null,
    date_added varchar(20) not null
)