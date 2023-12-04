import Singleton.listArchieve
import Singleton.numArchive
import Singleton.screenNumber

class ArchiveController : Overall() {
    //Смотрим, есть ли у нас такой архив
    fun selectItem(numberArchive : Int) {
        if (numberArchive > listArchieve.size) println("Такого архива нет в списке. Укажите корректное число")
        else {
            numArchive = numberArchive - 1
            seeArchiveDetail()
        }
    }
    //Просматриваем архив детально
     fun seeArchiveDetail() {
        println("Архив '${listArchieve[numArchive].title}'.")
        println("Созданные заметки:")
        if (listArchieve[numArchive].list!!.size == 0) println("У вас еще не создано ни одной заметки")
        else listArchieve[numArchive].list!!.forEachIndexed { index, note -> val i = index + 1; println("$i. ${note.title}") }
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
        seeArchiveDetail()
    }
    fun selectNote(num : Int) {
        if (num > listArchieve[numArchive].list!!.size) {
            println("Такой заметки нет в списке. Укажите корректное число")
        } else {
            screenNumber = 5
            seeNote(num)
        }
    }
    //Просматриваем заметку
    private fun seeNote(select : Int) {
        val num : Int = select - 1
        println("Расположение: '${listArchieve[numArchive].title}'")
        println("Название: '${listArchieve[numArchive].list!![num].title}'")
        println("Текст: '${listArchieve[numArchive].list!![num].text}'")
    }


}