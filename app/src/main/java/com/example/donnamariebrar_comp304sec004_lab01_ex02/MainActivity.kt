package com.example.donnamariebrar_comp304sec004_lab01_ex02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextDate = findViewById<EditText>(R.id.editTextDate)
        val editTextOrg = findViewById<EditText>(R.id.editTextOrg)
        val checkBoxCorp = findViewById<CheckBox>(R.id.checkBoxCorp)
        val checkBoxNonProf = findViewById<CheckBox>(R.id.checkBoxNonProf)
        val checkBoxEduc = findViewById<CheckBox>(R.id.checkBoxEduc)
        val radioGrpFormat = findViewById<RadioGroup>(R.id.radioGrpFormat)
        val btnReg = findViewById<Button>(R.id.btnReg)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val textViewInfo = findViewById<TextView>(R.id.textViewInfo)
        val spinnerCity = findViewById<Spinner>(R.id.spinnerCity)

        btnReg.setOnClickListener()
        {
            val name = editTextName.text.toString()
            val date = editTextDate.text.toString()
            val org = editTextOrg.text.toString()
            val city = spinnerCity.selectedItem.toString()
            val selectedRadio = radioGrpFormat.checkedRadioButtonId
            val types: MutableList<String> = mutableListOf()
            var format = ""

            if (checkBoxCorp.isChecked)
            {
                types.add("Corporate")
            }

            if (checkBoxNonProf.isChecked)
            {
                types.add("Not-for-Profit")
            }

            if (checkBoxEduc.isChecked)
            {
                types.add("Educational")
            }

            if (types.isEmpty())
            {
                Toast.makeText(this, "Please select at least one event type", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val typeString = types.joinToString(separator = ", ")

            if (selectedRadio == R.id.radioBtnInPerson)
            {
                format = "In Person"
            }
            else
            {
                format = "Online"
            }

            textViewInfo.text = "Your event is registered! \nEvent Name: $name \nEvent Date: $date \nEvent Organizer: $org \nEvent Location: $city \nEvent Type: $typeString \nEvent Format: $format"
            Toast.makeText(this,"Your event is registered! \nEvent Name: $name \nEvent Date: $date \nEvent Organizer: $org \nEvent Location: $city \nEvent Type: $typeString \nEvent Format: $format", Toast.LENGTH_SHORT).show()

        }

    }
}