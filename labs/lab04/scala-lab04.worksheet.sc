sealed trait tree3[+A]
    case object Empty extends tree3[Nothing]
    case class Node[+A](element: A, t1: tree3[A], t2: tree3[A], t3: tree3[A]) extends tree3[A]

val testTree1 = Empty
val testTree2 = Node("abcd", Empty, Node("aaa", Empty, Empty, Empty), Empty)
val testTree3 = Node(1, Node(2, Empty, Empty, Empty), Node(3, Node(5, Empty, Empty, Empty), Empty, Node(6, Empty, Empty, Empty)), Node(4, Empty, Empty, Empty))

def mapTree3[A,B](mapFunction: A => B)(tree: tree3[A]): tree3[B] =
    tree match
        case Empty => Empty
        case Node(element, t1, t2, t3) => Node(mapFunction(element), mapTree3(mapFunction)(t1), mapTree3(mapFunction)(t2), mapTree3(mapFunction)(t3))

val cube: (Int => Int) = x => x * x * x
val repeatString: (String => String) = s => s + s

mapTree3(cube)(testTree1)
mapTree3(repeatString)(testTree2)
mapTree3(cube)(testTree3)
mapTree3(x => x.toString())(testTree3)

sealed trait dataResource
    case class File(name: String) extends dataResource
    case class Directory(name: String, dataResources: List[dataResource]) extends dataResource

case class Drive(idLetter: Char, dataResources: List[dataResource])

val testDrive1 = Drive('D', Nil)
val tetsDrive2 = Drive('C', List(
    File("fileName1"),
    File("fileName2"),
    Directory("dir1", List(
        File("file1WithinDir1"),
        Directory("dir2", Nil),
        File("file2WithinDir1"))
    )
))

def pathDFS(driveToSearch: Drive)(resourceName: String): Option[String] =
    def searchRelativePath(currentSubDirectory: List[dataResource])(accFilePath: String): Option[String] =
        currentSubDirectory match
            case Nil => None
            case h :: t =>
                 val (name, resources) = (
                    h match
                        case File(name) => (name, Nil)
                        case Directory(name, dataResources) => (name, dataResources)
                 )
                 if name == resourceName then Some(accFilePath) else
                    searchRelativePath(resources)(accFilePath + name + "/") match
                        case None => searchRelativePath(t)(accFilePath)
                        case Some(value) => Some(value)
    val Drive(idLetter, rootDir) = driveToSearch
    searchRelativePath(rootDir)(s"$idLetter:/")

def pathBFS(driveToSearch: Drive)(resourceName: String): Option[String] =
    def resourceListToTupleList(pathName: String)(resourceList: List[dataResource]): List[Tuple2[String, dataResource]] =
        resourceList match
            case Nil => Nil
            case h :: t => (pathName, h) :: resourceListToTupleList(pathName)(t)
    def searchPath(queue: List[Tuple2[String, dataResource]]): Option[String] =
        queue match
            case Nil => None
            case (resourcePath, h) :: t =>
                val (name, resources) = (
                    h match
                        case File(name) => (name, Nil)
                        case Directory(name, dataResources) => (name, dataResources)
                )
                if name == resourceName then Some(resourcePath) else
                    searchPath(t ::: (resourceListToTupleList(resourcePath + name + "/")(resources)))
    val Drive(idLetter, rootDir) = driveToSearch
    searchPath(resourceListToTupleList(s"$idLetter:/")(rootDir))

val testDrive3 = Drive('E', List(
  File("abc"),
  File("def"),
  Directory("d1", List(
    File("aaa"),
    Directory("d1d1", List(
      Directory("d1d1d1", List(
        File("ghi"),
        File("d2file")
      ))
    ))
  )),
  File("ghi"),
  Directory("d2", List(
    File("d2file"),
    File("jkl")
  ))
))

pathDFS(testDrive3)("")
pathDFS(testDrive3)("d1")
pathDFS(testDrive3)("ghi")
pathDFS(testDrive3)("d1d1d1")
pathDFS(testDrive3)("d2file")
pathDFS(testDrive3)("jkl")
pathDFS(testDrive3)("aaa")

pathBFS(testDrive3)("")
pathBFS(testDrive3)("d1")
pathBFS(testDrive3)("ghi")
pathBFS(testDrive3)("d1d1d1")
pathBFS(testDrive3)("d2file")
pathBFS(testDrive3)("jkl")
pathBFS(testDrive3)("aaa")
