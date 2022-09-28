drop table if exists pumper cascade;
drop table if exists excuse cascade;
drop table if exists writes cascade;
drop table if exists respons_to cascade;

create table if not exists pumper (
	id text not null primary key,
	name text not null,
	attendance_count int not null,
	attendance_this_week int not null,
	attendance_next_week int not null,
	days_of_punishment int not null
);

create table if not exists excuse (
	id int not null primary key,
	excuse_date date not null,
	excuse_text text not null,
	image text
);

create table if not exists writes (
	id_excuse int not null,
	id_pumper text not null,
	constraint fk_excuse
		foreign key(id_excuse)
		references excuse(id),
	constraint fk_pumper
		foreign key(id_pumper)
		references pumper(id)

);

create table if not exists responds_to (
	id_excuse int not null,
	id_pumper text not null,
	answer text,
	accepted bool,
	constraint fk_excuse
		foreign key(id_excuse)
		references excuse(id),
	constraint fk_pumper
		foreign key(id_pumper)
		references pumper(id)

);