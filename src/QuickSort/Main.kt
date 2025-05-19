package QuickSort

fun main() {

    val quickSort = QuickSort()

    var array : IntArray = intArrayOf(5,9,1,3,6,2)

    println("Antes da ordenação : ")
    for (i in array){
        println(i)
    }

    quickSort.quickSort(array,0, array.size-1)

    println("Depois da ordenação : ")
    for (i in array){
        println(i)
    }

}
