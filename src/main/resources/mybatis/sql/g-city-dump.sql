--创建
create table user_auth_info
(
    user_id             varchar2(36) default sys_guid(),
    username       varchar2(20) not null,
    password       varchar2(64) not null,
    create_user_id varchar2(36) default null,
    create_time    TIMESTAMP    default sysdate,
    update_user_id varchar2(36) default null,
    update_time    TIMESTAMP    default sysdate,
    deleted        NUMBER(1)    default 0
);
alter table user_auth_info
    add constraint pk_user_auth_info_id primary key (user_id);
alter table user_auth_info
    add constraint uq_user_auth_info_username unique (username);

