# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table accessory (
  id                        bigint auto_increment not null,
  tent_id                   bigint,
  item_id                   bigint,
  amount                    decimal(9,2),
  constraint pk_accessory primary key (id))
;

create table entry (
  id                        bigint auto_increment not null,
  event_id                  varchar(255),
  event_type                integer,
  item_id                   bigint,
  amount                    decimal(9,2),
  constraint ck_entry_event_type check (event_type in (0,1,2,3)),
  constraint pk_entry primary key (id))
;

create table installation (
  installation_id           varchar(255) not null,
  action_id                 varchar(255),
  constraint pk_installation primary key (installation_id))
;

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

alter table accessory add constraint fk_accessory_tent_1 foreign key (tent_id) references item (id) on delete restrict on update restrict;
create index ix_accessory_tent_1 on accessory (tent_id);
alter table accessory add constraint fk_accessory_item_2 foreign key (item_id) references item (id) on delete restrict on update restrict;
create index ix_accessory_item_2 on accessory (item_id);
alter table entry add constraint fk_entry_item_3 foreign key (item_id) references item (id) on delete restrict on update restrict;
create index ix_entry_item_3 on entry (item_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table accessory;

drop table entry;

drop table installation;

drop table item;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

