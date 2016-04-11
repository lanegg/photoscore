-- private long id;
--     private String photoPath;
--     private String desc;
--     private String status;
--     private int creator;
--     private int isDelete;
--     private String createTime;
--     private String updateTime;

create table selfie(
  id bigint auto_increment primary key,
  photoPath varchar(500) not null,
  photoDescribe varchar(2000),
  status varchar(50) not null,
  creator bigint not null,
  isDelete int not null default 0,
  createTime varchar(50) not null,
  updateTime varchar(50) not null
) comment 'selfie info 主表';