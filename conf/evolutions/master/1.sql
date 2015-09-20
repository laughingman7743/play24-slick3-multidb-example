/*
SQL code is taken from the Java SE tutorial and licensed under
http://www.oracle.com/technetwork/licenses/bsd-license-1835287.html .
*/
# --- !Ups
create table companies ("id" INTEGER NOT NULL,"name" VARCHAR NOT NULL);

insert into companies values (1,'apple inc.');
insert into companies values (2,'thinking machines');
insert into companies values (3,'rca');
insert into companies values (4,'netronics');
insert into companies values (5,'tandy corporation');
insert into companies values (6,'commodore international');
insert into companies values (7,'mos technology');
insert into companies values (8,'micro instrumentation and telemetry systems');
insert into companies values (9,'ims associates,  inc.');
insert into companies values (10,'digital equipment corporation');
insert into companies values (11,'lincoln laboratory');
insert into companies values (12,'moore school of electrical engineering');
insert into companies values (13,'ibm');
insert into companies values (14,'amiga corporation');
insert into companies values (15,'canon');
insert into companies values (16,'nokia');
insert into companies values (17,'sony');
insert into companies values (18,'oqo');
insert into companies values (19,'next');
insert into companies values (20,'atari');
insert into companies values (21,'acorn computersrow');
insert into companies values (22,'timex sinclair');
insert into companies values (23,'nintendo');
insert into companies values (24,'sinclair research ltd');
insert into companies values (25,'xerox');
insert into companies values (26,'hewlett-packard');
insert into companies values (27,'zemmix');
insert into companies values (28,'acvs');
insert into companies values (29,'sanyo');
insert into companies values (30,'cray');
insert into companies values (31,'evans & sutherland');
insert into companies values (32,'e.s.r. inc.');
insert into companies values (33,'omron');
insert into companies values (34,'bbn technologies');
insert into companies values (35,'lenovo group');
insert into companies values (36,'asus');
insert into companies values (37,'amstrad');
insert into companies values (38,'sun microsystems');
insert into companies values (39,'texas instruments');
insert into companies values (40,'htc corporation');
insert into companies values (41,'research in motion');
insert into companies values (42,'Samsung Electronics');

# --- !Downs
drop table companies;
