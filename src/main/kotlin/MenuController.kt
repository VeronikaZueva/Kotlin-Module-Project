import kotlin.system.exitProcess
import Singleton.screenNumber

class MenuController(private val controller: Controller) :
    Overall() {

    //Определяем тип меню, какой необходимо выводить
    fun goMenu(screenNumber : Int) {
        when (screenNumber) {
            1 -> Menu.GENERAL.printMenu()
            2 -> Menu.LISTARCHIVE.printMenu()
            3 -> Menu.ARCHIVE.printMenu()
            4 -> Menu.SELECT.printMenu()
            5 -> Menu.NOTE.printMenu()
        }
    }

    //Обработчик команд меню (Контроллер) для всех экранов
     fun chooseCommand() {
        val number : Int = goScanner()
        when(screenNumber) {
            1 -> when (number) {
                0 -> exitProcess(0)
                1 -> controller.createArchieve()
                2 -> controller.seeListArchieve()
                else -> errorMenu()
            }
            2-> {
                if(number == 0) screenNumber = 1
                else controller.selectItem(number)
            }
            3 -> {
                when (number) {
                    0 -> screenNumber = 2
                    1 -> {controller.createNote()}
                    2 -> screenNumber = 4
                    else -> errorMenu()
                }
            }
            4-> {
                if(number == 0) screenNumber = 2
                else controller.selectItem(number)
            }
            5 -> {
                if(number == 0) screenNumber = 3
                else errorMenu()
            }
        }

        }


    //Обработчик сообщения об ошибке (в будущем, можно сделать отдельное для каждого экрана)
    private fun errorMenu() {
        println("Вы указали некорректную команду. Попробуйте еще раз. Нужно ввести цифру из указанному перечня")
    }


}


