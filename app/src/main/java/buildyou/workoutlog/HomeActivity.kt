package buildyou.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var fcvHome3:FragmentContainerView
    lateinit var bnvHome:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        castViews()
        setupBottomNav()
    }
    fun castViews(){
        fcvHome3=findViewById(R.id.fcvHome3)
        bnvHome=findViewById(R.id.bnvHome)
    }
    fun setupBottomNav(){
        bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.plan ->{
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome3,PlanFragment())
                    transaction.commit()
                    true
                }
                R.id.track ->{
                    val transaction = supportFragmentManager.beginTransaction().replace(R.id.fcvHome3,TrackFragment()).commit()
                    true
                }
                R.id.profile ->{
                    val transaction = supportFragmentManager.beginTransaction().replace(R.id.fcvHome3,ProfileFragment()).commit()
                    true
                }
                else ->false
            }

        }
    }
}