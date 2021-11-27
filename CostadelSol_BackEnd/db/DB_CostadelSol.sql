drop database if exists DB_CostadelSol;
create database if not exists DB_CostadelSol;
use  DB_CostadelSol;

create table Habitacion(
Habitacion_ID    char (4) not null,
Des_Hab varchar(250) not null,
Est_Hab varchar(50) not null,
Pre_Hab decimal(7,2) not null,
constraint PK_Habitacion_ID primary key (Habitacion_ID),
constraint CHK_Est_Habi check (Est_Hab in ("Disponible", "Ocupado", "Reservado"))
);
insert into Habitacion values ("H107","Suit","Disponible",320.30);
insert into Habitacion values ("H106","Matrimonial premium","Disponible",290.97);
insert into Habitacion values ("H205","Doble Premium","Ocupado",290.97);
insert into Habitacion values ("H104","Matrimonial Superior","Disponible",265.51);
insert into Habitacion values ("H203","Doble Superior","Ocupado",265.51);
insert into Habitacion values ("H102","Matrimonial Estandar","Ocupado",256.20);
insert into Habitacion values ("H201","Doble Estandar","Reservado",256.20);

create table Huesped(
DNI          char    (8) ,
Nom_Hue      varchar ( 50 ) not null,
Ape_Hue    varchar ( 50 ) not null ,
Tel_Hue     varchar ( 9  ) not null,
Cor_Hue       varchar ( 100) not null,
Est_Hue		varchar(10) not null,
constraint PK_DNI_Huesped primary key (DNI),
constraint CHK_EST_Hue check(Est_Hue in ("Activo","Desactivado"))
);
insert into Huesped values("45698721","Luis","Alva","950742655","lalva23@gmail.com","Activo");
insert into Huesped values ("65825471","Antonio","Lopez","997837584", "Antoniol5@hotmail.com","Activo");
insert into Huesped values ("35698249","Tereza","Torres","652321475","tere146@gmail.com","Activo");

create table Empleado(
Empleado_ID   varchar (4),
DNI            char    (8)   not null,
Nombre         varchar (20)  not null,
Apellidos      varchar (20)  not null,
Cargo          varchar (20)  not null,
constraint PK_Empleado_ID primary key (Empleado_ID)
);
insert into Empleado values ("A001","18154598","Juan","Perez" ,"Almacenro");
insert into Empleado values ("R001","70581632","Martin","Rodriguez" ,"Recepcionista");

create table  Reserva(
       Reserva_ID 	char(6) not null,
       DNI          char    ( 8  ) not null,      
       Empleado_ID   varchar (4) not null,
       Habitacion_ID    char (4) not null,
       Fec_Recerva  date  not null,
       Fec_Ingreso  date ,
       Fec_Salida   date  not null,       
constraint PK_Reserva_ID primary key (Reserva_ID),
constraint FK_DNI foreign key (DNI) references Huesped (DNI),
constraint FK_Empleado_ID foreign key (Empleado_ID) references Empleado (Empleado_ID),
constraint FK_Habitacion_ID foreign key (Habitacion_ID) references Habitacion (Habitacion_ID)
);

insert into Reserva values ("R00001","45698721","R001","H205","2020-09-25","2020-10-01","2020-10-20");
insert into Reserva values ("R00002","65825471","R001","H201","2020-10-10","2020-10-30","2020-11-03");
insert into Reserva values ("R00003","35698249","R001","H102","2020-10-21","2020-11-02","2020-11-10");  

create table Categoria_Producto (
Catpro_ID char (1),
Des_Catpro varchar (50) not null,
primary key (Catpro_ID)
);
insert into Categoria_Producto values ("H","Habitación");
insert into Categoria_Producto values("C","Cocina");


create table Producto(
Producto_ID         char (4) not null,
Des_Pro       varchar(200)        not null ,
Stock 		int not null,
Pre_Uni             decimal (7,2)      not null,
Catpro_ID char(1) not null,
constraint PK_Producto_ID primary key (Producto_ID),
constraint FK_Catpro_ID foreign key (Catpro_ID) references Categoria_Producto(Catpro_ID)
);
insert into Producto values ('P001',"Jabones de tocador",50,2.50, "H");
insert into Producto values ('P002',"Juego de sabanas",100,30.00,"H");
insert into Producto values ('P003',"Cuchillos de picar",7,15.30,"C");
insert into Producto values ('P004',"Funtes para el horno",5,30.24,"C");

-- FACTURA
create table Factura(
Num_Fac 	 char(6) not null,
RUC			 char(11) not null,
DNI          char    (8) not null,
Habitacion_ID    char (4) not null,
Empleado_ID   varchar (4) not null,
Pre_Noche	 decimal(7,2) not null,
Fec_Act		 date not null,
Constraint PK_RUC_Factura primary key (RUC),
Constraint FK_DNI_Fac_Hue foreign key (DNI) references Huesped(DNI),
Constraint FK_Empleado_ID_Fac_Usu foreign key (Empleado_ID) references Empleado(Empleado_ID),
constraint FK_Habitacion_Fac foreign key (Habitacion_ID) references Habitacion(Habitacion_ID)
);

insert into Factura values ("FAC001","11235879654","45698721","H205","R001",290.97,"2020-10-20");
insert into Factura values ("FAC002","11582586498","65825471","H201","R001",256.20,"2020-11-03");
insert into Factura values ("FAC003","11325632487","35698249","H102","R001",256.20,"2020-11-10");

