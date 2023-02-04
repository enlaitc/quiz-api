create table tb_quiz(
id_quiz SERIAL primary key not null,
des_name VARCHAR(100) not null,
dat_creation DATE not null
);

create table tb_quiz_review(
id_review SERIAL primary key not null,
id_quiz INTEGER not null,
des_user VARCHAR(100),
int_score INTEGER default 0,
des_difficult VARCHAR(20) not null,
time_duration TIME,
int_question INTEGER not null,
dat_creation TIMESTAMP not null,
dat_end TIMESTAMP,

foreign key(id_quiz)
references tb_quiz (id_quiz)
);


create table tb_quiz_category(
id_category SERIAL primary key not null,
des_name VARCHAR(20) not NULL
);


create table tb_quiz_question(
id_question SERIAL primary key not null,
id_quiz INTEGER not null,
des_question VARCHAR(255) not null,
des_question_type VARCHAR(20) not null,
des_question_difficult VARCHAR(20) not null,
dat_creation DATE not null,
dat_update DATE,

foreign key(id_quiz)
references tb_quiz (id_quiz);

create table tb_quiz_answer(
id_answer SERIAL primary key not null,
id_question INTEGER not null,
des_answer VARCHAR(255) not null,
boo_status BOOLEAN not null,

foreign key(id_question)
references tb_quiz_question(id_question)
);

CREATE TABLE ta_question_category(
question_id INTEGER NOT NULL,
category_id INTEGER NOT NULL,

PRIMARY KEY (question_id, category_id),
FOREIGN KEY (question_id) REFERENCES tb_quiz_question (id_question),
foreign key (category_id) references tb_quiz_category (id_category));

create table ta_review_category(
review_id INTEGER not null,
category_id INTEGER not NULL,

primary key (review_id, category_id),
foreign key (review_id) references tb_quiz_review (id_review),
foreign key (category_id) references tb_quiz_category (id_category));