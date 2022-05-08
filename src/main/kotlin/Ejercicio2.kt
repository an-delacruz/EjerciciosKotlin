import kotlin.math.floor

fun main() {
    //     println("Hello, world!!!")
    println("Datos persona 1")
    println("Ingrese el nombre: ");
    val nombre = readLine().toString();
    println("Ingrese la edad: ");
    val edad = readLine().toString().toInt()
    println("Ingrese el genero (H/M): ");
    val genero = readLine().toString().single();
    println("Ingrese el peso: ");
    val peso = readLine().toString().toDouble()
    println("Ingrese la altura: ");
    val altura = readLine().toString().toDouble()
    val persona1 = Persona(nombre,edad,genero,peso,altura);

    println("Datos persona 2")
    println("Ingrese el nombre: ");
    val nombre2 = readLine().toString();
    println("Ingrese la edad: ");
    val edad2 = readLine().toString().toInt()
    println("Ingrese el genero (H/M): ");
    val genero2 = readLine().toString().single();
    val persona2 = Persona(nombre2,edad2,genero2);

    println("Datos persona 3")
    println("Ingrese el nombre: ");
    val nombre3 = readLine().toString();
    println("Ingrese la edad: ");
    val edad3 = readLine().toString().toInt()
    println("Ingrese el genero (H/M): ");
    val genero3 = readLine().toString().single();
    println("Ingrese el peso: ");
    val peso3 = readLine().toString().toDouble()
    println("Ingrese la altura: ");
    val altura3 = readLine().toString().toDouble()
    val persona3 = Persona();
    persona3.setNombre(nombre3);
    persona3.setEdad(edad3);
    persona3.setSexo(genero3);
    persona3.setPeso(peso3);
    persona3.setAltura(altura3);

    val pesoIdealPersona1 = if(persona1.calcularIMC() == 1) "Sobrepeso" else if(persona1.calcularIMC() == 0) "Peso Ideal" else "Por debajo"
    val pesoIdealPersona2 = if(persona2.calcularIMC() == 1) "Sobrepeso" else if(persona2.calcularIMC() == 0) "Peso Ideal" else "Por debajo"
    val pesoIdealPersona3 = if(persona3.calcularIMC() == 1) "Sobrepeso" else if(persona3.calcularIMC() == 0) "Peso Ideal" else "Por debajo"

    val esMayorPersona1 = if(persona1.esMayorDeEdad()) "Si" else "No"
    val esMayorPersona2 = if(persona2.esMayorDeEdad()) "Si" else "No"
    val esMayorPersona3 = if(persona3.esMayorDeEdad()) "Si" else "No"

    val DNIPersona1 = persona1.generarDNI()
    val DNIPersona2 = persona2.generarDNI()
    val DNIPersona3 = persona3.generarDNI()

    println("Persona 1: \n${persona1.toString()} \nPeso: $pesoIdealPersona1 \nEs mayor de edad: $esMayorPersona1 \nDNI: $DNIPersona1")
    println("Persona 2: \n${persona2.toString()} \nPeso: $pesoIdealPersona2 \nEs mayor de edad: $esMayorPersona2 \nDNI: $DNIPersona2")
    println("Persona 3: \n${persona3.toString()} \nPeso: $pesoIdealPersona3 \nEs mayor de edad: $esMayorPersona3 \nDNI: $DNIPersona3")
}
    class Persona()
    {
        //Atributos
        private var nombre:String = ""
        private var edad:Int = 0
        private var DNI:String = ""
        private var sexo:Char = 'M'
        private var peso:Double = 0.0
        private var altura:Double = 0.0
        
        //Constructores secundarios
        constructor(nombre:String, edad:Int, sexo:Char):this(){
            this.nombre = nombre;
			this.edad = edad;
            this.sexo = sexo
        }
        constructor(nombre:String, edad:Int, sexo:Char, peso:Double, altura:Double):this(){
            this.nombre = nombre;
			this.edad = edad;
            this.sexo = sexo;
            this.peso = peso;
            this.altura = altura;
        }
        fun setNombre(nom:String){
            this.nombre = nom;
        }
        fun setEdad(edad:Int){
            this.edad = edad;
        }
        fun setSexo(sexo:Char){
            this.sexo = sexo;
        }
        fun setPeso(peso:Double){
            this.peso = peso;
        }
        fun setAltura(altura:Double){
            this.altura = altura;
        }
        fun calcularIMC():Int{
            val IMC = this.peso/(this.altura*this.altura);
            if(IMC < 20){
                return -1
            }else if(IMC > 25){
                return 1
            }else{
                return 0
            }
        }
        fun esMayorDeEdad():Boolean{
        	return this.edad >= 18
        }
        fun comprobarSexo(sexo:Char){
            if(this.sexo != sexo){
                this.sexo = 'H'
            }
        }
        override fun toString():String{
            return "Nombre: $nombre\nEdad: $edad\nDNI: " +
                    "$DNI\nSexo: $sexo\nPeso: $peso\nAltura: " +
                    "$altura"
        }

        fun generarDNI():String{
            var numeros = ""
            for(i in 0..7){
                numeros += floor((Math.random()*10)).toInt().toString()
            }
            println(numeros)
            val numero = numeros.toInt() % 23
            val dni = numeros + this.generarLetraDNI(numero).toString()
            return dni
        }
        fun generarLetraDNI(num: Int):Char{
            println(num)
            val letras: Map <Int, Char> = mapOf(Pair(0,'T'), Pair(1,'R'), Pair(2,'W'), Pair(3,'A'),
                Pair(4,'G'), Pair(5,'M'), Pair(6,'Y'), Pair(7,'F'), Pair(8,'P'), Pair(9,'D'),
                Pair(10,'X'), Pair(11,'B'), Pair(12,'N'), Pair(13,'J'), Pair(14,'Z'),
                Pair(15,'S'), Pair(16,'Q'), Pair(17,'V'), Pair(18,'H'), Pair(19,'L'),
                Pair(20,'C'), Pair(21,'K'), Pair(22,'E'))

            return letras[num]!!
        }

        
    }
