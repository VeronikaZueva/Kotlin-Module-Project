import Singleton.screenNumber
import kotlin.system.exitProcess

class MenuController(private val controller: Controller) :
    Overall() {

    //Определяем тип меню, какой необходимо выводить
    fun goMenu(screenNumber: Int) {
        when (screenNumber) {
            1 -> Menu.GENERAL.printMenu()
            2 -> Menu.LISTARCHIVE.printMenu()
            3 -> Menu.ARCHIVE.printMenu()
            4 -> Menu.NOTE.printMenu()
        }
    }

    //Обработчик команд меню (Контроллер) для экранов верхнего уровня
     fun chooseCommand() {
        when(screenNumber) {
            1 -> {
                if(goScanner() == 0) exitProcess(0)
                else if(goScanner() == 1) controller.createArchieve()
                else if(goScanner() == 2) controller.seeListArchieve()
                else errorMenu()
            }
            2 -> {
                if(goScanner() == 0) goMenu(1)
                else if(goScanner() == 1) controller.createArchieve()
                else if(goScanner() == 2) goMenu(screenNumber = 3)
                else errorMenu()
            }
            3 -> {
                if(goScanner() == 0) goMenu(2)
                else if(goScanner() == 1) controller.createNote()
                else if(goScanner() == 2) goMenu(screenNumber = 4)
                else errorMenu()
            }
            4 -> {
                if(goScanner() == 0) goMenu(3)
                else errorMenu()
            }

        }

        }


    //Обработчик сообщения об ошибке (в будущем, можно сделать отдельное для каждого экрана)
    private fun errorMenu() {
        println("Вы указали некорректную команду. Попробуйте еще раз. Нужно ввести цифру из указанному перечня меню")
    }

}


