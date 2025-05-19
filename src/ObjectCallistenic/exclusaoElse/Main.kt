package ObjectCallistenic.exclusaoElse

fun main() {


    // Aqui uma funcao usando ELSE
    fun pode_entrar(idade : Int) : String{
        if (idade >= 18) {
            return "Pode entrar"
        }else{
            return "Menor de idade, não pode entrar"
        }
    }

    // Aqui a mesma funcao aplicada o principio de evitar else, as duas funcionam perfeitamente
    fun pode_entrar2(idade : Int) : String{
        if (idade <= 18) {
            return "Menor de idade, não pode entrar"
        }
        return "Pode entrar"
    }
}
