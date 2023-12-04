object Singleton {
    var listArchieve : MutableList<Archive> = mutableListOf()
    val menuController = MenuController(Controller())
    //Задаем переменные, которые будут менять свое состояние по ходу выполнения программы
    var screenNumber : Int = 1
}