import Singleton.listArchieve
import Singleton.menuController
import Singleton.screenNumber

class Controller : Overall() {

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
            Menu.SELECT.printMenu()

        }
    }

    //Просмотр детального состояния архива
    private fun seeArchieveDetail(num : Int) {
        println(listArchieve[num])
    }

    //Создаем заметку в выбранном архиве
    fun createNote() : Note {
        val titleNote : String = createTitle()
        println("Введите текст заметки")
        var text : String = scanner.next()
        while(text.isEmpty()) {
            println("Вы не указали Текст заметки. Попробуйте еще раз")
            text = scanner.next()
        }
        val note = Note(titleNote, text)
        listArchieve[num].list!!.add(note)
        return note
    }

    //Определяем тип переданного объекта


    //Код, который нужно лаконично обработать
    if (selectArchive > listArchieve.size) {
        println("Такого архива нет в списке.")
    } else {
        val num : Int = selectArchive - 1
        seeArchieveDetail(num)
        screenNumber = 3
        Menu.ARCHIVE.printMenu()
        val selectMenu: Int = goScanner()
        when(selectMenu) {
            1 ->
        }
        if(selectMenu > listArchieve[num].list.size) {
            println("Такой заметки нет в списке")
        } else {

            return
        }
    }

}