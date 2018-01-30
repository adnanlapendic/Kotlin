package startup.adnanlapendic.ba.tictactoy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun btnClick(view: View){
        val btnSelected:Button = view as Button
        var buttonId = 0
        when(btnSelected.id){
            R.id.button1 -> buttonId = 1
            R.id.button2 -> buttonId = 2
            R.id.button3 -> buttonId = 3
            R.id.button4 -> buttonId = 4
            R.id.button5 -> buttonId = 5
            R.id.button6 -> buttonId = 6
            R.id.button7 -> buttonId = 7
            R.id.button8 -> buttonId = 8
            R.id.button9 -> buttonId = 9
        }

        //Toast.makeText(this, "ID: $buttonId", Toast.LENGTH_LONG).show()

        playGame(buttonId, btnSelected)
        checkWinner()

    }

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1

   private fun playGame(buttonId:Int, buttonSelected:Button){

        if(activePlayer == 1){
            buttonSelected.text = "X"
            buttonSelected.setBackgroundResource(R.color.DeepSkyBlue)
            player1.add(buttonId)
            activePlayer = 2
            autoPlay()
        }else{
            buttonSelected.text = "O"
            buttonSelected.setBackgroundResource(R.color.SeaGreen)
            player2.add(buttonId)
            activePlayer = 1

        }

        buttonSelected.isEnabled = false
    }

   private fun checkWinner() {
        var winner = -1

        // Row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // Row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // Row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //Column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // Column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // Column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        // Diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        // Diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun autoPlay(){
        val freeButtons= (1..9).filterNot { player1.contains(it) || player2.contains(it) }

        if(freeButtons.isNotEmpty()) {
            val random = Random()
            val randInrex = random.nextInt(freeButtons.size)
            val buttronId = freeButtons[randInrex]

        val btnSelected:Button?
            btnSelected = when(buttronId){
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> {
                    button1
                }
    
            }

        playGame(buttronId, btnSelected)
      }
    }
}
