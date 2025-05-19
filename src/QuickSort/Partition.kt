package QuickSort

class Partition {

    fun swap(array : IntArray,i : Int, j : Int){
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    fun partition(array : IntArray, inicio : Int, fim : Int) : Int {
        var pivo = array[fim]
            var i = inicio -1

        for (j in inicio until fim){
            if (array[j] < pivo){
                    i = i + 1
                swap(array, i, j)
            }
        }
        swap(array, i+1, fim)
        return i + 1
        }
}
