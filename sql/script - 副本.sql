create table if not exists ecategory
(
    employee char(16) not null,
    constraint ecategory_employee_uindex
        unique (employee)
);

alter table ecategory
    add primary key (employee);

create table if not exists employee
(
    eid       char(12)                           not null
        primary key,
    ename     char(10)                           null,
    epassword char(20)                           null,
    eaddress  char(64)     default '-'          null,
    edaddress char(64)     default '-'          null,
    ephone    char(12)      default '-'          null,
    ebirthday date          default '1970-01-01' null,
    erole     char(16)                          null,
    esex      char(4)                            null,
    esalary   double(6, 2) default 0.00         null,
    constraint employee_ibfk_1
        foreign key (erole) references ecategory (employee)
);

create index erole
    on employee (erole);

create table if not exists gcategory
(
    goods char(16) not null
        primary key
);

create table if not exists insign
(
    idate    datetime not null
        primary key,
    ioutdate datetime null,
    eid      char(12) null,
    constraint insign_employee_eid_fk
        foreign key (eid) references employee (eid)
            on update cascade on delete cascade
);

create table if not exists integral
(
    ivalue int null,
    pvalue int null
);

create table if not exists province
(
    provinceID int         not null
        primary key,
    province   varchar(20) null
);

create table if not exists city
(
    cityID     int         not null
        primary key,
    city       varchar(20) null,
    provinceID int         null,
    constraint city_province_provinceID_fk
        foreign key (provinceID) references province (provinceID)
            on update cascade on delete cascade
);

create table if not exists area
(
    areaID int         not null
        primary key,
    area   varchar(20) null,
    cityID int         null,
    constraint area_city_cityID_fk
        foreign key (cityID) references city (cityID)
            on update cascade on delete cascade
);

create table if not exists reficition
(
    reficitions char(16) not null
        primary key
);

create table if not exists goods
(
    gid            char(20)                   not null,
    gname          char(32)                  null,
    gcategory      char(16)                  not null,
    gorigin        char(32)                  null,
    gsupplier      char(32)                  null,
    gindate        date                       null,
    gnum           double        default 0    null,
    gpurchaseprice double(6, 2) default 0.00 null,
    gpprice        double(6, 2) default 0.00 null,
    gvprice        double(6, 2) as ((`gpprice` * `gdiscount`)),
    gdiscount      double(2, 2)  default 0.00 null,
    specifications char(16)                  not null,
    constraint goods_gid_uindex
        unique (gid),
    constraint goods_gcategory_goods_fk
        foreign key (gcategory) references gcategory (goods)
            on update cascade on delete cascade,
    constraint goods_reficition_reficitions_fk
        foreign key (specifications) references reficition (reficitions)
            on update cascade on delete cascade
);

alter table goods
    add primary key (gid);

create table if not exists ticket
(
    tid  char(12)      not null,
    gid  char(20)      not null,
    tnum double(12, 2) null,
    primary key (tid, gid),
    constraint ticket_ibfk_1
        foreign key (gid) references goods (gid)
            on update cascade on delete cascade
);

create table if not exists psales
(
    tid   char(12)      not null
        primary key,
    pid   char(15)      null,
    pdate datetime      null,
    pcash double(6, 2) null,
    eid   char(12)      null,
    constraint psales_employee_eid_fk
        foreign key (eid) references employee (eid),
    constraint psales_ticket_tid_fk
        foreign key (tid) references ticket (tid)
            on update cascade on delete cascade
);

create table if not exists vipcustomer
(
    vid       char(15)             not null
        primary key,
    vname     char(10) default '-' null,
    vsex      char(4)  default '-' null,
    vphone    char(12) default '-' null,
    vintegral int      default 0   null,
    vrdate    date                 null,
    vodate    date                 null,
    vstate    char(8)              null
);

create table if not exists vsales
(
    tid       char(12)                   not null
        primary key,
    vid       char(15)                   null,
    sdate     datetime                   null,
    scash     double(6, 2)              null,
    eid       char(12)                   null,
    sintegral double(12, 2) default 0.00 null,
    constraint sales_employee_eid_fk
        foreign key (eid) references employee (eid)
            on update cascade on delete cascade,
    constraint vsales_ibfk_1
        foreign key (tid) references ticket (tid)
            on update cascade on delete cascade,
    constraint vsales_vipcustomer_vid_fk
        foreign key (vid) references vipcustomer (vid)
            on update cascade on delete cascade
);
insert into ecategory value ('<空>');
insert into ecategory value ('管理员');
insert into gcategory value ('<空>');
insert into reficition value ('<空>');

insert into employee(eid,epassword,ename,erole,esex) value ('1234567890','1234567890','管理员','管理员','男');

