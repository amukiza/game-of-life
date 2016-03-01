import GameOfLife.{DEAD, ALIVE}

case class Pos(x: Int, y: Int)

case class Cell(alive: Boolean = DEAD, position: Pos = Pos(0, 0)) {

  def near(pos: Pos) : Boolean = {
    (Math.abs(pos.x - position.x) <= 1 && Math.abs(pos.y - position.y) <= 1)  && !(position == pos)
  }

  def transform(aliveNeighbors: Int): Cell = {
    if (aliveNeighbors == 3) Cell(ALIVE, position)
    else if ((aliveNeighbors == 2) && alive) Cell(ALIVE, position)
    else Cell(DEAD, position)
  }

}
