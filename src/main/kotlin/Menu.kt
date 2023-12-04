enum class Menu : PrintMenu  {
    GENERAL {override fun printMenu() {println("0 - выход из программы; 1 - создать архив; 2 - выбрать архив")}},
    LISTARCHIVE {override fun printMenu() {println("0 - вернуться в предыдущее меню; ИЛИ укажите номер архива, чтобы его просмотреть")} },
    ARCHIVE {override fun printMenu() {println("0 - вернуться в предыдущее меню; 1 - создать заметку в этом архиве; 2 - выбрать заметку")}},
    SELECT {override fun printMenu() {println("0 - вернуться в предыдущее меню; ИЛИ укажите номер заметки для детального просмотра")}},
    NOTE {override fun printMenu() {println("0 - вернуться к другим заметкам архива")}};
}