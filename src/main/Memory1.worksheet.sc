

case class Card(Symbol: String, isFaceUp: Boolean = false)


case class Field(Card: Seq[Card]) {
  def turnCard(index: Int): Field = {
    val updatedCards = Card.updated(index, Card(index).copy(isFaceUp = !Card(index).isFaceUp))
    Field(updatedCards)
  }
}

case class Player(id: Int, Stack: Int = 0, turn: Boolean) {
  def addPair(): Player = copy(Stack = Stack + 1)
  def nextTurn(): Player = copy(turn = !turn)
}


val player1 = Player(1, Turn = true)
val player2 = Player(2, Turn = false)

val initialBoard = Field(Seq(
  Card("A"), Card("A"),
  Card("B"), Card("B"),
  Card("C"), Card("C")
))

player1.nextTurn()
player1.addPair()

initialBoard.turnCard(2)

println(initialBoard)
