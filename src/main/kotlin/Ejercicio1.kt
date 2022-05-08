
fun main() {
    //     println("Hello, world!!!")
        val cuenta = Cuenta("Antonio",20.5);
        cuenta.ingresar(5.5);
        cuenta.retirar(1.0);
        println(cuenta.toString())
    }
    /*Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad (puede tener decimales).
    El titular será obligatorio y la cantidad es opcional. Crea dos constructores que cumpla lo anterior.
    Utiliza sus métodos get, set y toString… Recuerda que estos por default se heredan de la clase Any.
    Tendrá dos métodos especiales:
    	ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
    	retirar(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.
    */
    class Cuenta(private var titular:String = "")
    {
        //private var titular:String = "";
        private var cantidad:Double = 0.0;
        
        constructor(titular:String, cantidad:Double):this(titular){
            this.titular = titular;
            this.cantidad = cantidad
        }   
        fun getTitular():String{
            return titular
        }
        fun setTitular(nuevoTitular:String){
            this.titular = nuevoTitular
        }
        fun getCantidad():Double{
            return cantidad
        }
        fun setCantidad(cantidad:Double){
            this.cantidad = cantidad
        }
        override fun toString():String{
            return "Titular: $titular, Cantidad: $cantidad";
        }
        fun ingresar(cantidad:Double){
            if(cantidad > 0){
                this.cantidad += cantidad;
            }
        }
        fun retirar(cantidad:Double){
            if(this.cantidad - cantidad < 0){
                this.cantidad = 0.0;
            }else{
                this.cantidad -= cantidad;
            }
        }   
    }
