"Hello World"
res0 + "!"

val x = 7
x + 3

2.5 + 1.1
x + 2.5

val f = (x: Double) => x * x + 1
f(10)

def g(x: Double) = x * x + 1
g(10)

def h(xy: (Double, Double)) = xy._1 * xy._1 + xy._2 * xy._2
h((1.0, 1.0))

def ff(x: Double, y: Double) = {
	val sum = x + y
	if x < y then sum else -sum
}
ff(10, 5)

def fact(n: Int): Int = 
	if n <= 1 then 1 else fact(n - 1) * n 

fact(6)

def fff[T](x: T) = x
val ffff = [T] => (x: T) => x