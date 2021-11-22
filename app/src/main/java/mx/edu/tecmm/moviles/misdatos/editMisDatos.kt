package mx.edu.tecmm.moviles.misdatos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class editMisDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_mis_datos)
        val boton = findViewById<FloatingActionButton>(R.id.btnGuardar);
        val txtNombre = findViewById<TextView>(R.id.Nombre);
        val txtNoControl = findViewById<TextView>(R.id.txtEditCarrera);
        val txtCarrera = findViewById<TextView>(R.id.txtEditControl);
        val txtHobbies = findViewById<TextView>(R.id.txtEditHobbies)

        boton.setOnClickListener{
            val misPreferencias = getSharedPreferences("MisDatos", Context.MODE_PRIVATE)
            with(misPreferencias.edit()) {
                val nombre : String = txtNombre.text.toString();
                val car: String = txtCarrera.text.toString();
                val con : String = txtNoControl.text.toString();
                val hobi : String = txtHobbies.text.toString();
                putString("nombre", nombre)// aqui va el campo de texto en segundo parametro
                putString("carrera", car)
                putString("nc", con)
                putString("hobbies", hobi);
                commit()
                finish();
            }
        }
    }
}