# Тестовое задание для zBrain

Контроллер обрабатывает POST-запрос на URL http://localhost:1620/zbrain-test/add-email с JSON 
вида {"email": "example@mail.ru"}.
При отправке в JSON-файле значения null, пустой строки, или строки, не подходящей под паттерн "[\\\w]{1,15}@[\\\w]{1,15}+\\\\.[\\\w]{1,5}", а так же любых других некорректных запросов, будет получен статус 400.
При отправке корректного запроса, электронный адрес сохраняется в базе данных и возвращается статус 200.

Адреса записываются в базе данных в таблицу email с единственным полем email типа varchar(32), которое явлеятся так же первичным ключом.

Все настройки доступа к БД находятся в файле src/main/resources/application.properties.

Главный класс с pswm: src/main/java/org/zbrain/test/TestApplication.java