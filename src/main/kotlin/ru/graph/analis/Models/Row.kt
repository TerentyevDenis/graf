package ru.graph.analis.Models

class Row {
    var cols = ArrayList<String>(20)

    fun getElem():String{
        var res = cols.get(indexOfRow)
        if (indexOfRow <19){
            indexOfRow++
        }else indexOfRow =0
        return res
    }
}
var indexOfRow:Int=0