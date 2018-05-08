--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 10.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: danielcs88
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    payment_id bigint,
    user_id integer
);


--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: danielcs88
--

CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: danielcs88
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- Name: product_category; Type: TABLE; Schema: public; Owner: danielcs88
--

CREATE TABLE public.product_category (
    id integer NOT NULL,
    name character varying NOT NULL,
    description character varying NOT NULL,
    department character varying NOT NULL
);


--
-- Name: product_orders; Type: TABLE; Schema: public; Owner: danielcs88
--

CREATE TABLE public.product_orders (
    id integer NOT NULL,
    order_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL
);


--
-- Name: product_orders_id_seq; Type: SEQUENCE; Schema: public; Owner: danielcs88
--

CREATE SEQUENCE public.product_orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: product_orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: danielcs88
--

ALTER SEQUENCE public.product_orders_id_seq OWNED BY public.product_orders.id;


--
-- Name: productcategory_id_seq; Type: SEQUENCE; Schema: public; Owner: danielcs88
--

CREATE SEQUENCE public.productcategory_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: productcategory_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: danielcs88
--

ALTER SEQUENCE public.productcategory_id_seq OWNED BY public.product_category.id;


--
-- Name: products; Type: TABLE; Schema: public; Owner: danielcs88
--

CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying NOT NULL,
    description character varying NOT NULL,
    price double precision NOT NULL,
    currency character varying NOT NULL,
    product_category_id integer,
    supplier_id integer
);


--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: danielcs88
--

CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: danielcs88
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- Name: suppliers; Type: TABLE; Schema: public; Owner: danielcs88
--

CREATE TABLE public.suppliers (
    id integer NOT NULL,
    name character varying NOT NULL,
    description character varying NOT NULL
);


--
-- Name: suppliers_id_seq; Type: SEQUENCE; Schema: public; Owner: danielcs88
--

CREATE SEQUENCE public.suppliers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: suppliers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: danielcs88
--

ALTER SEQUENCE public.suppliers_id_seq OWNED BY public.suppliers.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: danielcs88
--

CREATE TABLE public.users (
    email character varying,
    phone character varying,
    billing_country character varying,
    billing_city character varying,
    billing_address character varying,
    billing_zipcode character varying,
    shipping_country character varying,
    shipping_city character varying,
    shipping_address character varying,
    shipping_zipcode character varying,
    name character varying NOT NULL,
    password character varying,
    id integer NOT NULL
);

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: danielcs88
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: danielcs88
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- Name: product_category id; Type: DEFAULT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.product_category ALTER COLUMN id SET DEFAULT nextval('public.productcategory_id_seq'::regclass);


--
-- Name: product_orders id; Type: DEFAULT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.product_orders ALTER COLUMN id SET DEFAULT nextval('public.product_orders_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- Name: suppliers id; Type: DEFAULT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.suppliers ALTER COLUMN id SET DEFAULT nextval('public.suppliers_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: danielcs88
--

INSERT INTO public.orders (id, payment_id, user_id) VALUES (2, 987654321, 1);
INSERT INTO public.orders (id, payment_id, user_id) VALUES (3, 123459876, 1);
INSERT INTO public.orders (id, payment_id, user_id) VALUES (1, 123456789, 1);


--
-- Data for Name: product_category; Type: TABLE DATA; Schema: public; Owner: danielcs88
--

INSERT INTO public.product_category (id, name, description, department) VALUES (1, 'Smarthphone', 'Phones that think instead of you.', 'Electronics');


--
-- Data for Name: product_orders; Type: TABLE DATA; Schema: public; Owner: danielcs88
--

INSERT INTO public.product_orders (id, order_id, product_id, quantity) VALUES (1, 1, 1, 3);
INSERT INTO public.product_orders (id, order_id, product_id, quantity) VALUES (2, 2, 1, 7);
INSERT INTO public.product_orders (id, order_id, product_id, quantity) VALUES (3, 3, 1, 13);
INSERT INTO public.product_orders (id, order_id, product_id, quantity) VALUES (4, 1, 1, 7);
INSERT INTO public.product_orders (id, order_id, product_id, quantity) VALUES (5, 1, 1, 10);


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: danielcs88
--

INSERT INTO public.products (id, name, description, price, currency, product_category_id, supplier_id) VALUES (1, 'Phone', 'A phone.', 500, 'USD', 1, 1);


--
-- Data for Name: suppliers; Type: TABLE DATA; Schema: public; Owner: danielcs88
--

INSERT INTO public.suppliers (id, name, description) VALUES (1, 'Samsung', 'Cutting edge electronics.');


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: danielcs88
--

INSERT INTO public.users (email, phone, billing_country, billing_city, billing_address, billing_zipcode, shipping_country, shipping_city, shipping_address, shipping_zipcode, name, password, id) VALUES ('admin@admin.org', '123456789', 'Hungary', 'Budapest', 'Nagymező utca 42.', '1060', 'Hungary', 'Budapest', 'Nagymező utca 42.', '1060', 'John Doe', 'admin', 1);


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: danielcs88
--

SELECT pg_catalog.setval('public.orders_id_seq', 3, true);


--
-- Name: product_orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: danielcs88
--

SELECT pg_catalog.setval('public.product_orders_id_seq', 5, true);


--
-- Name: productcategory_id_seq; Type: SEQUENCE SET; Schema: public; Owner: danielcs88
--

SELECT pg_catalog.setval('public.productcategory_id_seq', 1, true);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: danielcs88
--

SELECT pg_catalog.setval('public.products_id_seq', 1, true);


--
-- Name: suppliers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: danielcs88
--

SELECT pg_catalog.setval('public.suppliers_id_seq', 1, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: danielcs88
--

SELECT pg_catalog.setval('public.users_id_seq', 1, true);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: product_orders product_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.product_orders
    ADD CONSTRAINT product_orders_pkey PRIMARY KEY (id);


--
-- Name: product_category productcategory_pkey; Type: CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.product_category
    ADD CONSTRAINT productcategory_pkey PRIMARY KEY (id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: suppliers suppliers_pkey; Type: CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.suppliers
    ADD CONSTRAINT suppliers_pkey PRIMARY KEY (id);


--
-- Name: users users_id_pk; Type: CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_id_pk PRIMARY KEY (id);


--
-- Name: orders orders_users_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_users_id_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: product_orders product_orders_orders_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.product_orders
    ADD CONSTRAINT product_orders_orders_id_fk FOREIGN KEY (order_id) REFERENCES public.orders(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: product_orders product_orders_products_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.product_orders
    ADD CONSTRAINT product_orders_products_id_fk FOREIGN KEY (product_id) REFERENCES public.products(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: products products_product_category_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_product_category_id_fk FOREIGN KEY (product_category_id) REFERENCES public.product_category(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- Name: products products_suppliers_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: danielcs88
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_suppliers_id_fk FOREIGN KEY (supplier_id) REFERENCES public.suppliers(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- PostgreSQL database dump complete
--

