fun main() {
    println("PROJETO ALURA BANK")
    println("------------------")

//O uso das Labels é considerado uma boa prática em Kotlin
    val contaAlex = Conta(titular = "Alex", numero = 1000)
    contaAlex.deposita(200.0)

    val contaFran = Conta("Fran", 1001)
    contaFran.deposita(300.0)


    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println("------------------")

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("------------------")

    println("DEPOSITO NA CONTA DO ALEX")
    contaAlex.deposita(valor = 50.0)
    println(contaAlex.saldo)
    println("------------------")

    println("DEPOSITO NA CONTA DE FRAN")
    contaFran.deposita(valor = 70.0)
    println(contaFran.saldo)
    println("------------------")

    println("SACANDO 10R$ NA CONTA DO ALEX")
    contaAlex.saca(valor = 10.0)
    println(contaAlex.saldo)
    println("------------------")

    println("SACANDO 20R$ NA CONTA DE FRAN")
    contaFran.saca(valor = 20.0)
    println(contaFran.saldo)
    println("------------------")

    println("SACANDO EM 'EXECESSO' NA CONTA DE ALEX")
    contaAlex.saca(valor = 250.0)
    println(contaAlex.saldo)
    println("------------------")

    println("SACANDO EM 'EXCESSO' NA CONTA DE FRAN")
    contaFran.saca(valor = 400.0)
    println(contaFran.saldo)
    println("------------------")

    println("TRANSFERENCIA DE FRAN PARA ALEX")

    if (contaFran.transfere(400.0, contaAlex)) {
        println("TRANSFERENCIA BEM SUCEDIDA")
    } else {
        println("FALHA NA TRANSFERENCIA")
    }
    println("------------------")
    println(contaAlex.saldo)
    println("------------------")
    println(contaFran.saldo)
}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set


    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }


}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("Joao", 1002)
    var contaMaria = Conta("Maria", 1003)
    contaMaria.titular = "Maria"
    contaJoao.titular = "Joao"

    println("titular conta joão: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos() {
    println("Teste do Alura")
    var i = 0
    while (i < 5) {
        val titular = "Alex $i"
        val numeroConta = 1000 + i
        var saldo = i + 0.0


        println("titular $titular")
        println("número da conta $numeroConta")
        println("o saldo da conta $saldo")
        println()
        i++

    }

    for (i in 5 downTo 1) {
        val titular = "Alex $i"
        val numeroConta = 1000 + i
        var saldo = i + 0.0


        println("titular $titular")
        println("número da conta $numeroConta")
        println("o saldo da conta $saldo")
        println()
    }

}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }
}