package my.edu.tarc.jxel

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttoncan: ImageButton = findViewById(R.id.can)
        buttoncan.setOnClickListener{
            val intent= Intent(this, stock::class.java)
            startActivity(intent)
        }
        val buttontemp: ImageButton = findViewById(R.id.thermo)
        buttontemp.setOnClickListener {
            val intent = Intent(this, thermo::class.java)
            startActivity(intent)
        }
    }
}