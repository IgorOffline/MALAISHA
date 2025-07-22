CREATE TABLE public.album
(
    id_album serial                   NOT NULL,
    name     text                     NULL,
    ctime    timestamp with time zone NOT NULL,
    mtime    timestamp with time zone NOT NULL,
    CONSTRAINT album_id_album_pk PRIMARY KEY (id_album)
);
