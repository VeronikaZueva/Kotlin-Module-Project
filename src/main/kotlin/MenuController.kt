import Singleton.screenNumber
import kotlin.system.exitProcess

class MenuController(private val archiveController: ArchiveController, private val noteController: NoteController) :
    Overall() {

    //Определяем тип меню, какой необходимо выводить
    fun goMenu(screenNumber: Int) {
        when (screenNumber) {
            1 -> Menu.GENERAL.printMenu()
            2 -> Menu.LISTARCHIVE.printMenu()
            3 -> Menu.ARCHIVE.printMenu()
            4 -> Menu.NOTE.printMenu()
            5 -> Menu.CREATE.printMenu()
        }
    }

    //Обработчик сканнера
     fun chooseCommand() {
         when (goScanner()) {
                0 -> {
                    if (screenNumber == 1) exitProcess(0)
                    else println("Пока ничего не делаем")

                }

                1 -> {
                    if (screenNumber == 1) {
                        archiveController.createArchieve()
                    }
                    else noteController.createNote()
                }

                2 -> {
                    if (screenNumber == 1) archiveController.seeListArchieve()
                }

                else -> {
                    println("Такой команды нет в меню. Попробуйте ввести комаду еще раз")

                }

            }

        }


}


