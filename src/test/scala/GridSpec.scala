import org.scalatest._

import Status._

class GridSpec extends WordSpec with ShouldMatchers  {

  "The Grid" should {

    "have no movement when everyone is dead" in {
      val grid: Grid = Grid(List(
        List(Cell(DEAD), Cell(DEAD)),
        List(Cell(DEAD), Cell(DEAD))))

      grid.next shouldEqual Grid(List(
        List(Cell(DEAD), Cell(DEAD)),
        List(Cell(DEAD), Cell(DEAD))))
    }

    "kill living cell when it has no living neighbours" in {
      val grid: Grid = Grid(List(
        List(Cell(ALIVE), Cell(DEAD)),
        List(Cell(DEAD), Cell(DEAD))))

      grid.next shouldEqual Grid(List(
        List(Cell(DEAD), Cell(DEAD)),
        List(Cell(DEAD), Cell(DEAD))))
    }

    "revive a dead cell when it has three living neighbours" in {
      val grid: Grid = Grid(List(
        List(Cell(ALIVE, Pos(0,0)), Cell(ALIVE, Pos(1, 0))),
        List(Cell(ALIVE,  Pos(0, 1)), Cell(DEAD,  Pos(1, 1)))))

      grid.next shouldEqual Grid(List(
        List(Cell(ALIVE, Pos(0,0)), Cell(ALIVE, Pos(1, 0))),
        List(Cell(ALIVE,  Pos(0, 1)), Cell(ALIVE,  Pos(1, 1)))))
    }

    "kill all but corners" in {
      val grid: Grid = Grid(List(
        List(Cell(ALIVE, Pos(0,0)), Cell(ALIVE, Pos(1, 0)), Cell(ALIVE, Pos(2, 0))),
        List(Cell(ALIVE,  Pos(0, 1)), Cell(ALIVE,  Pos(1, 1)), Cell(ALIVE, Pos(2, 1)))))

      grid.next shouldEqual Grid(List(
        List(Cell(ALIVE, Pos(0,0)), Cell(DEAD, Pos(1, 0)), Cell(ALIVE, Pos(2, 0))),
        List(Cell(ALIVE,  Pos(0, 1)), Cell(DEAD,  Pos(1, 1)), Cell(ALIVE, Pos(2, 1)))))
    }
  }

}
