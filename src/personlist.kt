open class PersonList(val userParty: MutableList<Adult> = mutableListOf()) {

    fun rollCall() {
        println("\nList of participants below:\n")

        userParty.forEach { a -> println("[${a.personID}] ${a.personName}") }

    }
}