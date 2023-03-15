package dwitdisciples.example.androidappfour

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.ContextMenu.ContextMenuInfo
import android.widget.*



class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instance of Context Menu (Part 3)
        val etMsg = findViewById<EditText>(R.id.editText)
        val viewContext = findViewById<View>(R.id.tcContext)
        registerForContextMenu(viewContext)

        //Instance of Next Activity Button (Part 1)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            doNextActivity()
        }

        //Entire Part 2
        //Menu Items
        val tb = findViewById<androidx.appcompat.widget.Toolbar>(R.id.tb)
        tb.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.info -> {
                    Toast.makeText(this, "Information", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.email -> {
                    Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }

    }


    //Function for SecondActivity.kt
    //takes user input from main activity then converts to string for output in the second activity
    fun doNextActivity() {
        val EditMsg = findViewById<EditText>(R.id.editText)
        val msg = EditMsg.text.toString()
        val intent = Intent(this,SecondActivity::class.java).also{
            it.putExtra("MESSAGE", msg)
            startActivity(it)
        }
    }

    //Menu Inflater for context menu (Part 3)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    //Menu Inflater for options menu (Part 2)
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    //Toast pop ups for options menu (Part 2)
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.add -> {
                showToast("Add")
                true
            }
            R.id.edit -> {
                showToast("Edit")
                true
            }
            R.id.delete -> {
                showToast("Delete")
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    //Toast layout block for context menu (Part 3)
    private fun showToast(str: String) {
        val inflater: LayoutInflater = getLayoutInflater()
        val layout: View = inflater.inflate(
            R.layout.layout_toast,
            findViewById(R.id.toast_layout_root) as ViewGroup?
        )
        val text = layout.findViewById<View>(R.id.text) as TextView
        text.text = str
        val toast = Toast(getApplicationContext())
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.setView(layout)
        toast.show()
    }

    //Output toast for option menu (Part 2)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.info -> {
                Toast.makeText(this, "Information", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.email -> {
                Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}
