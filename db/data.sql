--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2 (Debian 11.2-1.pgdg90+1)
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: application; Type: TABLE DATA; Schema: public; Owner: helmes_user
--

INSERT INTO public.application VALUES (1, 'ewfewf', 'ChgIRAyWVaakujAZ-m7NpM624CZiJTAT', true);
INSERT INTO public.application VALUES (2, 'fwef', 'ChgIRAyWVaakujAZ-m7NpM624CZiJTAT', true);
INSERT INTO public.application VALUES (3, 'fwef', 'ChgIRAyWVaakujAZ-m7NpM624CZiJTAT', true);
INSERT INTO public.application VALUES (4, '333', 'ChgIRAyWVaakujAZ-m7NpM624CZiJTAT', true);
INSERT INTO public.application VALUES (5, '123', 'ChgIRAyWVaakujAZ-m7NpM624CZiJTAT', true);


--
-- Data for Name: application_categories; Type: TABLE DATA; Schema: public; Owner: helmes_user
--

INSERT INTO public.application_categories VALUES (1, 19);
INSERT INTO public.application_categories VALUES (1, 18);
INSERT INTO public.application_categories VALUES (2, 1);
INSERT INTO public.application_categories VALUES (2, 19);
INSERT INTO public.application_categories VALUES (2, 18);
INSERT INTO public.application_categories VALUES (2, 6);
INSERT INTO public.application_categories VALUES (2, 342);
INSERT INTO public.application_categories VALUES (3, 1);
INSERT INTO public.application_categories VALUES (3, 19);
INSERT INTO public.application_categories VALUES (3, 18);
INSERT INTO public.application_categories VALUES (3, 6);
INSERT INTO public.application_categories VALUES (3, 342);
INSERT INTO public.application_categories VALUES (4, 1);
INSERT INTO public.application_categories VALUES (4, 19);
INSERT INTO public.application_categories VALUES (4, 18);
INSERT INTO public.application_categories VALUES (4, 6);
INSERT INTO public.application_categories VALUES (4, 342);
INSERT INTO public.application_categories VALUES (5, 1);
INSERT INTO public.application_categories VALUES (5, 19);
INSERT INTO public.application_categories VALUES (5, 18);
INSERT INTO public.application_categories VALUES (5, 6);
INSERT INTO public.application_categories VALUES (5, 342);


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: helmes_user
--

INSERT INTO public.category VALUES (1, 'Manufacturing', NULL);
INSERT INTO public.category VALUES (19, 'Construction materials', 1);
INSERT INTO public.category VALUES (18, 'Electronics and Optics', 1);
INSERT INTO public.category VALUES (6, 'Food and Beverage', 1);
INSERT INTO public.category VALUES (342, 'Bakery & confectionery products', 6);


--
-- Data for Name: databasechangelog; Type: TABLE DATA; Schema: public; Owner: helmes_user
--

INSERT INTO public.databasechangelog VALUES ('1631355609537-1', 'levmalinovski', 'db/changelog/2021/09/11-01-changelog.xml', '2021-09-13 17:09:42.169462', 1, 'EXECUTED', '8:fc2845729c36f20c209cab712acf8395', 'createTable tableName=category', '', NULL, '4.3.5', NULL, NULL, '1542181993');
INSERT INTO public.databasechangelog VALUES ('1631355609537-2', 'levmalinovski', 'db/changelog/2021/09/11-01-changelog.xml', '2021-09-13 17:09:42.187694', 2, 'EXECUTED', '8:91701e81764d5c6454f16517d9894b35', 'addForeignKeyConstraint baseTableName=category, constraintName=FK_CATEGORY_ON_PARENT, referencedTableName=category', '', NULL, '4.3.5', NULL, NULL, '1542181993');
INSERT INTO public.databasechangelog VALUES ('1631355609537-3', 'levmalinovski', 'db/changelog/2021/09/11-01-changelog.xml', '2021-09-13 17:09:42.204766', 3, 'EXECUTED', '8:c4a6960ed7a5c48ee3ec14644494ef03', 'insert tableName=category; insert tableName=category; insert tableName=category; insert tableName=category; insert tableName=category', '', NULL, '4.3.5', NULL, NULL, '1542181993');
INSERT INTO public.databasechangelog VALUES ('1631462110476-1', 'levmalinovski', 'db/changelog/2021/09/12-01-changelog.xml', '2021-09-13 17:09:42.217913', 4, 'EXECUTED', '8:7cf79cf6fab5c6743e6b287c18d61234', 'createTable tableName=application', '', NULL, '4.3.5', NULL, NULL, '1542181993');
INSERT INTO public.databasechangelog VALUES ('1631462110476-2', 'levmalinovski', 'db/changelog/2021/09/12-01-changelog.xml', '2021-09-13 17:09:42.226591', 5, 'EXECUTED', '8:2f7bf3d4f4fc1fb3c6752c55d8959dae', 'createTable tableName=application_categories', '', NULL, '4.3.5', NULL, NULL, '1542181993');


--
-- Data for Name: databasechangeloglock; Type: TABLE DATA; Schema: public; Owner: helmes_user
--

INSERT INTO public.databasechangeloglock VALUES (1, false, NULL, NULL);


--
-- Name: application_id_seq; Type: SEQUENCE SET; Schema: public; Owner: helmes_user
--

SELECT pg_catalog.setval('public.application_id_seq', 5, true);


--
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: helmes_user
--

SELECT pg_catalog.setval('public.category_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

