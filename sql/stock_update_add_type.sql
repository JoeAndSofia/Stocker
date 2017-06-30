begin;
ALTER TABLE stock RENAME TO sqlitestudio_temp_table;

CREATE TABLE stock (
    id         INTEGER      PRIMARY KEY AUTOINCREMENT,
    verify     BOOLEAN      DEFAULT false
                            NOT NULL,
    type       INT          COLLATE BINARY
                            DEFAULT (0),
    type_code  VARCHAR (10) COLLATE RTRIM
                            DEFAULT (''),
    stock_code VARCHAR (10) DEFAULT ('') 
                            NOT NULL
                            COLLATE RTRIM,
    import     BOOLEAN      DEFAULT false
                            NOT NULL,
    name       VARCHAR (10) DEFAULT ('') 
                            NOT NULL
);

INSERT INTO stock (
                      id,
                      verify,
                      type_code,
                      stock_code,
                      import,
                      name
                  )
                  SELECT id,
                         verify,
                         type,
                         code,
                         import,
                         name
                    FROM sqlitestudio_temp_table;

DROP TABLE sqlitestudio_temp_table;

CREATE INDEX [stock-verify_type_code-idx] ON stock (
    verify COLLATE BINARY ASC,
    type COLLATE BINARY ASC,
    stock_code COLLATE BINARY ASC
);
commit;


begin;
update stock set type=1 where type_code='sh';
update stock set type=2 where type_code='sz';
update stock set type=3 where type_code='fu';
commit;