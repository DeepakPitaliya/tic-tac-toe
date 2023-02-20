
class TicTacToe {
    val gameArray: Array<CharArray> = arrayOf(
        charArrayOf('|', ' ', ' ', ' ', '|'),
        charArrayOf('|', ' ', ' ', ' ', '|'),
        charArrayOf('|', ' ', ' ', ' ', '|'),
    )
    var count = 0

    fun printBoard() {
        println("---------")
        for (i in 0..2) {
            for (j in 0..4) {
                print(gameArray[i][j] + " ")
            }
            println()
        }
        println("---------")
    }

    fun modifyGameArray(array: Array<CharArray>): Array<CharArray> {
        try {
            val input = readln().split(" ").map { it.toInt() }
            val row = input[0]
            val col = input[1]
            if ((1..3).contains(row) && (1..3).contains(col)) {
                if (array[row - 1][col] == ' ') {
                    if (count % 2 == 0) {
                        array[row - 1][col] = 'X'
                        count++
                    } else {
                        array[row - 1][col] = 'O'
                        count++
                    }
                } else {
                    println("This cell is occupied! Choose another one!")
                    modifyGameArray(array)
                }
            } else {
                println("Coordinates should be from 1 to 3!")
                modifyGameArray(array)
            }
        } catch (e: Exception) {
            println("You should enter numbers!")
            modifyGameArray(array)
        }
        return array
    }

    fun checkGameState(array: Array<CharArray>): Boolean {
        var runGame = true
        val s: String = "" + array[0][1] + array[0][2] + array[0][3] +
                array[1][1] + array[1][2] + array[1][3] +
                array[2][1] + array[2][2] + array[2][3]

        var xWins = false
        var oWins = false

        for (i in 0..2) {
            if (s[i] == s[i + 3] && s[i + 3] == s[i + 6]) {
                if (s[i] == 'X') xWins = true
                if (s[i] == 'O') oWins = true
            }
        }
        for (i in 0..6 step 3) {
            if (s[i] == s[i + 1] && s[i + 1] == s[i + 2]) {
                if (s[i] == 'X') xWins = true
                if (s[i] == 'O') oWins = true
            }
        }
        if ((s[0] == s[4] && s[4] == s[8]) || (s[2] == s[4] && s[4] == s[6])) {
            if (s[4] == 'X') xWins = true
            if (s[4] == 'O') oWins = true
        }


        if (xWins) {
            println("X wins")
            runGame = false
        } else if (oWins) {
            println("O wins")
            runGame = false
        } else if (count == 9){
            println("Draw")
            runGame = false
        }
        return runGame
    }
}
