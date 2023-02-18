--删除
COMMIT;
alter table user_auth_info
    disable constraint pk_user_auth_info_id;
alter table user_auth_info
    disable constraint uq_user_auth_info_username;
drop table user_auth_info;--删除