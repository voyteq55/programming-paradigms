def primes(n: Int) =
    val numbers = List.range(2, n + 1)
    def isPrime(num: Int) =
        if (num == 2) then true else
            val possibleDivisors = 2 :: List.range(3, math.sqrt(num).toInt + 1, 2)
            val divisors = for (
                divisor <- possibleDivisors
                if (num % divisor == 0)
            ) yield ()
            divisors == Nil
    for (
        k <- numbers
        if isPrime(k)
    ) yield k

primes(0)
primes(1)
primes(2)
primes(10)
primes(121)
