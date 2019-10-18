package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var player1Array = ArrayList<Int>()
    var player2Array = ArrayList<Int>()

    var activePlayer: Int =1

    var isAllCellFilled=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view: View) {
        var selectedButton:Button = view as Button
        var id:Int  =0
        when (selectedButton.id){
            R.id.button1 -> id = 1
            R.id.button2 -> id = 2
            R.id.button3 -> id = 3
            R.id.button4 -> id = 4
            R.id.button5 -> id = 5
            R.id.button6 -> id = 6
            R.id.button7 -> id = 7
            R.id.button8 -> id = 8
            R.id.button9 -> id = 9
        }

        playing(id,selectedButton)

        //check if all cell is filled
        if (isAllCellFilled == 9 ){
            //the game is ended with draw
            Toast.makeText(this,"Game is Draw",Toast.LENGTH_SHORT).show()
            clearAll()
        }
        //checking for winner
        if(checkIfWon(player1Array)){
            winner("1")
        }
        else if(checkIfWon(player2Array)){
            winner("2")
        }
    }

    fun winner(text:String){
        Toast.makeText(this, "Player $text wins", Toast.LENGTH_SHORT).show()
        clearAll()

    }

    //clear all buttons after the game is finished
    fun clearAll(){
        //restarting activity
            finish()
            startActivity(getIntent())
    }

    fun playing(id :Int,selectedButton:Button){

        if(activePlayer == 1){
            selectedButton.setText("X")
            selectedButton.setBackgroundColor(Color.GREEN)
            player1Array.add(id)
            activePlayer = 2
        }else {
            selectedButton.setText("O")
            selectedButton.setBackgroundColor(Color.BLUE)
            player2Array.add(id)
            activePlayer =1
        }

        selectedButton.isEnabled = false
        isAllCellFilled ++
    }

    fun checkIfWon(playerArray:ArrayList<Int>): Boolean{
        var winner=false

        if(playerArray.contains(1) && playerArray.contains(2) && playerArray.contains(3)){
            winner = true
        }else if(playerArray.contains(1) && playerArray.contains(4) && playerArray.contains(7)){
            winner = true
        }else if(playerArray.contains(1) && playerArray.contains(5) && playerArray.contains(9)){
            winner = true
        }else if(playerArray.contains(2) && playerArray.contains(5) && playerArray.contains(8)){
            winner = true
        }else if(playerArray.contains(3) && playerArray.contains(6) && playerArray.contains(9)){
            winner = true
        }else if(playerArray.contains(3) && playerArray.contains(5) && playerArray.contains(7)){
            winner = true
        }else if(playerArray.contains(4) && playerArray.contains(5) && playerArray.contains(6)){
            winner = true
        }else if(playerArray.contains(7) && playerArray.contains(8) && playerArray.contains(9)){
            winner = true
        }
        return winner
    }
}
