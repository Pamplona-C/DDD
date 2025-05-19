
package QuickSort

class QuickSort{

    val partition = Partition()

    fun quickSort(array : IntArray, inicio : Int, fim : Int) : IntArray{
        if (inicio < fim){
            val pi = partition.partition(array,inicio,fim)
            quickSort(array,inicio, pi-1)
            quickSort(array, pi+1, fim)
        }

        return array
    }

}
