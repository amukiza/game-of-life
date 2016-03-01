import org.scalatest._

import GameOfLife.{DEAD, ALIVE}

class CellSpec extends WordSpec with ShouldMatchers {

  "A Cell" should {

    "be alive or dead" in {
      Cell(ALIVE).alive shouldBe ALIVE
      Cell(DEAD).alive shouldBe DEAD
    }

    "switch from DEAD to ALIVE if its surrounded exactly by 3 living cells" in {
      val cell = Cell(DEAD)

      cell.transform(3).alive shouldBe ALIVE
    }

    "remain alive if its surrounded by 2 or 3 living cells" in {
      val cell = Cell(ALIVE)

      cell.transform(2).alive shouldBe ALIVE
      cell.transform(3).alive shouldBe ALIVE
    }

    "switch from being ALIVE to DEAD if its surrounded by more than 3 living cells because of over population" in {
      val cell = Cell(ALIVE)

      cell.transform(4).alive shouldBe DEAD
    }
  }

  "switch from being ALIVE to DEAD if its surrounded by less than 2 cells because of under population" in {
    val cell = Cell(ALIVE)

    cell.transform(1).alive shouldBe DEAD
  }

  "know his/her neighborhood" in {
    val cell = Cell(position = Pos(1,1))

    cell.near(Pos(1, 1)) shouldBe false
    cell.near(Pos(0, 0)) shouldBe true
    cell.near(Pos(1, 0)) shouldBe true
    cell.near(Pos(2, 0)) shouldBe true
    cell.near(Pos(2, 1)) shouldBe true
    cell.near(Pos(2, 2)) shouldBe true
    cell.near(Pos(1, 2)) shouldBe true
    cell.near(Pos(0, 2)) shouldBe true
    cell.near(Pos(0, 1)) shouldBe true
    cell.near(Pos(1, 3)) shouldBe false
  }

}
