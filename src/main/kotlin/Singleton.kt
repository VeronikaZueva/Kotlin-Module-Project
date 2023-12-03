object Singleton {
    var screenNumber : Int = 1
    var listArchieve : MutableList<Archive> = mutableListOf()
    val menuController = MenuController(Controller())
}