
case class Grid(cells: List[List[Cell]]) {

  def aliveNeighbors(cell: Cell): Int = cells.flatten.count(_.near(cell.position))

  def next: Grid =
    Grid(
      cells.map { row =>
        row.map( cell => cell.transform(aliveNeighbors(cell)) )
      }
    )
}
