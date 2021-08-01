CREATE TABLE tb_cliente (
  id bigint NOT NULL auto_increment,
  city varchar(255) DEFAULT NULL,
  district varchar(255) DEFAULT NULL,
  number varchar(255) DEFAULT NULL,
  public_place varchar(255) DEFAULT NULL,
  state varchar(255) DEFAULT NULL,
  zip_code varchar(255) DEFAULT NULL,
  age int DEFAULT NULL,
  document_number varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) engine=InnoDB default charset=utf8;
