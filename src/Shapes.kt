fun main() {
    val shapes:Array<Shape> = arrayOf( //Array for shapes
        Circle(4.1),
        Rectangle(4.2,5.3),
        Sphere(4.1)
    )

    shapes.forEach {//Output of calculated results
        val name = it.getName()

        when(it){
            is TwoDimensional -> println(name+"="+it.calculateArea())

            is ThreeDimensial -> println(name+"="+it.calculateVolume())

            else -> throw Exception("Ne var ne yox?")
        }
    }
}


enum class ShapeType { //Enum
    Rectangle,
    Circle,
    Sphere
}


abstract class Shape { // Created abstract class for mutual spesifications of shapes
    abstract fun getName(): String
}

interface TwoDimensional { // mutual spesifications of TWO dimentional shapes
    fun calculateArea (): Double
}

interface ThreeDimensial { //mutual spesifications of THREE dimentional shapes
    fun calculateVolume ()
}


class Circle(private val radius: Double) : Shape(), TwoDimensional { // Calculation of CIRCLE, Overriding name by ENUM
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }

    override fun getName(): String {
        return ShapeType.Circle.toString()
    }
}

class Rectangle(private val width: Double, private val height: Double) : Shape(), TwoDimensional { // Calculation of RECTANGLE, Overriding name by ENUM

    override fun calculateArea(): Double {
        return width * height
    }

    override fun getName(): String {
        return ShapeType.Rectangle.toString()
    }
}
class Sphere(private val radius: Double) : Shape(), ThreeDimensial, TwoDimensional { // Calculation of SPHERE, Overriding name by ENUM
    override fun calculateVolume() {
        (4.0/3.0)*Math.PI*radius*radius*radius
    }

    override fun getName(): String {
        return ShapeType.Sphere.toString()
    }

    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}