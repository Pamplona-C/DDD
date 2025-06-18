package DamaBeecrowd

fun main(args: Array<String>) {

    fun calculaMovimento(x1:Int,y1:Int,x2:Int,y2:Int):String {
        if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0) {
            return ""
        }else {
            if (x1 == x2 && y1 == y2){
                return "0"
            }else{
                if (x1 == x2 || y1 == y2 || (x2 - x1) == (y2 - y1) || (x2 - x1) == -(y2 - y1)) {
                   return "1"
                } else {
                    return "2"
                }
            }
        }
    }

    val input = readLine()!!.split(" ")
    val x1 = input[0].toInt()
    val y1 = input[1].toInt()
    val x2 = input[2].toInt()
    val y2 = input[3].toInt()

    println(calculaMovimento(x1, y1, x2, y2))
}
