package pl.unittest.seventh_lab

import spock.lang.Specification

class BankSpec extends Specification {

    def "should create accounts with unique numbers"() {
        given:
        def bank = new Bank()

        when:
        def acc1 = bank.createAccount()
        def acc2 = bank.createAccount()

        then:
        acc1 == 1
        acc2 == 2
    }

    def "should deposit money to an existing account"() {
        given:
        def bank = new Bank()
        def acc = bank.createAccount()

        when:
        def success = bank.deposit(acc, 100)

        then:
        success
        bank.getBalance(acc) == 100
    }

    def "should not deposit to non-existing account"() {
        given:
        def bank = new Bank()

        expect:
        !bank.deposit(1, 100)
    }

    def "should withdraw if there are sufficient funds"() {
        given:
        def bank = new Bank()
        def acc = bank.createAccount()
        bank.deposit(acc, 150)

        when:
        def success = bank.withdraw(acc, 100)

        then:
        success
        bank.getBalance(acc) == 50
    }

    def "should not allow overdrawn withdrawal"() {
        given:
        def bank = new Bank()
        def acc = bank.createAccount()
        bank.deposit(acc, 50)

        expect:
        !bank.withdraw(acc, 100)
        bank.getBalance(acc) == 50
    }

    def "should perform a transfer between accounts"() {
        given:
        def bank = new Bank()
        def acc1 = bank.createAccount()
        def acc2 = bank.createAccount()
        bank.deposit(acc1, 200)

        when:
        def success = bank.transfer(acc1, acc2, 150)

        then:
        success
        bank.getBalance(acc1) == 50
        bank.getBalance(acc2) == 150
    }

    def "should not transfer if source account has insufficient funds"() {
        given:
        def bank = new Bank()
        def acc1 = bank.createAccount()
        def acc2 = bank.createAccount()
        bank.deposit(acc1, 50)

        expect:
        !bank.transfer(acc1, acc2, 100)
        bank.getBalance(acc1) == 50
        bank.getBalance(acc2) == 0
    }

    def "should return -1 when querying non-existent account"() {
        given:
        def bank = new Bank()

        expect:
        bank.getBalance(999) == -1
    }

    def "should correctly close an account and return its balance"() {
        given:
        def bank = new Bank()
        def acc = bank.createAccount()
        bank.deposit(acc, 250)

        when:
        def closedBalance = bank.closeAccount(acc)

        then:
        closedBalance == 250
        bank.getBalance(acc) == -1
    }

    def "should calculate total treasury balance correctly"() {
        given:
        def bank = new Bank()
        def acc1 = bank.createAccount()
        def acc2 = bank.createAccount()
        bank.deposit(acc1, 100)
        bank.deposit(acc2, 200)

        expect:
        bank.getTreasuryBalance() == 300
    }

    def "should not allow deposit of negative amount"() {
        given:
        def bank = new Bank()
        def acc = bank.createAccount()

        expect:
        !bank.deposit(acc, -50)
        bank.getBalance(acc) == 0
    }

    def "should not allow withdrawal of negative amount"() {
        given:
        def bank = new Bank()
        def acc = bank.createAccount()
        bank.deposit(acc, 100)

        expect:
        !bank.withdraw(acc, -20)
        bank.getBalance(acc) == 100
    }
}

