# Репозиторий для домашних заданий из академии iFellow

## Первое задание
В файле [RunTest](/src/test/java/RunTest.java) содержатся 2 теста:
1. Тест, проверяющий работоспособность кнопки "Карьера". В нём мы находим элемент в теге "header" с текстом "Карьера" и нажимаем на него. После сравниваем ссылку после перехода с той, на которую должна отправлять кнопка.
2. Тест, проверяющий появление ошибки после ввода почты в неправильном формате. Для этого мы проматываем страницу вниз, вводим почту без символа @ и нажимаем кнопку "Подписаться". После выполнения  этих действий должна появиться ошибка.