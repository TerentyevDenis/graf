package ru.graph.analis.view

import ru.graph.analis.app.Styles
import dejkstra.graph
import tornadofx.*
import javax.swing.JFrame
import edu.uci.ics.jung.visualization.VisualizationViewer
import edu.uci.ics.jung.algorithms.layout.FRLayout
import edu.uci.ics.jung.algorithms.layout.Layout
import edu.uci.ics.jung.graph.Graph
import edu.uci.ics.jung.graph.UndirectedGraph
import edu.uci.ics.jung.graph.UndirectedSparseGraph
import edu.uci.ics.jung.samples.SimpleGraphDraw.getGraph


class MainView : View("Graph plot") {

    override val root = vbox {
        prefHeight = 700.0
        prefWidth = 800.0
        add(Manubar::class)
        add(Graphtable::class)
    }
}