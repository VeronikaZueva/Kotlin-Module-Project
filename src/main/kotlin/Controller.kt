import Singleton.listArchieve
import Singleton.screenNumber

class Controller : Overall() {
//Действия экрана 1: screenNumber - 1
    //Создание архива
    fun createArchieve() {
        println("Создаем архив")
        val titleArchieve : String = createTitle()
        val listNote = mutableListOf<Note>()
        println("Архив '$titleArchieve' создан")
        val arch = Archive(titleArchieve, listNote)
        listArchieve.add(arch)
    }
    //Просмотр Списка архивов
    fun seeListArchieve() {
        println("Созданные архивы:")
        if(listArchieve.size == 0) {println("У вас еще не создано ни одного архива")}
        else {
            listArchieve.forEachIndexed { index, archive -> val i = index + 1; println("$i. ${archive.title}") }
            screenNumber = 2
        }
    }



}