import kotlin.random.Random


fun main(args: Array<String>) {
    val board = Array<String>(9){" "}
    var winner: String? = null

    while(true){
        drawBoard(board)
        getUserMove(board)

        winner = getWinner(board)
        if(winner != null){
            println()
            print(winner)
            drawBoard(board)
            break
        }

        if(isGameEnd(board)){
            println("Tie")
            break
        }

        getComputerMove(board)
        winner = getWinner(board)
        if(winner != null){
            println()
            println(winner)
            drawBoard(board)
            break
        }
    }
}
fun getWinner(board: Array<String>): String?{

    if(checkRows(board) == "XXX") return "You win"
    if(checkRows(board) == "OOO") return "Computer win"

    if(checkColumns(board) == "XXX") return "You win"
    if(checkColumns(board) == "OOO") return "Computer win"

    if(checkDiagonals(board) == "XXX") return "You win"
    if(checkDiagonals(board) == "OOO") return "Computer win"

    return null
}

fun isGameEnd(board: Array<String>): Boolean{
    for (i in board){
        if(i == " ") return false
    }
    return true
}

fun checkDiagonals(board: Array<String>): String?{

    val diagonal1 = board[0]+board[4]+board[8]
    val diagonal2 = board[2]+board[4]+board[6]

    if (diagonal1 == "XXX") return diagonal1
    else if(diagonal1 =="OOO" ) return diagonal1

    if (diagonal2 == "XXX") return diagonal2
    else if(diagonal2 =="OOO" ) return diagonal2

    return null
}
fun checkColumns(board: Array<String>): String?{

    val column1 = board[0] + board[3] + board[6]
    val column2 = board[1] + board[4] + board[7]
    val column3 = board[2] + board[5] + board[8]

    if (column1 == "XXX") return column1
        else if(column1 =="OOO" ) return column1

    if (column2 == "XXX") return column2
        else if(column2 =="OOO" ) return column2

    if (column3 == "XXX") return column3
        else if(column3 =="OOO" ) return column3

    return null

}
fun checkRows(board: Array<String>): String?{

    val row1 = board[0] + board[1] + board[2]
    val row2 = board[3] + board[4] + board[5]
    val row3 = board[6] + board[7] + board[8]

    if (row1 == "XXX") return row1
        else if(row1 =="OOO" ) return row1

    if (row2 == "XXX") return row2
        else if(row2 =="OOO" ) return row2

    if (row3 == "XXX") return row3
        else if(row3 =="OOO" ) return row3

    return null
}

fun getComputerMove(board: Array<String>) {

    while(true){
        val computerMove = Random.nextInt(0,9)
        if(board[computerMove] != " "){
            continue
        }

        board[computerMove] = "O"
        break
    }
}

fun getUserMove(board: Array<String>){
    println()
    while(true){
        print("Podaj numer pola (1-9): ")
        val userMove= readLine()!!.toInt()-1
        if(userMove !in 0..8){
            println("Nie ma takiego pola!")
            continue
        }
        if(board[userMove] != " "){
            println("Pole jest zajęte!")
            continue
        }
        board[userMove] = "X"
        break
    }
}

fun drawBoard(board: Array<String>) {
    println()
    for (i in 0..8){
        if (i%3!=2)
            print("[${board[i]}]")
        else
            println("[${board[i]}]")
    }
}
