

object Status  extends Enumeration {
  val DEAD, ALIVE = Value
}

case class Pos(x: Int, y: Int)

case class Cell(alive: Status.Value = Status.DEAD, position: Pos = Pos(0, 0)) {

  def near(pos: Pos) : Boolean = {
    (Math.abs(pos.x - position.x) <= 1 && Math.abs(pos.y - position.y) <= 1)  && !(position == pos)
  }

  def transform(aliveNeighbors: Int): Cell = {
    if (aliveNeighbors == 3) Cell(Status.ALIVE, position)
    else if ((aliveNeighbors == 2) && isAlive) Cell(Status.ALIVE, position)
    else Cell(Status.DEAD, position)
  }

  def isAlive : Boolean = alive == Status.ALIVE
}
