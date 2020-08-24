open class ExpenseList(var expenseList: MutableList<ExpenseItem> = mutableListOf()){

    fun findTotal() {

        println("\nList of Expenses:\n")

        expenseList.forEach { e -> println("${e.label}: \$${e.formattedSubCost}") }

        val totalRough = expenseList.sumByDouble { e -> e.subCost }

        val totalFine = "%.2f".format(totalRough)

        println("\nExpenses Subtotal: \$$totalFine")

    }

}