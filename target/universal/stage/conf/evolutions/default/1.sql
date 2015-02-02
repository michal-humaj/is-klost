# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table item (
  ITEM_TYPE                 varchar(31) not null,
  id                        bigint auto_increment not null,
  name                      varchar(255),
  category                  integer,
  amount                    decimal(9,2),
  weight                    decimal(9,2),
  constraint ck_item_category check (category in (0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)),
  constraint pk_item primary key (id))
;

create table user (
  id                        varchar(255) not null,
  refresh_token             varchar(255),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table item;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

