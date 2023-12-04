import Singleton.screenNumber
import kotlin.system.exitProcess

class MenuController(private val controller: Controller) :
    Overall() {

    //Выводим меню на экран
    fun goMenu(screenNumber : Int) {
        when (screenNumber) {
            1 -> Menu.GENERAL.printMenu()
            2 -> Menu.LISTARCHIVE.printMenu()
            3 -> Menu.ARCHIVE.printMenu()
            4 -> Menu.SELECT.printMenu()
            5 -> Menu.NOTE.printMenu()
        }
    }


    //Определяем тип меню, какой необходимо выводить
    fun goCommand() {
        val number : Int = goScanner()
        if(screenNumber == 1) {
            when (number) {
                0 -> exitProcess(0)
                1 -> controller.createArchieve()
                2 -> controller.seeListArchieve()
                else -> errorMenu()
            }
        }
        else {
            val numArchive : Int = number - 1
            val archive = ArchiveController(numArchive)
            when(screenNumber) {
            2 -> archive.selectItem()
            3 -> {
                    when (number) {
                        0 -> screenNumber = 2
                        1 -> archive.createNote()
                        2 -> screenNumber = 4
                        else -> errorMenu()
                    }
                }
            4-> archive.selectNote(number)
            5 -> {
                    if(number == 0) screenNumber = 3
                    else errorMenu()
                }
            }
        }
    }

    //Обработчик сообщения об ошибке (в будущем, можно сделать отдельное для каждого экрана)
    private fun errorMenu() {
        println("Вы указали некорректную команду. Попробуйте еще раз. Нужно ввести цифру из указанному перечня")
    }

}


