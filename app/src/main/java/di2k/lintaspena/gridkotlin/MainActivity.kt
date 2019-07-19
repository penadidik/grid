package di2k.lintaspena.gridkotlin
//Created by 디딬 Didik M. Hadiningrat on 19 July 201
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_entry.view.*

class MainActivity : AppCompatActivity() {

    var adapter: FoodAdapter? = null
    var foodList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load foods
        foodList.add(Food("Coffee", "" ,R.drawable.coffee_pot))
        foodList.add(Food("Espresso", "" ,R.drawable.espresso))
        foodList.add(Food("French Fires","", R.drawable.french_fries))
        foodList.add(Food("Honey","", R.drawable.honey))
        foodList.add(Food("Strawberry","", R.drawable.strawberry_ice_cream))
        foodList.add(Food("Sugar Cubes","", R.drawable.sugar_cubes))
        adapter = FoodAdapter(this, foodList)

        gvFoods.adapter = adapter

    }

    class FoodAdapter : BaseAdapter{
        var foodList = ArrayList<Food>()
        var context: Context? = null

        constructor(context: Context, foodList: ArrayList<Food>): super(){
            this.context = context
            this.foodList = foodList
        }

        override fun getCount(): Int {
            return foodList.size
        }

        override fun getItem(position: Int): Any{
            return foodList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.foodList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_entry, null)
            foodView.imgFood.setOnClickListener{
                val intent = Intent(context, FoodDetails::class.java)
                intent.putExtra("name", food.name!!)
                intent.putExtra("description", food.description!!)
                intent.putExtra("image", food.image!!)
                context!!.startActivity(intent)
            }

            foodView.imgFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!

            return foodView
        }
    }
}
