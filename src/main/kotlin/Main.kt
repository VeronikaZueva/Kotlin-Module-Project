import Singleton.screenNumber

fun main() {
    println("Привет! В этом приложении ты можешь создавать заметки и управлять архивами (списками) созданных заметок")
    println("Начнем...")
    //Создаем обработчик нашего меню, который позволит нам осуществить дальнейшие редиректы
    val menuController = MenuController(ArchiveController(), NoteController())
    while(true) {
        //Выводим меню на экран
        menuController.goMenu(screenNumber)
        //Вызываем обработчик меню
        menuController.chooseCommand()
    }

}