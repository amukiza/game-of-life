
case class Grid(cells: List[List[Cell]]) {

  def getCells:List[List[Cell]] = cells

  def aliveNeighbors(cell: Cell): Int = cells.flatten.filter(_.near(cell.position)).count(_.isAlive)

  def next: Grid =
    this.copy(
      cells.map { row =>
        row.map( cell => cell.transform(aliveNeighbors(cell)) )
      }
    )

}
