package BhaskaraBeecrowd

fun Delta(b:Double, a: Double, c: Double): Double {
    return (b * b) - (4 * a * c)
}

fun main(args: Array<String>){

    val input = readLine()!!.split(" ")
    val a = input[0].toDouble()
    val b = input[1].toDouble()
    val c = input[2].toDouble()

    val delta = Delta(b,a,c)

    if (a != 0.0 && delta > 0.0){
        var R1 = String.format("%.5f",(-(b) + Math.sqrt(delta)) / (2 * a))

        var R2 = String.format("%.5f",(-(b) - Math.sqrt(delta)) / (2 * a))

        println("R1 = $R1")
        println("R2 = $R2")

    }else{
        println("Impossivel calcular")
    }


}
