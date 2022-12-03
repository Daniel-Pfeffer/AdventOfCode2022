import java.util.PriorityQueue

suspend fun main() {
    val priorityQueue = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    var current = 0
    InputReceiver.get(1).forEach {
        if (it.isBlank()) {
            priorityQueue.add(current)
            current = 0
        } else {
            val i = it.toInt()
            current += i
        }
    }
    println(priorityQueue.poll()+priorityQueue.poll()+priorityQueue.poll())
}
