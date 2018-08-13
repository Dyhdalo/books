--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.19
-- Dumped by pg_dump version 9.1.19
-- Started on 2018-08-13 10:48:55

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 177 (class 1259 OID 16899)
-- Dependencies: 1797 5
-- Name: author_book; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE author_book (
    id bigint DEFAULT nextval('seq_ids'::regclass) NOT NULL,
    book_id bigint NOT NULL,
    author_id bigint NOT NULL
);


ALTER TABLE public.author_book OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16881)
-- Dependencies: 1795 5
-- Name: authors; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE authors (
    id bigint DEFAULT nextval('seq_ids'::regclass) NOT NULL,
    name character varying(126) NOT NULL,
    gender character varying(6) NOT NULL,
    born date
);


ALTER TABLE public.authors OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16888)
-- Dependencies: 1796 5
-- Name: books; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE books (
    id bigint DEFAULT nextval('seq_ids'::regclass) NOT NULL,
    name character varying(126) NOT NULL,
    published date,
    genre character varying(64) NOT NULL,
    rating character(1) NOT NULL
);


ALTER TABLE public.books OWNER TO postgres;

--
-- TOC entry 1911 (class 0 OID 16899)
-- Dependencies: 177 1912
-- Data for Name: author_book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY author_book (id, book_id, author_id) FROM stdin;
15213	15206	15200
15214	15207	15200
15215	15205	15201
15216	15208	15202
15217	15209	15202
15218	15210	15203
15219	15211	15203
15220	15212	15204
\.


--
-- TOC entry 1909 (class 0 OID 16881)
-- Dependencies: 175 1912
-- Data for Name: authors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY authors (id, name, gender, born) FROM stdin;
15200	Dan Brown	male	1964-06-22
15201	J.K.Rowling	female	1965-07-31
15202	Andrzej Sapkowski	male	1948-06-21
15203	Макс Кідрук	male	1984-04-01
15204	Дара Корній	female	1970-09-20
\.


--
-- TOC entry 1910 (class 0 OID 16888)
-- Dependencies: 176 1912
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY books (id, name, published, genre, rating) FROM stdin;
15205	Harry Potter and the Philosophers Stone	1997-06-26	fantasy	5
15206	Deception Point	2001-06-08	novel	5
15207	Inferno	2013-05-14	mystery	5
15208	Narrenturm	2002-05-07	powiesc	4
15209	Wieza Jaskolki	1997-04-13	fantasy	5
15210	НОІМ	2017-09-14	містичний роман	4
15211	Бот	2012-01-04	технотрилер	5
15212	Зворотній бік сутіні	2016-06-07	роман	4
15225	Твердиня	2012-05-23	роман	5
\.


--
-- TOC entry 1803 (class 2606 OID 16907)
-- Dependencies: 177 177 1913
-- Name: author_book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY author_book
    ADD CONSTRAINT author_book_pkey PRIMARY KEY (id);


--
-- TOC entry 1799 (class 2606 OID 16896)
-- Dependencies: 175 175 1913
-- Name: author_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY authors
    ADD CONSTRAINT author_pkey PRIMARY KEY (id);


--
-- TOC entry 1801 (class 2606 OID 16898)
-- Dependencies: 176 176 1913
-- Name: book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY books
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);


--
-- TOC entry 1804 (class 1259 OID 16913)
-- Dependencies: 177 1913
-- Name: fki_author_fkey; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_author_fkey ON author_book USING btree (author_id);


--
-- TOC entry 1805 (class 1259 OID 16919)
-- Dependencies: 177 1913
-- Name: fki_books_fkey; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_books_fkey ON author_book USING btree (book_id);


--
-- TOC entry 1806 (class 2606 OID 16908)
-- Dependencies: 177 175 1798 1913
-- Name: author_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY author_book
    ADD CONSTRAINT author_fkey FOREIGN KEY (author_id) REFERENCES authors(id);


--
-- TOC entry 1807 (class 2606 OID 16914)
-- Dependencies: 1800 176 177 1913
-- Name: books_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY author_book
    ADD CONSTRAINT books_fkey FOREIGN KEY (book_id) REFERENCES books(id);


-- Completed on 2018-08-13 10:48:57

--
-- PostgreSQL database dump complete
--

