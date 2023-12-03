enum class Menu : PrintMenu  {
    GENERAL {override fun printMenu() {println("0 - выход из программы; 1 - создать архив; 2 - ваш список архивов")}},
    LISTARCHIVE {override fun printMenu() {println("0 - вернуться в предыдущее меню; ИЛИ укажите номер выбранного архива для просмотра")} },
    ARCHIVE {override fun printMenu() {println("0 - вернуться в предыдущее меню; 1 - создать заметку в этом архиве; ИЛИ укажите номер выбранной заметки для просмотра")}},
    NOTE {override fun printMenu() {println("0 - вернуться к другим заметкам архива")}},
    CREATE {override fun printMenu() {println("0 - отменить действие")}};

}