package dejkstra

import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File

fun inputgraf(dir:File){
   val exWB = WorkbookFactory.create(dir);
   val exWs = exWB.getSheetAt(0)
   for (i in 1..20){
      for(j in 1..20){
         if (exWs.getRow(7+i).getCell(6+j)!=null) {
            if (exWs.getRow(7+i).getCell(6+j).numericCellValue != 0.0) {
               graph.addArc(Integer.toString(i) to Integer.toString(j), exWs.getRow(7+i).getCell(6+j).numericCellValue)
            }
         }
      }
   }
}