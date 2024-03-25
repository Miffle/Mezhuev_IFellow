# Репозиторий для домашних заданий из академии iFellow

## Итоговое задание по UI тестам
### Список тестов:
1. Файлы [**SprintsPage**](src/main/java/ru/iFellow/pages/SprintsPage.java)/[**SprintsPageTest**](src/test/java/tests/SprintsPageTest.java).
   1. Проверка статуса задачи TestSelenium.
   2. Проверка значения в поле "Исправить в версиях".
2. Файлы [**TasksPage**](src/main/java/ru/iFellow/pages/TasksPage.java)/[**TasksPageTest**](src/test/java/tests/TasksPageTest.java).
   1. Поверка создания новой задачи.
      1. Получение количества задач.
      2. Создание новой темы.
      3. Получение нового количества задач.
      4. Сравнение количества до и после создания.
3. Файлы [**TasksCreatedByMePage**](src/main/java/ru/iFellow/pages/TasksCreatedByMePage.java)/[**TasksCreatedByMePageTest**](src/test/java/tests/TasksCreatedByMePageTest.java).
    1. Открытие последней созданной мной задачи.
   2. Прогон по основным состояниям: Сделать, В работе, Исполнено, Готово.
   
-----
### Отличия от шестого задания
Отличий, на самом деле, очень мало.
1. Маленькие исправления в структуре проекта (изменил название пакета, в котором лежат тесты).
2. **Добавил возможность указать другой chromedriver.** Для этого нужно указать пропертю с названием `chrome.driver.location`. 

Пример: 
```properties
chrome.driver.location=src/main/resources/chromedriver.exe
```
3. Вынес все ссылки в [app.properties](src/main/resources/app.properties).
4. Убрал ненужный метод getStatus.
-------

Пришлось поменять версию aspectj, чтобы работало с аннотацией Step. Так же стоит объяснить причины, по которым используются ссылки, а не переходы по кнопкам со стартовой страницы: У меня не прогружалась Jira и вылезала ошибка.
![Скриншот ошибки](pics/img.png)
![Скриншот ошибки](pics/img_1.png)
