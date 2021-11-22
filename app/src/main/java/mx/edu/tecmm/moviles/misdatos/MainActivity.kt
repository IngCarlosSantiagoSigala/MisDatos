package mx.edu.tecmm.moviles.misdatos

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var txtNombre:TextView;
    lateinit var txtNoControl:TextView;
    lateinit var txtCarrera:TextView;
    lateinit var txtHobbies:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var botonEditar = findViewById<FloatingActionButton>(R.id.btnEditar)
         txtNombre= findViewById(R.id.txtNombre)
         txtCarrera = findViewById(R.id.txtCarrera)
         txtNoControl = findViewById(R.id.txtNoControl)
         txtHobbies = findViewById(R.id.txtHobbies);

        botonEditar.setOnClickListener{
            val abrirVentana = Intent(this, editMisDatos::class.java)
            startActivity(abrirVentana)
        }

    }

    override fun onResume() {
        super.onResume()
        val misPreferencias = getSharedPreferences("MisDatos",Context.MODE_PRIVATE);

        with(misPreferencias){
            val nombre = getString("nombre","No se ha Guardados")
            val numControl = getString("nc","N/A")
            val hobbies = getString("hobbies", "N/A")
            val carrera = getString("carrera", "N/A")
            txtNombre.text = nombre;
            txtNoControl.text = numControl
            txtHobbies.text = hobbies
            txtCarrera.text = carrera
        }
    }




}