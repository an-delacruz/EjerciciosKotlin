fun main(){
    print("Ingrese la longitud del Array de passwords: ")
    val longitud = readLine().toString().toInt()
    var arrPassword:Array<Password> = Array(longitud){Password()}
    var arrEsFuerte:Array<Boolean> = Array(longitud){false}
    for (i in 0..arrPassword.size-1){
        print("Ingrese longitud de la contraseña: ")
        val longitudPassword = readLine().toString().toInt()
        arrPassword[i] = Password(longitudPassword)
        arrEsFuerte[i] = arrPassword[i].esFuerte();
    }
    for (i in 0..arrPassword.size-1){
        println("- ${arrPassword[i].getContraseña()} ${if(arrEsFuerte[i]) "Es fuerte" else "No es fuerte"}")
    }
}
class Password(){
    private var longitud: Int = 8
    private var contraseña: String = ""

    constructor(longitud:Int):this(){
        this.longitud = longitud
        this.contraseña = generarContraseña()
    }

    fun esFuerte():Boolean{
        var fuerte:Boolean = false
        var mayus:Int = 0
        var minus:Int = 0
        var digitos:Int = 0
        this.contraseña.forEach { c ->
            if(c.isUpperCase()){
                mayus++
            }else if(c.isLowerCase()){
                minus++
            }else if(c.isDigit()){
                digitos++
            }
        }
        if(mayus >= 2 && minus >=1 && digitos >= 5){
            fuerte = true
        }
        return fuerte
    }
    fun generarContraseña():String{
        var contraseña:String = ""
        val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        for (i in 0..this.longitud){
            contraseña += caracteres.random()
        }
        return contraseña

    }
    fun getContraseña():String{
        return this.contraseña
    }
    fun getLongitud():Int{
        return this.longitud
    }
    fun setLongitud(longitud:Int){
        this.longitud = longitud
    }
}