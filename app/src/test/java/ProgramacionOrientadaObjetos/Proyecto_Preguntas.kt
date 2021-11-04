package ProgramacionOrientadaObjetos

import com.briggittelew.p_orientadaobjeto.proyecto.generar_Pregunta
import java.io.File

open class preguntas(var pregunta:Int,var respuesta:String){
    val fileName :String = "preguntas.txt"
    val nroPreguntas = (File(fileName).readLines().size - 2) / 2
    var arreglo = generar_Pregunta(nroPreguntas)
    var respuestaCorrecta = ""

    fun preguntar(pregunta:Int){
        //println("**** ${arreglo[pregunta]}")
        var posicion = arreglo[pregunta]
        println(File(fileName).readLines()[posicion])
        respuestaCorrecta =     File(fileName).readLines()[posicion+1]

    }

    fun respuesta1(){
        respuesta= readLine()!!
    }
    fun compararRespuesta(): Boolean{
        var str1 = respuestaCorrecta
        var str2 = respuesta
        var strboolean = false
        if (str2 != " ")
            strboolean = str1.lowercase().contains(str2.lowercase())

        if (strboolean) {
            println("Correcto")
            println(respuestaCorrecta)
        }else
            println("Incorrecto")
        return strboolean
    }
}
