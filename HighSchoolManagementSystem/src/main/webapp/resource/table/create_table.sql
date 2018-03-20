/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/25 10:10:25                           */
/*==============================================================*/


drop table if exists anthorty_info;

drop table if exists attendance_info;

drop table if exists audition_info;

drop table if exists class_info;

drop table if exists class_transaction_info;

drop table if exists classroom_info;

drop table if exists communication_info;

drop table if exists data_dictionary;

drop table if exists discipline_info;

drop table if exists email_info;

drop table if exists evaluation_info;

drop table if exists market_active;

drop table if exists message_info;

drop table if exists role_anthorty_info;

drop table if exists role_info;

drop table if exists staff_info;

drop table if exists staff_salary;

drop table if exists student_info;

drop table if exists student_payment;

drop table if exists student_write_grade;

drop table if exists syllabus_info;

drop table if exists template_info;

drop table if exists track_record_info;

/*==============================================================*/
/* Table: anthorty_info                                         */
/*==============================================================*/
create table anthorty_info
(
   anthorty_id          int not null auto_increment,
   anthorty_pid         int,
   anthorty_nane        varchar(100),
   anthorty_desc        varchar(1000),
   anthorty_url         varchar(1000),
   primary key (anthorty_id)
);

/*==============================================================*/
/* Table: attendance_info                                       */
/*==============================================================*/
create table attendance_info
(
   attendance_id        int not null auto_increment,
   student_id           int,
   attendance_desc      varchar(100),
   attendance_state     varchar(10),
   attendance_time      datetime,
   attendance_remark    varchar(2000),
   primary key (attendance_id)
);

/*==============================================================*/
/* Table: audition_info                                         */
/*==============================================================*/
create table audition_info
(
   audition_id          int not null auto_increment,
   student_id           int,
   audition_time        datetime,
   audition_addr        varchar(300),
   audition_course      varchar(100),
   audition_desc        varchar(2000),
   primary key (audition_id)
);

/*==============================================================*/
/* Table: class_info                                            */
/*==============================================================*/
create table class_info
(
   class_id             int not null auto_increment,
   discipline_id        int,
   syllabus_id          int,
   classroom_id         int,
   staff_id             int,
   class_name           varchar(100),
   class_number         int,
   class_start_time     datetime,
   class_end_time       datetime,
   class_isused         varchar(10),
   class_state          varchar(10),
   class_desc           varchar(2000),
   primary key (class_id)
);

/*==============================================================*/
/* Table: class_transaction_info                                */
/*==============================================================*/
create table class_transaction_info
(
   class_transaction_id int not null auto_increment,
   class_id             int,
   class_transaction_tile varchar(100),
   class_transaction_content varchar(2000),
   class_transaction_person varchar(100),
   class_transaction_time datetime,
   class_transaction_remar varchar(2000),
   primary key (class_transaction_id)
);

/*==============================================================*/
/* Table: classroom_info                                        */
/*==============================================================*/
create table classroom_info
(
   classroom_id         int not null auto_increment,
   classroom_name       varchar(100),
   classroom_max        int,
   classroom_info       varchar(1000),
   classroom_remark     varchar(2000),
   classroom_mark       varchar(10),
   primary key (classroom_id)
);

/*==============================================================*/
/* Table: communication_info                                    */
/*==============================================================*/
create table communication_info
(
   communication_id     int not null auto_increment,
   student_id           int,
   staff_id             int,
   communication_time   datetime,
   communication_content varchar(2000),
   primary key (communication_id)
);

/*==============================================================*/
/* Table: data_dictionary                                       */
/*==============================================================*/
create table data_dictionary
(
   data_id              int not null auto_increment,
   data_content         varchar(100),
   data_type            varchar(100),
   data_desc            varchar(2000),
   primary key (data_id)
);

/*==============================================================*/
/* Table: discipline_info                                       */
/*==============================================================*/
create table discipline_info
(
   discipline_id        int not null auto_increment,
   discipline_name      varchar(100),
   discipline_tuition   int,
   discipline_bring     int,
   discipline_desc      varchar(2000),
   discipline_isused    varchar(10),
   primary key (discipline_id)
);

/*==============================================================*/
/* Table: email_info                                            */
/*==============================================================*/
create table email_info
(
   email_id             int not null auto_increment,
   staff_id             int,
   email_title          varchar(1000),
   email_content        varchar(2000),
   email_time           datetime,
   email_man            varchar(100),
   email_addr           varchar(300),
   email_state          varchar(10),
   primary key (email_id)
);

