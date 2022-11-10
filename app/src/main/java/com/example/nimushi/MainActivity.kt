package com.example.nimushi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {


    private lateinit var name: EditText
    private lateinit var lastname: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        lastname = findViewById(R.id.lastname)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)


        var registration: AppCompatButton = findViewById(R.id.registration)
        var checktest:CheckBox = findViewById(R.id.checktest)

        checktest.setOnClickListener{


        }
        registration.setOnClickListener{

            val cecktest: CheckBox = findViewById(R.id.checktest)
            if(cecktest.isChecked){
                checking()
            }else{
                Toast.makeText(applicationContext, "Checkbox is not checked", Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun checking(){
        if(name.length() < 3){
            Toast.makeText(applicationContext, "Name must contain more than 3 characters", Toast.LENGTH_SHORT).show()
        }
        if(lastname.length() < 5){
            Toast.makeText(applicationContext, "Lastname must contain more than 5 characters", Toast.LENGTH_SHORT).show()
        }
        if(password.length() < 8){
            Toast.makeText(applicationContext, "Password must contain more than 8 characters", Toast.LENGTH_SHORT).show()
        }
        if (password.length() >= 8 && lastname.length() >= 5 && name.length() >= 3){
            Toast.makeText(applicationContext, "მიმდინარეობს გადახდა", Toast.LENGTH_SHORT).show()
        }
        checkEmail()
    }
    fun checkEmail(){
        var index1 = 0
        var index2 = 0
        for(i in email.text.toString()){
            if(i == '@'){
                break
            }
            index1++
        }
        for(i in email.text.toString()){
            if(i == '.'){
                break
            }
            index2++
        }
        if(index1 == email.length()){
            index1 = 0
        }
        if(index2 == email.length()){
            index2 = 0

        }
        if(index1 < index2 && index1 != 0 && index2 != 0){
            Toast.makeText(applicationContext,"correct E-Mail",Toast.LENGTH_SHORT)
        }else if(index1 > index2 && index1 != 0 && index2 != 0){
            Toast.makeText(applicationContext,"Incorrect E-Mail",Toast.LENGTH_SHORT).show()
        }else if(index1 == 0 || index2 == 0){
            Toast.makeText(applicationContext,"Incorrect E-Mail",Toast.LENGTH_SHORT).show()
        }
    }
}








