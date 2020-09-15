DROP TABLE IF EXISTS public.users;
CREATE TABLE public.users
(
    id           serial PRIMARY KEY,
    created_at   date,
    updated_at   date,
    email        varchar(255),
    password     varchar(255),
    type_of_user integer,
    name_of_user varchar(255)
);

DROP TABLE IF EXISTS public.hotel;
CREATE TABLE public.hotel
(
    id            serial PRIMARY KEY,
    created_at    date,
    updated_at    date,
    email_address varchar(255),
    password      varchar(255),
    manager_id    varchar(255),
    users_id      bigint,
    balance       double precision
);

DROP TABLE IF EXISTS public.transaction;
CREATE TABLE public.transaction
(
    id                  serial PRIMARY KEY,
    created_at          date,
    updated_at          date,
    hotel_id            bigint,
    type_of_transaction integer,
    amount              double precision
);

DROP TABLE IF EXISTS public.collector_transaction;
CREATE TABLE public.collector_transaction
(
    id         serial PRIMARY KEY,
    created_at date,
    updated_at date,
    hotel_id   bigint,
    users_id   bigint,
    amount     double precision,
    approved   boolean
);

DROP TABLE IF EXISTS public.mapping;
CREATE TABLE public.mapping
(
    id           serial PRIMARY KEY,
    created_at   date,
    updated_at   date,
    collector_id bigint,
    approver_id  bigint
);