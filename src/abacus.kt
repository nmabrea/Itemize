open class Abacus(private val sortExpenseList: MutableList<ExpenseItem>,
                  private val sortUserList: MutableList<Adult>,
                  private val receipt: Receipt) {

    fun divByPersonCost() {

        println("\nAssign everyone's responsibility for each expense by entering their associated number key.")

        sortExpenseList.forEach { e ->
            println("\n${e.label}: \$${e.formattedSubCost}")

            println("\nAssign this expense to:")

            sortUserList.forEach { a -> println("[${a.personID}] ${a.personName}") }

            val assignmentToPersonID: Int = readLine()!!.toInt()

            println("\nEnter this expense's essential rating number ([1] least essential to [3] highly essential):")

            e.essentialRating = readLine()!!.toInt()

            sortUserList[assignmentToPersonID - 1].itemResponsibilities.add(e)
        }

        println("\nConfirmation of Initial Responsibility:")

        sortUserList.forEach { a ->
            println("\n${a.personName}: ")

            a.itemResponsibilities.forEach { e -> println("+ ${e.label}: \$${e.formattedSubCost} | Rating: ${e.essentialRating}") }

            val userSubTotalRough = a.itemResponsibilities.sumByDouble { e -> e.subCost }

            val userSubTotalFine = "%.2f".format(userSubTotalRough)

            println("Subtotal: \$${userSubTotalFine}")
        }

        val sharedExpenses = sortUserList[sortUserList.size - 1]
        when {

            sharedExpenses.personName == "Shared" && sharedExpenses.itemResponsibilities.size > 0 -> {

                for (i in 0..sharedExpenses.itemResponsibilities.size - 1) {

                    val sharedExpenseItem = sharedExpenses.itemResponsibilities[i]

                    sharedExpenseItem.quantity /= sortUserList.size - 1

                    sharedExpenseItem.subCost = sharedExpenseItem.cost * sharedExpenseItem.quantity

                    sharedExpenseItem.formattedSubCost = "%.2f".format(sharedExpenseItem.subCost)

                    sortUserList.forEach {a -> a.itemResponsibilities.add(sharedExpenseItem)}

                    }
                sortUserList.remove(sharedExpenses)

                }
        }

        println("\nConfirmation of Final Responsibility:")

        sortUserList.forEach { a ->
            println("\n${a.personName}: ")

            a.itemResponsibilities.forEach { e -> println("+ ${e.label}: \$${e.formattedSubCost} | Essential Rating: ${e.essentialRating}") }

            val userSubTotalRough = a.itemResponsibilities.sumByDouble { e -> e.subCost }

            val userSubTotalFine = "%.2f".format(userSubTotalRough)

            println("Subtotal: \$${userSubTotalFine}")
        }
    }



    fun chargeTo() {
        println("\nWho paid for this expense record?")

        sortUserList.forEach { a -> println("[${a.personID}] ${a.personName}") }

        val assignmentToPersonID: Int = readLine()!!.toInt()

        receipt.personInCharge = sortUserList[assignmentToPersonID - 1]

        println("Make all payments to: ${receipt.personInCharge!!.personName}")
    }
}