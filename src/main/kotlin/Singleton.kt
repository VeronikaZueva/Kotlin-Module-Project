object Singleton  {
    var screenNumber : Int = 1
    var numArchive : Int = 0
    var listArchieve : MutableList<Archive> = mutableListOf()
    val menuController = MenuController(Controller(), ArchiveController())
}