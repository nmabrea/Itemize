open class Adult (override var personName: String,
                  override var personID: Int,
                  override var itemResponsibilities: MutableList<ExpenseItem> = mutableListOf(),
                  override var expenseRating1: Double = 0.0,
                  override var expenseRating2: Double = 0.0,
                  override var expenseRating3: Double = 0.0) : Person, PersonList() {

    override fun listPerson() {
        println("\nType in a user's name to add to the party or press 'Enter' key to stop:")
        personName = readLine().toString()


        if (personName != "") {

            personID++

            userParty.add(Adult(personName,personID))

        } else {

            if (userParty.size > 1) {
                userParty.add(Adult("Shared", personID = userParty.size + 1))
            }
            rollCall()
        }
    }
}
