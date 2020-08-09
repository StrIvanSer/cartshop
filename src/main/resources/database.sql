INSERT INTO public.role(id, name)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

INSERT INTO public.users (id, email, password, username)
VALUES (1, 'admin12345@LIst.ru', '$2a$10$SHkA87emrDlw1MVCYdJZCeuBC4x7yh54Er04pUxZZV/sIkNoY9CT6', 'admin');

INSERT INTO public.users (id, email, password, username)
VALUES (2, 'svet42@yandex.ru', '$2a$10$PLa76WRjZJj84i6/Bmw93Oiw.6RIO.szuSderu8SfnpvwQilKei06', 'bubbaleh');

INSERT INTO public.users (id, email, password, username)
VALUES (3, 'testUser@user.ru', '$2a$10$awPSAImmkFvPENBDKY6qQeYiJyNaV5tCU6kLKauT6PL4R.ONWN0.q', 'testUser');

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (1, 2);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (2, 1);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (3, 1);

INSERT INTO public.product (prod_id, brand, description, name, price)
VALUES (1, 'LG', 'Современный и отменный', 'Телевизор', 14200.60),
       (2, 'BOSH', 'Стирает и на том спасибо', 'Стиральная машина', 9200.30),
       (3, 'SAMSUNG', 'Лучшее что придумало человечество', 'Покрывало', 3700.32),
       (4, 'ВИТЯЗЬ', 'Морозит', 'Холодильник', 12900.00),
       (5, 'ПЯТЕРОЧКА', 'ПОдарочный купон', 'купон', 90000.00),
       (6, 'SAMSUNG', '1990', 'Телевизор', 8900.00),
       (7, 'BMW', 'M5', 'Автомобиль', 123900.36),
       (8, 'SONY', 'Ждем', 'PS5', 42900.00);


INSERT INTO public.cart (cart_id, email, sum, active)
VALUES (1, 'svet42@yandex.ru', 0.00, TRUE);

INSERT INTO public.cart (cart_id, email, sum, active)
VALUES (2, 'testUser@user.ru', 0.00, TRUE);


INSERT INTO public.product_shop(prod_id, cart_id)
VALUES (1, 1);
INSERT INTO public.product_shop(prod_id, cart_id)
VALUES (3, 1);
INSERT INTO public.product_shop(prod_id, cart_id)
VALUES (4, 2);


INSERT INTO public.product_shop(prod_id, cart_id)
VALUES (6, 2);
INSERT INTO public.product_shop(prod_id, cart_id)
VALUES (7, 2);
-- --
--
-- INSERT INTO public.cart_item (id, price, value, cart_id, prod_id)
--     VALUES (1, 200 , 3 , 1 , 2);
--
-- INSERT INTO public.cart_item (id, price, value, cart_id, prod_id)
--     VALUES (5, 200 , 3 , 2 , 2);
--
-- INSERT INTO public.cart_item (id, price, value, cart_id, prod_id)
--     VALUES (4, 200322 , 4 , 1 , 3);

