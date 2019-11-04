package ru.graph.analis.view

import dejkstra.fillDataforTable
import dejkstra.graph
import dejkstra.inputgraf
import edu.uci.ics.jung.algorithms.layout.FRLayout
import edu.uci.ics.jung.graph.DirectedSparseGraph
import edu.uci.ics.jung.graph.Graph
import edu.uci.ics.jung.graph.UndirectedSparseGraph
import edu.uci.ics.jung.visualization.VisualizationViewer
import edu.uci.ics.jung.visualization.renderers.Renderer
import javafx.scene.Node
import javafx.stage.FileChooser
import org.apache.commons.collections4.Transformer
import tornadofx.*
import java.awt.Dimension
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.swing.JFrame
import javax.swing.text.Position

class Manubar : Fragment() {
    override val root = menubar() {
        menu("File") {
            item("Add task file") {
                this.setOnAction {
                    val ef = arrayOf(FileChooser.ExtensionFilter("EXEL file of the task (.xlsm)", "*.xlsm"))
                    var dir = tornadofx.chooseFile("Single + non/block", ef, FileChooserMode.Single)
                    if (!dir.isEmpty()) {
                        run {
                            inputgraf(dir.get(0))
                            if (row.isNotEmpty()) {
                                row.clear()
                            }
                            row.clear()
                            row.addAll(fillDataforTable())
                            PlotGraph()
                        }
                    }
                }
            }
        }
    }
}