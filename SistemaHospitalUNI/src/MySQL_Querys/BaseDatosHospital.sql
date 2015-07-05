Create Database SistemaHospital;

Use SistemaHospital;

Create Table AlergiaMedicamento(
	id_alergia Int primary key auto_increment not null,
    nombre varchar(50),
    descripcion varchar(500)
);

Create Table Padecimiento_AM(
	id_padecimientoam Int primary key auto_increment not null,
    id_paciente int,
    id_alergia int not null,
    Foreign key (id_alergia) references AlergiaMedicamento(id_alergia)
);

Create Table Paciente_16(
	id_paciente int primary key auto_increment not null,
    cedula varchar(18)not null,
    foto longblob,
    check (cedula like '[0-9]''[0-9]''[0-9]''-''[0-9]''[0-9]''[0-9]''[0-9]''[0-9]''[0-9]''-''[0-9]''[0-9]''[0-9]''[0-9]''[A-Z]')
);

Create Table Sector(
	id_sector int primary key auto_increment not null,
    barrio varchar(100)not null,
    distrito varchar(100)not null
);

Create Table Paciente(
	id_paciente int primary key auto_increment not null,
    id_sector int not null,
    foreign key (id_sector)references Sector(id_sector),
    nombre varchar(50)not null,
    apellido varchar(50)not null,
    foto longblob,
    telefono varchar(15)not null,
    direccion varchar(200)not null,
    check(telefono like '2''[0-9]''[0-9]''[0-9]''[0-9]''[0-9]''[0-9]')
);

Create Table Enfermedad_Cronica(
	id_ec int primary key auto_increment not null,
    nombre varchar(50)not null,
    descripcion varchar(500)not null
);

Create Table Padecimiento_EC(
	id_padecimientoec int primary key auto_increment not null,
    id_paciente int not null,
    id_ec int not null,
    descripcion varchar(500)not null,
    foreign key (id_paciente)references Paciente(id_paciente),
    foreign key (id_ec)references Enfermedad_Cronica(id_ec)
);

Create Table Medico(
	id_medico int primary key auto_increment not null,
    nombre varchar(50)not null,
    apellido varchar(50)not null,
    foto longblob,
    especialidad varchar(100)not null,
	cedula varchar(18)not null
    check (cedula like '[0-9]''[0-9]''[0-9]''-''[0-9]''[0-9]''[0-9]''[0-9]''[0-9]''[0-9]''-''[0-9]''[0-9]''[0-9]''[0-9]''[A-Z]')
);

Create Table Cita(
	id_cita int primary key auto_increment not null,
    id_medico int not null,
    id_paciente int not null,
    fecha date not null,
    hora time not null,
    estado varchar(100)not null,
    foreign key (id_medico)references Medico(id_medico)
);

Create Table HorarioMedico(
	id_horariomedico int primary key auto_increment not null,
    hora_entrada time not null,
    hora_salida time not null
);

Create Table Medico_HorarioMedico(
	id_medico_horariomedico int primary key auto_increment not null,
    id_medico int not null,
    foreign key (id_medico)references Medico(id_medico),
    dia date not null
);

Create Table Catalogo_Examen(
	id_examen int primary key auto_increment not null,
    nombre varchar(50)not null,
    descripcion varchar(200)not null,
    precio float not null
);

Create Table Cajero(
	id_cajero int primary key auto_increment not null,
    nombre varchar(50)not null,
    apellido varchar(50)not null,
    cedula varchar(18)not null,
    check (cedula like '[0-9]''[0-9]''[0-9]''-''[0-9]''[0-9]''[0-9]''[0-9]''[0-9]''[0-9]''-''[0-9]''[0-9]''[0-9]''[0-9]''[A-Z]'),
    foto longblob
);

Create Table FacturaExamen(
	id_facturaex int primary key auto_increment not null,
    id_paciente int not null,
    foreign key(id_paciente)references Paciente(id_paciente),
    id_cajero int not null,
    foreign key (id_cajero)references Cajero(id_cajero),
    horas time not null,
    total float not null
);

Create Table Detalle_Factura(
	id_detallefact int primary key auto_increment not null,
    id_examen int not null,
    id_facturaex int not null,
    foreign key(id_examen)references Catalogo_Examen(id_examen),
    foreign key(id_facturaex)references FacturaExamen(id_facturaex)
);

Create Table Factura_procedimiento(
	id_factpro int primary key auto_increment not null,
    id_cajero int not null,
    foreign key(id_cajero)references Cajero(id_cajero),
    id_paciente int not null,
    foreign key(id_paciente)references Paciente(id_paciente),
    fecha date not null,
    total float not null
);

Create Table FacturaConsulta(
	id_factura int primary key auto_increment not null,
    id_cajero int not null,
    foreign key(id_cajero)references Cajero(id_cajero),
    horas time not null,
    precio float not null
);

Create Table ProcedimientosEspeciales(
	id_proc int primary key auto_increment not null,
    nombre varchar(100)not null,
    descripcion varchar(200)not null,
    id_factura int not null,
    foreign key(id_factura)references FacturaConsulta(id_factura),
    precio float not null
);

Create Table Detalle_factpro(
	id_detfactpro int primary key auto_increment not null,
    id_fact int not null,
    foreign key (id_fact)references Factura_procedimiento(id_factpro),
    id_proc int not null,
    foreign key(id_proc) references ProcedimientosEspeciales(id_proc)
);

Create Table Consulta(
	id_consulta int primary key auto_increment not null,
    descripcion varchar(200)not null,
    precio float
);

Create Table Detalle_Consulta(
	id_detconsulta int primary key auto_increment not null,
    id_consulta int unique not null,
    foreign key(id_consulta)references Consulta(id_consulta),
    altura varchar(20)not null,
    peso varchar(20)not null
);

Create Table Diagnostico(
	id_diagnostico int primary key auto_increment not null,
    id_consulta int not null,
    foreign key(id_consulta)references Consulta(id_consulta),
    descripcion varchar(200)not null
);

Create Table Examen(
	id_examen_diagnostico int primary key auto_increment not null,
    id_diagnostico int not null,
    foreign key(id_diagnostico)references Diagnostico(id_diagnostico),
    nombre varchar(50)not null,
    descripcion varchar(200)not null,
    fecha date not null
);

Create Table Receta(
	id_receta int primary key auto_increment not null,
    id_diagnostico int not null,
    foreign key(id_diagnostico)references Diagnostico(id_diagnostico),
    medicamento varchar(200)not null,
    dosis varchar(200)not null,
    cantidad int not null
);