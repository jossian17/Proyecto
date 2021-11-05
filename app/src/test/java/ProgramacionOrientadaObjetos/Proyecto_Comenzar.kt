package ProgramacionOrientadaObjetos

class Comenzar_Preguntas() {
    fun Comenzar(){
        val puntos1=Camino()
        var contarPregunta = 0
        var desde = 0
        while (desde < 7) {
            val distanciaAB = Camino()
            distanciaAB.Calcular_Distancia(puntos1.comenzarCamino(), desde)
            var pregunta = preguntas(contarPregunta, "a")
            pregunta.preguntar(contarPregunta)
            do {
                var esCorrecta = false
                pregunta.respuesta1()
                if (pregunta.compararRespuesta()) {
                    contarPregunta++
                    desde++
                    esCorrecta = true
                    if (desde == 7) {
                        println("FELICITACIONES LLEGASTE!!!!")
                        break
                    }
                } else
                    println("Intente nuevamente")
            } while (!esCorrecta)
        }
    }
}
