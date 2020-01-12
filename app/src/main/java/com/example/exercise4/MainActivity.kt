package com.example.exercise4

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var selectDate = Calendar.getInstance()
        val now = Calendar.getInstance()
        var left : Int
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            selectDate.set(year, month, day)

            var actualAge =  now.get(Calendar.YEAR) - selectDate.get(Calendar.YEAR)
            if(now.get(Calendar.MONTH) < selectDate.get(Calendar.MONTH)){
                if(now.get(Calendar.DAY_OF_MONTH) < selectDate.get(Calendar.DAY_OF_MONTH)) {
                    actualAge--
                }
            }



            if(actualAge>16&&actualAge<20){
                left = 5000
            }else if(actualAge>21&&actualAge<25){
                left= 14000
            }else if(actualAge>26&&actualAge<30){
                left=29000
            }else if(actualAge>31&&actualAge<35){
                left=50000
            }else if(actualAge>36&&actualAge<40){
                left=78000
            }else if(actualAge>41&&actualAge<45){
                left=116000
            }else if(actualAge>46&&actualAge<50){
                left=165000
            }else if(actualAge>51&&actualAge<55){
                left=228000
            }else {
                left=0
            }
            txtAge.text = "age="+actualAge.toString()
            txtTotal.text = "money="+left.toString()
        }

        bDate.setOnClickListener{
            DatePickerDialog(this, datePicker, selectDate.get(Calendar.YEAR), selectDate.get(
                Calendar.MONTH), selectDate.get(Calendar.DAY_OF_MONTH)).show().toString()
        }
    }
}
