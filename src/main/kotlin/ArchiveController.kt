import Singleton.listArchieve
import Singleton.screenNumber

class ArchiveController : Overall() {

    //Создание архива
    fun createArchieve() : Archive {
        println("Создаем архив")
        val titleArchieve : String = createTitle()
        val listNote = mutableListOf<Note>()
        println("Архив '$titleArchieve' создан")
        val arch = Archive(titleArchieve, listNote)
        listArchieve.add(arch)
        return arch
    }
    //Просмотра Списка архива
    fun seeListArchieve() {
        println("Созданные архивы:")
        if(listArchieve.size == 0) {println("У вас еще не создано ни одного архива")}
        else {
            listArchieve.forEachIndexed { index, archive ->
                val i = index + 1; println("$i. ${archive.title}")
            }
            screenNumber = 2
            while (true) {
                Menu.LISTARCHIVE.printMenu()
                val selectArchive: Int = goScanner()

                if (selectArchive > listArchieve.size) {
                    println("Такого архива нет в списке.")
                } else {
                    val num: Int = selectArchive - 1
                    screenNumber = 3
                    seeArchieveDetail(num)
                    return
                }
            }
        }
    }

    //Просмотр детального состояния архива
    private fun seeArchieveDetail(num : Int) {
        println(listArchieve[num])
    }
}