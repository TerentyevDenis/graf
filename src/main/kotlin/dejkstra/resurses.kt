package dejkstra
import MyGraph
import ru.graph.analis.Models.Row
import javafx.collections.ObservableArray
import javafx.collections.ObservableList
import shortestPath
import tornadofx.*
import java.util.*
import kotlin.collections.ArrayList

val graph = MyGraph<String, Double>(directed = false, defaultCost = 1.0)

fun fillDataforTable(): ObservableList<Row>{
    var result = ArrayList<Row>(20)
    for (i in 0..19){
        if (result.size<20) {
            result.add(i, Row())
        }
        for (j in 0..19){
            val (path, value) = shortestPath(graph,(i+1).toString(),(j+1).toString() )
//            print("$i, $j")
//            println("path = $path, value = $value")
            if (value!= Double.POSITIVE_INFINITY) {
                result.get(i).cols.add(j, "$value, path = $path")
            }else
                result.get(i).cols.add(j, "0")
        }
    }
    return result.observable()
}