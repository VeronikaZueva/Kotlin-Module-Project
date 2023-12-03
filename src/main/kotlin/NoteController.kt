class NoteController : Overall() {
    //Создание заметки
    fun createNote() : Note {
        val titleNote : String = createTitle()
        println("Введите текст заметки")
        var text : String = scanner.next()
        while(text.isEmpty()) {
            println("Вы не указали Текст заметки. Попробуйте еще раз")
            text = scanner.next()
        }
        return Note(titleNote, text)
    }
}