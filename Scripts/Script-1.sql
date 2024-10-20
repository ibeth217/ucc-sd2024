CREATE TABLE public.dummy (
    id serial4 NOT NULL,
    "name" varchar(30) NULL
);
INSERT INTO public.dummy ("name") VALUES ('John Doe');
INSERT INTO public.dummy ("name") VALUES ('Jane Smith');
INSERT INTO public.dummy ("name") VALUES ('Alice Johnson');
INSERT INTO public.dummy ("name") VALUES ('Bob Williams');

select * from public.dummy
