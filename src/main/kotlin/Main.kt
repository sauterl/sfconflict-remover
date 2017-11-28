import java.io.File

/**
 * TODO: Write JavaDoc
 * @author loris.sauter
 */

val PATTERN = "SFConflict"


fun main(args: Array<String>){
    if(args.isEmpty()){
       usage()
    }

    val dir = File(args[0])
    var counter = traverseRecursively(dir)

    println("Found $counter matching files")
}

fun usage(){
    println("SFConflict Remover")
    println()
    println("Usage: sfconflict-remover <dir>")
    println("\tWhere <dir> is the directory you want to clean.\n\tNOTE: SFConflict Remover always cleans a directory and its subdirectories recursively.")
}

fun traverseRecursively(dir : File): Int {
    var counter = 0
    dir.walkTopDown().forEach {
        if(it.isFile && it.name.contains(PATTERN)){
            println("rm ${it.absolutePath}")
            it.delete()
            counter++
        }

    }
    return counter
}