package com.example.ejemplocalculadoramvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejemplocalculadoramvvm.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // variable observadora para la suma
        val addObserver = Observer<Double> {suma ->
            mainBinding.resultTextView.setText(suma.toString())
        }
        // conexión
        mainViewModel.add.observe(this,addObserver)

        // variable observadora para la resta
        val substractObserver = Observer<Double> {resta ->
            mainBinding.resultTextView.setText(resta.toString())
        }
        // conexión
        mainViewModel.substrac.observe(this,substractObserver)

        // variable observadora para la multiplicación
        val multiplyObserver = Observer<Double> {multiplicacion ->
            mainBinding.resultTextView.setText(multiplicacion.toString())
        }
        // conexión
        mainViewModel.multiply.observe(this,multiplyObserver)

        // variable observadora para la división
        val divisionObserver = Observer<Double> {division ->
            mainBinding.resultTextView.setText(division.toString())
        }
        // conexión
        mainViewModel.divide.observe(this,divisionObserver)

        val errorMsgObserver = Observer<String> { errorMsg ->
            Snackbar.make(view,errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("Aceptar"){ }
                .show()
        }

        mainViewModel.errorMsg.observe(this,errorMsgObserver)

        mainBinding.addButton.setOnClickListener {
            mainViewModel.addOperation(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString())
            /*//Comprobacion para que no se estalle la app
            if (mainBinding.firstNumberEditText.text.toString().isEmpty() || mainBinding.secondNumberEditText.text.toString().isEmpty()){
                //Snackbar.make(view,"Debe digitar dos números", Snackbar.LENGTH_SHORT).show()
                Snackbar.make(view,"Debe digitar dos números", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Aceptar"){ }
                    .show()
            } else {
            val number1 = mainBinding.firstNumberEditText.text.toString().toDouble()
            val number2 = mainBinding.secondNumberEditText.text.toString().toDouble()
            val total = number1 + number2
            //mainBinding.resultTextView.text = total.toString()
            mainBinding.resultTextView.setText(total.toString())
            }*/
        }

        mainBinding.substractButton.setOnClickListener {
            mainViewModel.substractOperation(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString())
        }

        mainBinding.multiplyButton.setOnClickListener {
            mainViewModel.multiplyOperation(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString())
        }

        mainBinding.divideButton.setOnClickListener {
            mainViewModel.divisionOperation(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString())
        }
    }
}