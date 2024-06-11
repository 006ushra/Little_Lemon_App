package com.bush.littlelemonapp.navigation

interface Destinations {
    val route: String
}

object Home: Destinations {
    override val route = "Home"
}

object DishDetails: Destinations {
    override val route = "details"
    val argDishId = "dishId"
}

object ReserveTable: Destinations {
    override val route = "reserve"
}

object Settings: Destinations {
    override val route = "settings"
}

object Account: Destinations {
    override val route = "account"
}