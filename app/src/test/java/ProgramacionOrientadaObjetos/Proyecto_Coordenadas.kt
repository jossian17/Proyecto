package ProgramacionOrientadaObjetos


import kotlin.math.sqrt
/**Juego de caza del tesoro, preguntas y respuestas*/
/*Declaración de clases para calcular distancias entre puntos reales*/
//Mapas a utilizar
enum class Mapa(val distancia: Double){
    VIZCAYA(85.31),
    ESPAÑA(1178.46),
    ARIZGOITI(0.02)
}
//Clase de datos para la gestion de coordenadas
data class Coordenada(val latitud: Double, val longitud: Double, val ubicacion: String)

//Clase abstracta para escalar mapas y distancias
abstract class Escalar(){
    var escala = 0.0
    abstract fun Calcular()
}
open class Escalar_Mapa(var origen: Mapa, var destino: Mapa): Escalar() {
    var origenmts = origen.distancia * 1000
    var destinomts = destino.distancia * 1000

    override fun Calcular() {
        escala = origenmts / destinomts
        //println("${origen.distancia} kms ($origenmts mts) / " +
        //"${destino.distancia} kms ($destinomts mts)")
        //println("Dimensiones de la escala: 1/${escala.roundToInt()}")
    }

    fun Escalar_Distancia(distanciaAB: Double) {
        val escalaDistancia = (distanciaAB * 1000) / escala
        print("${Math.round(escalaDistancia * 100) / 100.0} pasos hacia el ")
    }
}
open class Camino() {

    fun Calcular_Distancia(puntos: Array<Coordenada>, puntoOrigen: Int): Double {
        if (puntoOrigen == 0)
            println("Bienvenido a ${puntos[puntoOrigen].ubicacion.uppercase()}")
        else
            println()
        var distanciaAB = 0.0
        var roundDistancia = 0.0
        if (puntoOrigen <= 6) {
            println("Siguiente localización ${puntos[puntoOrigen + 1].ubicacion.uppercase()}")
            distanciaAB = sqrt(
                Math.pow((puntos[puntoOrigen + 1].latitud - puntos[puntoOrigen].latitud), 2.0) +
                        Math.pow(
                            (puntos[puntoOrigen + 1].longitud - puntos[puntoOrigen].longitud),
                            2.0
                        )
            ) * 100

            roundDistancia = Math.round(distanciaAB * 100) / 100.0
            /* println("Siguiente punto ${puntos[puntoOrigen+1].ubicacion.uppercase()} distancia ")
      */
        }
        return roundDistancia.toDouble()

    }

    fun Calcular_Rumbo(puntos: Array<Coordenada>, puntoOrigen: Int): String {
        val rumboX = puntos[puntoOrigen + 1].latitud - puntos[puntoOrigen].latitud
        val rumboY = puntos[puntoOrigen + 1].longitud - puntos[puntoOrigen].longitud
        val rumboFinal = when {
            rumboX > 0 && rumboY > 0 -> "norte"
            rumboX > 0 && rumboY < 0 -> "oeste"
            rumboX < 0 && rumboY < 0 -> "sur"
            else -> "este"
        }
        return rumboFinal
    }

    fun comenzarCamino(): Array<Coordenada> {
        val definirEscala = Escalar_Mapa(Mapa.VIZCAYA, Mapa.ARIZGOITI)
        definirEscala.Calcular()
        val puntos: Array<Coordenada> = arrayOf(
            Coordenada(43.45367, -2.75221, "Cabo Machichaco"),
            Coordenada(43.31336, -2.67962, "Casa de Juntas Gernika"),
            Coordenada(43.26614, -2.93799, "Museo de Bellas Artes de Bilbao"),
            Coordenada(43.30148, -3.04201, "Funicular de Larreineta"),
            Coordenada(43.25329, -3.13091, "Torre Loizaga"),
            Coordenada(43.19879, -2.83914, "Embalse Lekubaso"),
            Coordenada(43.17481, -2.81030, "Argiñatxe Kobak"),
            Coordenada(42.98596, -2.83197, "Parque Natural Gorbeia")
        )
        return puntos
    }
}
