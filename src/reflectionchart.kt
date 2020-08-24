open class ReflectionChart (private val evaluatedUserList: MutableList<Adult>) {

    fun evaluate() {
        evaluatedUserList.forEach { a ->
            val userExpenseQuantity = a.itemResponsibilities.size.toDouble()
            val userExpenseRating1 = a.itemResponsibilities.count{e -> e.essentialRating == 1}.toDouble()
            val userExpenseRating2 = a.itemResponsibilities.count{e -> e.essentialRating == 2}.toDouble()
            val userExpenseRating3 = a.itemResponsibilities.count{e -> e.essentialRating == 3}.toDouble()

            when { userExpenseRating1 != 0.0 -> a.expenseRating1 = (userExpenseRating1 / userExpenseQuantity) * 100 }
            when { userExpenseRating2 != 0.0 -> a.expenseRating2 = (userExpenseRating2 / userExpenseQuantity) * 100 }
            when { userExpenseRating3 != 0.0 -> a.expenseRating3 = (userExpenseRating3 / userExpenseQuantity) * 100 }

            println("\nEvaluated expenditure types for ${a.personName} below:")
            println("[Least Essential | ${"%.2f".format(a.expenseRating1)}%]")
            println("[Moderately Essential | ${"%.2f".format(a.expenseRating2)}%]")
            println("[Highly Essential | ${"%.2f".format(a.expenseRating3)}%]")
        }
    }
}