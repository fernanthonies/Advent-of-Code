package days

class DaySeven(input: List<String>) : BaseDay(input) {

    private var rootNode = ENode(null, "root", ENode.NodeType.Directory)

    override fun solvePartOne(): String {
        var currentNode: ENode = rootNode
        var total = 0
        input.drop(1).forEach { inputLine ->
            when (val line = parseLine(inputLine)) {
                is Command -> {
                    currentNode = when (line.type) {
                        CommandType.MoveIn -> {
                            currentNode.children.find { node -> node.name == line.argument } ?: throw Error()
                        }
                        CommandType.MoveOut -> {
                            currentNode.parent ?: throw Error()
                        }
                        CommandType.List -> currentNode
                    }
                }
                is Dir -> {
                    if (!currentNode.children.map { it.name }.contains(line.name)) {
                        currentNode.addChild(ENode(currentNode, line.name, ENode.NodeType.Directory))
                    }
                }
                is File -> {
                    if (!currentNode.children.map { it.name }.contains(line.name)) {
                        currentNode.addChild(ENode(currentNode, line.name, ENode.NodeType.File, line.size))
                    }
                }
            }
        }

        val runningTotals = mutableListOf<Int>()
        rootNode.traverseToSumDirs(runningTotals)
        total = runningTotals.sum()
        return total.toString()
    }

    override fun solvePartTwo(): String {
        val spaceNeeded = 30000000 - (70000000 - rootNode.size)
        val listOfDirs = mutableListOf<ENode>()

        rootNode.traverseForDirToDelete(listOfDirs, spaceNeeded)

        listOfDirs.sortBy { it.size }
        val resultSize = listOfDirs.first().size

        return resultSize.toString()
    }

    class ENode(val parent: ENode?, val name: String, val type: NodeType, var size: Int = 0) {
        var children: MutableList<ENode> = mutableListOf()

        fun addChild(child: ENode) {
            children.add(child)
        }

        enum class NodeType {
            Directory,
            File
        }
    }

    private fun ENode.traverseToSumDirs(list: MutableList<Int>) {
        this.children.forEach { it.traverseToSumDirs(list) }
        if (this.type == ENode.NodeType.Directory) {
            this.size = children.sumOf { it.size }
            if (this.size <= 100000) list.add(this.size)
        }

    }

    private fun ENode.traverseForDirToDelete(list: MutableList<ENode>, spaceNeeded: Int) {
        if (this.type == ENode.NodeType.Directory && this.size >= spaceNeeded) {
            list.add(this)
        }
        this.children.forEach { it.traverseForDirToDelete(list, spaceNeeded) }
    }

    private fun parseLine(input:String): CommandLine {
        return when (input[0]) {
            '$' -> parseCommand(input)
            'd' -> parseDir(input)
            else -> parseFile(input)
        }
    }

    private fun parseCommand(input: String): Command {
        val elements = input.split(" ")
        return when (elements[1]) {
            "cd" -> when (elements[2]) {
                ".." -> Command(CommandType.MoveOut)
                else -> Command(CommandType.MoveIn, elements[2])
            }
            "ls" -> Command(CommandType.List)
            else -> throw Error()
        }
    }

    private fun parseFile(input: String): File {
        val elements = input.split(" ")
        return File(elements[1], elements[0].toInt())
    }

    private fun parseDir(input: String): Dir {
        val elements = input.split(" ")
        return Dir(elements[1])
    }

    interface CommandLine
    class File(val name: String, val size: Int): CommandLine
    class Dir(val name: String): CommandLine
    class Command(val type: CommandType, val argument: String = ""): CommandLine

    enum class CommandType {
        MoveIn,
        MoveOut,
        List
    }
}