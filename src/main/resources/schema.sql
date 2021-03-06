DROP TABLE product IF EXISTS;

create table product (
                         id bigint generated by default as identity,
                         created_at timestamp,
                         modified_at timestamp,
                         name varchar(255) not null,
                         price integer not null,
                         stock_quantity integer not null,
                         primary key (id)
);