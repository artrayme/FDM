-- create table factory
-- (
--     id   bigserial not null,
--     name varchar(255),
--     primary key (id)
-- );
-- 
-- 
-- create table input_report
-- (
--     id           bigserial not null,
--     date         date      not null,
--     worker_fio   varchar(255),
--     worker_post  varchar(255),
--     warehouse_id int8      not null,
--     primary key (id)
-- );
-- 
-- 
-- create table inventory_unit
-- (
--     id               int8 not null,
--     count            int8 check (count >= 1),
--     type             varchar(255),
--     input_report_id  int8,
--     output_report_id int8,
--     primary key (id)
-- );
-- 
-- 
-- create table output_report
-- (
--     id           bigserial not null,
--     date         date      not null,
--     worker_fio   varchar(255),
--     worker_post  varchar(255),
--     warehouse_id int8      not null,
--     primary key (id)
-- );
-- 
-- 
-- create table warehouse
-- (
--     id         int8 not null,
--     name       varchar(255),
--     telephone  varchar(255),
--     factory_id int8 not null,
--     primary key (id)
-- );
-- 
-- 
-- alter table factory
--     add constraint FACTORY_NAME_CONSTRAIN unique (name);
-- 
-- 
-- alter table factory
--     drop constraint FACTORY_NAME_CONSTRAIN;
-- 
-- alter table warehouse
--     add constraint WAREHOUSE_NAME_CONSTRAIN unique (name);
-- 
-- alter table warehouse
--     drop constraint WAREHOUSE_NAME_CONSTRAIN;
-- 
-- alter table input_report
--     add constraint FK_INPUT_REPORT_TO_WAREHOUSE
--         foreign key (warehouse_id)
--             references warehouse;
-- 
-- 
-- alter table inventory_unit
--     add constraint FK_INVENTORY_TO_INPUT_REPORT
--         foreign key (input_report_id)
--             references input_report;
-- 
-- 
-- alter table inventory_unit
--     add constraint FK_INVENTORY_TO_OUTPUT_REPORT
--         foreign key (output_report_id)
--             references output_report;
-- 
-- 
-- alter table output_report
--     add constraint FK_OUTPUT_REPORT_TO_WAREHOUSE
--         foreign key (warehouse_id)
--             references warehouse;
-- 
-- 
-- alter table warehouse
--     add constraint FK_WAREHOUSE_TO_FACTORY
--         foreign key (factory_id)
--             references factory;


create table factory
(
    id   bigserial not null,
    name varchar(255),
    primary key (id)
);


create table input_report
(
    id           bigserial not null,
    date         date      not null,
    worker_fio   varchar(255),
    worker_post  varchar(255),
    warehouse_id int8      not null,
    primary key (id)
);


create table inventory_unit
(
    id               int8 not null,
    count            int8 check (count >= 1),
    type             varchar(255),
    input_report_id  int8,
    output_report_id int8,
    primary key (id)
);


create table output_report
(
    id           bigserial not null,
    date         date      not null,
    worker_fio   varchar(255),
    worker_post  varchar(255),
    warehouse_id int8      not null,
    primary key (id)
);


create table warehouse
(
    id         int8 not null,
    name       varchar(255),
    telephone  varchar(255),
    factory_id int8 not null,
    primary key (id)
);


alter table factory
    add constraint FACTORY_NAME_CONSTRAIN unique (name);

alter table factory
    drop constraint FACTORY_NAME_CONSTRAIN;

alter table warehouse
    add constraint WAREHOUSE_NAME_CONSTRAIN unique (name);
create sequence hibernate_sequence start 1 increment 1;

alter table warehouse
    drop constraint WAREHOUSE_NAME_CONSTRAIN;

alter table input_report
    add constraint FK_INPUT_REPORT_TO_WAREHOUSE
        foreign key (warehouse_id)
            references warehouse;


alter table inventory_unit
    add constraint FK_INVENTORY_TO_INPUT_REPORT
        foreign key (input_report_id)
            references input_report;


alter table inventory_unit
    add constraint FK_INVENTORY_TO_OUTPUT_REPORT
        foreign key (output_report_id)
            references output_report;


alter table output_report
    add constraint FK_OUTPUT_REPORT_TO_WAREHOUSE
        foreign key (warehouse_id)
            references warehouse;


alter table warehouse
    add constraint FK_WAREHOUSE_TO_FACTORY
        foreign key (factory_id)
            references factory;