/*
2. Extend the BankAccount class of the preceding exercise into a class SavingsAccount that earns interest
every month (when a method earnMonthlyInterest is called) and has three free deposits or
withdrawals every month. Reset the transaction count in the earnMonthlyInterest method.
 */

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def currentBalance = balance

  def deposit(amount: Double) = {
    balance += amount;
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount;
    balance
  }
}

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var transactionCount = 0

  /**
    * Additional transactions after this limit are taxed with $1
    */
  private val nrFreeTransactions = 3

  /**
    * Montlhy interest multiplier
    */
  private val interestMultiplier: Double = 0.1

  def earnMonthlyInterest: Double = {
    transactionCount = 0
    super.deposit(currentBalance * interestMultiplier)
  }

  override def deposit(amount: Double): Double = {
    transactionCount += 1
    if (transactionCount > nrFreeTransactions) {
      super.deposit(amount - 1)
    } else {
      super.deposit(amount)
    }
  }

  override def withdraw(amount: Double): Double = {
    transactionCount += 1
    if (transactionCount > nrFreeTransactions) {
      super.withdraw(amount + 1)
    } else {
      super.withdraw(amount)
    }
  }
}