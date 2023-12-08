import java.lang.Exception

class Bank {
    private var accounts: ArrayList<BankAccount> = arrayListOf()
    private var accountCounter = 1

    fun browseAccounts() {
        if (accounts.isEmpty()) throw Exception("Ошибка! Нет открытых счетов")
        for (account in accounts) {
            println(account.toString())
        }
    }

    fun createAccount(name: String) {
        accounts.add(BankAccount(name, 0.0f, accountCounter++))
    }

    fun refillAccount(account: BankAccount, sum: Float) {
        account.balance += sum
    }

    fun transferMoney(src: BankAccount, dest: BankAccount, money: Float) {
        dest.balance += money
        src.balance -= money
    }

    fun getValidAccount(): BankAccount {
        if (accounts.isEmpty()) {
            throw Exception("Ошибка! Нет открытых счетов")
        }
        var index = readlnOrNull()!!.toInt()
        while (index !in 0..<accounts.size) {
            index = readlnOrNull()!!.toInt()
        }

        return accounts[index]
    }
}