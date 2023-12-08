import java.lang.Exception

fun main() {
    val bank = Bank()
    val handler = CommandHandler(bank)
    var status: Status

    do {
        handler.printCommands()
        status = handler.getCommand()

        try {
            when (status) {
                Status.Browse -> bank.browseAccounts()
                Status.Open -> {
                    print("Введите имя счёта (поле не должно быть пустым): ")
                    val name = handler.getValidName()
                    bank.createAccount(name)
                }

                Status.Refill -> {
                    print("Введите сумму пополнения: ")
                    val sum = handler.getValidSum()
                    val account = bank.getValidAccount()
                    bank.refillAccount(account, sum)
                }

                Status.Transfer -> {
                    val pair = handler.getValidPairOfAccounts()
                    val src = pair.first
                    val dest = pair.second
                    print("Введите сумму пополнения: ")
                    val sum = handler.getValidSum()
                    bank.transferMoney(src, dest, sum)
                }

                else -> {}
            }
        } catch (e: Exception) {
            println(e.message)
        }
    } while (status != Status.Exit)

    println("Работа завершена")
}
