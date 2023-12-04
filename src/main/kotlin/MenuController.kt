import Singleton.screenNumber
import kotlin.system.exitProcess

class MenuController(private val controller: Controller, private val archive : ArchiveController) :
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
        when(screenNumber) {
        1 -> when (number) {
                0 -> exitMenu()
                1 -> controller.createArchieve()
                2 -> controller.seeListArchieve()
                else -> errorMenu()
            }
        2 -> {
            if(number == 0) exitMenu()
            else archive.selectItem(number)
            }
        3 -> {
            when (number) {
                0 -> exitMenu()
                1 -> archive.createNote()
                2 -> screenNumber = 4
                else -> errorMenu()
            }
              }
        4-> {
             if(number == 0) exitMenu()
             else archive.selectNote(number)
           }
        5 -> {
            if(number == 0) exitMenu()
            else errorMenu()
                }
            }
        }


    //Обработчик сообщения об ошибке (в будущем, можно сделать отдельное для каждого экрана)
    private fun errorMenu() {
        println("Вы указали некорректную команду. Попробуйте еще раз. Нужно ввести цифру из указанному перечня")
    }

    //Перенаправление при выходах
    private fun exitMenu() {
        when(screenNumber) {
            1 -> exitProcess(0)
            2 -> screenNumber = 1
            3 -> {screenNumber = 2; controller.seeListArchieve()}
            4 -> {screenNumber = 3; archive.seeArchiveDetail()}
            5 -> {screenNumber = 3; archive.seeArchiveDetail()}
        }
    }

}


