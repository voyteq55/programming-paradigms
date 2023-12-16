let imperacci m n =
  if m >= 1 then (
    let
      skiponacciSequence = Array.make n 0 and
      previousValue = ref 0 and
      currentValue = ref 1 and
      index = ref 0 and
      skiponacciDegree = ref (2 * (m - 1))
    in (
      while !index < n do
        if !skiponacciDegree = 0 then (
          skiponacciSequence.(!index) <- !currentValue;
          index := !index + 1
        ) else
          skiponacciDegree := !skiponacciDegree - 1;
        currentValue := !previousValue + !currentValue;
        previousValue := !currentValue - !previousValue
      done;
      skiponacciSequence;
    )
  ) else
    Array.make 0 0

let testImperacci1 = imperacci 1 10
let testImperacci2 = imperacci 2 6
let testImperacci3 = imperacci 4 10
let testImperacci4 = imperacci 2 0
let testImperacci5 = imperacci 0 6
