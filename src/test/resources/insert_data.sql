insert into institutions(name,description) values('Dbam o Zdrowie','Pomoc dzieciom z ubogich rodzin');
insert into institutions(name,description) values('A kogo','Pomoc wybudzaniu dzieci ze śpiączki');
insert into institutions(name,description) values('Dla dzieci','Pomoc osobom znajdującym się w trudnej sytuacji życiowej');
insert into institutions(name,description) values('Bez domu','Pomoc dla osób nie posiadających miejsca zamieszkania');

insert into categories(name) values ('ubrania, które nadają się do ponownego użycia');
insert into categories(name) values ('ubrania, do wyrzucenia');
insert into categories(name) values ('zabawki');
insert into categories(name) values ('książki');
insert into categories(name) values ('inne');

insert into donations(city,street,zip_code,pick_up_comment,pick_up_date,pick_up_time,quantity,institution_id) values ('Gniezno','Mała','62-250',null,'2021-10-02','12:00',5,1);
insert into donations(city,street,zip_code,pick_up_comment,pick_up_date,pick_up_time,quantity,institution_id) values ('Września','Średnia','62-300',null,'2021-10-04','10:00',1,2);
insert into donations(city,street,zip_code,pick_up_comment,pick_up_date,pick_up_time,quantity,institution_id) values ('Poznań','Czarno Ciemna','62-001',null,'2021-10-02','9:00',2,3);
insert into donations(city,street,zip_code,pick_up_comment,pick_up_date,pick_up_time,quantity,institution_id) values ('Gniezno','Wielka','62-250','coś tam','2021-10-02','21:00',4,3);

insert into donations_categories(donation_id, categories_id) values (1,1);
insert into donations_categories(donation_id, categories_id) values (1,2);
insert into donations_categories(donation_id, categories_id) values (1,3);

insert into donations_categories(donation_id, categories_id) values (2,1);
insert into donations_categories(donation_id, categories_id) values (2,3);
insert into donations_categories(donation_id, categories_id) values (2,5);

insert into donations_categories(donation_id, categories_id) values (3,1);
insert into donations_categories(donation_id, categories_id) values (3,4);
insert into donations_categories(donation_id, categories_id) values (3,5);

insert into donations_categories(donation_id, categories_id) values (4,1);
insert into donations_categories(donation_id, categories_id) values (4,3);
insert into donations_categories(donation_id, categories_id) values (4,5);

insert into roles(id,name) values (1,'ROLE_USER');
insert into roles(id,name) values (2,'ROLE_ADMIN');