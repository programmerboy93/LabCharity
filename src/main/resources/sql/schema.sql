DROP TABLE IF EXISTS donations_categories;
DROP TABLE IF EXISTS donations;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS institutions;

create table `charity-donation-test`.categories
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

create table `charity-donation-test`.institutions
(
    id          bigint auto_increment
        primary key,
    description varchar(500) null,
    name        varchar(40)  null
)
    engine = MyISAM;

create table `charity-donation-test`.donations
(
    id              bigint auto_increment
        primary key,
    city            varchar(255) null,
    pick_up_comment varchar(255) null,
    pick_up_date    date         not null,
    pick_up_time    time         not null,
    quantity        int          not null,
    street          varchar(255) null,
    zip_code        varchar(6)   null,
    institution_id  bigint       null
)
    engine = MyISAM;

create index FK4vbbe785haqnjerv22xjehvbg
    on `charity-donation-test`.donations (institution_id);

create table `charity-donation-test`.donations_categories
(
    donation_id   bigint not null,
    categories_id bigint not null
)
    engine = MyISAM;

create index FK8vte7y1uahh9hvijwuyp0teci
    on `charity-donation-test`.donations_categories (donation_id);

create index FK9m7exjei7ijgrumug4ds90n6n
    on `charity-donation-test`.donations_categories (categories_id);