/*==============================================================*/
/* Table: evaluation_info                                       */
/*==============================================================*/
create table evaluation_info
(
   evaluation_id        int not null auto_increment,
   student_id           int,
   evaluation_tile      varchar(100),
   evaluation_content   varchar(2000),
   evaluation_course    varchar(100),
   evaluation_teacher   varchar(100),
   evaluation_time      datetime,
   primary key (evaluation_id)
);

/*==============================================================*/
/* Table: market_active                                         */
/*==============================================================*/
create table market_active
(
   active_id            int not null auto_increment,
   staff_id             int,
   active_name          varchar(300),
   active_state         int,
   active_start         datetime,
   active_end           datetime,
   active_type          int,
   active_coste_estimate double,
   active_coste         double,
   active_refect_estimate int,
   active_student       varchar(300),
   active_content       varchar(2000),
   primary key (active_id)
);

/*==============================================================*/
/* Table: message_info                                          */
/*==============================================================*/
create table message_info
(
   message_id1          int not null auto_increment,
   staff_id             int,
   message_content      varchar(1000),
   message_man          varchar(10),
   message_phone        varchar(15),
   message_time         datetime,
   message_state        varchar(10),
   primary key (message_id1)
);

/*==============================================================*/
/* Table: role_anthorty_info                                    */
/*==============================================================*/
create table role_anthorty_info
(
   role_anthorty_id     int not null auto_increment,
   role_id              int,
   anthorty_id          int,
   primary key (role_anthorty_id)
);

/*==============================================================*/
/* Table: role_info                                             */
/*==============================================================*/
create table role_info
(
   role_id              int not null auto_increment,
   role_name            varchar(100),
   role_desc            varchar(1000),
   role_state           varchar(10),
   primary key (role_id)
);

/*==============================================================*/
/* Table: staff_info                                            */
/*==============================================================*/
create table staff_info
(
   staff_id             int not null auto_increment,
   role_id              int,
   staff_name           varchar(100),
   staff_sex            varchar(10),
   staff_age            int(10),
   staff_native_place   varchar(100),
   staff_idcard         varchar(100),
   staff_birthday       datetime,
   staff_office_phone   varchar(50),
   staff_mobile_phone   varchar(50),
   staff_email          varchar(100),
   staff_addr           varchar(200),
   staff_qq             varchar(30),
   staff_entry_time     datetime,
   staff_education_level varchar(20),
   staff_remark         varchar(2000),
   staff_state          varchar(10) comment '1有效
            0无效',
   staff_number         varchar(100),
   staff_password       varchar(100),
   primary key (staff_id)
);

/*==============================================================*/
/* Table: staff_salary                                          */
/*==============================================================*/
create table staff_salary
(
   staff_salary_id      int not null auto_increment,
   staff_id             int,
   sta_staff_id         int,
   staff_salary_total   double,
   staff_salary_deduct  double,
   staff_salary_real    double,
   staff_salary_isused  varchar(10),
   staff_salary_time    datetime,
   remark               varchar(2000),
   primary key (staff_salary_id)
);

/*==============================================================*/
/* Table: student_info                                          */
/*==============================================================*/
create table student_info
(
   student_id           int not null auto_increment,
   staff_id             int,
   class_id             int,
   student_name         varchar(100),
   student_sex          varchar(10),
   student_age          int,
   student_tellphone    varchar(100),
   student_email        varchar(200),
   student_idcard       varchar(30),
   student_address      varchar(300),
   student_birthday     datetime,
   student_school       varchar(100),
   student_qq           varchar(30),
   student_parents_name varchar(100),
   student_parents_phone varchar(100),
   student_pro          varchar(100),
   student_pro_city     varchar(100),
   student_type         varchar(100),
   student_ispay        varchar(10),
   student_state        int,
   student_mark         varchar(10),
   student_desc         varchar(2000),
   student_number       varchar(100),
   student_password     varchar(100),
   primary key (student_id)
);

/*==============================================================*/
/* Table: student_payment                                       */
/*==============================================================*/
create table student_payment
(
   payment_id           int not null auto_increment,
   student_id           int,
   staff_id             int,
   payment_situtation   varchar(1000),
   payment_menthod      int,
   payment_time         datetime,
   payment_discount_amount double,
   payment_should_amount double,
   payment_real_amount  double,
   payment_debt_amount  double,
   payment_remark       varchar(2000),
   primary key (payment_id)
);

