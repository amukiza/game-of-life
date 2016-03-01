
case class Grid(cells: List[List[Cell]]) {

  def aliveNeighbors(i: Int, j: Int): Int = {
    cells.flatten.count(_.near(Pos(i, j)))
  }

  def next: Grid = {
    Grid(
      cells.zipWithIndex.map { case (row: List[Cell], rowIndex: Int) =>
        row.zipWithIndex.map{
          case (cell: Cell, columnIndex: Int) => cell.transform(aliveNeighbors(rowIndex, columnIndex))
        }
      }
    )
  }
}
