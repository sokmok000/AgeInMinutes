package eu.tutorials.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view ->
            ClickDatePicker(view)
             }
    }

    fun ClickDatePicker(view:View ){
        val MyCalendar = Calendar.getInstance()
        val year = MyCalendar.get(Calendar.YEAR)
        val month = MyCalendar.get(Calendar.MONTH)
        val day = MyCalendar.get(Calendar.DAY_OF_MONTH)

       var DPD = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, Selectyear, Selectmonth, SelectdayOfMonth
            ->Toast.makeText(this, "Year is $Selectyear Month is $Selectmonth Day is $SelectdayOfMonth", Toast.LENGTH_SHORT).show()
            val SelectDate = "$SelectdayOfMonth/${Selectmonth+1}/$Selectyear"

            TvSelectDate.setText(SelectDate)

            val Sdf = SimpleDateFormat("dd/MM/yyyy")

            val TheDate = Sdf.parse(SelectDate)

            val SelectDateInMinutes = TheDate!!.time / 60000

            val CurrentDate = Sdf.parse(Sdf.format(System.currentTimeMillis()))

            val CurrentDateInMinutes = CurrentDate!!.time / 60000

            val DifferentDate = CurrentDateInMinutes - SelectDateInMinutes

            TvInminutes.setText(DifferentDate.toString())



        } ,year , month , day )

        DPD.datePicker.setMaxDate(Date().time - 86400000)
        DPD.show()


    }
}