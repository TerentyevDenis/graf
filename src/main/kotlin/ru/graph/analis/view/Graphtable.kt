package ru.graph.analis.view
import ru.graph.analis.Models.Row
import javafx.beans.property.StringProperty
import javafx.collections.FXCollections
import javafx.scene.control.TableColumn
import javafx.scene.layout.Priority
import tornadofx.*
import java.util.regex.PatternSyntaxException

class Graphtable : Fragment() {

    override val root = tableview(row) {
        for (i in 1..20) {
            column(i.toString(), Row::getElem).remainingWidth().isSortable=false
        }
        columnResizePolicy = SmartResize.POLICY
        hgrow=Priority.ALWAYS
        vgrow=Priority.ALWAYS
    }

}
val row = FXCollections.observableArrayList<Row>()


