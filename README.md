# cartshop
Shopping cart Spring Boot 

Первая версия проекта, добавлен магазин и корзина
Реализована авторизация с разными ролями.


Использованые технологии:
Spring Boot, Spring Security , JPA, Postgresql, HTML.


Пользователь со статусом ADMIN может :
добавлять товар
изменять товар
удалять товар

Пользователь со статусом USER имеет может :
-Добавлять товары в корзину


Для старта проекта необходимо .
1) git clone https://github.com/StrIvanSer/cartshop.git
2) в файле application.properties изменить параметры url, username, password для доступа к вашей базе данных
3) запустить ServingWebContent
4) после успешного старта сервера, необходимо запустить скрипт database.sql для предзаполнения бд.
