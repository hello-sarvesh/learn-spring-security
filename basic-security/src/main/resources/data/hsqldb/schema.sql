DROP TABLE IF EXISTS members;

CREATE TABLE members (
    m_id varchar(50) NOT NULL,
    pwd varchar(68) NOT NULL,
    active tinyint NOT NULL,
    PRIMARY KEY (m_id)
);

DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
    m_id varchar(50) NOT NULL,
    roles varchar(50) NOT NULL
    -- UNIQUE KEY authorities_idx_1 (m_id,roles),
    -- CONSTRAINT authorities_idfk_1 FOREIGN KEY (m_id) REFERENCES members(m_id)
);