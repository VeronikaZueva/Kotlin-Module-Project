import Singleton.listArchieve
import Singleton.screenNumber
import Singleton.numArchive
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

    //Действия экрана 2 и 4: screenNumber - 2 и 4
    //Переходим на детальный просмотр нужного элемента
    fun selectItem(select: Int) {
        when (screenNumber) {
            2 -> {
                if (select > listArchieve.size) println("Такого архива нет в списке. Укажите корректное число")
                else seeArchieveDetail(select)
            }
            4 -> {
                if (select > listArchieve[select].list!!.size) {
                    println("Такой заметки нет в списке. Укажите корректное число")
                } else seeNote(select)
            }
        }
    }

    //Действия экрана 3: screenNumber - 3
    //Просмотр детального состояния архива (список заметок)
    private fun seeArchieveDetail(select: Int) {
        val num : Int = select - 1
        println("Архив '${listArchieve[num].title}':")
        println("Созданные заметки:")
        if(listArchieve[num].list!!.size == 0) {
            println("У вас еще не создано ни одной заметки")
        }
        else {
            listArchieve[num].list!!.forEachIndexed {index, note -> val i = index+1; println("$i. ${note.title}") }
            numArchive = num
        }
        screenNumber = 3
    }

    //Создаем заметку в выбранном архиве
    fun createNote() {
        val titleNote : String = createTitle()
        println("Введите текст заметки")
        var text : String = scanner.next()
        while(text.isEmpty()) {
            println("Вы не указали Текст заметки. Попробуйте еще раз")
            text = scanner.next()
        }
        val note = Note(titleNote, text)
        listArchieve[numArchive].list!!.add(note)
        println("Заметка '$titleNote' создана")
        seeArchieveDetail(numArchive)
    }

    //Просматриваем список заметок архива
    private fun seeNote(select : Int) {
        val num : Int = select - 1
        println("Ваши заметки в архиве ${listArchieve[numArchive].title}")
        println(listArchieve[numArchive].list!![num])
    }


}