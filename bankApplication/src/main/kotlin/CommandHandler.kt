enum class Status {
    Browse, Open, Refill, Transfer, Exit
}

class CommandHandler(bank: Bank) {
    private val commands: Array<String> =
        arrayOf("Просмотр списка счетов", "Открытие счета", "Пополнение счёта", "Перевод денег между счетами", "Выход")
    private val bank: Bank

    init {
        this.bank = bank
    }

    fun printCommands() {
        var i = 1
        for (command in commands) {
            println("${i++}. $command")
        }
    }

    fun getCommand(): Status {
        var number: Int
        while (true) {
            try {
                number = readlnOrNull()?.toInt() ?: 0
                if (number !in 1..5) throw java.lang.NumberFormatException()
                break
            } catch (e: NumberFormatException) {
                println("Ошибка! Введите целое число от 1 до 5")
            }
        }

        return when (number) {
            1 -> Status.Browse
            2 -> Status.Open
            3 -> Status.Refill
            4 -> Status.Transfer
            else -> Status.Exit
        }
    }


    fun getValidName(): String {
        print("Введите имя счёта (поле не должно быть пустым): ")
        var name = readlnOrNull()
        while (name!!.isEmpty()) {
            println("Ошибка! Имя не может быть пустым")
            name = readlnOrNull()
        }

        return name
    }

    fun getValidSum(): Float {
        print("Введите сумму пополнения: ")
        var sum: Float
        while (true) {
            try {
                sum = readlnOrNull()!!.toFloat()
                while (sum <= 0) {
                    println("Ошибка! Введите положительную сумму денег")
                    sum = readlnOrNull()!!.toFloat()
                }
                break
            } catch (e: Exception) {
                println("Ошибка! Введите число")
            }

        }

        return sum
    }
}