/*==============================================================*/
/* Table: student_write_grade                                   */
/*==============================================================*/
create table student_write_grade
(
   write_grade_id       int not null auto_increment,
   student_id           int,
   staff_id             int,
   write_grade_subject  varchar(1000),
   write_grade          varchar(50),
   write_grade_time     datetime,
   write_grade_note     varchar(2000),
   primary key (write_grade_id)
);

/*==============================================================*/
/* Table: syllabus_info                                         */
/*==============================================================*/
create table syllabus_info
(
   syllabus_id          int not null auto_increment,
   syllabus_yi          varchar(50),
   syllabus_er          varchar(50),
   syllabus_san         varchar(50),
   syllabus_si          varchar(50),
   syllabus_wu          varchar(50),
   syllabus_liu         varchar(50),
   syllabus_qi          varchar(50),
   syllabus_isused      varchar(50),
   syllabus_name        varchar(100),
   primary key (syllabus_id)
);

/*==============================================================*/
/* Table: template_info                                         */
/*==============================================================*/
create table template_info
(
   template_id          int not null auto_increment,
   template_title       varchar(200),
   template_content     varchar(2000),
   template_type        varchar(20),
   primary key (template_id)
);

/*==============================================================*/
/* Table: track_record_info                                     */
/*==============================================================*/
create table track_record_info
(
   track_record_id      int not null auto_increment,
   student_id           int,
   track_record_title   varchar(200),
   track_record_content varchar(2000),
   track_record_time    datetime,
   enrollment           int,
   next_record_time     datetime,
   primary key (track_record_id)
);

alter table anthorty_info add constraint FK_Reference_2 foreign key (anthorty_pid)
      references anthorty_info (anthorty_id) on delete restrict on update restrict;

alter table attendance_info add constraint FK_Reference_22 foreign key (student_id)
      references student_info (student_id) on delete restrict on update restrict;

alter table audition_info add constraint FK_Reference_10 foreign key (student_id)
      references student_info (student_id) on delete restrict on update restrict;

alter table class_info add constraint FK_Reference_17 foreign key (discipline_id)
      references discipline_info (discipline_id) on delete restrict on update restrict;

alter table class_info add constraint FK_Reference_18 foreign key (syllabus_id)
      references syllabus_info (syllabus_id) on delete restrict on update restrict;

alter table class_info add constraint FK_Reference_19 foreign key (classroom_id)
      references classroom_info (classroom_id) on delete restrict on update restrict;

alter table class_info add constraint FK_Reference_20 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table class_transaction_info add constraint FK_Reference_21 foreign key (class_id)
      references class_info (class_id) on delete restrict on update restrict;

alter table communication_info add constraint FK_Reference_12 foreign key (student_id)
      references student_info (student_id) on delete restrict on update restrict;

alter table communication_info add constraint FK_Reference_13 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table email_info add constraint FK_Reference_7 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table evaluation_info add constraint FK_Reference_11 foreign key (student_id)
      references student_info (student_id) on delete restrict on update restrict;

alter table market_active add constraint FK_Reference_5 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table message_info add constraint FK_Reference_6 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table role_anthorty_info add constraint FK_Reference_3 foreign key (role_id)
      references role_info (role_id) on delete restrict on update restrict;

alter table role_anthorty_info add constraint FK_Reference_4 foreign key (anthorty_id)
      references anthorty_info (anthorty_id) on delete restrict on update restrict;

alter table staff_info add constraint FK_Reference_1 foreign key (role_id)
      references role_info (role_id) on delete restrict on update restrict;

alter table staff_salary add constraint FK_Reference_25 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table staff_salary add constraint FK_Reference_26 foreign key (sta_staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table student_info add constraint FK_Reference_16 foreign key (class_id)
      references class_info (class_id) on delete restrict on update restrict;

alter table student_info add constraint FK_Reference_8 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table student_payment add constraint FK_Reference_23 foreign key (student_id)
      references student_info (student_id) on delete restrict on update restrict;

alter table student_payment add constraint FK_Reference_24 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table student_write_grade add constraint FK_Reference_14 foreign key (student_id)
      references student_info (student_id) on delete restrict on update restrict;

alter table student_write_grade add constraint FK_Reference_15 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table track_record_info add constraint FK_Reference_9 foreign key (student_id)
      references student_info (student_id) on delete restrict on update restrict;

