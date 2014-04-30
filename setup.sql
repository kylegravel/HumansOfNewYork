create table people (
    person_id int,
    gender varchar(10),
    image_file varchar(50),
    primary key (person_id)
);

create table age (
    person_id int,
    age_range varchar(40),
    foreign key (person_id) references people (person_id)
);

create table emotion (
    person_id int,
    short_desc varchar(10),
    foreign key (person_id) references people (person_id)
);

insert into people (person_id, gender, image_file) values
(1, 'Male', '1.jpg'),
(2, 'Male', '2.jpg'),
(3, 'Female', '3.jpg'),
(4, 'Female', '4.jpg'),
(5, 'Male', '5.jpg'),
(6, 'Female', '6.jpg'),
(7, 'Male', '7.jpg'),
(8, 'Female', '8.jpg'),
(9, 'Ambiguous', '9.jpg'),
(10, 'Male', '10.jpg'),
(11, 'Female', '11.jpg'),
(12, 'Female', '12.jpg'),
(13, 'Male', '13.jpg'),
(14, 'Male', '14.jpg'),
(15, 'Female', '15.jpg');

insert into age (person_id, age_range) values
(1, '31-40'),
(2, '31-40'),
(3, '21-30'),
(4, '70+'),
(5, '11-20'),
(6, '31-40'),
(7, '51-60'),
(8, '0-10'),
(9, '21-30'),
(10,'70+'),
(11, '0-10'),
(12, '70+'),
(13, '31-40'),
(14, '41-50'),
(15, '61-70');

insert into emotion (person_id, short_desc) values
(1, 'Angry'),
(2, 'Sad'),
(3, 'Happy'),
(4, 'Happy'),
(5, 'Happy'),
(6, 'Sad'),
(7, 'Angry'),
(8, 'Ambiguous'),
(9, 'Angry'),
(10,'Ambiguous'),
(11, 'Happy'),
(12, 'Sad'),
(13, 'Happy'),
(14, 'Sad'),
(15, 'Happy');
