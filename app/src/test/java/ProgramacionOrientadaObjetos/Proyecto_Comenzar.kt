package ProgramacionOrientadaObjetos

class Comenzar_Preguntas() {
    fun comenzarCamino() {
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
        var contarPregunta = 0
        var desde = 0
        while (desde < 7) {
            val distanciaAB = Camino()
            distanciaAB.Calcular_Distancia(puntos, desde)
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