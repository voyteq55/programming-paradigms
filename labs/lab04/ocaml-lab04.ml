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
let toStringTestTree3 = mapTree3 (fun x -> string_of_int x) testTree3

type dataResource = File of string | Directory of string * dataResource list
type drive = Drive of char * dataResource list

let testDrive1 = Drive('D', [])
let testDrive2 = Drive('C', [
  File("fileName1");
  File("fileName2");
  Directory("dir1", [
    File("file1WithinDir1");
    Directory("dir2", []);
    File("file2WithinDir1")
  ])
])

let pathDFS driveToSearch resourceName =
  let rec searchRelativePath currentSubDirectory accFilePath =
    match currentSubDirectory with
    | [] -> None
    | h :: t ->
      let (name, resources) = (
        match h with
        | File(name) -> name, []
        | Directory(name, resources) -> name, resources
      )
      in if name = resourceName then Some accFilePath else
        match searchRelativePath resources (accFilePath ^ name ^ "/") with
        | None -> searchRelativePath t accFilePath
        | Some x -> Some x
  in let Drive(idLetter, rootDir) = driveToSearch 
  in searchRelativePath rootDir (String.make 1 idLetter ^ ":/")

let pathBFS driveToSearch resourceName =
  let rec resourceListToTupleList pathName resourceList =
    match resourceList with
    | [] -> []
    | h :: t -> (pathName, h) :: resourceListToTupleList pathName t
  in
  let rec searchPath queue =
    match queue with
    | [] -> None
    | (resourcePath, h) :: t -> 
      let (name, resources) = (
        match h with
        | File(name) -> name, []
        | Directory(name, resources) -> name, resources
      )
      in if name = resourceName then Some resourcePath else
        searchPath (t @ (resourceListToTupleList (resourcePath ^ name ^ "/") resources))
  in
  let Drive(idLetter, rootDir) = driveToSearch 
  in searchPath (resourceListToTupleList (String.make 1 idLetter ^ ":/") rootDir)

let testDrive3 = Drive('E', [
  File("abc");
  File("def");
  Directory("d1", [
    File("aaa");
    Directory("d1d1", [
      Directory("d1d1d1", [
        File("ghi");
        File("d2file")
      ])
    ])
  ]);
  File("ghi");
  Directory("d2", [
    File("d2file");
    File("jkl")
  ])
])

let testBFSPathSearch1 = pathBFS testDrive3 ""
let testBFSPathSearch2 = pathBFS testDrive3 "d1"
let testBFSPathSearch3 = pathBFS testDrive3 "ghi"
let testBFSPathSearch4 = pathBFS testDrive3 "d1d1d1"
let testBFSPathSearch5 = pathBFS testDrive3 "d2file"
let testBFSPathSearch6 = pathBFS testDrive3 "jkl";;
let testBFSPathSearch7 = pathBFS testDrive3 "aaa";;

let testDFSPathSearch1 = pathDFS testDrive3 ""
let testDFSPathSearch2 = pathDFS testDrive3 "d1"
let testDFSPathSearch3 = pathDFS testDrive3 "ghi"
let testDFSPathSearch4 = pathDFS testDrive3 "d1d1d1"
let testDFSPathSearch5 = pathDFS testDrive3 "d2file"
let testDFSPathSearch6 = pathDFS testDrive3 "jkl";;
let testDFSPathSearch7 = pathDFS testDrive3 "aaa";;