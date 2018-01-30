package calculator.adnanlapendic.ba.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonNumberEvent(view: View){

        if(isNewOperation){
            display.text = ""

        }
        isNewOperation = false

        val buttonSelected = view as Button
        var buttonClickedValue:String =display.text.toString()

        if(buttonClickedValue == "0"){
            buttonClickedValue = ""
        }

        when(buttonSelected.id){
            button_0.id -> { buttonClickedValue += "0"}
            button_1.id -> { buttonClickedValue += "1"}
            button_2.id -> { buttonClickedValue += "2"}
            button_3.id -> { buttonClickedValue += "3"}
            button_4.id -> { buttonClickedValue += "4"}
            button_5.id -> { buttonClickedValue += "5"}
            button_6.id -> { buttonClickedValue += "6"}
            button_7.id -> { buttonClickedValue += "7"}
            button_8.id -> { buttonClickedValue += "8"}
            button_9.id -> { buttonClickedValue += "9"}
            button_dot.id -> {
                if(!buttonClickedValue.contains(".")) {
                    buttonClickedValue += "."
                    }
                }
            button_plus_minus.id -> {

                if (buttonClickedValue[0] != '-') {
                    buttonClickedValue = "-" + buttonClickedValue
                } else{
                    buttonClickedValue = buttonClickedValue.removePrefix("-")
                    Log.i("- - - - - - - - - - -", "|$buttonClickedValue|")
                }
            }
        }
        display.text = buttonClickedValue
    }

    var operation = ""
    var numberBeforeOperation = ""
    var isNewOperation = true
    fun buttonOperationEvent(view:View){


        val buttonSelected = view as Button
        when(buttonSelected.id){

            button_plus.id -> {
                operation = "+"
            Log.i("+++++++++++++++++","++++++++++++++++++++++++++++++")}
            button_minus.id -> { operation = "-"}
            button_divide.id -> { operation = "/"}
            button_x.id -> { operation = "*"}
        }
        numberBeforeOperation = display.text.toString()
        isNewOperation = true
    }


    fun buttonEqualEvent(view:View){

        val newNumber = display.text.toString()
        var result:Double?=null
        when(operation){
            "*" -> {result = numberBeforeOperation.toDouble() * newNumber.toDouble()}
            "/" -> {result = numberBeforeOperation.toDouble() / newNumber.toDouble()}
            "+" -> {result = numberBeforeOperation.toDouble() + newNumber.toDouble()}
            "-" -> {result = numberBeforeOperation.toDouble() - newNumber.toDouble()}
        }

        display.text = result.toString()
        isNewOperation = true
    }

    fun buttonPercentageEvent(view :View){
        val number = display.text.toString().toDouble()/100

        display.text = number.toString()
        isNewOperation = true
    }

    fun buttonCleanScreenEvent(view:View){
        display.text = "0"
        isNewOperation = true
    }
}

