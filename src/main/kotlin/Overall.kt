import java.util.Scanner


open class Overall {
    //Даем пользователю возможность определиться. Для этого создаем scanner
    val scanner = Scanner(System.`in`).useDelimiter("\\n")!!

    //Считываем ввод пользователя и запускаем обработку команд
    fun goScanner() : Int {
        //Запускаем сканнер, попутно осуществляя его валидацию
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt()
            } else {
                println("Вы ввели не число. Пожалуйста, укажите корректное значение")
                scanner.next()
            }

        }
    }

    //Создаем заголовок - общий метод
    fun createTitle() : String {
        println("Укажите название:")
        while(true) {
            val title : String = scanner.next()
            if(title.isEmpty()) {
                println("Название не может быть пустым")
            }
            else { return title }
        }
    }


}