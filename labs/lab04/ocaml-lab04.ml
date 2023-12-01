type 'a tree3 = Empty | Node of 'a * 'a tree3 * 'a tree3 * 'a tree3

let testTree1 = Empty
let testTree2 = Node("abcd", Empty, Node("aaa", Empty, Empty, Empty), Empty)
let testTree3 = Node(1, Node(2, Empty, Empty, Empty), Node(3, Node(5, Empty, Empty, Empty), Empty, Node(6, Empty, Empty, Empty)), Node(4, Empty, Empty, Empty))

let rec mapTree3 mapFunction tree =
  match tree with
  | Empty -> Empty
  | Node(element, t1, t2, t3) -> Node(mapFunction element, mapTree3 mapFunction t1, mapTree3 mapFunction t2, mapTree3 mapFunction t3)

let repeat s = s ^ s
let cube x = x * x * x

let cubedTestTree1 = mapTree3 cube testTree1
let repeatedTestTree2 = mapTree3 repeat testTree2
let cubedTestTree3 = mapTree3 cube testTree3