create table Orden_Compra(
Nro_Ord char(6) not null,
Nom_emp varchar(50) not null,
Dir_emp varchar(250) not null,
Ema_Pro varchar(150) not null,
Fec_Ord date not null,
constraint PK_Nro_Ord primary key (Nro_Ord)
);

create table Detalle_Orden_Compra(
Nro_Ord char(6) not null,
Producto_ID char (4) not null,
Des_Pro varchar(100) not null,
Can_Pro varchar(3) not null,
constraint FK_DT_Nro_Ord foreign key (Nro_Ord) references Orden_Compra(Nro_Ord),
constraint FK_DT_Pro_ID foreign key (Producto_ID) references Producto(Producto_ID)
);

create table Orden_Pedido(
Nro_Ped char(6) not null,
Area varchar(50) not null,
constraint PK_Nro_Ped primary key (Nro_Ped)
);

create table Detalle_Orden_Pedido(
Nro_Ped char(6) not null,
Producto_ID char (4) not null,
Area varchar(50) not null,
Cant_Ped int not null,
constraint FK_DT_Ped_Nro_Ped foreign key (Nro_Ped) references Orden_Pedido(Nro_Ped),
constraint FK_DT_Ped__Pro_ID foreign key (Producto_ID) references Producto(Producto_ID)
);

/*
create table usuario(
user_id INT UNSIGNED AUTO_INCREMENT,
username VARCHAR(75) NOT NULL,
password VARCHAR(75) NOT NULL,
email VARCHAR(125) NOT NULL,
CONSTRAINT usuario_user_id_pk
	PRIMARY KEY(user_id),
CONSTRAINT usuario_username_uk
	UNIQUE(username)
);

create table role(
role_id INT UNSIGNED AUTO_INCREMENT,
role VARCHAR(75) NOT NULL,
CONSTRAINT role_role_id_pk
	PRIMARY KEY(role_id)
);

create table user_role(
user_id INT UNSIGNED,
role_id INT UNSIGNED,
CONSTRAINT user_role_user_id_role_id_pk
	PRIMARY KEY(user_id,role_id),
CONSTRAINT user_role_user_id_fk
	FOREIGN KEY(user_id)
		REFERENCES usuario(user_id),
CONSTRAINT user_role_role_id_fk
	FOREIGN KEY(role_id)
		REFERENCES role(role_id),
CONSTRAINT user_role_role_id_uk
	UNIQUE(role_id)
);

select * from usuario;
select * from role;
select * from user_role;
*/

/*

INSERT INTO usuario
	VALUES	(DEFAULT, 'karc@gmail.com', '1973546'),
			(DEFAULT, 'marcos123@yahoo.com', 'password'),
            (DEFAULT, 'jugo@outlook.com', 'admin123'),
            (DEFAULT, 'luciaperez@hotmail.com', 'lucia123');
*/

create table usuario(
user_id INT UNSIGNED AUTO_INCREMENT,
username VARCHAR(75) NOT NULL,
password VARCHAR(75) NOT NULL,
CONSTRAINT usuario_user_id_pk
	PRIMARY KEY(user_id),
CONSTRAINT usuario_username_uk
	UNIQUE(username)
);

INSERT INTO usuario
	VALUES	(DEFAULT, 'karc', '1973546'),
			(DEFAULT, 'marcos123', 'password'),
            (DEFAULT, 'jugo', 'admin123'),
            (DEFAULT, 'luciaperez', 'lucia123');

/*


======================PROCEDURE===============================*/
SELECT * FROM Habitacion;


DELIMITER $$
create procedure sp_listar_reserva(dni char(8))
begin
select R.DNI,HA.Des_Hab,R.Fec_Recerva,HU.Tel_Hue from Huesped HU 
inner join Reserva R on HU.DNI=R.DNI 
inner join Habitacion HA on R.Habitacion_ID=HA.Habitacion_ID
where R.DNI=dni;
end$$
call sp_listar_reserva('35698249');


-- LISTAR RESERVA
DELIMITER $$
create procedure sp_registrar_reserva(dni char(8),nombre varchar(50),apellido varchar(50),telef varchar(9),correo varchar(100),
									  res_id char(6),hab_id char(4),ingreso date , salida date)
begin
if ingreso=null then
insert into Huesped values(dni,nombre,apellido,telef,correo,"Activo");
insert into Reserva values(res_id,dni,"R001",hab_id,curdate(),null,salida);
update Habitacion
set Est_Hab = 'Reservado'
where Habitacion_ID=hab_id;
else
insert into Huesped values(dni,nombre,apellido,telef,correo,"Activo");
insert into Reserva values(res_id,dni,"R001",hab_id,curdate(),ingreso,salida);
update Habitacion
set Est_Hab = 'Ocupado'
where Habitacion_ID=hab_id;
end if;
end$$

DELIMITER $$
create procedure sp_reservaciones()
begin
select r.DNI,h.Des_Hab,r.Fec_Recerva,hu.Tel_Hue from Huesped hu 
inner join reserva r on hu.DNI=r.DNI
inner join habitacion h on r.Habitacion_ID=h.Habitacion_ID;
end$$
call sp_reservaciones();

select * from empleado
tb_usuarios