# Выстраивание логики консольного приложения:

# 1. Создаем 2 типа сущностей нашего приложения - это Archieve и Note. Данные классы не имеют функциональности, а потому будут являться data классами

# 2. Создаем enum класс - Menu - здесь будут перечислены все вариации меню для каждого типа экрана, а также интерфейс PrintMenu, от которого будет работать данный класс

# 3. Создаем Singleton класс, который будет содержать свойства, необходимые для запуска и работы всего приложения. 
# Это начальное состояние экрана и номера выбранного архива, создание единственного экземпляра обработчика меню и создание пустого списка архивов

# 4. Создаем общий класс, содержащий общие методы для всех обработчиков - Overall. Это методы ввода команд меню(работа со сканнером) и создание заголовков

# 5. Создаем класс обработчик для меню: MenuController 

# 6. Создаем классы-обработчики для реализации логики работы с архивами и заметками:

# - Controller - обработчик команд, поступающих от MainScreenController
# - ArciveController - обработчик команд, поступающих от MenuController, и ведущих на действия внутри архива

# 6. Класс Main - будет запускать само приложение и зацикливать его

