import scala.util.Random

object GameOfLife {

  def generateCells(size: Int) = {
    (0 until size).map{x =>
      (0 until size).map {y =>
        Cell(randomize, Pos(x, y))
      }.toList
    }.toList
  }

  def randomize: Status.Value = {
    if (Random.nextInt() > 0) Status.ALIVE else Status.DEAD
  }

  def printGrind(grid: Grid): Unit = {
    print("\033[H\033[2J")

    grid.getCells.foreach{row =>
      row.foreach( cell => if(cell.isAlive) print(" * ") else print("   "))
      println()
    }

    Thread.sleep(500)
  }

  def main (args: Array[String]) {

    var grid = Grid(generateCells(30))
    while (true) {
      grid = grid.next
      printGrind(grid)
    } 

  }

}
