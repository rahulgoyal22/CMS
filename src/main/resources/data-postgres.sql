INSERT INTO public.users (id, created_at, updated_at, email, password, name_of_user, type_of_user)
VALUES (1, '2020-09-15', '2020-09-15', 'approver1', 'testing', 'approver1', 1);
INSERT INTO public.users (id, created_at, updated_at, email, password, name_of_user, type_of_user)
VALUES (2, '2020-09-15', '2020-09-15', 'approver2', 'testing', 'approver2', 1);
INSERT INTO public.users (id, created_at, updated_at, email, password, name_of_user, type_of_user)
VALUES (3, '2020-09-15', '2020-09-15', 'collector1', 'testing', 'collector1', 0);
INSERT INTO public.users (id, created_at, updated_at, email, password, name_of_user, type_of_user)
VALUES (4, '2020-09-15', '2020-09-15', 'collector2', 'testing', 'collector2', 0);
INSERT INTO public.users (id, created_at, updated_at, email, password, name_of_user, type_of_user)
VALUES (5, '2020-09-15', '2020-09-15', 'collector3', 'testing', 'collector3', 0);

INSERT INTO public.hotel (id, created_at, updated_at, email_address, password, manager_id, users_id, balance)
VALUES (1, '2020-09-15', '2020-09-15', 'hotel1', 'testing', 'Hotel1', '3', 0);
INSERT INTO public.hotel (id, created_at, updated_at, email_address, password, manager_id, users_id, balance)
VALUES (2, '2020-09-15', '2020-09-15', 'hotel2', 'testing', 'Hotel2', '3', 0);
INSERT INTO public.hotel (id, created_at, updated_at, email_address, password, manager_id, users_id, balance)
VALUES (3, '2020-09-15', '2020-09-15', 'hotel3', 'testing', 'Hotel3', '4', 0);
INSERT INTO public.hotel (id, created_at, updated_at, email_address, password, manager_id, users_id, balance)
VALUES (4, '2020-09-15', '2020-09-15', 'hotel4', 'testing', 'Hotel4', '4', 0);
INSERT INTO public.hotel (id, created_at, updated_at, email_address, password, manager_id, users_id, balance)
VALUES (5, '2020-09-15', '2020-09-15', 'hotel5', 'testing', 'Hotel5', '5', 0);

INSERT INTO public.mapping (id, created_at, updated_at, collector_id, approver_id)
VALUES (1, '2020-09-15', '2020-09-15', 3, 1);
INSERT INTO public.mapping (id, created_at, updated_at, collector_id, approver_id)
VALUES (2, '2020-09-15', '2020-09-15', 4, 1);
INSERT INTO public.mapping (id, created_at, updated_at, collector_id, approver_id)
VALUES (3, '2020-09-15', '2020-09-15', 5, 2);

SELECT setval('users_id_seq',5, true);
SELECT setval('hotel_id_seq',5, true);
SELECT setval('mapping_id_seq',3, true);

