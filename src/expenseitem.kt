open class ExpenseItem(override var label: String,
                       override var cost: Double,
                       override var quantity: Double,
                       override var formattedSubCost: String,
                       override var subCost: Double = cost * quantity,
                       override var essentialRating: Int? = null ) : Expense, ExpenseList() {

    override fun itemize() {

        println("\nType in expense name to add to the receipt or press 'Enter' key to stop:")

        label = readLine().toString()

        when (label) {
            "" -> println("\n----End of List----")
            else -> {
                println("\nExpense cost:")
                cost = readLine()!!.toDouble()

                println("\nExpense quantity:")
                quantity = readLine()!!.toDouble()

                subCost = cost * quantity

                formattedSubCost = "%.2f".format(subCost)

                expenseList.add(ExpenseItem(label, cost, quantity, formattedSubCost, subCost, essentialRating))
            }
        }
        findTotal()
    }
}