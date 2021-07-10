package com.example.ageinminute

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun btnDatePicker(view: View) {
        //val datepickerbtn = findViewById<Button>(R.id.date_Picker_btn)
        clickDatePicker(view)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view:View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)



      val dpd =  DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,selectedYear,selectedMonth,selectedDayOfmonth
            ->
            Toast.makeText(this,"Selected date is $selectedDayOfmonth/${selectedMonth+1}/$selectedYear ",Toast.LENGTH_LONG).show()
            val selectedDayOfmonth:Int = day
            val selectedMonth:Int = month
            val selectedYear:Int = year
            val selectedDate= "$selectedDayOfmonth/${selectedMonth+1}/$selectedYear"
            val selectedDatebtn = findViewById<TextView>(R.id.tvSelectedDate)
            selectedDatebtn.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val thedate = sdf.parse(selectedDate)
            val selectedDateInMinutes = thedate!!.time/60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateinMinutes = currentDate!!.time/60000
            val differenceInMinutes = currentDateinMinutes-selectedDateInMinutes
            val outputScreen = findViewById<TextView>(R.id.age_in_min)
            outputScreen.setText(differenceInMinutes.toString())
        },year,month,day)

       // dpd.datePicker.getMaxDate(Date().time-8640000)
        dpd.show()


    }
}
