package finbonacciMemo


fun fibMemo(n : Long) : Long{

    var x : Long = 0
    var y : Long = 1

    for(i in 2..n){
        var aux : Long = x + y
        x = y
        y = aux
    }
    return y
}



fun main(args: Array<String>) {


    println("Fibonacci de 1: " + fibMemo(1))
    println("Fibonacci de 5: " + fibMemo(5))
    println("Fibonacci de 8: " + fibMemo(8))
    println("Fibonacci de 103: " + fibMemo(103))


}
