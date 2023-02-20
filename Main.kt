fun main() {
    val t = TicTacToe()
    t.printBoard()
    while (t.checkGameState(t.gameArray)) {
        t.modifyGameArray(t.gameArray)
        t.printBoard()
    }
}