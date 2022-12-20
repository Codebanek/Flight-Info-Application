


insert into roles (id, name) values
(null, 'ROLE_USER'),
(null, 'ROLE_ADMIN');


insert into users(id, email, username, enabled, first_name, last_name, password) values
(null, 'user1@flightinfo.pl', 'user1', 1, 'exampleName1', 'exampleLastName1', '$2a$10$qtrkwmPM0xv6mRS5KHpiZu74/R3bzr2/W0puXWPt5.ClqsEHx6O72'),
(null, 'user2@flightinfo.pl', 'user2', 1, 'exampleName2', 'exampleLastName2', '$2a$10$PMamj0cWTsZx61dAvLY5QeN0KGbM6/34jrgaOgvO5BQ2R34QWBO5a'),
(null, 'admin@admin.pl', 'admin', 1, 'adminFirstName', 'adminLastName', '$2a$10$z.WUQKAwUr74ncS1OFwxk.fdwQZNB6jYm7IwnBeW9IK4JAwBpyfPa');

insert into user_role(user_id, role_id) values
(1,1), (2,1), (3,2);

insert into planes(id, type) values
(null, 'Cessna 152'),
(null, 'Diamond DA20'),
(null, 'Piper PA28'),
(null, 'Tecnam P2008');

insert into airports(id,icao_code,lattitude,longitude) values
(null, 'EPPI', 53.1, 16.42),
(null, 'EPDE', 51.33, 21.53),
(null, 'EPPO', 52.25, 16.49),
(null, 'EPWA', 52.09, 20.58);

insert into flight_details(id,arrival_code,departure_code,distance,flight_time,speed,type,user_id)
values
(null, 'EPPI', 'EPPO', 95, 31, 100, 'Diamond DA20', 1),
(null, 'EPDE', 'EPWA', 107, 35, 100, 'Cessna 152', 1),
(null, 'EPPI', 'EPPO', 95, 31, 100, 'Diamond DA20', 2),
(null, 'EPDE', 'EPWA', 107, 35, 100, 'Cessna 152', 2);
