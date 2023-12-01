import java.util.Scanner

class Menu {
    fun menuCommand(numberScreen : Int) {
        //Метод определения экрана
        when(numberScreen) {
            1 -> println("Вызываем метод просмотра списков архивов и списков")
            2 -> println("Вызываем просмотр архива")
            3 -> println("Вызываем просмотр заметки")
            4 -> {createNote(); println("Заметка успешно создана")}
            5 -> {createArchieve(); println("Архив успешно создан")}
            else -> println("Что-то пошло не так...")
        }
    }

    private val scanner =  Scanner(System.`in`)

    //Методы действий
    //Создаем заголовок
    private fun createTitle() : String {
        println("Укажите название")
        var title : String = scanner.nextLine()
        while(title.isEmpty()) {
            println("Вы не указали название. Попробуйте еще раз")
            title = scanner.nextLine()
        }
        return title
    }
    //Создание архива
    private fun createArchieve() : Archive {
        val titleArchieve : String = createTitle()
        val listNote = mutableListOf<Note>()

        return Archive(titleArchieve, listNote)
    }

    //Создание заметки
    private fun createNote() : Note {
        val titleNote : String = createTitle()
        println("Введите текст заметки")
        var text : String = scanner.nextLine()
        while(text.isEmpty()) {
            println("Вы не указали Текст заметки. Попробуйте еще раз")
            text = scanner.nextLine()
        }
        return Note(titleNote, text)
    }
}