import kotlin.Exception

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
                    val name = handler.getValidName()
                    bank.createAccount(name)
                }

                Status.Refill -> {
                    val account = bank.getValidAccount(true)
                    val sum = handler.getValidSum()
                    bank.refillAccount(account, sum)
                }

                Status.Transfer -> {
                    val pair = bank.getValidPairOfAccounts()
                    val src = pair.first
                    val dest = pair.second
                    while (true) {
                        try {
                            val sum = handler.getValidSum()
                            bank.transferMoney(src, dest, sum)
                            break
                        } catch (e: Exception) {
                            println(e.message)
                        }
                    }
                }

                else -> {}
            }
        } catch (e: Exception) {
            println(e.message)
        }
    } while (status != Status.Exit)
}
