//Пока лишь пробуем просто описать общую логику меню в одном классе
class Menu() {
    fun menuCommand(numberScreen : Int) {
        //Метод определения экрана
        when(numberScreen) {
            1 -> println("Вызываем метод просмотр архивов")
            2 -> println("Вызываем просмотр архива")
            3 -> println("Это экран выбора заметки в архиве")
            4 -> println("Это экран создания заметки")
            5 -> println("Это экран заметки с текстом")
            else -> println("Что-то пошло не так...")
        }
    }

    //Методы действий

}