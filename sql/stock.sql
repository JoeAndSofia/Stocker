DROP TABLE stock;

CREATE TABLE stock (
    id     INTEGER PRIMARY KEY AUTOINCREMENT,
    verify BOOLEAN DEFAULT false NOT NULL,
    type   VARCHAR (10) COLLATE RTRIM DEFAULT (''),
    code   VARCHAR (10) DEFAULT ('') NOT NULL COLLATE RTRIM,
    import BOOLEAN DEFAULT false NOT NULL,
    name   VARCHAR (10) DEFAULT ('') NOT NULL
);

CREATE INDEX [stock-verify_type_code-idx] ON stock (
    verify COLLATE NOCASE ASC,
    type COLLATE NOCASE ASC,
    code COLLATE NOCASE ASC
);
