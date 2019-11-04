package ru.graph.analis.view

import dejkstra.graph
import edu.uci.ics.jung.algorithms.layout.FRLayout
import edu.uci.ics.jung.graph.Graph
import edu.uci.ics.jung.graph.UndirectedSparseGraph
import edu.uci.ics.jung.visualization.VisualizationViewer
import edu.uci.ics.jung.visualization.renderers.Renderer
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import sun.swing.JLightweightFrame
import tornadofx.*
import java.awt.Dimension
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.swing.JFrame

class PlotGraph : JFrame("Source graph ") {
    init{
        val g: Graph<String, Double> = UndirectedSparseGraph();
        graph.edges.forEach { t ->
            try {
                g.addEdge(t.value, t.from, t.to)
            } catch (e: IllegalArgumentException) {
            }
        }
        val jf = JFrame()
        val l = FRLayout(g)
        val preferredSize = Dimension(1000, 1000)
        val vv = VisualizationViewer(l, preferredSize)
        vv.renderContext.setVertexLabelTransformer { t -> t }
        vv.renderer.vertexLabelRenderer.position = Renderer.VertexLabel.Position.CNTR
        vv.size = preferredSize
        val df = DecimalFormat("#.##")
        df.setRoundingMode(RoundingMode.CEILING)
        vv.renderContext.setEdgeLabelTransformer { t -> df.format(t) }
        jf.contentPane.add(vv)
        jf.defaultCloseOperation = 3
        jf.pack()
        jf.isVisible = true
    }
}
